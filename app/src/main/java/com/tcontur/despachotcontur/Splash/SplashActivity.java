package com.tcontur.despachotcontur.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.tcontur.despachotcontur.Activities.LoginActivity;
import com.tcontur.despachotcontur.Activities.MainActivity;
import com.tcontur.despachotcontur.Utils.Util;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        if (!TextUtils.isEmpty(Util.getUsernamePrefs(prefs)) && !TextUtils.isEmpty(Util.getPasswordPrefs(prefs)) && !TextUtils.isEmpty(Util.getClavePrefs(prefs))) {
            startActivity(intentMain);
        } else {
            startActivity(intentLogin);
        }

    }

}
