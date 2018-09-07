package com.accenture.naajiyahsoobratty.moFaim.Contracts;

import android.provider.BaseColumns;

public class RatingsContract {

    public RatingsContract() {}

    public static class RatingsEntry implements BaseColumns {

        public static final String TABLE_NAME = "RATINGS";

        public static final String COLUMN_RESTAURANT_ID = "RESTAURANT_ID";
        public static final String COLUMN_USER_ID = "USER_ID";
        public static final String COLUMN_RATINGS = "RATINGS";
    }
}
