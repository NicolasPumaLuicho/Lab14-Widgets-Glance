package com.example.lab14glance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab14glance.ui.SummaryScreen
import com.example.lab14glance.ui.theme.Lab14Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14Theme {
                SummaryScreen(onBack = { finish() })
            }
        }
    }
}
