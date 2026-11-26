package com.example.lab14glance.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.lab14glance.MainActivity
import com.example.lab14glance.SecondActivity
import com.example.lab14glance.data.MovieStore

class MovieWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MovieWidget()
}

class MovieWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val count = MovieStore.count(context)
        provideContent {
            GlanceTheme {
                MovieContent(count)
            }
        }
    }

    @Composable
    private fun MovieContent(count: Int) {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .padding(12.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Películas vistas",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onSurface
                )
            )
            Spacer(GlanceModifier.height(4.dp))
            Text(
                text = count.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = GlanceTheme.colors.primary
                )
            )
            Spacer(GlanceModifier.height(8.dp))
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Sumar",
                    onClick = actionRunCallback<AddMovieAction>()
                )
                Button(
                    text = "Resumen",
                    onClick = actionStartActivity<SecondActivity>()
                )
            }
        }
    }
}

class AddMovieAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        MovieStore.add(context)
        MovieWidget().update(context, glanceId)
    }
}
