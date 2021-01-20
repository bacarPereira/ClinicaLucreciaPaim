package com.example.clinicalucreciapain.webService

import com.google.gson.annotations.SerializedName

data class UsuarioPerfilResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("fotoUrl")
    var fotoUrl: String? = null,
    @SerializedName("telefone")
    var telefone: String? = null
)