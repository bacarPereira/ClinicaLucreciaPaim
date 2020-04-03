package proitdevelopers.com.bloomberg.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clinicalucreciapain.baseDeDados.dao.CartaoGestanteDao
import com.example.clinicalucreciapain.baseDeDados.db_engine.DbMaternidade
import com.example.clinicalucreciapain.baseDeDados.entidades.CartaoGestanteEntity

class CartaoGestanteViewModel(application:Application):AndroidViewModel(application) {

    private val dao: CartaoGestanteDao

    init {
        val dbBega = DbMaternidade.getDataBase(application)
        dao = dbBega!!.cartaoGestanteUserEntity()
    }

    fun inserir(entity: CartaoGestanteEntity){
        InsertAsyncTask(dao).execute(entity)
    }

    fun getCartao(nome:String):LiveData<CartaoGestanteEntity>{
        return dao.getCartao(nome)
    }

    fun delete(){
        DeleteAllAsyncTask(dao).execute()
    }

    companion object{
        private class InsertAsyncTask(private val dao_: CartaoGestanteDao):AsyncTask<CartaoGestanteEntity,Void,Void>(){
            override fun doInBackground(vararg entity: CartaoGestanteEntity): Void? {
                dao_.inserir(entity[0])
                return null
            }
        }

        private class DeleteAllAsyncTask(private val dao_: CartaoGestanteDao):AsyncTask<CartaoGestanteEntity,Void,Void>(){
            override fun doInBackground(vararg entity: CartaoGestanteEntity): Void? {
                dao_.deleteAll()

                return null
            }
        }

    }

}