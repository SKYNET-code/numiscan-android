package com.numiscan.app.utils


import android.content.ClipData
import android.content.Context


object ClipboardManager {


    fun copy(

        context: Context,

        text: String

    ){


        val clipboard =
            context.getSystemService(
                Context.CLIPBOARD_SERVICE
            )
            as android.content.ClipboardManager



        clipboard.setPrimaryClip(

            ClipData.newPlainText(

                "NumiScan",

                text

            )

        )

    }



    fun paste(

        context: Context

    ): String {


        val clipboard =
            context.getSystemService(
                Context.CLIPBOARD_SERVICE
            )
            as android.content.ClipboardManager



        if(
            !clipboard.hasPrimaryClip()
        ){

            return ""

        }



        return clipboard
            .primaryClip
            ?.getItemAt(0)
            ?.text
            ?.toString()
            ?: ""

    }

}
