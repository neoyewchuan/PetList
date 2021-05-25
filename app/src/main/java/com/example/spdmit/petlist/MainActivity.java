package com.example.spdmit.petlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] menu;//={"Dog","Cat","Hamster"};
    PetCollection petlist;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petlist = new PetCollection();
        menu = petlist.getAllPets();

        list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,menu);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              //  Toast.makeText(getApplicationContext(),menu[position]+" clicked!",Toast.LENGTH_SHORT).show();
                onClick(position);
            }
        });
    }

    public void onClick(int selected){
        Intent intent = new Intent(getApplicationContext(),DisplayPet.class);

        String selectedPet = petlist.getPetAt(selected).getSpecies();
        int pic = petlist.getPetAt(selected).getPic();
        intent.putExtra("pet", selectedPet);
        intent.putExtra("pic", pic);

        startActivity(intent);
    }



}
