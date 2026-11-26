package com.example.lab14glance.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
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

class SimpleWidget : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = SimpleWidgetContent()
}

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(12.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MovieCounter",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onBackground
                )
            )
            Spacer(GlanceModifier.height(4.dp))
            Text(
                text = "¿A dónde quieres ir?",
                style = TextStyle(color = GlanceTheme.colors.onBackground)
            )
            Spacer(GlanceModifier.height(8.dp))
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Inicio",
                    onClick = actionStartActivity<MainActivity>()
                )
                Spacer(GlanceModifier.height(0.dp))
                Button(
                    text = "Resumen",
                    onClick = actionStartActivity<SecondActivity>()
                )
            }
        }
    }
}
