package com.example.ericklopes.customlisttime;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] time = {"Atlético PR", "Coritiba", "Grêmio"};
    Integer[] imageId = {R.drawable.atletico, R.drawable.coritiba, R.drawable.gremio};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListCell adapter = new ListCell(MainActivity.this, time, imageId);
        list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(MainActivity.this , "Clicou na "+time[position], Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(MainActivity.this, DetailActivity.class);
                    //Object obj = MainActivity.this.getListAdapter().getItem(position);
                    String item = (String)parent.getItemAtPosition(position);
                    it.putExtra("time", item);
                    startActivity(it);

                }
            }
        );
    }
}
