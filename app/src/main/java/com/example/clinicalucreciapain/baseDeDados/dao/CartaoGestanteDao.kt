package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.CartaoGestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
@Dao
interface CartaoGestanteDao {
    @Insert
    fun inserir(cartaoGestanteEntity: CartaoGestanteEntity)

    @Update
    fun update(cartaoGestanteEntity: CartaoGestanteEntity)

    @Query("SELECT * FROM cartaoGestanteEntity WHERE nome == :nome")
    fun getCartao(nome:String):LiveData<CartaoGestanteEntity>

    @Query("DELETE FROM cartaoGestanteEntity ")
    fun deleteAll()
}