package com.example.slide;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static final String PREF_NAME = "Wellcome";
    private static final String IS_FIRST_TIME_LAUNCH = "isFirstTimeLaunch";

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public PrefManager( Context context ) {
        this.mContext = context;
        mPref = context.getSharedPreferences( PREF_NAME , Context.MODE_PRIVATE );
        mEditor = mPref.edit();
    }

    public void setFirstTimeLaunch ( boolean isFirstTime ){
        mEditor.putBoolean( IS_FIRST_TIME_LAUNCH , isFirstTime );
        mEditor.apply();
    }

    public boolean isFirstTimeLaunch(){
        return mPref.getBoolean( IS_FIRST_TIME_LAUNCH , false );
    }
}
