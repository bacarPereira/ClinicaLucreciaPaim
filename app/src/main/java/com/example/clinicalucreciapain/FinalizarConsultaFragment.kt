package com.example.clinicalucreciapain


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.comuns.estados_consulta
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import com.example.clinicalucreciapain.comuns.minhasConsultasViewModel
import kotlinx.android.synthetic.main.fragment_finalizar_consulta.*
import proitappsolutions.com.rumosstore.adapter.MinhasConsultasAdapter
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel


class FinalizarConsultaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)

        return inflater.inflate(R.layout.fragment_finalizar_consulta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicoUserViewModel.medicos.observe(this, Observer {

            minhasConsultasViewModel.minhasConsultasMedico(it.get(0).nome, estados_consulta.get(0)).observe(this,
                Observer {

                    if (it.size>0){
                        val layoutManager = LinearLayoutManager(context)
                        layoutManager.orientation = RecyclerView.VERTICAL
                        val adapter = MinhasConsultasAdapter(view.context, activity,medico = true,finalizar_consulta = true,minhasConsultasViewModel = minhasConsultasViewModel)
                        recycler_finalizar_consultas.layoutManager = layoutManager
                        recycler_finalizar_consultas.adapter = adapter
                        adapter.setLista(it)
                        tv_info_consultas_pendentes.visibility = View.GONE
                    }else{
                        tv_info_consultas_pendentes.visibility = View.VISIBLE
                        Log.i("dasda","dsdsd")
                    }
                })
        })

        imgb_voltar.setOnClickListener { getFragmentManager()?.popBackStack() }

    }

}
