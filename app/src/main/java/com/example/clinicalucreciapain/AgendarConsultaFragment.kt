package com.example.clinicalucreciapain


import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.clinicalucreciapain.baseDeDados.entidades.MinhasConsultasEntity
import com.example.clinicalucreciapain.comuns.*
import kotlinx.android.synthetic.main.fragment_agendar_consulta.*
import kotlinx.android.synthetic.main.fragment_agendar_consulta.view.*
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel
import java.util.*

class AgendarConsultaFragment : Fragment() {

    var medico :String ? = null
    var paciente :String? = null
    var data :String = ""
    var hora :String = ""
    var mCurrentDate: Calendar = Calendar.getInstance()
    var mDateSetListener: DatePickerDialog.OnDateSetListener? = null
    var progressDialog: ProgressDialog? = null

    var remarcar_agenda = false
    var relatorio:String = ""
    var estado:String = ""
    var idConsulta = semInt

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_agendar_consulta, container, false)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)

        medico = AgendarConsultaFragmentArgs.fromBundle(arguments!!).medico
        paciente = AgendarConsultaFragmentArgs.fromBundle(arguments!!).paciente
        remarcar_agenda = AgendarConsultaFragmentArgs.fromBundle(arguments!!).remarcarAgendar

        if(remarcar_agenda){
            data = AgendarConsultaFragmentArgs.fromBundle(arguments!!).hora.toString()
            hora = AgendarConsultaFragmentArgs.fromBundle(arguments!!).data.toString().trim()
            relatorio = AgendarConsultaFragmentArgs.fromBundle(arguments!!).relatorio.toString()
            estado = AgendarConsultaFragmentArgs.fromBundle(arguments!!).estadoConsulta.toString()
            idConsulta = AgendarConsultaFragmentArgs.fromBundle(arguments!!).idConsulta
            view.btn_confirmar.text = "Remarcar Consulta"

            view.edt_hora.setText(hora)
            view.edt_data_consulta.setText(data)
        }

        view.acao_editavel.text = AgendarConsultaFragmentArgs.fromBundle(arguments!!).accaoAgendamento

        paciente.let { view.txt_paciente.text = "Paciente - " + it }
        progressDialog(view.context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirmar.setOnClickListener {

            if (validarCampos(view)){
                medico?.let { medico -> paciente?.let { paciente -> agendarConsulta(medico, paciente,data,hora) } }
            }
        }
        imgb_voltar.setOnClickListener {
            getFragmentManager()?.popBackStack()
            activity?.let { it1 -> esconderTeclado(it1) }
        }

        edt_data_consulta.setOnClickListener {
            mCurrentDate?.let {
                val ano = it.get(Calendar.YEAR)
                val mes = it.get(Calendar.MONTH)
                val dia = it.get(Calendar.DAY_OF_WEEK)
                val mDatePickerDialog = DatePickerDialog(view.context, R.style.DialogTheme,
                    DatePickerDialog.OnDateSetListener { datePicker, selecionaAno, selecionaMes, selecionaDia ->
                        if (selecionaAno != ano) {
                            context?.mostrarMensagem("Ano selecionado não permitido")
                            edt_data_consulta.error = "Data inválida"
                        } else {
                            edt_data_consulta.setText("${selecionaDia.toString()}-${selecionaMes + 1}-$selecionaAno")
                            it.set(selecionaAno, selecionaMes, selecionaDia)
                            data = edt_data_consulta.text.toString()
                        }
                    }, ano, mes, dia)
                mDatePickerDialog.show()

            }
        }
    }

    private fun progressDialog(context: Context) {
        progressDialog = ProgressDialog(context,
            R.style.MyStyleProgress
        )
        progressDialog!!.setCancelable(false)
    }

    private fun agendarConsulta(
        medico: String,
        paciente: String,
        data: String,
        hora: String
    ) {
        activity?.let { esconderTeclado(it) }
        progressDialog?.setMessage(msg_acarregar)
        progressDialog?.show()

        Handler().postDelayed({
            progressDialog?.dismiss()
            if (remarcar_agenda){
                minhasConsultasViewModel.update(MinhasConsultasEntity(idConsulta, relatorio, estados_consulta.get(0),data.plus(", $hora"),paciente,medico))
                getFragmentManager()?.popBackStack()
                context?.mostrarMensagem("Consulta atualizada com sucesso !!")
            }else{
                minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio, estados_consulta.get(0),data.plus(", $hora"),paciente,medico))
                activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(AgendarConsultaFragmentDirections.actionAgendarConsultaFragmentToHostFragmentMedico())
                context?.mostrarMensagem("Consulta marcada com sucesso !!")
            }
        }, TEMPO_RUN.toLong())
    }

    private fun validarCampos(view: View): Boolean {

        view.edt_hora?.let {
            view.context.limparErroEditTxt(view.edt_hora)
            hora = view.edt_hora.text.toString()
            Log.i("log_user",hora)
        }

        view.edt_data_consulta?.let {
            view.context.limparErroEditTxt(view.edt_data_consulta)
            data = view.edt_data_consulta.text.toString().trim()
            Log.i("log_user",data)
        }

        if (!hora.matches(regex_hora.toRegex())) {
            view.edt_hora.error = "A hora deve estar no formato hh:mm"
            return false
        }

        val hora_temp = hora.split(":")

        if (hora_temp.get(0).toInt() >24){
            view.edt_hora.error = "Hora não pode ser maior que 24"
            return false
        }

        if (hora_temp.get(1).toInt() >60){
            view.edt_hora.error = "Minutos não podem ser maior que 60"
            return false
        }

        if (TextUtils.isEmpty(hora)) {
            view.context.erroEditText(view.edt_hora, MSG_ERRO_VAZIO_CAMPO)
            return false
        }

        if (TextUtils.isEmpty(data)) {
            view.context.erroEditText(view.edt_data_consulta, MSG_ERRO_VAZIO_CAMPO)
            return false
        }

        val data_consulta = data.split("-")
        val ano = mCurrentDate.get(Calendar.YEAR)
        val mes = mCurrentDate.get(Calendar.MONTH)
        val dia = mCurrentDate.get(Calendar.DAY_OF_WEEK)

        if (data_consulta[2].toInt() <ano){
            view.edt_data_consulta.setText(null)
            view.edt_data_consulta.error = "Data Inválida"
            context?.mostrarMensagem("Ano selecionado não permitido")
            return false
        }

        if (data_consulta[1].toInt() < mes+1){
            view.edt_data_consulta.setText(null)
            view.edt_data_consulta.error = "Data Inválida"
            context?.mostrarMensagem("Ano selecionado não permitido")
            return false
        }

        if (data_consulta[0].toInt() <dia){
            view.edt_data_consulta.setText(null)
            view.edt_data_consulta.error = "Data Inválida"
            context?.mostrarMensagem("Ano selecionado não permitido")
            return false
        }

        Log.i("log_user","0"+data_consulta.get(0))
        Log.i("log_user","1"+data_consulta.get(1))
        Log.i("log_user","mes"+mes)
        Log.i("log_user","2"+data_consulta.get(2))

        return true
    }
}
