package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity

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