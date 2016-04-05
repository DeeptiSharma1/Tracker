package com.example.saurabhsr.tracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;


public class BrocstWithNotification extends ActionBarActivity {

    ToggleButton wifitoggle;
    CheckBox brcheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brocst_with_notification);
     // Locate the ToggleButton in activity_main.xml
            wifitoggle = (ToggleButton) findViewById(R.id.wifitoggle);

            // Locate the CheckBox in activity_main.xml
            brcheckbox = (CheckBox) findViewById(R.id.brcheckbox);

            // WifiManager to control the Wifi Service
            final WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

            // Capture ToggleButton clicks
            wifitoggle.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (wifitoggle.isChecked()) {
                        // Switch On Wifi
                        wifiManager.setWifiEnabled(true);
                    } else {
                        // Switch Off Wifi
                        wifiManager.setWifiEnabled(false);
                    }
                }
            });

            // Capture CheckBox clicks
            brcheckbox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (brcheckbox.isChecked()) {
                        // Switch On Broadcast Receiver
                        PackageManager pm = BrocstWithNotification.this.getPackageManager();
                        ComponentName componentName = new ComponentName(
                                BrocstWithNotification.this, BroadcastManager.class);
                        pm.setComponentEnabledSetting(componentName,
                                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                                PackageManager.DONT_KILL_APP);
                        Toast.makeText(getApplicationContext(),
                                "Broadcast Receiver Started", Toast.LENGTH_LONG)
                                .show();
                    } else {
                        // Switch Off Broadcast Receiver
                        PackageManager pm = BrocstWithNotification.this.getPackageManager();
                        ComponentName componentName = new ComponentName(
                                BrocstWithNotification.this, BroadcastManager.class);
                        pm.setComponentEnabledSetting(componentName,
                                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                                PackageManager.DONT_KILL_APP);
                        Toast.makeText(getApplicationContext(),
                                "Broadcast Receiver Stopped", Toast.LENGTH_LONG)
                                .show();

                    }
                }
            });
            // If Wifi already turned on switch ToggleButton to on
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm.getActiveNetworkInfo() != null
                    && cm.getActiveNetworkInfo().isAvailable()
                    && cm.getActiveNetworkInfo().isConnected()) {
                wifitoggle.setChecked(true);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_brocst_with_notification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
