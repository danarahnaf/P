package com.example.pwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs = null;
    SharedPref theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        theme = new SharedPref(this);
        String vari = "2";
//
//        switch (theme.LoadTheme()) {
            switch (vari) {
            case "1":
                setTheme(R.style.Theme1);
                break;
            case "2":
                setTheme(R.style.Theme2);
                break;
//            case "3":
//                setTheme(R.style.Theme3);
//                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,navigatorview.class));
                finish();
            }
        },2000);

        prefs = getSharedPreferences("com.example.pwpb", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {

            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }
}
