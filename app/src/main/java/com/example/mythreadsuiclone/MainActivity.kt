package com.example.mythreadsuiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mythreadsuiclone.ui.MyNavGraph
import com.example.mythreadsuiclone.ui.theme.MyThreadsUICloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThreadsUICloneTheme {
                MyNavGraph()
            }
        }
    }
}