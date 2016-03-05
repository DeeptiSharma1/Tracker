package com.example.saurabhsr.tracker;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;


public class LoginScreen extends ActionBarActivity {
    EditText username,txtpassword;

    Button btnclear;

    DBHelper dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        username = (EditText) findViewById(R.id.email);
         txtpassword = (EditText) findViewById(R.id.pwd);
        //String Email=username.getText().toString();

        dbAdapter=new DBHelper(this);

        final Button Login = (Button) findViewById(R.id.Btn_login1);

         btnclear =(Button)findViewById(R.id.btnClear);

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent regUntent=new Intent(LoginScreen.this,Registeration.class);
                startActivity(regUntent);
                Toast.makeText(LoginScreen.this,"U Pressed Clear",Toast.LENGTH_LONG).show();
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=username.getText().toString();
                String password = txtpassword.getText().toString();

// fetch the Password form database for respective user name
                dbAdapter.open();

                String storedPassword=  dbAdapter.getSinlgeEntry(userName);
        dbAdapter.close();
// check if the Stored password matches with Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(LoginScreen.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(LoginScreen.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
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
