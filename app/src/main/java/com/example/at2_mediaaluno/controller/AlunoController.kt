package com.example.at2_mediaaluno.controller

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.at2_mediaaluno.model.Aluno

class AlunoController{
    private val _aluno = mutableStateOf(Aluno())
    val aluno: State<Aluno> = _aluno

    fun atualizarNome(novoNome: String){
        _aluno.value = _aluno.value.copy(nome = novoNome)
    }

    fun atualizarNota(indice: Int, nota: Double){
        if(indice in 0..2){
            val notasAtualizadas = _aluno.value.notas.toMutableList()
            notasAtualizadas[indice] = nota
            _aluno.value = _aluno.value.copy(notas = notasAtualizadas)
        }
    }
    fun limparDados(){
        _aluno.value = Aluno()
    }
}