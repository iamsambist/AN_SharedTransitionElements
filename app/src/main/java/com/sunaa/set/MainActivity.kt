package com.sunaa.set

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sunaa.set.withoutshared.presentation.ScreenMainView
import com.sunaa.set.ui.theme.SETTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SETTheme {
                ScreenMainView()
            }
        }
    }
}
