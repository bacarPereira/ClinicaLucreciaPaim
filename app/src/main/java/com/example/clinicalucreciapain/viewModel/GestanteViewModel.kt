package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.GestanteDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity

class GestanteViewModel(application:Application):AndroidViewModel(application) {

    private val dao: GestanteDao

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.gestanteEntity()
    }

    fun inserir(entity: GestanteEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun gestante_medicos(n_ordem:String):LiveData<List<GestanteEntity>>{
        return dao.gestantes_medico(n_ordem)
    }


    fun login(usuario:String,senha:String):LiveData<GestanteEntity>{
        return dao.login(usuario,senha)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: GestanteDao):AsyncTask<GestanteEntity,Void,Void>(){
            override fun doInBackground(vararg entity: GestanteEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: GestanteDao):AsyncTask<GestanteEntity,Void,Void>(){
            override fun doInBackground(vararg entity: GestanteEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}