package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity

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