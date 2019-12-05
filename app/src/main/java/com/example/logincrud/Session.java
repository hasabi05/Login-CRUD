package com.example.logincrud;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    private static Session session;
    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private Context context;

    private int PRIVATE_MODE= 0;
    private static final String PREF_NAME = "Sessions";

    public static String name = "name";
    public static String email = "email";

    public Session(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static Session getInstance(Context context){
        if(session==null){
            session = new Session(context);

        }
        return session;
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return pref.getString(key,"");
    }
    public void logout(){
        editor.clear();
        editor.commit();
    }
}
