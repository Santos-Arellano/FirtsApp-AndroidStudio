package com.example.emptylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emptylogin.ui.theme.EmptyLoginTheme

class TemperatureConverterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyLoginTheme {
                TemperatureConverterScreen()
            }
        }
    }
}

@Composable
fun TemperatureConverterScreen() {
    var temperatureInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = temperatureInput,
            onValueChange = { temperatureInput = it },
            label = { Text("Temperatura en Celsius") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val celsius = temperatureInput.toFloatOrNull()
                result = if (celsius != null) {
                    val fahrenheit = celsius * 9 / 5 + 32
                    "$celsius°C = $fahrenheit°F"
                } else {
                    "Entrada inválida"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convertir a Fahrenheit")
        }

        result?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TemperatureConverterPreview() {
    EmptyLoginTheme {
        TemperatureConverterScreen()
    }
}