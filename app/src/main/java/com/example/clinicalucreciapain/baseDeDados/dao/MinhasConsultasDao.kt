package com.example.clinicalucreciapain.baseDeDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity

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

    @Query("SELECT * FROM minhasConsultasEntity WHERE data == :data AND medico == :medico")
    fun isConsultaInThisData(data:String,medico:String):LiveData<MinhasConsultasEntity>

    @Query("DELETE FROM minhasConsultasEntity ")
    fun deleteAll()
}