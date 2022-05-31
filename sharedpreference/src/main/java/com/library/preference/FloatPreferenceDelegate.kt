package com.library.preference

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private class FloatPreferenceDelegate(
    private val name: String,
    private val defaultValue: Float?,
    private val preferences: SharedPreferences?
) : ReadWriteProperty<Any, Float> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Float {
        return preferences?.getFloat(name, defaultValue!!)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) {
        preferences?.edit()?.putFloat(name, value)?.apply()
    }
}

fun SharedPreferences.floatPreference(
    name: String,
    defaultValue: Float?
): ReadWriteProperty<Any, Float> = FloatPreferenceDelegate(name, defaultValue, this)