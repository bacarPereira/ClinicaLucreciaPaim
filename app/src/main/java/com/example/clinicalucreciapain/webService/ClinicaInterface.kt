package com.proitappsolutions.xpressentregas.repository.remoteDataSource.retrofit.webServices

import com.example.clinicalucreciapain.webService.UsuarioPerfilResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ClinicaInterface {

    @GET("api/usuario/perfil")
    fun getUsuarioPerfil(): Call<UsuarioPerfilResponse>

}

