package com.supplements.posrockettask.helper

import android.app.Activity
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.WindowInsets
import androidx.annotation.NonNull


class HelperClass {

    companion object {

        fun calcSpanWidth(@NonNull activity: Activity , itemSize: Double): Int {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val windowMetrics = activity.windowManager.currentWindowMetrics
                val insets: Insets = windowMetrics.windowInsets
                    .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
                val matrix = windowMetrics.bounds.width() - insets.left - insets.right
                val density = activity.resources.displayMetrics.density
                val dpWidth = matrix / density
                (dpWidth / itemSize).toInt()


            } else {
                val displayMetrics = DisplayMetrics()
                activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
                val matrix = displayMetrics.widthPixels
                val density = activity.resources.displayMetrics.density
                val dpWidth = matrix / density
                (dpWidth / itemSize).toInt()
            }
        }

    }
}