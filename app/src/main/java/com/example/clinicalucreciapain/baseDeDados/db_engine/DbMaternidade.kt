package com.example.clinicalucreciapain.baseDeDados.db_engine

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clinicalucreciapain.baseDeDados.dao.*
import com.example.clinicalucreciapain.baseDeDados.entidades.*

@Database(entities = [RecomendacaoEntity::class,
    GestanteEntity::class,GestanteUserEntity::class,CartaoGestanteEntity::class
    ,MedicoEntity::class,MedicoUserEntity::class,MinhasConsultasEntity::class,BebeEntity::class], version = 2, exportSchema = false)
abstract class DbMaternidade:RoomDatabase() {

    abstract fun recomendacaoDao(): RecomendacaoDao
    abstract fun gestanteEntity(): GestanteDao
    abstract fun gestanteUserEntity(): GestanteUserDao
    abstract fun cartaoGestanteUserEntity(): CartaoGestanteDao
    abstract fun medicoEntity(): MedicoDao
    abstract fun medicoUserEntity(): MedicoUserDao
    abstract fun minhasConsultas(): MinhasConsultasDao
    abstract fun bebeDao(): BebeDao

    companion object{
        @Volatile
        private var dbMaternidadeInstancia : DbMaternidade? = null

        internal fun getDataBase(context: Context): DbMaternidade?{
            if (dbMaternidadeInstancia == null){
                synchronized(DbMaternidade::class.java){
                    if (dbMaternidadeInstancia == null){
                        dbMaternidadeInstancia = Room.databaseBuilder(
                            context.applicationContext,
                            DbMaternidade::class.java,"db_maternidade")
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return dbMaternidadeInstancia
        }
    }
}