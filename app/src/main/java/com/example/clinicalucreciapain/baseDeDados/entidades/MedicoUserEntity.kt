package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "medicoUserEntity")
class MedicoUserEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var nome:String,
    var n_ordem:String,
    var sexo:String,
    var nacionalidade:String,
    var data_nasc:String,
    var email:String,
    var num_documento:String,
    var telefone:String,
    var senha:String,
    var foto:String
)