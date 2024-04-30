package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contador.ui.theme.ContadorTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var contador by remember { mutableStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "$contador",
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    Row (modifier=modifier.padding(16.dp).align(Alignment.Start)){
        Button(onClick = { if (contador<10)contador++
                            else contador=0}) {
            Text(text = "Suma")
        }
        Button(onClick = { contador=0 }) {
            Text(text = "Reinicia")
        }
        Button(onClick = { if (contador!=0) contador -- }) {
            Text(text = "Resta")
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContadorTheme {
        Greeting("Android")
    }
}