package com.example.at2_mediaaluno.controller

fun filterTextToNumber(text: String): String{
    val standardizedText = text.replace(',', '.')

    return standardizedText
        .filterIndexed { index, char ->
            char.isDigit() ||
                    (char == '.' && standardizedText.indexOf('.') == index)
        }
}