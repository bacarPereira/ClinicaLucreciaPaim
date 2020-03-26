package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.GestanteUserDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity

class GestanteUserViewModel(application:Application):AndroidViewModel(application) {
//
    private val dao: GestanteUserDao
    internal val gestante:LiveData<List<GestanteUserEntity>>

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.gestanteUserEntity()
        gestante = dao.encomendas
    }

    fun inserir(entity: GestanteUserEntity){
        InsertAsyncTask(dao).execute(entity)
    }


    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: GestanteUserDao):AsyncTask<GestanteUserEntity,Void,Void>(){
            override fun doInBackground(vararg entity: GestanteUserEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: GestanteUserDao):AsyncTask<GestanteUserEntity,Void,Void>(){
            override fun doInBackground(vararg entity: GestanteUserEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}