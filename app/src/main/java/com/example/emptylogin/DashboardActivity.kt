package com.example.emptylogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emptylogin.ui.theme.EmptyLoginTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyLoginTheme {
                DashboardScreen(
                    onTemperatureClick = { navigateToTemperatureConverter() },
                    onGameClick = { navigateToRockPaperScissors() },
                    onBackClick = { finish() }  // Opción para regresar
                )
            }
        }
    }

    private fun navigateToTemperatureConverter() {
        val intent = Intent(this, TemperatureConverterActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToRockPaperScissors() {
        val intent = Intent(this, RockPaperScissorsActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun DashboardScreen(
    onTemperatureClick: () -> Unit,
    onGameClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF2F2F2)),  // Fondo gris claro
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Panel Principal",
            fontSize = 28.sp,  // Tamaño más grande para mayor visibilidad
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = { onTemperatureClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Convertidor de Temperatura", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onGameClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Piedra, Papel o Tijera", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onBackClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDD2C00)),  // Botón con color de alerta
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Regresar", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    EmptyLoginTheme {
        DashboardScreen(onTemperatureClick = {}, onGameClick = {}, onBackClick = {})
    }
}
