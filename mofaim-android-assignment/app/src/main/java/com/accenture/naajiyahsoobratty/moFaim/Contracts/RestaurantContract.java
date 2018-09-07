package com.accenture.naajiyahsoobratty.moFaim.Contracts;

import android.provider.BaseColumns;

public class RestaurantContract {
    private RestaurantContract() {
    }

    public static class RestaurantEntry implements BaseColumns {

        public static final String TABLE_NAME = "RESTAURANT";

        public static final String COLUMN_RES_ID = "RESTAURANT_ID";
        public static final String COLUMN_RES_NAME = "RESTAURANT_NAME";
        public static final String COLUMN_RES_LOCATION = "RESTAURANT_LOCATION";
        public static final String COLUMN_RES_RATINGS = "RESTAURANT_RATINGS";
        public static final String COLUMN_RES_PHONENUM="RESTAURANT_PHONE_NO";
        public static final String COLUMN_RES_IMAGE="RESTAURANT_IMAGE";

    }
}
