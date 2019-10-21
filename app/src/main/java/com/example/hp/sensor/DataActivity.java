package com.example.hp.sensor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DataActivity extends AppCompatActivity {

    public static String TAG = "TAG";
    public JSONObject readingsJson = null;
    int state = 0;
    View v;
    TextView status,gsr,sysBP,diaBP,pulse,cholestrol;
    Button connect,collectGSR,collectBP,submitReadings;

    private BluetoothAdapter mBTAdapter;
    private Set<BluetoothDevice> mPairedDevices;

    private Handler mHandler; // Our main handler that will receive callback notifications
    private ConnectedThread mConnectedThread; // bluetooth background worker thread to send and receive data
    private BluetoothSocket mBTSocket = null; // bi-directional client-to-client data path

    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // "random" unique identifier

    // #defines for identifying shared types between calling functions
    private final static int REQUEST_ENABLE_BT = 1; // used to identify adding bluetooth names
    private final static int MESSAGE_READ = 2; // used in bluetooth handler to identify message update
    private final static int CONNECTING_STATUS = 3; // used in bluetooth handler to identify message status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        status = (TextView)findViewById(R.id.status);
        gsr = (TextView)findViewById(R.id.gsr);
        sysBP = (TextView)findViewById(R.id.sysBP);
        diaBP = (TextView)findViewById(R.id.diaBP);
        pulse = (TextView)findViewById(R.id.pulse);
        cholestrol = (TextView)findViewById(R.id.cholestrol);

        addFakeReadings();
        cholestrol.setText(getIntent().getStringExtra("glucose"));
        connect = (Button)findViewById(R.id.connect);
        collectGSR = (Button)findViewById(R.id.collectGSR);
        collectBP = (Button)findViewById(R.id.collectBP);
        submitReadings = (Button)findViewById(R.id.submitReadings);

        mBTAdapter = BluetoothAdapter.getDefaultAdapter();

        mHandler = new Handler(){
            public void handleMessage(android.os.Message msg){
                if(msg.what == MESSAGE_READ){
                    String readMessage = null;
                    try {
                        readMessage = new String((byte[]) msg.obj, "UTF-8");
                        Log.e(TAG, "handleMessage: "+readMessage);
                        if(readMessage.charAt(0)=='#') {
                            gsr.setText(readMessage.substring(1,readMessage.length()));
                        }
                        else if(readMessage.charAt(0)=='$')
                        {
                            String[] readings = readMessage.substring(1,readMessage.length()).split("@");
                            sysBP.setText(readings[0]);
                            diaBP.setText(readings[1]);
                            pulse.setText(readings[2]);
                        }
                        //reading.setText(new String(((byte[]) msg.obj)).substring(0,msg.arg1));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                if(msg.what == CONNECTING_STATUS){
                    if(msg.arg1 == 1)
                        status.setText("Connected to Device: " + (String)(msg.obj));
                    else
                        status.setText("Connection Failed! Try again.");
                }
            }
        };

        if (mBTAdapter == null) {
            // Device does not support Bluetooth
            status.setText("Status: Bluetooth not found");
            Toast.makeText(getApplicationContext(),"Bluetooth device not found!",Toast.LENGTH_SHORT).show();
        }
        else {
            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    v = view;
                    Log.e(TAG, "onClick: 1" );
                    if(state == 0) {
                        bluetoothOn(v);
                        connect.setText("Discover Devices");
                        state = 1;
                    }
                    else if(state==1)
                    {
                        discover(view);
                        connect.setText("Get All Devices");
                        state = 2;
                    }
                    else if(state==2)
                    {
                        listPairedDevices(view);
                        connect.setText("Connect To Device");
                        state = 3;
                    }
                    else
                    {
                        connectHC05();
                        connect.setText("If Connection Failed, Try again");
                        state = 0;
                    }
                }
            });

            collectGSR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mConnectedThread.write("1");
                    Log.e(TAG, "onClick: "+"GSR Clicked" );
                }
            });
            collectBP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mConnectedThread.write("2");
                    Log.e(TAG, "onClick: "+"BP Clicked" );
                }
            });

        }

        submitReadings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createReadingsJson();
                callAddRecordedDataAPI();
            }
        });


    }

    private void createReadingsJson() {
        readingsJson = new JSONObject();
        try {
            readingsJson.put("mobile","9821070658");
            readingsJson.put("systolicBp",sysBP.getText().toString());
            readingsJson.put("diastolicBp",diaBP.getText().toString());
            readingsJson.put("pulse",pulse.getText().toString());
            readingsJson.put("gsr",gsr.getText().toString());
            readingsJson.put("cholestrol",cholestrol.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void callAddRecordedDataAPI() {
        String submitReadingsURL = "http://demoppa.herokuapp.com/addRecordedData";

        final JsonObjectRequest submitReadingJsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, submitReadingsURL ,readingsJson , new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("TAG", "onPre book Response: "+response );

                        } catch (Exception e) {
                            Log.e("TAG", "onResponse: " + e);
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "onResponse: " + error);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));

                    JSONObject result = null;

                    if (jsonString != null && jsonString.length() > 0)
                        result = new JSONObject(jsonString);

                    return Response.success(result,
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
        submitReadingJsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(40000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(submitReadingJsonObjectRequest);
    }


    private void addFakeReadings() {
        gsr.setText("120");
        sysBP.setText("120");
        diaBP.setText("80");
        pulse.setText("72");
    }

    private void bluetoothOn(View view){
        if(!mBTAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            status.setText("Bluetooth enabled");
            Log.e(TAG, "onClick: 2" );
            Toast.makeText(getApplicationContext(), "Bluetooth turned on", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Log.e(TAG, "onClick: 3" );
        }
    }

    // Enter here after user selects "yes" or "no" to enabling radio
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        // Check which request we're responding to
        if (requestCode == REQUEST_ENABLE_BT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                Log.e(TAG, "onClick: 4" );
                status.setText("Bluetooth Enabled");
            }
            else
                status.setText("Bluetooth Disabled");
        }
    }


    private void discover(View view){
        // Check if the device is already discovering
        if(mBTAdapter.isDiscovering()){
            Log.e(TAG, "onClick: 5" );
            mBTAdapter.cancelDiscovery();
            //Toast.makeText(getApplicationContext(),"Discovery stopped",Toast.LENGTH_SHORT).show();
        }
        else{
            if(mBTAdapter.isEnabled()) {
                //mBTArrayAdapter.clear(); // clear items
                mBTAdapter.startDiscovery();
                //Toast.makeText(getApplicationContext(), "Discovery started", Toast.LENGTH_SHORT).show();
                registerReceiver(blReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
                Log.e(TAG, "onClick: 6" );
            }
            else{
                Toast.makeText(getApplicationContext(), "Bluetooth not on", Toast.LENGTH_SHORT).show();
            }
        }
    }

    final BroadcastReceiver blReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Log.e(TAG, "onClick: 7" );
                //connectHC05();
            }
        }
    };

    private void listPairedDevices(View view) {
        mPairedDevices = mBTAdapter.getBondedDevices();
    }

    private void connectHC05()
    {
        Log.e(TAG, "onClick: 8" );
        if(!mBTAdapter.isEnabled()) {
            Toast.makeText(getBaseContext(), "Bluetooth not on", Toast.LENGTH_SHORT).show();
            return;
        }

        status.setText("Connecting...");
        // Get the device MAC address, which is the last 17 chars in the View
        String info = "";
        for (BluetoothDevice device : mPairedDevices) {
            if(device.getName().equals("HC-05"))
            {
                info = device.getName()+device.getAddress();
            }
            //mBTArrayAdapter.add(device.getName() + "\n" + device.getAddress());
        }

        final String address = info.substring(info.length() - 17);
        final String name = info.substring(0,info.length() - 17);

        new Thread()
        {
            public void run() {
                boolean fail = false;

                BluetoothDevice device = mBTAdapter.getRemoteDevice(address);

                try {
                    mBTSocket = createBluetoothSocket(device);
                } catch (IOException e) {
                    fail = true;
                    Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_SHORT).show();
                }
                // Establish the Bluetooth socket connection.
                try {
                    mBTSocket.connect();
                } catch (IOException e) {
                    try {
                        fail = true;
                        mBTSocket.close();
                        mHandler.obtainMessage(CONNECTING_STATUS, -1, -1)
                                .sendToTarget();
                    } catch (IOException e2) {
                        //insert code to deal with this
                        Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_SHORT).show();
                    }
                }
                if(fail == false) {
                    mConnectedThread = new ConnectedThread(mBTSocket);
                    mConnectedThread.start();

                    mHandler.obtainMessage(CONNECTING_STATUS, 1, -1, name)
                            .sendToTarget();
                }
            }
        }.start();
    }

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        return  device.createRfcommSocketToServiceRecord(BTMODULEUUID);
        //creates secure outgoing connection with BT device using UUID
    }

    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[64];  // buffer store for the stream
            int bytes; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = mmInStream.available();
                    if (bytes != 0) {
                        SystemClock.sleep(100); //pause and wait for rest of data. Adjust this depending on your sending speed.
                        bytes = mmInStream.available(); // how many bytes are ready to be read?
                        bytes = mmInStream.read(buffer, 0, bytes); // record how many bytes we actually read
                        Log.e("YE AAYA", "run: " + new String(buffer));
                        //reading.setText(new String(buffer).substring(1,bytes+1));
                        mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
                                .sendToTarget(); // Send the obtained bytes to the UI activity
                        buffer = new byte[64];
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes();           //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
            }
        }

        public int read() {
            try {
                return mmInStream.read();
            } catch (IOException e) {
            }
            return -1;
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
            }
        }
    }
}
