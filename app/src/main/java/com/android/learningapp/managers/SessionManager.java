package com.android.learningapp.managers;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME="elearning";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
