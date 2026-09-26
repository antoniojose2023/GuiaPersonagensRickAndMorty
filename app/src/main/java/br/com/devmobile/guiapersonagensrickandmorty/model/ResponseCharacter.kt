package br.com.devmobile.guiapersonagensrickandmorty.model

data class ResponseCharacter(
    val info: Info,
    val results: List<Result>
)