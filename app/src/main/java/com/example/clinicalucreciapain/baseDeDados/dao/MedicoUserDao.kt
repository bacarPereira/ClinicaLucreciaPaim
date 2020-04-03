package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoUserEntity

@Dao
interface MedicoUserDao {
    @Insert
    fun inserir(medicoUserEntity: MedicoUserEntity)

    @Update
    fun update(medicoUserEntity: MedicoUserEntity)

    @Query("SELECT * FROM medicoUserEntity WHERE n_ordem == :usuario AND senha == :senha or email == :usuario and senha == :senha")
    fun login(usuario:String,senha:String):LiveData<MedicoUserEntity>

    @get:Query("SELECT * FROM medicoUserEntity")
    val medicos:LiveData<List<MedicoUserEntity>>

    @Query("SELECT * FROM medicoUserEntity WHERE n_ordem == :n_ordem ")
    fun meuMedico(n_ordem:String):LiveData<MedicoUserEntity>

    @Query("DELETE FROM medicoUserEntity ")
    fun deleteAll()
}