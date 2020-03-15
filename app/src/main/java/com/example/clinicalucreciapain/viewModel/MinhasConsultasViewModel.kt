package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.MinhasConsultasDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity

class MinhasConsultasViewModel(application:Application):AndroidViewModel(application) {

    private val dao: MinhasConsultasDao

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.minhasConsultas()
    }

    fun inserir(entity: MinhasConsultasEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun update(entity: MinhasConsultasEntity){
        UpdateAsyncTask(dao).execute(entity)
    }

    fun minhasConsultas(paciente:String,estado:String):LiveData<List<MinhasConsultasEntity>>{
        return dao.minhasConsultas(paciente,estado)
    }

    fun minhasConsultasMedico(medico_nome:String, estado:String):LiveData<List<MinhasConsultasEntity>>{
        return dao.minhasConsultasMedico(medico_nome,estado)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: MinhasConsultasDao):AsyncTask<MinhasConsultasEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MinhasConsultasEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class UpdateAsyncTask(private val dao_: MinhasConsultasDao):AsyncTask<MinhasConsultasEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MinhasConsultasEntity): Void? {
                dao_.update(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: MinhasConsultasDao):AsyncTask<MinhasConsultasEntity,Void,Void>(){
            override fun doInBackground(vararg entity: MinhasConsultasEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}