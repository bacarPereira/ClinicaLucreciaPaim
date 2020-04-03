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
import com.example.clinicalucreciapain.comuns.gestanteViewModel
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_actividades_medico.*
import proitappsolutions.com.rumosstore.adapter.MinhasPacientesAdapter
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel

class
ActividadesMedicoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        return inflater.inflate(R.layout.fragment_actividades_medico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicoUserViewModel.medicos.observe(this, Observer {

            gestanteViewModel.gestante_medicos(it.get(0).n_ordem).observe(this, Observer {
                if (it.size>0){
                    val layoutManager = LinearLayoutManager(context)
                    layoutManager.orientation = RecyclerView.VERTICAL
                    val adapterConfAtualidade = MinhasPacientesAdapter(view.context,activity,true)
                    recycler_view_pacientes.layoutManager = layoutManager
                    recycler_view_pacientes.adapter = adapterConfAtualidade
                    adapterConfAtualidade.setLista(it)
                }
            })
        })
    }


}
