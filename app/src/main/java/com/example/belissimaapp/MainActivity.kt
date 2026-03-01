package com.example.belissimaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF8E1) // fundo amarelo claro
                ) {
                    BelissimaApp()
                }
            }
        }
    }
}

@Composable
fun BelissimaApp() {

    var produto by remember { mutableStateOf("") }
    val listaProdutos = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Belíssima Cosméticos",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFB300) // amarelo forte
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = produto,
            onValueChange = { produto = it },
            label = { Text("Digite o produto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (produto.isNotBlank()) {
                    listaProdutos.add(produto)
                    produto = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Adicionar",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(listaProdutos) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF176) // amarelo suave
                    )
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(12.dp),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}