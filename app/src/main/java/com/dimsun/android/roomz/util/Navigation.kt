package com.dimsun.android.roomz.util

import android.content.Context
import android.content.Intent
import com.dimsun.android.roomz.ui.InsertActivity

interface Navigation {
    fun goToInsertActivity()
}

class NavigationImpl(private val context: Context) : Navigation {

    override fun goToInsertActivity() {
        val intent = Intent(context, InsertActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
