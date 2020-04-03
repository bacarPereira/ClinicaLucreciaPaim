package proitappsolutions.com.rumosstore.adapter

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.FinalizarConsultaFragmentDirections
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity
import com.example.clinicalucreciapain.comuns.*
import com.example.clinicalucreciapain.fragmentos.hosts.HostFragmentActividadesDirections
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
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
    var cBEcografia: CheckBox? = null
    var editAltura: TextInputEditText? = null
    var editPeso: TextInputEditText? = null
    var editSemanas: TextInputEditText? = null
    var editDias: TextInputEditText? = null
    var groupEcografia: Group? = null

    var textInputAltura: TextInputLayout? = null
    var textInputPeso: TextInputLayout? = null
    var textInputSemanas: TextInputLayout? = null
    var textInputDias: TextInputLayout? = null
    var ecografia = false

    var altura = semValorString
    var peso = semValorString
    var semanas = semValorString
    var dias = semValorString

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

                    setOnClickListener {
                        dialog_finalizar_consulta?.show()
                        cBEcografia?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
                            override fun onCheckedChanged(p0: CompoundButton?, mostar: Boolean) {
                                if (mostar){
                                    groupEcografia?.visibility = View.VISIBLE
                                    ecografia = true
                                    eliminarErri()
                                } else{
                                    groupEcografia?.visibility = View.GONE
                                    ecografia = false
                                }
                            }
                        })
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

                finalizar_consulta_btn?.setOnClickListener {

                    edt_data_consulta2?.let {
                        context.limparErroEditTxt(it)
                    }

                    if (ecografia){
                        Log.i("validar_eco","ecografiaaaa")
                         if (validarCampos()){
                             validarFinalizar(posicao)
                         }
                    }else{
                        validarFinalizar(posicao)
                    }


                }
            }
        }

        fun validarFinalizar(posicao: Int) {
            if (TextUtils.isEmpty(edt_data_consulta2?.text)) {
                edt_data_consulta2?.let { it1 -> context.erroEditText(it1, MSG_ERRO_VAZIO_CAMPO) }
            }else{
                Thread {
                    bebeViewModel.updateCrescimentoBebe(peso,altura,dias,semanas,res_room.get(posicao).paciente)
                }.start()
                minhasConsultasViewModel?.update(MinhasConsultasEntity(res_room.get(posicao).id,edt_data_consulta2?.text.toString(),
                    estados_consulta.get(1),res_room.get(posicao).data,res_room.get(posicao).paciente,res_room.get(posicao).medico))
                edt_data_consulta2?.text?.clear()
                dialog_finalizar_consulta?.dismiss()
                activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(FinalizarConsultaFragmentDirections.actionFinalizarConsultaFragmentSelf())
                activity?.let { it1 -> esconderTeclado(it1) }
                notifyDataSetChanged()
                activity?.getFragmentManager()?.popBackStack()
                context.mostrarMensagem("Consulta finalizada com sucesso!!")

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

        cBEcografia = dialog_finalizar_consulta?.findViewById(R.id.cBEcografia)
        editAltura = dialog_finalizar_consulta?.findViewById(R.id.editAltura)
        editPeso = dialog_finalizar_consulta?.findViewById(R.id.editPeso)
        editSemanas = dialog_finalizar_consulta?.findViewById(R.id.editSemanas)
        editDias = dialog_finalizar_consulta?.findViewById(R.id.editDias)
        groupEcografia = dialog_finalizar_consulta?.findViewById(R.id.groupEcografia)

        textInputAltura = dialog_finalizar_consulta?.findViewById(R.id.textInputAltura)
        textInputPeso = dialog_finalizar_consulta?.findViewById(R.id.textInputPeso)
        textInputSemanas = dialog_finalizar_consulta?.findViewById(R.id.textInputSemanas)
        textInputDias = dialog_finalizar_consulta?.findViewById(R.id.textInputDias)
    }

    private fun validarCampos(): Boolean {

        eliminarErri()

        altura = editAltura?.text.toString()
        peso = editPeso?.text.toString()
        semanas = editSemanas?.text.toString()
        dias = editDias?.text.toString()

        if (TextUtils.isEmpty(altura)) {
            editAltura?.let { context.erroEditText(it, MSG_ERRO_VAZIO_CAMPO) }
            return false
        }

        if (TextUtils.isEmpty(peso)) {
            editPeso?.let { context.erroEditText(it, MSG_ERRO_VAZIO_CAMPO) }
            return false
        }

        if (TextUtils.isEmpty(semanas)) {
            editSemanas?.let { context.erroEditText(it, MSG_ERRO_VAZIO_CAMPO) }
            return false
        }

        if (TextUtils.isEmpty(dias)) {
            editDias?.let { context.erroEditText(it, MSG_ERRO_VAZIO_CAMPO) }
            return false
        }

        return true
    }

    private fun eliminarErri(){
        editAltura?.let { context.limparErroEditTxt(it) }
        editPeso?.let { context.limparErroEditTxt(it) }
        editSemanas?.let { context.limparErroEditTxt(it) }
        editDias?.let { context.limparErroEditTxt(it) }
    }

}