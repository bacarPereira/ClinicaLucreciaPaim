package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
@Dao
interface RecomendacaoDao {
    @Insert
    fun inserir(recomendacaoEntity: RecomendacaoEntity)

    @get:Query("SELECT * FROM recomendacaoEntity")
    val recomendacoes:LiveData<List<RecomendacaoEntity>>

    @Delete
    fun delete(recomendacaoEntity: RecomendacaoEntity)

    @Query("DELETE FROM recomendacaoEntity ")
    fun deleteAll()
}