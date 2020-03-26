package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.BebeEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
@Dao
interface BebeDao {
    @Insert
    fun inserir(bebeEntity: BebeEntity)

    @Update
    fun update(bebeEntity: BebeEntity)

    @Query("SELECT * FROM bebeEntity where gestante_bi == :gestante_bi")
    fun gestante_bebe(gestante_bi:String):LiveData<BebeEntity>

    @Query("DELETE FROM bebeEntity ")
    fun deleteAll()
}