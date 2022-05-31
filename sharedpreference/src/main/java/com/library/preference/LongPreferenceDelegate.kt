package com.library.preference

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private class LongPreferenceDelegate(
    private val name: String,
    private val defaultValue: Long?,
    private val preferences: SharedPreferences?
) : ReadWriteProperty<Any, Long> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Long {
        return preferences?.getLong(name, defaultValue!!)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        preferences?.edit()?.putLong(name, value)?.apply()
    }
}

fun SharedPreferences.longPreference(
    name: String,
    defaultValue: Long?
): ReadWriteProperty<Any, Long> = LongPreferenceDelegate(name, defaultValue, this)