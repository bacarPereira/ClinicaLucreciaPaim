package com.example.clinicalucreciapain.baseDeDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "minhasConsultasEntity")
class MinhasConsultasEntity (
    @field:PrimaryKey(autoGenerate = true)
    var id:Int,
    var relatorio:String,
    var estado:String,
    var data:String,
    var paciente:String,
    var medico:String
)