package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
@Dao
interface GestanteUserDao {
    @Insert
    fun inserir(gestanteUserEntity: GestanteUserEntity)

    @Update
    fun update(gestanteUserEntity: GestanteUserEntity)

    @get:Query("SELECT * FROM gestanteUserEntity")
    val encomendas:LiveData<List<GestanteUserEntity>>

    @Query("DELETE FROM gestanteUserEntity ")
    fun deleteAll()
}