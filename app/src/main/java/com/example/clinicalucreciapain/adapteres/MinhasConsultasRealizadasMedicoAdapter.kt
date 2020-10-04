package com.example.clinicalucreciapain.adapteres

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity
import kotlinx.android.synthetic.main.item_minhas_consultas.view.txt_data
import kotlinx.android.synthetic.main.item_minhas_consultas_medico.view.*

class MinhasConsultasRealizadasMedicoAdapter(
    private val context: Context,
    private val activity: FragmentActivity?) : RecyclerView.Adapter<MinhasConsultasRealizadasMedicoAdapter.MyViewHolder>() {

    private var res_room: List<MinhasConsultasEntity> = mutableListOf()

    var dialog_resumo: Dialog? = null
    var dialog_resum_txt: TextView? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_minhas_consultas_medico, p0, false)
        initDialogResumo(view)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = res_room.size

    fun setLista(resultado: List<MinhasConsultasEntity>) {

        res_room = resultado

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, posicao: Int) {
            holder.mudarDados(posicao)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun mudarDados(posicao: Int) {
            itemView.apply {
                txt_gestante.text = res_room[posicao].paciente
                txt_data.text = res_room[posicao].data
                dialog_resum_txt?.text = res_room[posicao].relatorio
                setOnClickListener {
                    dialog_resumo?.show()
                }
            }
        }
    }

    private fun initDialogResumo(view: View) {
        dialog_resumo = Dialog(view.context)
        dialog_resumo?.setContentView(R.layout.item_resumo_consulta)
        dialog_resum_txt = dialog_resumo?.findViewById(R.id.txt_reumo)

    }

}