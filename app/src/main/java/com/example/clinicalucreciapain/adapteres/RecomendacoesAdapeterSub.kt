package proitappsolutions.com.rumosstore.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.modelo.Recomendacao

class RecomendacoesAdapeterSub(
    private val context: Context,
    private var recomendacoesLista: MutableList<Recomendacao>,
    private val activity: FragmentActivity?) : RecyclerView.Adapter<RecomendacoesAdapeterSub.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rewcomendacoes_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = recomendacoesLista.size

    override fun onBindViewHolder(holder: MyViewHolder, posicao: Int) {
            holder.mudarDados(posicao)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun mudarDados(posicao: Int) {
            Log.i("indexx","$posicao")
        }
    }

}