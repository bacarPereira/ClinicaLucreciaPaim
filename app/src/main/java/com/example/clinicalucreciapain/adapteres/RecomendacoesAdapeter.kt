package proitappsolutions.com.rumosstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.modelo.recomendacoes
import kotlinx.android.synthetic.main.item_recomendacoes.view.*

class RecomendacoesAdapeter(
        private val context: Context,
        private val activity: FragmentActivity?) : RecyclerView.Adapter<RecomendacoesAdapeter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recomendacoes, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MyViewHolder, posicao: Int) {
            holder.mudarDados()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun mudarDados() {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = RecyclerView.VERTICAL
            val adapterConfAtualidade = RecomendacoesAdapeterSub(context,  recomendacoes, activity)
            itemView.recycler_view_recomendacoes.layoutManager = layoutManager
            itemView.recycler_view_recomendacoes.adapter = adapterConfAtualidade
        }
    }

}