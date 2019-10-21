package com.example.hp.sensor;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Optional extends AppCompatActivity {

    AuxReceiver receiver;
    Button skipbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);

        try {
            IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
            this.receiver = new AuxReceiver();
            registerReceiver(this.receiver, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button skipbtn = (Button)findViewById(R.id.skip);
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DataActivity.class);
                intent.putExtra("glucose","0");
                startActivity(intent);
            }
        });
    }
}
