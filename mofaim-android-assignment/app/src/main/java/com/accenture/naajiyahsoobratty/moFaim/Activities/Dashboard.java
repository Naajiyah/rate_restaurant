package com.accenture.naajiyahsoobratty.moFaim.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.accenture.naajiyahsoobratty.moFaim.Repositories.RestaurantRepository;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;
import com.accenture.naajiyahsoobratty.mopasfaim.R;
import com.accenture.naajiyahsoobratty.moFaim.RecyclerView.RecyclerViewAdapter;


import java.util.ArrayList;


public class Dashboard extends AppCompatActivity {

    private static final String TAG = "Dashboard";

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    EditText searchByLocation;
    Button buttonLocationSearch;
    EditText searchByName;
    Button buttonNameSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        RestaurantRepository restaurantRepository=new RestaurantRepository(this);
        restaurantList=restaurantRepository.getAllRestaurant();
        Log.d(TAG,restaurantList.get(0).getRestaurant_name());
        Log.d(TAG, "onCreate:started.");

        initRecyclerView();
    }
    public void initRecyclerView(){
        Log.d(TAG,"initRecyclerView : Init recyclerView.");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(restaurantList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickDisplayByLocation(View view){

        searchByLocation=findViewById(R.id.editText_location);
        buttonLocationSearch=findViewById(R.id.button_location);
        RestaurantRepository restaurantRepository=new RestaurantRepository(this);
        ArrayList<Restaurant> restaurantListLocation=restaurantRepository.findRestaurantByLocation(searchByLocation.getText().toString());

        if(restaurantListLocation.isEmpty()){
            Toast.makeText(this, "No Restaurant found at this location", Toast.LENGTH_SHORT).show();
            initRecyclerView();
        }
        else{
            RecyclerView recyclerView=findViewById(R.id.recycler_view);
            RecyclerViewAdapter adapter=new RecyclerViewAdapter(restaurantListLocation,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }
    public void onClickDisplayByName(View view){

        searchByName=findViewById(R.id.editText_name);
        buttonNameSearch=findViewById(R.id.button_name);
        RestaurantRepository restaurantRepository=new RestaurantRepository(this);
        ArrayList<Restaurant> restaurantListName=restaurantRepository.findRestaurantByName(searchByName.getText().toString());

        if(restaurantListName.isEmpty()){
            Toast.makeText(this, "Restaurant not found", Toast.LENGTH_SHORT).show();
            initRecyclerView();
        }
        else{
            RecyclerView recyclerView=findViewById(R.id.recycler_view);
            RecyclerViewAdapter adapter=new RecyclerViewAdapter(restaurantListName,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }



}

