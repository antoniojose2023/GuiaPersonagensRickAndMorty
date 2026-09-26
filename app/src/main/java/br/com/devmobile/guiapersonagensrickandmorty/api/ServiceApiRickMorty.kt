package br.com.devmobile.guiapersonagensrickandmorty.api

import br.com.devmobile.guiapersonagensrickandmorty.model.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApiRickMorty {

    @GET("character")
    suspend fun getCharacter(): Response<ResponseCharacter>
}