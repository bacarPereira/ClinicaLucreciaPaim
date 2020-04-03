package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bebeEntity")
class BebeEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var altura:Float,
    var peso:Float,
    var gestante:String,
    var sexo:String,
    var semanas:String,
    var dias:String

)