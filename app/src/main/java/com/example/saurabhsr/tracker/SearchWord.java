package com.example.saurabhsr.tracker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class SearchWord extends ActionBarActivity {

    TextView txtsrch;
    Button Search;
    EditText txtInput;
    ListView listItems;

    private String[] monthsArray = { "Rajesh", "Pooja", "Rohit","Deepti"};

    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_word);
        listItems=(ListView)findViewById(R.id.listMenu);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, monthsArray);

        listItems.setAdapter(arrayAdapter);

        registerForContextMenu(listItems);

        Search=(Button)findViewById(R.id.btnPop);


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(SearchWord.this, Search);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup1, popup.getMenu());

                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(SearchWord.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;                  }
                });

            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Send SMS");
        }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_word, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_TextColor) {

            PopupMenu popup = new PopupMenu(SearchWord.this, Search);
            //Inflating the Popup using xml file
            popup.getMenuInflater().inflate(R.menu.popup1, popup.getMenu());

            popup.show();
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(SearchWord.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;                  }
            });

        }

        return super.onOptionsItemSelected(item);
    }
}
