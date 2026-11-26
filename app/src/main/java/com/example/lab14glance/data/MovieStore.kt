package com.example.lab14glance.data

import android.content.Context
import androidx.glance.appwidget.updateAll
import com.example.lab14glance.widget.MovieWidget
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object MovieStore {
    private const val PREFS = "movie_widget"
    private const val KEY_COUNT = "count"

    fun count(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY_COUNT, 0)

    fun add(context: Context): Int {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val next = prefs.getInt(KEY_COUNT, 0) + 1
        prefs.edit().putInt(KEY_COUNT, next).apply()
        return next
    }

    fun reset(context: Context) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().clear().apply()
    }

    fun refreshWidgets(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            MovieWidget().updateAll(context)
        }
    }
}
