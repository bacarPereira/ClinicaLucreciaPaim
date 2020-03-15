package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoUserEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
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