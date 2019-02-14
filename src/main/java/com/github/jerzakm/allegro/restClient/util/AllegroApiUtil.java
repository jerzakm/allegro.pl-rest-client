package com.github.jerzakm.allegro.restClient.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AllegroApiUtil {
    public static long stringToTimestamp(String date) {
        date = date.substring(0,16);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        long millis = 0;
        try {
            millis = sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millis;
    }
}
