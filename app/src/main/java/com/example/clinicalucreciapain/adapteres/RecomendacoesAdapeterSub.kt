package proitappsolutions.com.rumosstore.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
import com.example.clinicalucreciapain.fragmentos.secundarioPaciente.InicioFragmentDirections
import com.example.clinicalucreciapain.modelo.Recomendacao
import kotlinx.android.synthetic.main.item_rewcomendacoes_item.view.*

class RecomendacoesAdapeterSub(
    private val context: Context,
    private val activity: FragmentActivity?) : RecyclerView.Adapter<RecomendacoesAdapeterSub.MyViewHolder>() {

    private var res_room: List<RecomendacaoEntity> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rewcomendacoes_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = res_room.size

    fun setLista(resultado: List<RecomendacaoEntity>) {

        res_room = resultado

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, posicao: Int) {
            holder.mudarDados(posicao)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun mudarDados(posicao: Int) {

            itemView.setOnClickListener {
                activity?.findNavController(R.id.contentInicial)?.
                    navigate(
                        InicioFragmentDirections.actionInicioFragmentToDetalheRecomendacaoFragment(
                        res_room[posicao].titulo,res_room[posicao].foto,res_room[posicao].corpo
                    ))
            }

            itemView.txt_rec_titulo.text = res_room[posicao].titulo
            itemView.txt_rec_resumo.text = res_room[posicao].resumo

            Glide.with(context)
                .load(res_room[posicao].foto)
                .into(itemView.img_rec_foto)

        }
    }

}