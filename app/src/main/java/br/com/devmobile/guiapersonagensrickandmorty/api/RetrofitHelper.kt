package br.com.devmobile.guiapersonagensrickandmorty.api

import br.com.devmobile.guiapersonagensrickandmorty.util.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
      val serviceApiRickMorty = Retrofit.Builder()
          .baseUrl(Util.URL_BASE)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(ServiceApiRickMorty::class.java)
}