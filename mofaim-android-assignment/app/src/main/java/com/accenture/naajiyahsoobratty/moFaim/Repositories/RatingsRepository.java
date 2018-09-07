package com.accenture.naajiyahsoobratty.moFaim.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.accenture.naajiyahsoobratty.moFaim.Contracts.RatingsContract;
import com.accenture.naajiyahsoobratty.moFaim.Contracts.RestaurantContract;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Ratings;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;
import com.accenture.naajiyahsoobratty.moFaim.Entities.User;

import java.util.ArrayList;

public class RatingsRepository {

    private static final String LOG_TAG = "MenuRepository";

    private DatabaseManager db;
    private SQLiteDatabase mWritableDatabase;

    public RatingsRepository(Context context) {
        db = new DatabaseManager(context);
    }


    public void onClickInsertRatings(Ratings ratings){
        try{
            mWritableDatabase=db.getWritableDatabase();
            mWritableDatabase.execSQL("INSERT INTO RATINGS VALUES('"+ratings.getRatings()+"','"+ratings.getRestaurant_id()+"','"+ratings.getUser_id()+"')");

        }
        catch (Exception ex){
            Log.d(LOG_TAG,"Insert ratings: exception"+ ex.toString());
        }
    }

    public ArrayList<Ratings> findRatingsByUserIdAndResId(Integer userId, Integer restaurantId){

        Cursor results=null;
        Ratings ratings=new Ratings();
        ArrayList<Ratings> ratingsList=new ArrayList<>();


        try{
            String query= String.format(
                    "SELECT * FROM %s WHERE %s = '%s' AND %s = '%s' ",
                    RatingsContract.RatingsEntry.TABLE_NAME,
                    RatingsContract.RatingsEntry.COLUMN_RESTAURANT_ID,
                    restaurantId,
                    RatingsContract.RatingsEntry.COLUMN_USER_ID,
                    userId
            );

            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();
            Log.d(LOG_TAG,query);
            mReadableDatabase=db.getReadableDatabase();

            results=mReadableDatabase.rawQuery(query,null);
            Log.d(LOG_TAG,Integer.toString(results.getCount()));
            while (results.moveToNext()){
//
                ratings= new Ratings(
                        results.getInt(results.getColumnIndex(RatingsContract.RatingsEntry.COLUMN_RESTAURANT_ID)),
                        results.getInt(results.getColumnIndex(RatingsContract.RatingsEntry.COLUMN_USER_ID)),
                        results.getInt(results.getColumnIndex(RatingsContract.RatingsEntry.COLUMN_RATINGS))

                );
                ratingsList.add(ratings);

            }

            return ratingsList;
        }
        catch (Exception ex){
            Log.d(LOG_TAG, "findRatingsByUserIdAndResId: exception" + ex.toString());
        }
        finally {

            if(results != null) {
                results.close();
            }
            return ratingsList;
        }
    }













    }



