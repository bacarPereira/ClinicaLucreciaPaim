package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoEntity

@Dao
interface MedicoDao {
    @Insert
    fun inserir(medicoEntity: MedicoEntity)

    @Update
    fun update(medicoEntity: MedicoEntity)

    @Query("SELECT * FROM medicoEntity WHERE n_ordem == :n_ordem ")
    fun meuMedico(n_ordem:String):LiveData<MedicoEntity>

    @Query("SELECT * FROM medicoEntity WHERE n_ordem == :usuario AND senha == :senha or email == :usuario and senha == :senha")
    fun login(usuario:String,senha:String):LiveData<MedicoEntity>

    @Query("DELETE FROM medicoEntity ")
    fun deleteAll()
}