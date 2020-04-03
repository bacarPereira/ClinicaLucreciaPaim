package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.BebeDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.BebeEntity

class BebeViewModel(application:Application):AndroidViewModel(application) {

    private val dao: BebeDao

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.bebeDao()
    }

    fun inserir(entity: BebeEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun updateCrescimentoBebe(peso:String,altura:String,dias:String,semanas:String,gestante:String){
        dao.update_crescimentoBebe(peso,altura,dias,semanas,gestante)
    }

    fun getMyBaby(gestante_bi:String):LiveData<BebeEntity>{
        return dao.gestante_bebe(gestante_bi)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: BebeDao):AsyncTask<BebeEntity,Void,Void>(){
            override fun doInBackground(vararg entity: BebeEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: BebeDao):AsyncTask<BebeEntity,Void,Void>(){
            override fun doInBackground(vararg entity: BebeEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}