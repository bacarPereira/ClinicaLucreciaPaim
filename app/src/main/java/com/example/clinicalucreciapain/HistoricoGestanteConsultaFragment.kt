package com.example.clinicalucreciapain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.adapteres.MinhasConsultasRealizadasMedicoAdapter
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_historico_gestante_consulta.*
import kotlinx.android.synthetic.main.fragment_minhas_consultas.*
import kotlinx.android.synthetic.main.fragment_minhas_consultas.imgb_voltar
import proitappsolutions.com.rumosstore.adapter.MinhasConsultasAdapter

class HistoricoGestanteConsultaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico_gestante_consulta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            tv_gestante_nome.text = HistoricoGestanteConsultaFragmentArgs.fromBundle(requireArguments()).gestante
            minhasConsultasViewModel.minhasConsultas(HistoricoGestanteConsultaFragmentArgs.fromBundle(requireArguments()).gestante, estados_consulta.get(1)).observe(this, Observer {
                val adapter = LinearLayoutManager(context)
                adapter.orientation = RecyclerView.VERTICAL
                val adapterConfAtualidade = MinhasConsultasRealizadasMedicoAdapter(view.context,activity)
                recyclerMinhasConsultasPacienteGestante.layoutManager = adapter
                recyclerMinhasConsultasPacienteGestante.adapter = adapterConfAtualidade
                adapterConfAtualidade.setLista(it)

            })

        imgb_voltar.setOnClickListener {
            getFragmentManager()?.popBackStack()
        }

    }
}