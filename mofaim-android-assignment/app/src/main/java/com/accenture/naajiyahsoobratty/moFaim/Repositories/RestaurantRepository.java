package com.accenture.naajiyahsoobratty.moFaim.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.accenture.naajiyahsoobratty.moFaim.Contracts.RestaurantContract;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private static final String LOG_TAG = "RestaurantRepository";

    private DatabaseManager db;

    public RestaurantRepository(Context context) {
        db = new DatabaseManager(context);
    }

    public ArrayList<Restaurant> getAllRestaurant(){
        Cursor results=null;
        ArrayList<Restaurant> restaurantList=new ArrayList<>();

        try {
            String query = "SELECT * FROM "+ RestaurantContract.RestaurantEntry.TABLE_NAME;

            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();

            results = mReadableDatabase.rawQuery(query, null);

            while (results.moveToNext()) {
                Restaurant restaurant = new Restaurant(
                        results.getInt(0),
                        results.getString(1),
                        results.getString(2),
                        results.getString(3),
                        results.getInt(4),
                        results.getString(5));

                restaurantList.add(restaurant);
            }
            System.out.print(restaurantList);
            return restaurantList;

        }
        catch (Exception ex){
            Log.d(LOG_TAG,"getAllRestaurants : exception"+ex.toString());

        }
        finally {
            if(results!=null){
                results.close();
            }

            return restaurantList;
        }

    }

    public ArrayList<Restaurant> findRestaurantByLocation(String location){

        Cursor results=null;
        Restaurant restaurant=new Restaurant();
        ArrayList<Restaurant> restaurantList=new ArrayList<>();

        try{
            String query= String.format(
                    "SELECT * FROM %s WHERE %s COLLATE NOCASE = '%s' ",
                    RestaurantContract.RestaurantEntry.TABLE_NAME,
                    RestaurantContract.RestaurantEntry.COLUMN_RES_LOCATION,
                    location
            );

            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();
            Log.d(LOG_TAG,query);
            mReadableDatabase=db.getReadableDatabase();

            results=mReadableDatabase.rawQuery(query,null);
            Log.d(LOG_TAG,Integer.toString(results.getCount()));
            while (results.moveToNext()){
//
                          restaurant= new Restaurant(
                                  results.getInt(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_ID)),
                                  results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_NAME)),
                                  results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_LOCATION)),
                                  results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_PHONENUM)),
                                  results.getInt(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_RATINGS)),
                                  results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_IMAGE))
                          );
                restaurantList.add(restaurant);

            }

            return restaurantList;
    }
        catch (Exception ex){
            Log.d(LOG_TAG, "searchRestaurantByLocation: exception" + ex.toString());
        }
        finally {

            if(results != null) {
                results.close();
            }
            return restaurantList;
        }
    }

    public ArrayList<Restaurant> findRestaurantByName(String name){

        Cursor results=null;
        Restaurant restaurant=new Restaurant();
        ArrayList<Restaurant> restaurantList=new ArrayList<>();

        try{
            String query= String.format(
                    "SELECT * FROM %s WHERE %s COLLATE NOCASE = '%s' ",
                    RestaurantContract.RestaurantEntry.TABLE_NAME,
                    RestaurantContract.RestaurantEntry.COLUMN_RES_NAME,
                    name
            );

            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();
            Log.d(LOG_TAG,query);
            mReadableDatabase=db.getReadableDatabase();

            results=mReadableDatabase.rawQuery(query,null);
            Log.d(LOG_TAG,Integer.toString(results.getCount()));
            while (results.moveToNext()){
//
                restaurant= new Restaurant(
                        results.getInt(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_ID)),
                        results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_NAME)),
                        results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_LOCATION)),
                        results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_PHONENUM)),
                        results.getInt(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_RATINGS)),
                        results.getString(results.getColumnIndex(RestaurantContract.RestaurantEntry.COLUMN_RES_IMAGE))
                );
                restaurantList.add(restaurant);
            }
            return restaurantList;
        }
        catch (Exception ex){
            Log.d(LOG_TAG, "searchRestaurantByLocation: exception" + ex.toString());
        }
        finally {

            if(results != null) {
                results.close();
            }
            return restaurantList;
        }
    }

}
