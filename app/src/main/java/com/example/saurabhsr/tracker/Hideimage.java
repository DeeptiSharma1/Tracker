package com.example.saurabhsr.tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Hideimage extends ActionBarActivity {

    TextView txtImage;
    Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hideimage);
        txtImage=(TextView)findViewById(R.id.textView);
        btnAction=(Button)findViewById(R.id.btnImag);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        String ButtonText= btnAction.getText().toString();

                if(ButtonText=="Hide") {
                    txtImage.setVisibility(View.GONE);
                    btnAction.setText("Show");
                    Log.d("Message","Ur image is hiding");

                }
                else {
                    txtImage.setVisibility(View.VISIBLE);
                    btnAction.setText("Hide");
                }


            }
        });

            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hideimage, menu);
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
