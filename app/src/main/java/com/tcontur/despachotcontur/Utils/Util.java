package com.tcontur.despachotcontur.Utils;

import android.content.SharedPreferences;

public class Util {

    public static String getUsernamePrefs(SharedPreferences preferences) {
        return preferences.getString("username", "");
    }

    public static  String getPasswordPrefs(SharedPreferences preferences) {
        return preferences.getString("password", "");
    }

    public static  String getClavePrefs(SharedPreferences preferences) {
        return preferences.getString("clave", "");
    }
}
