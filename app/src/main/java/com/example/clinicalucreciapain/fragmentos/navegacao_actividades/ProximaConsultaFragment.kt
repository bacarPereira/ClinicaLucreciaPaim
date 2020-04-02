package com.example.clinicalucreciapain.fragmentos.navegacao_actividades


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_proxima_consulta.*
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class ProximaConsultaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        return inflater.inflate(R.layout.fragment_proxima_consulta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gestanteUserViewModel.gestante.observe(this, Observer {
            minhasConsultasViewModel.minhasConsultas(it.get(0).nome, estados_consulta.get(0)).observe(this,
                Observer {
                    if (it.size>0){
                        txt_info_sem_consulta.visibility = View.GONE
                        txt_medico_proxima_c.visibility = View.VISIBLE
                        txt_data_proxima_c.visibility = View.VISIBLE
                        txt_lb_medico.visibility = View.VISIBLE
                        txt_lb_data.visibility = View.VISIBLE
                        txt_medico_proxima_c.text = it.get(0).medico
                        txt_data_proxima_c.text = it.get(0).data
                        val consulta = it.get(0)
                        cartao_consulta.setOnClickListener {
                            findNavController().navigate(ProximaConsultaFragmentDirections.actionProximaConsultaFragmentToAgendarConsultaFragment(
                                consulta.medico,consulta.paciente,resources.getString(R.string.remarcar_consulta),true,consulta.relatorio,consulta.estado,
                                consulta.data.split(",").get(1),
                                consulta.data.split(",").get(0),consulta.id
                            ))
                        }
                    }else{
                        txt_info_sem_consulta.visibility = View.VISIBLE
                        txt_lb_medico.visibility = View.GONE
                        txt_lb_data.visibility = View.GONE
                        txt_medico_proxima_c.visibility = View.GONE
                        txt_data_proxima_c.visibility = View.GONE
                    }
                })
        })
        imgb_voltar.setOnClickListener { getFragmentManager()?.popBackStack() }

    }


}
