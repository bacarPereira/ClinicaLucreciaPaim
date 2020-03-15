package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cartaoGestanteEntity")
class CartaoGestanteEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var unidade_sanitaria:String,
    var nome:String,
    var idade:String,
    var estado_c:String,
    var h_literarias:String,
    var nome_parceiro:String,
    var residencia:String,
    var ponto_ref:String,
    var contact_emergencia:String,
    var n_gestacao:String,
    var n_partos:String,
    var n_abortos:String,
    var n_filhos:String,
    var n_nados:String,
    var foto:String
)