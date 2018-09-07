package com.accenture.naajiyahsoobratty.moFaim.Contracts;

import android.provider.BaseColumns;

public final class UserContract {

    private UserContract() {
    }

    public static class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "USER";
        public static final String COLUMN_USER_ID = "USER_ID";
        public static final String COLUMN_USER_NAME = "USER_NAME";
        public static final String COLUMN_USER_EMAILADDRESS = "USER_EMAIL";
        public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";

    }


}