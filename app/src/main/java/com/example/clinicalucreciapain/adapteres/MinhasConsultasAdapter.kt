package proitappsolutions.com.rumosstore.adapter

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.FinalizarConsultaFragment
import com.example.clinicalucreciapain.FinalizarConsultaFragmentDirections
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity
import com.example.clinicalucreciapain.comuns.*
import com.example.clinicalucreciapain.fragmentos.hosts.HostFragmentActividadesDirections
import kotlinx.android.synthetic.main.fragment_tela_inicial.view.*
import kotlinx.android.synthetic.main.item_minhas_consultas.view.*
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class MinhasConsultasAdapter(
    private val context: Context,
    private val activity: FragmentActivity?,
    private val medico: Boolean = false,
    private val finalizar_consulta: Boolean = false,
    private val minhasConsultasViewModel: MinhasConsultasViewModel? = null) : RecyclerView.Adapter<MinhasConsultasAdapter.MyViewHolder>() {

    private var res_room: List<MinhasConsultasEntity> = mutableListOf()

    var dialog_resumo: Dialog? = null
    var dialog_finalizar_consulta: Dialog? = null
    var finalizar_consulta_btn: ImageButton? = null
    var edt_data_consulta2: EditText? = null
    var dialog_resum_txt: TextView? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_minhas_consultas, p0, false)

        initDialogResumo(view)
        initDialogFinalizarConsulta(view)
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

            if (medico){
                itemView.apply {
                    txt_doctor.text = res_room[posicao].paciente
                    txt_data.text = res_room[posicao].data
                    tv_lb_med_pac.text = "Paciente. "
                    setOnClickListener {
                        activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                            HostFragmentActividadesDirections
                                .actionHostFragmentMedicoToAgendarConsultaFragment(
                                    res_room[posicao].medico,res_room[posicao].paciente,
                                    resources.getString(R.string.remarcar_consulta),true,
                                    res_room[posicao].relatorio,res_room[posicao].estado,
                                    res_room[posicao].data.split(",").get(1),
                                    res_room[posicao].data.split(",").get(0),res_room[posicao].id))
                    }
                }
            }else{
                itemView.apply {
                    txt_doctor.text = res_room[posicao].medico
                    txt_data.text = res_room[posicao].data
                }
                itemView.setOnClickListener {
                    dialog_resum_txt?.text = res_room[posicao].relatorio
                    dialog_resumo?.show()
                }
            }

            if (finalizar_consulta){
                itemView.setOnClickListener {
                    dialog_finalizar_consulta?.show()
                }

                finalizar_consulta_btn?.setOnClickListener {

                    edt_data_consulta2?.let {
                        context.limparErroEditTxt(it)
                    }

                    if (TextUtils.isEmpty(edt_data_consulta2?.text)) {
                        edt_data_consulta2?.let { it1 ->
                            context.erroEditText(
                                it1,
                                MSG_ERRO_VAZIO_CAMPO)
                        }
                    }else{
                        minhasConsultasViewModel?.update(MinhasConsultasEntity(res_room.get(posicao).id,edt_data_consulta2?.text.toString(),
                            estados_consulta.get(1),res_room.get(posicao).data,res_room.get(posicao).paciente,res_room.get(posicao).medico))
                        edt_data_consulta2?.text?.clear()
                        dialog_finalizar_consulta?.dismiss()
                        activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(FinalizarConsultaFragmentDirections.actionFinalizarConsultaFragmentSelf2())
                        activity?.let { it1 -> esconderTeclado(it1) }
                        notifyDataSetChanged()
                        context.mostrarMensagem("Consulta finalizada com sucesso!!")

                    }
                }
            }
        }
    }

    private fun initDialogResumo(view: View) {
        dialog_resumo = Dialog(view.context)
        dialog_resumo?.setContentView(R.layout.item_resumo_consulta)
        dialog_resum_txt = dialog_resumo?.findViewById(R.id.txt_reumo)

    }

    private fun initDialogFinalizarConsulta(view: View) {
        dialog_finalizar_consulta = Dialog(view.context)
        dialog_finalizar_consulta?.setContentView(R.layout.dialogo_finalizar_consulta)
        finalizar_consulta_btn = dialog_finalizar_consulta?.findViewById(R.id.finalizar_consulta_btn)
        edt_data_consulta2 = dialog_finalizar_consulta?.findViewById(R.id.edt_data_consulta2)

    }

}