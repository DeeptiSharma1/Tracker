package com.example.saurabhsr.tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class CalenderEx extends ActionBarActivity {

    private TimePicker timePicker1;
    TextView txtdate;
Calendar calendar;
    private String format = "";
    Button btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_ex);
        timePicker1=(TimePicker)findViewById(R.id.timePicker);
        txtdate=(TextView)findViewById(R.id.textView2);
        btnTime=(Button)findViewById(R.id.btnSet);

        calendar = Calendar.getInstance();

        btnTime.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           int hour = timePicker1.getCurrentHour();
                                           int min = timePicker1.getCurrentMinute();

                                           txtdate.setText(new StringBuilder().append(hour).append(" : ").append(min)
                                                   .append(" ").append(format));
                                       }
                                   });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calender_ex, menu);
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
