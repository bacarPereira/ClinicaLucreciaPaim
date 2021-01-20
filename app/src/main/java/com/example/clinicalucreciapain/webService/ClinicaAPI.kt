package com.example.clinicalucreciapain.webService

import com.proitappsolutions.xpressentregas.repository.remoteDataSource.retrofit.webServices.ClinicaInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClinicaAPI {
    //URL_BASE BASE
    private val URL_BASE = "https://deliverapi.xpressentregas.com/"
    val URL_BASE_INTERNET_COMPARATOR = "deliverapi.xpressentregas.com"
//"ws://" +
    const val URL_BASE_REALTIME  = "ws://apilocalizacao.xpressentregas.com/api-entrega"
    var tokenAuth:String = "NONE"
    var userIdBenan:String = "NONE"
    //Criar Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var builder:Retrofit
    var okHttp:OkHttpClient.Builder
    var service: ClinicaInterface

    init {
        //Criar OkHttp Client
        val addInterceptor = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer" + tokenAuth).build()
                chain.proceed(request)
            }

        okHttp = addInterceptor

        //Criar retrofit builder
        builder = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()

        service = buildSercice(ClinicaInterface::class.java)

    }

    fun <T> buildSercice(serviceType: Class<T>): T {
        return builder.create(serviceType)
    }

    fun instanciaRetrofit(): Retrofit {
        return builder
    }
}