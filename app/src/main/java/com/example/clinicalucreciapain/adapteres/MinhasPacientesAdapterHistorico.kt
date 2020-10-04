package com.example.clinicalucreciapain.adapteres

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.MinhasPacientesFragment
import com.example.clinicalucreciapain.MinhasPacientesFragmentDirections
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.comuns.nulo
import com.example.clinicalucreciapain.comuns.semInt
import com.example.clinicalucreciapain.fragmentos.hosts.HostFragmentActividadesDirections
import kotlinx.android.synthetic.main.item_minhas_pacientes.view.*

class MinhasPacientesAdapterHistorico(
    private val context: Context,
    private val activity: FragmentActivity?
) : RecyclerView.Adapter<MinhasPacientesAdapterHistorico.MyViewHolder>() {

    private var res_room: List<GestanteEntity> = mutableListOf()

    var dialog_pre_natal: Dialog? = null
    var cartao_consulta_tv: TextView? = null
    var relatorio_consulta_tv: TextView? = null

    var cartao_consulta_btn: ImageButton? = null
    var relatorio_consulta_btn: ImageButton? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_minhas_pacientes, p0, false)
        initDialogResumo(view)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = res_room.size

    fun setLista(resultado: List<GestanteEntity>) {

        res_room = resultado

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, posicao: Int) {
            holder.mudarDados(posicao)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun mudarDados(posicao: Int) {
            itemView.apply {
                    txt_paciente_nome.text = res_room[posicao].nome
                    txt_paciente_peso.text = res_room[posicao].peso
                    txt_paciente_telefone.text = res_room[posicao].telefone
                itemView.setOnClickListener {
                    dialog_pre_natal?.show()

                    cartao_consulta_tv?.setOnClickListener {
                        dialog_pre_natal?.dismiss()
                        activity?.findNavController(R.id.conteiner_medico)?.navigate(MinhasPacientesFragmentDirections.actionMinhasPacientesFragmentToCartaoGestantePacienteFragment(res_room[posicao].nome))

                    }
                    cartao_consulta_btn?.setOnClickListener {
                        dialog_pre_natal?.dismiss()
                        activity?.findNavController(R.id.conteiner_medico)?.navigate(MinhasPacientesFragmentDirections.actionMinhasPacientesFragmentToCartaoGestantePacienteFragment(res_room[posicao].nome))
                    }

                    relatorio_consulta_btn?.setOnClickListener {
                        dialog_pre_natal?.dismiss()
                        activity?.findNavController(R.id.conteiner_medico)?.navigate(MinhasPacientesFragmentDirections.actionMinhasPacientesFragmentToHistoricoGestanteConsultaFragment(res_room[posicao].nome))

                    }
                    relatorio_consulta_tv?.setOnClickListener {
                        dialog_pre_natal?.dismiss()
                        activity?.findNavController(R.id.conteiner_medico)?.navigate(MinhasPacientesFragmentDirections.actionMinhasPacientesFragmentToHistoricoGestanteConsultaFragment(res_room[posicao].nome))
                    }

                }

            }
        }
    }

    private fun initDialogResumo(view: View) {
        dialog_pre_natal = Dialog(view.context)
        dialog_pre_natal?.setContentView(R.layout.dialogo_opcoes_paciente)

        cartao_consulta_tv = dialog_pre_natal?.findViewById(R.id.cartao_consulta_tv)
        relatorio_consulta_tv = dialog_pre_natal?.findViewById(R.id.relatorio_consulta_tv)

        cartao_consulta_btn  = dialog_pre_natal?.findViewById(R.id.cartao_consulta_btn)
        relatorio_consulta_btn  = dialog_pre_natal?.findViewById(R.id.relatorio_consulta_btn)

    }
}