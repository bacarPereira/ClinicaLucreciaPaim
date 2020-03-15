package proitappsolutions.com.rumosstore.adapter

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
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteEntity
import com.example.clinicalucreciapain.fragmentos.hosts.HostFragmentActividadesDirections
import kotlinx.android.synthetic.main.item_minhas_pacientes.view.*

class MinhasPacientesAdapter(
    private val context: Context,
    private val activity: FragmentActivity?,
    private val estado: Boolean = false
) : RecyclerView.Adapter<MinhasPacientesAdapter.MyViewHolder>() {

    private var res_room: List<GestanteEntity> = mutableListOf()

    var dialog_pre_natal: Dialog? = null
    var add_consulta_tv: TextView? = null
    var finalizar_consulta_tv: TextView? = null

    var add_consulta_btn: ImageButton? = null
    var finalizar_consulta_btn: ImageButton? = null

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
            if (estado == false){
                itemView.apply {
                    txt_paciente_nome.text = res_room[posicao].nome
                    txt_paciente_peso.text = res_room[posicao].peso
                    txt_paciente_telefone.text = res_room[posicao].telefone
                    txt_paciente_peso.visibility = View.VISIBLE
                    tv_lb_peso.visibility = View.VISIBLE
                    txt_paciente_telefone.visibility = View.VISIBLE
                    tv_lb_telefone.visibility = View.VISIBLE
                }
            }else{
                itemView.apply {
                    txt_paciente_nome.text = res_room[posicao].nome
                    txt_paciente_peso.visibility = View.GONE
                    tv_lb_peso.visibility = View.GONE
                    txt_paciente_telefone.visibility = View.GONE
                    tv_lb_telefone.visibility = View.GONE
                }
                itemView.setOnClickListener { dialog_pre_natal?.show() }

                add_consulta_tv?.setOnClickListener {
                    dialog_pre_natal?.dismiss()
                    activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(HostFragmentActividadesDirections.actionHostFragmentMedicoToAgendarConsultaFragment(res_room[posicao].medico_nome,res_room[posicao].nome))
                }
                add_consulta_btn?.setOnClickListener {
                    dialog_pre_natal?.dismiss()
                    activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(HostFragmentActividadesDirections.actionHostFragmentMedicoToAgendarConsultaFragment(res_room[posicao].medico_nome,res_room[posicao].nome))
                }

                finalizar_consulta_btn?.setOnClickListener {dialog_pre_natal?.dismiss()
                    activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(HostFragmentActividadesDirections.actionHostFragmentMedicoToFinalizarConsultaFragment())
                }
                finalizar_consulta_tv?.setOnClickListener {
                    dialog_pre_natal?.dismiss()
                    activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(HostFragmentActividadesDirections.actionHostFragmentMedicoToFinalizarConsultaFragment())
                }
        }
        }
    }

    private fun initDialogResumo(view: View) {
        dialog_pre_natal = Dialog(view.context)
        dialog_pre_natal?.setContentView(R.layout.dialogo_prenatal)

        add_consulta_tv = dialog_pre_natal?.findViewById(R.id.add_consulta_tv)
        finalizar_consulta_tv = dialog_pre_natal?.findViewById(R.id.finalizar_consulta_tv)

        add_consulta_btn  = dialog_pre_natal?.findViewById(R.id.add_consulta_btn)
        finalizar_consulta_btn  = dialog_pre_natal?.findViewById(R.id.finalizar_consulta_btn)

    }
}