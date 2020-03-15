package proitappsolutions.com.rumosstore.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.RecomendacaoEntity
import com.example.clinicalucreciapain.fragmentos.secundarioPaciente.ConselhoFragmentDirections
import kotlinx.android.synthetic.main.item_concelhos_item.view.*

class ConcelhosAdapter(
    private val context: Context,
    private val activity: FragmentActivity?) : RecyclerView.Adapter<ConcelhosAdapter.MyViewHolder>() {

    private var res_room: List<RecomendacaoEntity> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_concelhos_item, p0, false)
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

            itemView.cardRoot.setCardBackgroundColor(Color.parseColor(res_room[posicao].cor))

            itemView.setOnClickListener {
                activity?.findNavController(R.id.contentInicial)?.
                    navigate(
                        ConselhoFragmentDirections.actionConselhoFragmentToDetalheRecomendacaoFragment(
                        res_room[posicao].titulo,res_room[posicao].foto,res_room[posicao].corpo
                    ))
            }

            itemView.text_titulo_conselho.text = res_room[posicao].titulo

            Glide.with(context)
                .load(res_room[posicao].foto)
                .into(itemView.img_concelho)

        }
    }

}