package com.example.filetransfer;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import static com.example.filetransfer.HomeActivity.MY_PERMISSIONS_REQUEST_LOCATION;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mchannel;
    private HomeActivity mActivity;


    public WifiDirectBroadcastReceiver(WifiP2pManager manager, WifiP2pManager.Channel channel, HomeActivity activity) {

        this.mManager = manager;
        this.mchannel = channel;
        this.mActivity = activity;

    }


    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);

            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                Toast.makeText(context, "Wifi is On", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Wifi is OFF", Toast.LENGTH_SHORT).show();
            }
        }
        else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {

            if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.mActivity,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
        else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
        }
        else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
        }


    }
}
