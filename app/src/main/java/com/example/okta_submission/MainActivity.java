package com.example.okta_submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAnimals;
    private ArrayList<Animal> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAnimals = findViewById(R.id.rv_animals);
        rvAnimals.setHasFixedSize(true);

        list.addAll(getListAnimals());
        showRecyclerList();
    }

    public ArrayList<Animal> getListAnimals(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<Animal> listAnimal = new ArrayList<>();
        for(int i = 0; i < dataName.length; i++){
            Animal animal = new Animal();
            animal.setName(dataName[i]);
            animal.setDescription(dataDescription[i]);
            animal.setPhoto(dataPhoto.getResourceId(i, -1));

            listAnimal.add(animal);
        }
        return listAnimal;
    }

    private void showRecyclerList(){
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        ListAnimalAdapter listAnimalAdapter = new ListAnimalAdapter(list);
        rvAnimals.setAdapter(listAnimalAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}