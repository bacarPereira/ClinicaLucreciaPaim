package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.CartaoGestanteEntity

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