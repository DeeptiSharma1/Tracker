package com.example.saurabhsr.tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortList extends ActionBarActivity {

    private Button mAscButton;
    private Button mDescButton;
    private ListView mNameListView;

    private List<String> stringList;
    private ArrayAdapter stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_list);
        mAscButton = (Button) findViewById(R.id.btnAcnding);
        mDescButton = (Button) findViewById(R.id.btnDecnding);
        mNameListView = (ListView) findViewById(R.id.Itemlist);

        stringList = new ArrayList<String>();
        stringList.add("Jan");
        stringList.add("Feb");
        stringList.add("March");
        stringList.add("April");
        stringList.add("May");
        stringList.add("June");

        stringAdapter = new ArrayAdapter(SortList.this, R.layout.list, stringList);
        mNameListView.setAdapter(stringAdapter);

        mAscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(stringList, StringAscComparator);
                Toast.makeText(SortList.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();

            }
        });
        mDescButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(stringList, StringAscComparator);
                Toast.makeText(SortList.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();

            }
        });
    }
    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName1.compareToIgnoreCase(stringName2);
        }
    };
    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName2.compareToIgnoreCase(stringName1);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sort_list, menu);
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
