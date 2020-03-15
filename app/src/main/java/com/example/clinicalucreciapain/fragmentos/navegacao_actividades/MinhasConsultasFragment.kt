package com.example.clinicalucreciapain.fragmentos.navegacao_actividades


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_minhas_consultas.*
import proitappsolutions.com.rumosstore.adapter.MinhasConsultasAdapter
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class MinhasConsultasFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)

        return inflater.inflate(R.layout.fragment_minhas_consultas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gestanteUserViewModel.gestante.observe(this, Observer {
            minhasConsultasViewModel.minhasConsultas(it.get(0).nome, estados_consulta.get(1)).observe(this, Observer {
                val adapter = LinearLayoutManager(context)
                adapter.orientation = RecyclerView.VERTICAL
                val adapterConfAtualidade = MinhasConsultasAdapter(view.context,activity)
                recyclerMinhasConsultas.layoutManager = adapter
                recyclerMinhasConsultas.adapter = adapterConfAtualidade
                adapterConfAtualidade.setLista(it)

            })
        })

        imgb_voltar.setOnClickListener {
            getFragmentManager()?.popBackStack()
        }

    }

}
