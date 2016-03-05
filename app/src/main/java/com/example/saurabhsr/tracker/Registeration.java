package com.example.saurabhsr.tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registeration extends ActionBarActivity {

    EditText txtname,txtmail,txtpwd;
    Button btnRegister,btdelete;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

      txtname=(EditText)findViewById(R.id.EditText_RegUser);
        txtpwd=(EditText)findViewById(R.id.EditText_RegPwd);
        txtmail=(EditText)findViewById(R.id.editText);

        db = new DBHelper(this);

        btnRegister=(Button)findViewById(R.id.btn_Reg);
        btdelete=(Button)findViewById(R.id.btn_Delete);
        btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name1 = txtname.getText().toString();
                db.open();
                db.deleteEntry(name1);
                db.close();
                Toast.makeText(Registeration.this,"Record Deleted",Toast.LENGTH_LONG).show();

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = txtname.getText().toString();
                String email = txtmail.getText().toString();
                String pwd = txtpwd.getText().toString();

            db.open();

                db.insertContact(name, email, pwd);

                db.close();

                Toast.makeText(Registeration.this,"Record Incerted",Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registeration, menu);
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
