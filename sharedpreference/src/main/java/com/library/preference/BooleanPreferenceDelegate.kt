package com.library.preference

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreferenceDelegate ( private val name: String,
private val defaultValue: Boolean,
private val preferences: SharedPreferences?
) : ReadWriteProperty<Any, Boolean> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean=
        preferences?.getBoolean(name,defaultValue) == true

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        preferences?.edit()?.putBoolean(name, value)?.apply()
    }
}
fun SharedPreferences?.booleanPreference(name: String, defaultValue: Boolean): ReadWriteProperty<Any, Boolean> = BooleanPreferenceDelegate(name, defaultValue, this)
