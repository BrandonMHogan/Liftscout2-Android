package com.brandonhogan.liftscout.managers

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Manages shared preferences, creating shorthand methods for setting and getting properties
 */

class PrefManager @Inject constructor(val context: Context, val preferences: SharedPreferences) {

    /**
     * Main Settings
     */
//    var adFrequency: Int
//        get() = preferences.getInt(AD_FREQUENCY_KEY, 0)
//        set(value) = preferences.edit().putInt(AD_FREQUENCY_KEY, value).apply()

    /**
     * Getter only function for setting listeners
     */
    var getPreference: SharedPreferences = preferences
        get() = preferences

    /**
     * Clears all preferences
     */
    fun clearAll() {
        preferences.all.clear()
    }
}