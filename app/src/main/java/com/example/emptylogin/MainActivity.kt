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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyLoginTheme {
                LoginScreen { navigateToDashboard() }
            }
        }
    }

    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFB8FFD3)),  // Color de fondo suave y agradable
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Iniciar Sesión",
            fontSize = 28.sp,  // Tamaño de letra un poco más grande para el título
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008080),  // Un color agradable y fresco
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),  // Campo de texto con fondo blanco
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username == "admin" && password == "1234") {
                    onLoginSuccess()
                } else {
                    errorMessage = "Credenciales inválidas"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),  // Espaciado más generoso
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008080))  // Color de botón más atractivo
        ) {
            Text("Iniciar Sesión", fontSize = 18.sp, color = Color.White)
        }

        errorMessage?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it, color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EmptyLoginTheme {
        LoginScreen(onLoginSuccess = {})
    }
}

