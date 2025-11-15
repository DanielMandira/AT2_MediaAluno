# AT2 | Média Geral

Projeto para atividade avaliativa: aplicação Android em Kotlin usando POO e Jetpack Compose para gerenciar notas de um aluno.

Aluno: Daniel Augusto Mandira  
Data de conclusão: 17 de novembro de 2025 — 18:30

## Instruções
Desenvolver uma aplicação que permita cadastrar um aluno, lançar três notas parciais (TP1, TP2, TP3), calcular a média aritmética e exibir o resultado com o status final.

## Requisitos Funcionais
- Cadastro de Aluno: inserir nome completo.  
- Lançamento de Notas: inserir TP1, TP2 e TP3.  
- Cálculo da Média: média aritmética das três notas.  
- Avaliação de Desempenho:
    - Reprovado: média < 6.0
    - Aprovado: 6.0 ≤ média ≤ 9.0
    - Ótimo Aproveitamento: média > 9.0

## Requisitos Técnicos Obrigatórios
- POO: usar Classes/Data Classes para representar entidades (ex.: class Aluno).  
- UI: apenas Jetpack Compose.  
- Gerenciamento de estado: usar remember e/ou mutableStateOf para manter Aluno, notas e média.  
- Estrutura de dados: usar MutableList<Double> para armazenar as notas parciais dentro da classe Aluno.

