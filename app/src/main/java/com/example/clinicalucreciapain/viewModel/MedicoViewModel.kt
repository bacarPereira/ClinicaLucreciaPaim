package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.MedicoDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoEntity

class MedicoViewModel(application:Application):AndroidViewModel(application) {

    private val dao: MedicoDao

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.medicoEntity()
    }

    fun inserir(entity: MedicoEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun meuMedico(n_ordem:String):LiveData<MedicoEntity>{
        return dao.meuMedico(n_ordem)
    }

    fun login(usuario:String,senha:String):LiveData<MedicoEntity>{
        return dao.login(usuario,senha)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: MedicoDao):AsyncTask<MedicoEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MedicoEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: MedicoDao):AsyncTask<MedicoEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MedicoEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}