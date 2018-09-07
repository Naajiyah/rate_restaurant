package com.accenture.naajiyahsoobratty.moFaim.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.accenture.naajiyahsoobratty.moFaim.Contracts.MenuContract;
import com.accenture.naajiyahsoobratty.moFaim.Contracts.RestaurantContract;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Menu;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;

import java.util.ArrayList;

public class MenuRepository {

    private static final String LOG_TAG = "MenuRepository";

    private DatabaseManager db;

    public MenuRepository(Context context) {
        db = new DatabaseManager(context);
    }

    public ArrayList<Menu> findMenuByRestaurantId(Integer restaurant_id){

        Cursor results=null;
        ArrayList<Menu> menuList=new ArrayList<>();

        try{
            String query= String.format(
                    "SELECT * FROM %s WHERE %s = '%s' ",
                    MenuContract.MenuEntry.TABLE_NAME,
                    RestaurantContract.RestaurantEntry.COLUMN_RES_ID,
                    restaurant_id
            );

            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();
            Log.d(LOG_TAG,query);
            mReadableDatabase=db.getReadableDatabase();

            results=mReadableDatabase.rawQuery(query,null);
            Log.d(LOG_TAG,Integer.toString(results.getCount()));
            while (results.moveToNext()){
//
                Menu menu= new Menu(
                        results.getInt(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_MENU_ID)),
                        results.getString(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_MENU_NAME)),
                        results.getInt(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_MENU_PRICE)),
                        results.getString(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_MENU_DETAILS)),
                        results.getString(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_MENU_IMAGE)),
                        results.getInt(results.getColumnIndex(MenuContract.MenuEntry.COLUMN_RESTAURANT_ID))
                );
                menuList.add(menu);

            }

            return menuList;
        }
        catch (Exception ex){
            Log.d(LOG_TAG, "searchMenuByRestaurantId: exception" + ex.toString());
        }
        finally {

            if(results != null) {
                results.close();
            }
            return menuList;
        }
    }





}
