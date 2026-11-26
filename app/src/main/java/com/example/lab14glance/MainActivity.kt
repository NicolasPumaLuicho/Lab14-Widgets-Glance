package com.example.lab14glance

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab14glance.ui.MainScreen
import com.example.lab14glance.ui.theme.Lab14Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14Theme {
                MainScreen(
                    onOpenSummary = {
                        startActivity(Intent(this, SecondActivity::class.java))
                    }
                )
            }
        }
    }
}
