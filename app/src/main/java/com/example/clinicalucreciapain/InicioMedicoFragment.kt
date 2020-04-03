package com.example.clinicalucreciapain


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_inicio_medico.*
import proitappsolutions.com.rumosstore.adapter.MinhasConsultasAdapter
import proitappsolutions.com.rumosstore.adapter.MinhasConsultasInicialMedicoAdapter
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class InicioMedicoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        return inflater.inflate(R.layout.fragment_inicio_medico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medicoUserViewModel.medicos.observe(this, Observer {

            minhasConsultasViewModel.minhasConsultasMedico(it.get(0).nome, estados_consulta.get(1)).observe(this,
                Observer {
                    tv_total_consultas_.text = "Total de consultas feitas - " + it.size
                })

            minhasConsultasViewModel.minhasConsultasMedico(it.get(0).nome, estados_consulta.get(0)).observe(this,
                Observer {

                    if (it.size>0){
                        tv_total_consultas_pendentes.text = "Total de consultas pendentes - " + it.size
                        val layoutManager = LinearLayoutManager(context)
                        layoutManager.orientation = RecyclerView.VERTICAL
                        val adapter = MinhasConsultasInicialMedicoAdapter(view.context, activity, medico = true)
                        recycler_minhas_pacientes.layoutManager = layoutManager
                        recycler_minhas_pacientes.adapter = adapter
                        adapter.setLista(it)
                    }else{
                        tv_minhas_consultas.visibility = View.GONE
                        txt_sem_consultas.visibility = View.VISIBLE
                    }
                })

            txt_doctor.text = "Olá Dr. "+it.get(0).nome
        })
    }


}
