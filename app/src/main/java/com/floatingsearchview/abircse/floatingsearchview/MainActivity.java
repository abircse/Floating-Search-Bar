package com.floatingsearchview.abircse.floatingsearchview;

import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list;
    FloatingSearchView searchView;
    ListView listView;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource();
        searchView = findViewById(R.id.searchview);
        listView = findViewById(R.id.mylist);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {

                List<String> templist = new ArrayList<>();

                for (int i = 0 ; i < list.size(); i++)
                {
                    if (list.get(i).contains(newQuery))
                    {
                        templist.add(list.get(i));
                    }

                    adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,templist);
                    listView.setAdapter(adapter);
                }

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Toast.makeText(getApplicationContext(), "You Clicked on "+adapter.getItem(position),Toast.LENGTH_LONG).show();
            }
        });



    }

    void datasource()
    {
        list = new ArrayList<>();
        list.add("Abir");
        list.add("Ramim");
        list.add("Saiful");
        list.add("Bappy");
        list.add("Imran");
        list.add("Shanta");
        list.add("Asrafa");
        list.add("Nasrin");




    }
}
