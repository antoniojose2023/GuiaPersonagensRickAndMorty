package br.com.devmobile.guiapersonagensrickandmorty.model

import kotlinx.serialization.Serializer
import java.io.Serializable

data class Origin(
    val name: String,
    val url: String
): Serializable