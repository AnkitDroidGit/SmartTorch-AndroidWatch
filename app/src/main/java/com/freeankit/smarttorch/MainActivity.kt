package com.freeankit.smarttorch

import android.content.Context
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import  android.provider.Settings.System


class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        screenBrightness(255, this)


    }

    override fun onRestart() {
        super.onRestart()
        // Enables Always-on
        setAmbientEnabled()

        screenBrightness(255, this)
    }

    override fun onResume() {
        super.onResume()
        // Enables Always-on
        setAmbientEnabled()

        screenBrightness(255, this)
    }

    private fun screenBrightness(level: Int, context: Context): Boolean {

        try {
            System.putInt(context.contentResolver,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS, level)

            System.putInt(context.contentResolver,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)

            System.putInt(
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
