package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bebeEntity")
class BebeEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var altura:Float,
    var peso:Float,
    var gestante_bi:String,
    var sexo:String,
    var tempoGestancional:String

)