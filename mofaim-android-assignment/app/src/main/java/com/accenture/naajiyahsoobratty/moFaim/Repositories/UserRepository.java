package com.accenture.naajiyahsoobratty.moFaim.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.accenture.naajiyahsoobratty.moFaim.Contracts.UserContract;
import com.accenture.naajiyahsoobratty.moFaim.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String LOG_TAG = "UserRepository";

    private DatabaseManager db;
    private SQLiteDatabase mWritableDatabase;
    private SQLiteDatabase mReadableDatabase;

    public UserRepository(Context context) {
        db = new DatabaseManager(context);
    }

    public void insertUser(User user){
        try{

            mWritableDatabase=db.getWritableDatabase();

            mWritableDatabase.execSQL("INSERT INTO USER VALUES(null,'"+user.getUserName()+"','"+user.getEmail()+"','"+user.getPassword()+"')");
        }
        catch (Exception ex){
            Log.d(LOG_TAG,"Insert user: exception"+ ex.toString());
        }
    }
    public List<User> getAllUsers(){
        Cursor results=null;
        List<User> userList=new ArrayList<>();

        try {
            String query = "SELECT * FROM "+ UserContract.UserEntry.TABLE_NAME;
            SQLiteDatabase mReadableDatabase = db.getReadableDatabase();

            results = mReadableDatabase.rawQuery(query, null);

            while (results.moveToNext()) {
                User user = new User(
                        results.getInt(0),
                        results.getString(1),
                        results.getString(2),
                        results.getString(3));

                //Log.d(LOG_TAG,results.getString(0));

                userList.add(user);
            }
            System.out.print(userList);
            return userList;

        }
        catch (Exception ex){
            Log.d(LOG_TAG,"getAllUsers : exception"+ex.toString());

        }
        finally {
            if(results!=null){
                results.close();
            }

            return userList;
        }

    }

    public User loginAuthentication(String username,String password){

        Cursor results=null;
        User user = null;
        try{
            String query= String.format(
                    "SELECT * FROM %s WHERE %s = '%s' AND %s = '%s' ",
                    UserContract.UserEntry.TABLE_NAME,
                    UserContract.UserEntry.COLUMN_USER_NAME,
                    username,
                    UserContract.UserEntry.COLUMN_USER_PASSWORD,
                    password
            );
            Log.d(LOG_TAG,query);
            mReadableDatabase=db.getReadableDatabase();

            results=mReadableDatabase.rawQuery(query,null);
            Log.d(LOG_TAG,Integer.toString(results.getCount()));
            while (results.moveToNext()){
                user = new User(
                        results.getInt(results.getColumnIndex("USER_ID")),
                        results.getString(results.getColumnIndex("USER_NAME")),
                        results.getString(results.getColumnIndex("USER_EMAIL")),
                        results.getString(results.getColumnIndex("USER_PASSWORD"))
                );

            }
            Log.d(LOG_TAG, "user "+results.getString(results.getColumnIndex("USER_NAME")));
            System.out.print("User Found: " + user.getUserName());
            return user;
        }
        catch (Exception ex){
            Log.d(LOG_TAG, "searchByUsernamePassword: exception" + ex.toString());
        }
        finally {
            //Log.d(LOG_TAG, "something went wrong ");
            if(results != null) {
                results.close();
            }
            return user;
        }
    }




}
