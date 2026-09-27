package br.com.devmobile.guiapersonagensrickandmorty.api

import br.com.devmobile.guiapersonagensrickandmorty.model.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApiRickMorty {

    @GET("character")
    suspend fun getCharacter(
         @Query("name") nome: String,
         @Query("pages") page: Int
    ): Response<ResponseCharacter>
}