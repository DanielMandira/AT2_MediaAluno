package com.example.at2_mediaaluno.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.at2_mediaaluno.controller.AlunoController
import com.example.at2_mediaaluno.controller.filterTextToNumber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlunoView(controller: AlunoController) {
    val aluno = controller.aluno.value
    var tp1Text by remember { mutableStateOf("") }
    var tp2Text by remember { mutableStateOf("") }
    var tp3Text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Gestão de Notas do Aluno",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Campo Nome
        OutlinedTextField(
            value = aluno.nome,
            onValueChange = { controller.atualizarNome(it) },
            label = { Text("Nome Completo do Aluno") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            text = "Notas Parciais",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        // Campo TP1
        OutlinedTextField(
            value = tp1Text,
            onValueChange = { novoTexto ->
                val textoFiltrado = filterTextToNumber(novoTexto)
                tp1Text = textoFiltrado
                textoFiltrado.toDoubleOrNull()?.let { nota ->
                    if (nota in 0.0..10.0) {
                        controller.atualizarNota(0, nota)
                    }
                }
            },

            label = { Text("TP1") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        // Campo TP2
        OutlinedTextField(
            value = tp2Text,
            onValueChange = { novoTexto ->
                val textoFiltrado = filterTextToNumber(novoTexto)
                tp2Text = textoFiltrado
                textoFiltrado.toDoubleOrNull()?.let { nota ->
                    if (nota in 0.0..10.0) {
                        controller.atualizarNota(1, nota)
                    }
                }
            },
            label = { Text("TP2") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        // Campo TP3
        OutlinedTextField(
            value = tp3Text,
            onValueChange = { novoTexto ->
                val textoFiltrado = filterTextToNumber(novoTexto)
                tp3Text = textoFiltrado
                textoFiltrado.toDoubleOrNull()?.let { nota ->
                    if (nota in 0.0..10.0) {
                        controller.atualizarNota(0, nota)
                    }
                }
            },
            label = { Text("TP3") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // Resultados
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Aluno: ${aluno.nome.ifEmpty { "Não informado" }}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "TP1: ${aluno.notas[0]}",
                    fontSize = 16.sp
                )
                Text(
                    text = "TP2: ${aluno.notas[1]}",
                    fontSize = 16.sp
                )
                Text(
                    text = "TP3: ${aluno.notas[2]}",
                    fontSize = 16.sp
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text(
                    text = "Média Geral: ${"%.2f".format(aluno.calcularMedia())}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                val status = aluno.obterStatus()
                val statusColor = when (status) {
                    "Reprovado" -> Color.Red
                    "Aprovado" -> Color.Green
                    else -> Color.Blue
                }

                Text(
                    text = "Status: $status",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = statusColor
                )
            }
        }

        // Botão Limpar
        Button(
            onClick = {
                controller.limparDados()
                tp1Text = ""
                tp2Text = ""
                tp3Text = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar Dados")
        }
    }
}