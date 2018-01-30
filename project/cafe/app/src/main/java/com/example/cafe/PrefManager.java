package com.example.cafe;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private final Context mContext;
    private final SharedPreferences mPref;
    private final SharedPreferences.Editor mEditor;
    private static final String PREF_NAME = "prefname";
    private static final String IS_FIRST_TIME_LAUNCH = "first time launch";

    public PrefManager(Context context) {
        this.mContext = context;
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public void setFirstTimeLaunch( boolean isFirstTime) {
        mEditor.putBoolean( IS_FIRST_TIME_LAUNCH, isFirstTime );
        mEditor.apply();
    }

    public  boolean isFirstTimeLaunch() {
        return mPref.getBoolean( IS_FIRST_TIME_LAUNCH, false );
    }
}
