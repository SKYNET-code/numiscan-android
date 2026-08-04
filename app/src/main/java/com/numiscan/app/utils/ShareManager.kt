package com.numiscan.app.utils

import android.content.Context
import android.content.Intent


object ShareManager {


    fun share(

        context: Context,

        text: String

    ) {


        val intent = Intent(
            Intent.ACTION_SEND
        )


        intent.type = "text/plain"


        intent.putExtra(
            Intent.EXTRA_TEXT,
            text
        )


        context.startActivity(
            Intent.createChooser(
                intent,
                "اشتراک‌گذاری با"
            )
        )

    }

}
