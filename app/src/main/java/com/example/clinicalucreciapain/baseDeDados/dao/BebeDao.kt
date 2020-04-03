package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.BebeEntity

@Dao
interface BebeDao {
    @Insert
    fun inserir(bebeEntity: BebeEntity)

    @Update
    fun update(bebeEntity: BebeEntity)

    @Query("UPDATE bebeEntity SET peso = :peso,altura =:altura,dias =:dias ,semanas =:semanas where gestante == :gestante")
    fun update_crescimentoBebe(peso:String,altura:String,dias:String,semanas:String,gestante: String)

    @Query("SELECT * FROM bebeEntity where gestante == :gestante_bi")
    fun gestante_bebe(gestante_bi:String):LiveData<BebeEntity>

    @Query("DELETE FROM bebeEntity ")
    fun deleteAll()
}