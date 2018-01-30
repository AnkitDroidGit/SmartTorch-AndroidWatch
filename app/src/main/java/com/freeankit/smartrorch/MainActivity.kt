package com.freeankit.smartrorch

import android.content.Context
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log


class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        screenBrightness(100, this)


    }

    fun screenBrightness(level: Int, context: Context): Boolean {

        try {
            android.provider.Settings.System.putInt(
                    context.contentResolver,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS, level)


            android.provider.Settings.System.putInt(context.contentResolver,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)

            android.provider.Settings.System.putInt(
                    context.contentResolver,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS,
                    level)


            return true
        } catch (e: Exception) {
            Log.e("Screen Brightness", "error changing screen brightness")
            return false
        }

    }
}
