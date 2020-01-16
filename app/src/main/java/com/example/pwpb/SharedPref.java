package com.example.pwpb;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    SharedPreferences mySharedPref;
    public SharedPref(Context context){
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void SetTheme(String string) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("theme", string);
        editor.commit();
    }

    public String LoadTheme() {
        String state = mySharedPref.getString("theme", "1");
        return state;
    }

}
