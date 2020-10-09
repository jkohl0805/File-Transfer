package com.example.android.filetransfer ;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    Button DISCOVER,SEND,RECEIVE;
    ListView listView;
    Switch wifi_toggle;
    TextView read_msg,Connection_status;
    EditText wrt_msg;

    WifiManager wifiManager;
    String status="OFF";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SEND =findViewById(R.id.button);
        RECEIVE = findViewById(R.id.button2);
        DISCOVER = findViewById(R.id.button3);
        wifi_toggle = findViewById(R.id.switch2);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        Connection_status = findViewById(R.id.textView3);

        if(wifiManager.isWifiEnabled()){
//            status="ON";
//            Connection_status.setText("WIFI is currently "+status);
            wifi_toggle.setChecked(false);
        }
        else{
//            status="OFF";
//            Connection_status.setText("WIFI is currently "+status);
            wifi_toggle.setChecked(false);
        }

        wifi_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    status=" ON";
                    Connection_status.setText("WIFI is currently "+status);
                    wifiManager.setWifiEnabled(true);
                    //Connection_status.setText("WIFI is currently ON");
                    Toast.makeText(HomeActivity.this,"WIFI IS ON",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    status="OFF";
                    Connection_status.setText("WIFI is currently "+status);
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(HomeActivity.this,"WIFI IS TURNING OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // toast message
       /* new AlertDialog.Builder(this)
                .setTitle("Wifi Connection ")
                .setCancelable(false)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomeActivity.this.finish();
                    }
                })
                .show();
     */

    }
    private void Wifi_On_OFF()
    {

    }
    private void initialization()
    {
    }

    public void clickTemporary(View view) {
    Intent intent=new Intent(HomeActivity.this,FileActivity.class);
    startActivity(intent);
    }



}