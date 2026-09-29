package com.example.launchedeffectstarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.launchedeffectstarter.ui.theme.LaunchedEffectStarterTheme

class MainActivity : ComponentActivity() {

    val viewModel : SongsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var artistState by remember { mutableStateOf("") }
            viewModel.liveArtist.observe(this) {
                artistState = it
            }
            Scaffold { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal=8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text("Artist:", modifier=Modifier.weight(1.0f).align(Alignment.CenterVertically), textAlign = TextAlign.Center, fontSize = 24.sp)
                        TextField(value=artistState, onValueChange = {
                            viewModel.artist = it
                        }, modifier = Modifier.weight(1.0f))

                    }
                    Text(modifier = Modifier.fillMaxHeight().padding(16.dp), fontSize = 16.sp, text="Results here")
                }
            }
        }
    }
}

