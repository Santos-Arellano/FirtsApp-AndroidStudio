package com.example.emptylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight  // Import agregado
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emptylogin.ui.theme.EmptyLoginTheme

class RockPaperScissorsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyLoginTheme {
                RockPaperScissorsScreen()
            }
        }
    }
}

@Composable
fun RockPaperScissorsScreen() {
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Piedra, Papel o Tijera",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,  // Usando FontWeight
            modifier = Modifier.padding(bottom = 24.dp)
        )

        val options = listOf("Piedra", "Papel", "Tijera")

        options.forEach { playerChoice ->
            Button(
                onClick = {
                    val computerChoice = options.random()
                    result = determineWinner(playerChoice, computerChoice)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Jugar con $playerChoice", fontSize = 16.sp)
            }
        }

        result?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(it, fontSize = 18.sp)
        }
    }
}

fun determineWinner(player: String, computer: String): String {
    return when {
        player == computer -> "Empate! Ambos eligieron $player."
        player == "Piedra" && computer == "Tijera" -> "Ganaste! Piedra vence a Tijera."
        player == "Papel" && computer == "Piedra" -> "Ganaste! Papel vence a Piedra."
        player == "Tijera" && computer == "Papel" -> "Ganaste! Tijera vence a Papel."
        else -> "Perdiste! El computador eligió $computer."
    }
}

@Preview(showBackground = true)
@Composable
fun RockPaperScissorsPreview() {
    EmptyLoginTheme {
        RockPaperScissorsScreen()
    }
}
