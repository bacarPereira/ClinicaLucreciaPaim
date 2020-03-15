package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.recomendacaoViewModel
import kotlinx.android.synthetic.main.fragment_conselho.*
import proitappsolutions.com.rumosstore.adapter.ConcelhosAdapter
import proitdevelopers.com.bloomberg.viewModel.RecomendacaoViewModel

/**
 * A simple [Fragment] subclass.
 */
class ConselhoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        recomendacaoViewModel = ViewModelProviders.of(this).get(RecomendacaoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_conselho, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recomendacaoViewModel.recomendacao.observe(this@ConselhoFragment, Observer { recomendacoes ->
            if (recomendacoes.size >0) {

                val adapterConfAtualidade = ConcelhosAdapter(view.context, activity)
                recyclerConcelhos.adapter = adapterConfAtualidade

                //val layoutManager = GridLayoutManager(context,2)
                val layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
                //layoutManager.orientation = RecyclerView.VERTICAL
                recyclerConcelhos.layoutManager = layoutManager
                adapterConfAtualidade.setLista(recomendacoes)
            }
        })

    }


}
