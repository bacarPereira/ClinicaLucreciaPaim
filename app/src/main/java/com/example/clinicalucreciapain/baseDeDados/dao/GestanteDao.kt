package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
@Dao
interface GestanteDao {
    @Insert
    fun inserir(gestanteEntity: GestanteEntity)

    @Update
    fun update(gestanteEntity: GestanteEntity)

    @Query("SELECT * FROM gestanteEntity where medico == :n_ordem")
    fun gestantes_medico(n_ordem:String):LiveData<List<GestanteEntity>>

    @Query("SELECT * FROM gestanteEntity WHERE telefone == :usuario AND senha == :senha or email == :usuario and senha == :senha")
    fun login(usuario:String,senha:String):LiveData<GestanteEntity>

    @Query("DELETE FROM gestanteEntity ")
    fun deleteAll()
}