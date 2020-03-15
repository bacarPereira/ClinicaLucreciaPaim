package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.MedicoDao
import com.example.clinicalucreciapain.baseDeDados.dao.MedicoUserDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoUserEntity

class MedicoUserViewModel(application:Application):AndroidViewModel(application) {

    private val dao: MedicoUserDao
    internal val medicos:LiveData<List<MedicoUserEntity>>

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.medicoUserEntity()
        medicos = dao.medicos
    }

    fun inserir(entity: MedicoUserEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun login(usuario:String,senha:String):LiveData<MedicoUserEntity>{
        return dao.login(usuario,senha)
    }

    fun getPerfil(n_ordem:String):LiveData<MedicoUserEntity>{
        return dao.meuMedico(n_ordem)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: MedicoUserDao):AsyncTask<MedicoUserEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MedicoUserEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: MedicoUserDao):AsyncTask<MedicoUserEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MedicoUserEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}