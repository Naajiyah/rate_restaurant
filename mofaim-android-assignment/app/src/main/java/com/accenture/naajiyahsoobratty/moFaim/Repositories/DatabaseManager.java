package com.accenture.naajiyahsoobratty.moFaim.Repositories;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.accenture.naajiyahsoobratty.moFaim.Contracts.MenuContract;
import com.accenture.naajiyahsoobratty.moFaim.Contracts.RatingsContract;
import com.accenture.naajiyahsoobratty.moFaim.Contracts.RestaurantContract;
import com.accenture.naajiyahsoobratty.moFaim.Contracts.UserContract;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Ratings;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String LOG_TAG=DatabaseManager.class.getSimpleName();
    private static final String DATABASE_NAME="javatraining";
    private static final Integer DATABASE_VERSION=1;
    public DatabaseManager(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    private static final String CREATE_TABLE_USER=
            "CREATE TABLE "+ UserContract.UserEntry.TABLE_NAME+"("+
                    UserContract.UserEntry.COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    UserContract.UserEntry.COLUMN_USER_NAME+" TEXT,"+
                    UserContract.UserEntry.COLUMN_USER_EMAILADDRESS+" TEXT,"+
                    UserContract.UserEntry.COLUMN_USER_PASSWORD+" TEXT)";


   public static final String  INSERT_INTO_USER =
           "INSERT INTO USER VALUES(null, 'Naajiyah', 'abc@gmail.com', '1234')";

    private static final String CREATE_TABLE_RESTAURANT=
            "CREATE TABLE "+ RestaurantContract.RestaurantEntry.TABLE_NAME+" ("+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_ID+" INTEGER PRIMARY KEY,"+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_NAME+" TEXT,"+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_LOCATION+" TEXT,"+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_PHONENUM+" TEXT,"+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_RATINGS+" INTEGER,"+
                    RestaurantContract.RestaurantEntry.COLUMN_RES_IMAGE+" TEXT)";

    private static final String INSERT_INTO_RESTAURANT=
            "INSERT INTO RESTAURANT VALUES(1,'McDonalds','Port-Louis',222-2222,8,'mcdonalds'),"+
            "(2,'Panarotti','Bagatelle',111-2222,10,'panarotti'),"+
                    "(3,'KFC','Curepipe',111-22282,10,'kfc'),"+
                    "(4,'Ocean Basket','Grand-Baie',111-2232,10,'oceanbasket'),"+
                    "(5,'Mug & Beans','Curepipe',111-2292,10,'mugandbeans'),"+
                    "(6,'SEN & KEN','Vacoas',113-2222,10,'senandken'),"+
                    "(7,'Charlie','Quatre-Bornes',111-2222,10,'charlie'),"+
                    "(8,'BNG','Curepipe',129-2222,10,'burger'),"+
                    "(9,'Sittar','Bagatelle',111-29382,10,'sittar'),"+
                    "(10,'Debonnaires','Vacoas',1083-2222,10,'debonnaire')";

    private static final String CREATE_TABLE_MENU =
            "CREATE TABLE " + MenuContract.MenuEntry.TABLE_NAME + " (" +
            MenuContract.MenuEntry.COLUMN_MENU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            MenuContract.MenuEntry.COLUMN_MENU_NAME + " TEXT," +
            MenuContract.MenuEntry.COLUMN_MENU_DETAILS + " TEXT," +
            MenuContract.MenuEntry.COLUMN_MENU_PRICE + " TEXT," +
            MenuContract.MenuEntry.COLUMN_MENU_IMAGE + " TEXT," +
            MenuContract.MenuEntry.COLUMN_RESTAURANT_ID + " INTEGER," +
            "FOREIGN KEY ("+ MenuContract.MenuEntry.COLUMN_RESTAURANT_ID+") REFERENCES " +
            RestaurantContract.RestaurantEntry.TABLE_NAME + " (" +
            RestaurantContract.RestaurantEntry.COLUMN_RES_ID +"))";

    private static final String INSERT_INTO_MENU=
            "INSERT INTO MENU VALUES(null,'BigMac','Non-Veg',100,'image1',1),"+
                    "(null,'Chicken Wings','Non-Veg',75,'image2',1),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',1),"+

                    "(null,'Beef pizza','Non-Veg',300,'image1',2),"+
                    "(null,'Pasta','Non-Veg',250,'image2',2),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',2),"+

                    "(null,'Beef burger','Non-Veg',160,'image1',3),"+
                    "(null,'Chicken wings','Non-Veg',390,'image2',3),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',3),"+

                    "(null,'Prawns','Non-Veg',160,'image1',4),"+
                    "(null,'Fish and Chips','Non-Veg',260,'image2',4),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',4),"+


                    "(null,'Beef Burger','Non-Veg',160,'image1',5),"+
                    "(null,'Chicken Wings','Non-Veg',260,'image2',5),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',5),"+

                    "(null,'Beef boulettes','Non-Veg',60,'image1',6),"+
                    "(null,'Chicken boulettes','Non-Veg',60,'image2',6),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',6),"+

                    "(null,'Beef boulettes','Non-Veg',160,'image1',7),"+
                    "(null,'Chicken','Non-Veg',660,'image2',7),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',7),"+

                    "(null,'Beef burger','Non-Veg',320,'image1',8),"+
                    "(null,'Chicken','Non-Veg',360,'image2',8),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',8),"+

                    "(null,'Beef pulao','Non-Veg',360,'image1',9),"+
                    "(null,'Chicken masala','Non-Veg',560,'image2',9),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',9),"+

                    "(null,'Beef pizza','Non-Veg',60,'image1',10),"+
                    "(null,'Chicken pizza','Non-Veg',60,'image2',10),"+
                    "(null,'Soft Drinks','Available cold',60,'image3',10)";

    private static final String CREATE_TABLE_RATINGS =
            "CREATE TABLE " + RatingsContract.RatingsEntry.TABLE_NAME + " (" +
                    RatingsContract.RatingsEntry.COLUMN_RATINGS+ " INTEGER,"+
                    RatingsContract.RatingsEntry.COLUMN_RESTAURANT_ID+ " INTEGER,"+
                    RatingsContract.RatingsEntry.COLUMN_USER_ID+ " INTEGER,"+
                    "PRIMARY KEY ("+ RatingsContract.RatingsEntry.COLUMN_USER_ID+","+RatingsContract.RatingsEntry.COLUMN_RESTAURANT_ID+"),"+
                    "FOREIGN KEY ("+ RatingsContract.RatingsEntry.COLUMN_RESTAURANT_ID+") REFERENCES " +
                    RestaurantContract.RestaurantEntry.TABLE_NAME + " (" +
                    RestaurantContract.RestaurantEntry.COLUMN_RES_ID +"),"+
                    "FOREIGN KEY ("+ RatingsContract.RatingsEntry.COLUMN_USER_ID+") REFERENCES " +
                    UserContract.UserEntry.TABLE_NAME + " (" +
                    UserContract.UserEntry.COLUMN_USER_ID +"))";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG_TAG,"onCreate : Initiating database-Start");

        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(INSERT_INTO_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_RESTAURANT);
        sqLiteDatabase.execSQL(INSERT_INTO_RESTAURANT);
        sqLiteDatabase.execSQL(CREATE_TABLE_MENU);
        sqLiteDatabase.execSQL(INSERT_INTO_MENU);
        sqLiteDatabase.execSQL(CREATE_TABLE_RATINGS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(LOG_TAG,"onUpgrade: Upgrading DB-Start");

    }

    public void initiateDatabase() {
        try {
            onCreate(getWritableDatabase());

        } catch (Exception ex) {
            Log.d(LOG_TAG, "initiateDatabase: exception" + ex.toString());
        }
    }

}
