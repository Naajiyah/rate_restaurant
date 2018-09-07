package com.accenture.naajiyahsoobratty.moFaim.Contracts;

import android.provider.BaseColumns;

public class MenuContract {

    private MenuContract(){}

    public static class MenuEntry implements BaseColumns {

        public static final String TABLE_NAME = "MENU";

        public static final String COLUMN_MENU_ID="MENU_ID";
        public static final String COLUMN_MENU_NAME = "MENU_NAME";
        public static final String COLUMN_MENU_PRICE = "MENU_PRICE";
        public static final String COLUMN_MENU_DETAILS = "MENU_DETAILS";
        public static final String COLUMN_MENU_IMAGE="MENU_IMAGE";
        public static final String COLUMN_RESTAURANT_ID = "RESTAURANT_ID";


    }


}
