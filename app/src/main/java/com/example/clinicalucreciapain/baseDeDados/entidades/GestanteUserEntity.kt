package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gestanteUserEntity")
class GestanteUserEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var nome:String,
    var bi:String,
    var nacionalidade:String,
    var peso:String,
    var altura:String,
    var sexo:String,
    var grupo_sanguineo:String,
    var raca:String,
    var provincia:String,
    var bairro:String,
    var rua:String,
    var municipio:String,
    var telefone:String,
    var email:String,
    var data_nac:String,
    var senha:String,
    var medico:String,
    var foto:String
)