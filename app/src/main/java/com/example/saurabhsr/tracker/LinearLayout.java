package com.example.saurabhsr.tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class LinearLayout extends ActionBarActivity {

    TextView txtRed,txtBlue;
    TextView txtOrange,txtGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        txtRed=(TextView)findViewById(R.id.txtred);
        txtBlue=(TextView)findViewById(R.id.txtblue);
        txtOrange=(TextView)findViewById(R.id.txturange);

        txtRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LinearLayout.this,"U pressed Red",Toast.LENGTH_LONG).show();
                Log.d("The color is", "U pressed Red");
            }
        });
        txtBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LinearLayout.this,"U pressed Blue",Toast.LENGTH_LONG).show();
               Log.d("The color is", "U pressed Blue");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(LinearLayout.this,"On Start Method",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linear_layout, menu);
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
