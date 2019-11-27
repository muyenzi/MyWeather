package com.moringaschool.myweather.models;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Common {

        public static final String APP_ID = "eeaa6ec7dfa8a14d7a98f77796f8bcda";
        public static Location current_location=null;

    public static String convertUnixToDate(long dt) {
        Date date = new Date(dt*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd EEE MM yyyy");
        String formatted = sdf.format(date);
        return formatted;
    }
}
