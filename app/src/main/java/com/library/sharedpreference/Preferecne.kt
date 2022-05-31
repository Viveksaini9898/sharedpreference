package com.library.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.library.preference.longPreference

class Preference(context: Context) {

    private var preferences: SharedPreferences? = null

    init {
        preferences = context.getSharedPreferences(MY_PREFS_NAME, 0)
    }

    fun edit(): SharedPreferences.Editor? {
        return preferences?.edit()
    }

    var text by preferences!!.longPreference("long", 121234567)
}


const val MY_PREFS_NAME = "MY_PREFS_NAME"