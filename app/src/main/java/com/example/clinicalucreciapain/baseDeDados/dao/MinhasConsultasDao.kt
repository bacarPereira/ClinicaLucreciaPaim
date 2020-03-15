package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinicalucreciapain.baseDeDados.entidades.CartaoGestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
import com.example.clinicalucreciapain.comuns.estados_consulta

@Dao
interface MinhasConsultasDao {
    @Insert
    fun inserir(minhasConsultasEntity: MinhasConsultasEntity)

    @Update
    fun update(minhasConsultasEntity: MinhasConsultasEntity)

    @Query("SELECT * FROM minhasConsultasEntity WHERE paciente == :paciente AND estado == :estado")
    fun minhasConsultas(paciente:String,estado:String):LiveData<List<MinhasConsultasEntity>>

    @Query("SELECT * FROM minhasConsultasEntity WHERE medico == :medico_nomw AND estado == :estado")
    fun minhasConsultasMedico(medico_nomw:String,estado:String):LiveData<List<MinhasConsultasEntity>>

    @Query("DELETE FROM minhasConsultasEntity ")
    fun deleteAll()
}