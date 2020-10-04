package com.example.clinicalucreciapain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.adapteres.MinhasConsultasRealizadasMedicoAdapter
import com.example.clinicalucreciapain.adapteres.MinhasPacientesAdapterHistorico
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.gestanteViewModel
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_minhas_consultas.*
import kotlinx.android.synthetic.main.fragment_minhas_pacientes.*
import kotlinx.android.synthetic.main.fragment_relatorio_consulta.*
import kotlinx.android.synthetic.main.fragment_relatorio_consulta.imgb_voltar
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class RelatorioConsultaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        return inflater.inflate(R.layout.fragment_relatorio_consulta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicoUserViewModel.medico.observe(this, Observer {

            if (it != null){
                minhasConsultasViewModel.minhasConsultasMedico(it.nome, estados_consulta[1]).observe(this, Observer {
                    if (it.size>0){
                        val layoutManager = LinearLayoutManager(context)
                        layoutManager.orientation = RecyclerView.VERTICAL
                        val adapterConfAtualidade = MinhasConsultasRealizadasMedicoAdapter(view.context,activity)
                        recyclerMinhasConsultasMedico.layoutManager = layoutManager
                        recyclerMinhasConsultasMedico.adapter = adapterConfAtualidade
                        adapterConfAtualidade.setLista(it)
                    }
                })
            }
        })

        imgb_voltar.setOnClickListener {
            getFragmentManager()?.popBackStack()
        }
    }

}