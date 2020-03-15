package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recomendacaoEntity")
class RecomendacaoEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var titulo:String,
    var resumo:String,
    var foto:String,
    var corpo:String,
    var cor:String
)