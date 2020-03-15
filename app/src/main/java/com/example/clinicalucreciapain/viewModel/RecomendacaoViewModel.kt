package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.RecomendacaoDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity

class RecomendacaoViewModel(application:Application):AndroidViewModel(application) {

    private val recomendacaoDao: RecomendacaoDao
    internal val recomendacao:LiveData<List<RecomendacaoEntity>>

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        recomendacaoDao = dbBega!!.recomendacaoDao()
        recomendacao = recomendacaoDao.recomendacoes
    }

    fun insertUsuario(recomendacaoEntity: RecomendacaoEntity){
        InsertAsyncTask(recomendacaoDao).execute(recomendacaoEntity)
    }

    fun deleteRecomendacoes(){
        DeleteAllAsyncTask(recomendacaoDao).execute()
    }
//

    companion object{
        private class InsertAsyncTask(private val recomendacoesDao: RecomendacaoDao):AsyncTask<RecomendacaoEntity,Void,Void>(){
            override fun doInBackground(vararg recomendacoes: RecomendacaoEntity): Void? {
                recomendacoesDao.inserir(recomendacoes[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val recomendacoesDao: RecomendacaoDao):AsyncTask<RecomendacaoEntity,Void,Void>(){
            override fun doInBackground(vararg usuario: RecomendacaoEntity): Void? {
                recomendacoesDao.deleteAll()

                return null
            }
        }

    }

}