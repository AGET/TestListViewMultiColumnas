package com.aldo.aget.testlistviewmulticolumnas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.aldo.aget.testlistviewmulticolumnas.adapter.ListviewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HashMap> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ListView listview = (ListView) findViewById(R.id.listview);
        populateList();
        ListviewAdapter adapter = new ListviewAdapter(this, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x = ((TextView) view.findViewById(R.id.columna_1)).getText().toString();
                Toast.makeText(MainActivity.this, x, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    //Rellenamos la lista con varias filas de ejemplo
    private void populateList() {

        list = new ArrayList<HashMap>();

        //HashMap temp0 = new HashMap();
        //list.add(temp0);

        HashMap temp = new HashMap();
        temp.put("COLUMNA_1","Marcos");
        temp.put("COLUMNA_2", "25");
        temp.put("COLUMNA_3", "Sevilla");
        temp.put("COLUMNA_4", "185");
        list.add(temp);

        HashMap temp1 = new HashMap();
        temp1.put("COLUMNA_1","Juan");
        temp1.put("COLUMNA_2", "27");
        temp1.put("COLUMNA_3", "Madrid");
        temp1.put("COLUMNA_4", "177");
        list.add(temp1);

        HashMap temp2 = new HashMap();
        temp2.put("COLUMNA_1","María");
        temp2.put("COLUMNA_2", "19");
        temp2.put("COLUMNA_3", "Huelva");
        temp2.put("COLUMNA_4", "168");
        list.add(temp2);

        HashMap temp3 = new HashMap();
        temp3.put("COLUMNA_1","Luis");
        temp3.put("COLUMNA_2", "32");
        temp3.put("COLUMNA_3", "Valencia");
        temp3.put("COLUMNA_4", "189");
        list.add(temp3);

        HashMap temp4 = new HashMap();
        temp4.put("COLUMNA_1","Carmen");
        temp4.put("COLUMNA_2", "29");
        temp4.put("COLUMNA_3", "Barcelona");
        temp4.put("COLUMNA_4", "170");
        list.add(temp4);

        for(int i = 0; i < 100 ;i++){
            HashMap tmp = new HashMap();
            tmp.put("COLUMNA_1","Carmen"+i);
            tmp.put("COLUMNA_2", "29");
            tmp.put("COLUMNA_3", "Barcelona");
            tmp.put("COLUMNA_4", "170");
            list.add(tmp);
        }
    }
}
