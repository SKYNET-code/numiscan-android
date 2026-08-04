package com.numiscan.app.utils

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator


object HapticManager {


    fun success(

        context: Context

    ) {


        val vibrator =
            context.getSystemService(
                Context.VIBRATOR_SERVICE
            )
            as Vibrator



        vibrator.vibrate(

            VibrationEffect.createOneShot(

                40,

                VibrationEffect.DEFAULT_AMPLITUDE

            )

        )

    }

}
