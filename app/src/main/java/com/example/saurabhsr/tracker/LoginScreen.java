package com.example.saurabhsr.tracker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreen extends ActionBarActivity {
    EditText username,password;

    Button btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        username = (EditText) findViewById(R.id.email);
         password = (EditText) findViewById(R.id.pwd);
        //String Email=username.getText().toString();

        final Button Login = (Button) findViewById(R.id.Btn_login1);

         btnclear =(Button)findViewById(R.id.btnClear);

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoginScreen.this,"U Pressed Clear",Toast.LENGTH_LONG).show();
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

                    Intent logi=new Intent(LoginScreen.this,Registeration.class);
                    logi.putExtra("name", "admin");
                    startActivity(logi);

                    //correcct password
                    Toast.makeText(LoginScreen.this, "Correct Password", Toast.LENGTH_LONG).show();
                } else {
                    //wrong password
                    Toast.makeText(LoginScreen.this,"InCorrect Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
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
