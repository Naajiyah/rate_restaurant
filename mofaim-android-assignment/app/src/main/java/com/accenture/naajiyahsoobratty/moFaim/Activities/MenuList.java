package com.accenture.naajiyahsoobratty.moFaim.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.accenture.naajiyahsoobratty.moFaim.Entities.Menu;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Ratings;
import com.accenture.naajiyahsoobratty.moFaim.Entities.User;
import com.accenture.naajiyahsoobratty.moFaim.RecyclerView.RecyclerViewAdapter_menu;
import com.accenture.naajiyahsoobratty.moFaim.Repositories.MenuRepository;
import com.accenture.naajiyahsoobratty.moFaim.Repositories.RatingsRepository;
import com.accenture.naajiyahsoobratty.moFaim.Repositories.UserRepository;
import com.accenture.naajiyahsoobratty.mopasfaim.R;

import java.util.ArrayList;

public class MenuList extends AppCompatActivity {

    private static final String TAG = "MenuList";
    private ArrayList<Menu> menuList=new ArrayList<>();
    private RatingsRepository ratingsRepository;
    private RatingBar ratingBar;
    private Button ratingButton;
    private Integer restaurant_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        Intent intent=getIntent();
        restaurant_id= intent.getIntExtra("RESTAURANT",0);
        MenuRepository menuRepository=new MenuRepository(this);
        menuList=menuRepository.findMenuByRestaurantId(restaurant_id);
        initRecyclerView();
    }
    public void initRecyclerView(){
        Log.d(TAG,"initRecyclerView : Init recyclerView.");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        RecyclerViewAdapter_menu adapter=new RecyclerViewAdapter_menu(menuList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickInsertRatings(View view) {

        RatingsRepository ratingsRepository = new RatingsRepository(this);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        int userId = sharedPref.getInt("user_id", 0);

        if (ratingsRepository.findRatingsByUserIdAndResId(userId, restaurant_id).isEmpty()) {

            ratingButton = findViewById(R.id.button_rate);
            ratingBar = findViewById(R.id.ratingBar);

            Ratings ratings = new Ratings();
            ratings.setRatings((int) ratingBar.getRating());
            ratings.setRestaurant_id(restaurant_id);

            ratings.setUser_id(userId);

            ratingsRepository.onClickInsertRatings(ratings);
//            Intent toDashboardActivity = new Intent(this, Dashboard.class);
//            startActivity(toDashboardActivity);
        }
        else{
            Toast.makeText(this, "Cannot rate more than once", Toast.LENGTH_SHORT).show();
        }
    }
    }




    //ratingbar
    //onclick rate - userId, restoId, ratings
    //putExtra from login to here





