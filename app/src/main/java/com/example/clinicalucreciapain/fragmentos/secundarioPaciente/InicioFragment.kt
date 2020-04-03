package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import proitappsolutions.com.rumosstore.adapter.RecomendacoesAdapeter
import proitdevelopers.com.bloomberg.viewModel.BebeViewModel
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MinhasConsultasViewModel
import proitdevelopers.com.bloomberg.viewModel.RecomendacaoViewModel

class InicioFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        recomendacaoViewModel = ViewModelProviders.of(this).get(RecomendacaoViewModel::class.java)
        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        bebeViewModel = ViewModelProviders.of(this).get(BebeViewModel::class.java)

        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gestanteUserViewModel.gestante.observe(this, Observer {
            if (it.size>0){
                txt_ola_gest.text = ola_gest.plus(it.get(0).nome)
                txt_meu_peso.text = "Meu Peso - ${it.get(0).peso}"

                minhasConsultasViewModel.minhasConsultas(it.get(0).nome, estados_consulta.get(1)).observe(this,
                    Observer { tv_total_consultas_.text = "Total de consultas feitas - ${it.size}" })

                bebeViewModel.getMyBaby(it.get(0).bi).observe(this, Observer {
                    bebe_sexo.text = it.sexo
                    bebe_altura.text = it.altura.toString().plus(" mm")
                    bebe_peso.text = it.peso.toString().plus(" g")
                    txt_tempo_gest.text = it.tempoGestancional
                })
            }
        })

        recomendacaoViewModel.recomendacao.observe(this@InicioFragment, Observer { recomendacoes ->
            if (recomendacoes != null) {
                val layoutManager = LinearLayoutManager(context)
                layoutManager.orientation = RecyclerView.VERTICAL
                val adapterConfAtualidade = RecomendacoesAdapeter(view.context,activity,recomendacoes)
                recycler_conteiner_recomendacoes.layoutManager = layoutManager
                recycler_conteiner_recomendacoes.adapter = adapterConfAtualidade
            }
        })
    }


}
