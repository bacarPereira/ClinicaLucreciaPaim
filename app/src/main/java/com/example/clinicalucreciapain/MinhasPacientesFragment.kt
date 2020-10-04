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
import com.example.clinicalucreciapain.adapteres.MinhasPacientesAdapterHistorico
import com.example.clinicalucreciapain.comuns.gestanteViewModel
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import kotlinx.android.synthetic.main.fragment_actividades_medico.*
import kotlinx.android.synthetic.main.fragment_minhas_pacientes.*
import proitappsolutions.com.rumosstore.adapter.MinhasPacientesAdapter
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel

class MinhasPacientesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        return inflater.inflate(R.layout.fragment_minhas_pacientes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicoUserViewModel.medico.observe(this, Observer {

            if (it != null){
                gestanteViewModel.gestante_medicos(it.n_ordem).observe(this, Observer {
                    if (it.size>0){
                        val layoutManager = LinearLayoutManager(context)
                        layoutManager.orientation = RecyclerView.VERTICAL
                        val adapterConfAtualidade = MinhasPacientesAdapterHistorico(view.context,activity)
                        recycler_view_pacientes_minhas.layoutManager = layoutManager
                        recycler_view_pacientes_minhas.adapter = adapterConfAtualidade
                        adapterConfAtualidade.setLista(it)
                    }
                })
            }
        })
    }
}