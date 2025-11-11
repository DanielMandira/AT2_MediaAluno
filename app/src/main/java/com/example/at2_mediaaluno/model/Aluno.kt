package com.example.at2_mediaaluno.model

data class Aluno(
    val nome: String = "",
    val notas: MutableList<Double> = mutableListOf(0.0, 0.0, 0.0)
){
    fun calcularMedia(): Double {
        return if (notas.size == 3) {
            notas.sum() / 3.0
        } else {
            0.0
        }
    }
    fun obterStatus(): String {
        val media = calcularMedia()
        return when {
            media < 6.0 -> "Reprovado"
            media in 6.0..9.0 -> "Aprovado"
            else -> "Ótimo Aproveitamento"
        }
    }
}