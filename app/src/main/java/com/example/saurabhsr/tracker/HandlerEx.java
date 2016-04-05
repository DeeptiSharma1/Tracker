package com.example.saurabhsr.tracker;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import android.os.Handler;
import java.util.logging.LogRecord;


public class HandlerEx extends ActionBarActivity {

    private ProgressDialog progressDialog;
    private ImageView imageView;
    private String url = "http://www.9ori.com/store/media/images/8ab579a656.jpg";
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_ex);

        imageView = (ImageView) findViewById(R.id.imageView);

        Button start = (Button) findViewById(R.id.btnimghand);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                progressDialog = ProgressDialog.show(HandlerEx.this, "", "Loading..");
                new Thread() {
                    public void run() {
                        bitmap = downloadBitmap(url);
                        messageHandler.sendEmptyMessage(0);
                    }
                }.start();
            }
        });
    }
    private Handler messageHandler = new Handler() {


        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    private Bitmap downloadBitmap(String url) {
        // Initialize the default HTTP client object
        final DefaultHttpClient client = new DefaultHttpClient();

        //forming a HttpGet request
        final HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse response = client.execute(getRequest);
            //check 200 OK for success
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url);
                return null;
            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    // getting contents from the stream
                    inputStream = entity.getContent();
                    // decoding stream data back into image Bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            getRequest.abort();
            Log.e(getString(R.string.app_name), "Error "+ e.toString());
        }
        return null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler_ex, menu);
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
