package br.com.devmobile.guiapersonagensrickandmorty.repository

import androidx.lifecycle.liveData
import br.com.devmobile.guiapersonagensrickandmorty.api.RetrofitHelper
import br.com.devmobile.guiapersonagensrickandmorty.util.Status

class RepositryCharacter {

    val serviceApiRickMorty = RetrofitHelper.serviceApiRickMorty

    fun getListCharacter() = liveData {
          emit(Status.loader  )

          try{
               val response =  serviceApiRickMorty.getCharacter()
               emit(Status.OnSucess(response.body()!!.results))

          }catch (ex: Exception) {
               emit(Status.OnError("Erro ${ex.message}") )
          }

    }

}