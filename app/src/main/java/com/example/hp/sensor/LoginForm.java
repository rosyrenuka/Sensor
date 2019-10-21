package com.example.hp.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

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

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginForm extends AppCompatActivity {
EditText usernameEditText,ageEditText,contactEditText,emailEditText,heightEditText,weightEditText;
RadioButton userMale,userFemale;
CheckBox smokeingCheckbox,exerciseCheckbox;
Button registerButton;
String username,contact,email;
int age;
double height,weight;
double bmi = 0.0d;
int gender,smoking,exercise;
JSONObject userJSON = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        Intent intent = new Intent(getApplicationContext(),Optional.class);
        startActivity(intent);
        usernameEditText = (EditText)findViewById(R.id.user_username);
        ageEditText = (EditText)findViewById(R.id.user_age);
        emailEditText = (EditText)findViewById(R.id.user_email);
        contactEditText = (EditText)findViewById(R.id.user_contact);
        heightEditText = (EditText)findViewById(R.id.user_height);
        weightEditText = (EditText)findViewById(R.id.user_weight);
        userMale = (RadioButton) findViewById(R.id.user_male);
        userFemale = (RadioButton) findViewById(R.id.user_female);
        smokeingCheckbox = (AppCompatCheckBox)findViewById(R.id.user_smoke);
        exerciseCheckbox = (AppCompatCheckBox)findViewById(R.id.user_exercise);
        registerButton = (Button) findViewById(R.id.user_register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameEditText.getText().toString();
                age = Integer.parseInt(ageEditText.getText().toString());
                contact = contactEditText.getText().toString();
                email = emailEditText.getText().toString();
                height = Double.parseDouble(heightEditText.getText().toString());
                weight = Double.parseDouble(weightEditText.getText().toString());

                gender = 0;
                if(userMale.isSelected())
                {
                    gender = 1;
                }
                if(smokeingCheckbox.isChecked())
                {
                    smoking=1;
                }
                if(exerciseCheckbox.isChecked())
                {
                    exercise = 1;
                }

                createUserJSON();

                callAddUserAPI();
            }
        });
    }

    public void createUserJSON()
    {
        userJSON = new JSONObject();
        try {
            bmi = (height/(weight*weight));
            userJSON.put("firstName",username);
            userJSON.put("age",age);
            userJSON.put("gender",gender);
            userJSON.put("height",height);
            userJSON.put("weight",weight);
            userJSON.put("bmi",bmi);
            userJSON.put("smoking",smoking);
            userJSON.put("exercise",exercise);
            userJSON.put("mobile",contact);
            userJSON.put("email",email);

            Log.e("TAG",userJSON.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void callAddUserAPI() {

        String registerUserURL = "http://demoppa.herokuapp.com/addUser";

        final JsonObjectRequest registerUserJsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, registerUserURL ,userJSON , new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("TAG", "onPre book Response: "+response );
                            Intent intent = new Intent(getApplicationContext(),DataActivity.class);
                            startActivity(intent);

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
        registerUserJsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(40000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(registerUserJsonObjectRequest);
    }
}
