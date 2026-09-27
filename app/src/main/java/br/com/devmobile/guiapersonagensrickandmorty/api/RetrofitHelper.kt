package br.com.devmobile.guiapersonagensrickandmorty.api

import br.com.devmobile.guiapersonagensrickandmorty.util.Util
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {

    val loggingInterceptor = HttpLoggingInterceptor {
           HttpLoggingInterceptor.Level.BODY
           HttpLoggingInterceptor.Level.HEADERS
           HttpLoggingInterceptor.Level.BASIC
    }

    private val client = OkHttpClient.Builder()
         .addInterceptor(loggingInterceptor)
         .readTimeout(5000, TimeUnit.SECONDS)
         .writeTimeout(5000, TimeUnit.SECONDS)
         .connectTimeout(5000, TimeUnit.SECONDS)
         .build()

      val serviceApiRickMorty = Retrofit.Builder()
          .baseUrl(Util.URL_BASE)
          .addConverterFactory(GsonConverterFactory.create())
          .client(client)
          .build()
          .create(ServiceApiRickMorty::class.java)
}