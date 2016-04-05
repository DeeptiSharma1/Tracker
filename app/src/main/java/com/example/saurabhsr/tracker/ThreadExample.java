package com.example.saurabhsr.tracker;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Handler;
import java.util.logging.LogRecord;


public class ThreadExample extends ActionBarActivity {

    Button btPress,btThrd,btHandlr;

    private static final String TAG="help";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);

        btPress = (Button) findViewById(R.id.btnPress);
        btThrd = (Button) findViewById(R.id.btnThrd);
        btHandlr = (Button) findViewById(R.id.btnHandler);

        //With Thread update Textview inside main thred

        btPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long endTime = System.currentTimeMillis() + 60 * 1000;

                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                TextView myTextView = (TextView) findViewById(R.id.myTextView);
                myTextView.setText("Button Pressed");
            }
        });

        //With Thread call a process
        btThrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable runnable = new Runnable() {
                    public void run() {

                        long endTime = System.currentTimeMillis() + 60 * 1000;

                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                };
                Thread mythread = new Thread(runnable);
                mythread.start();

            }
        });

        btHandlr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    public void run() {

                        long endTime = System.currentTimeMillis() + 60*1000;

                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                } catch (Exception e) {}
                            }

                        }
                        handler.sendEmptyMessage(0);
                    }
                };

                Thread mythread = new Thread(runnable);
                mythread.start();

            }
        });
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView myTextView =
                    (TextView)findViewById(R.id.myTextView);
            myTextView.setText("Button Pressed");
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thread_example, menu);
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
