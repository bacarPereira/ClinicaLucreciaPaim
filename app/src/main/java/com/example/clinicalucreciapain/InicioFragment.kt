package com.example.clinicalucreciapain


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinicalucreciapain.modelo.recomendacoes
import kotlinx.android.synthetic.main.fragment_inicio.*
import kotlinx.android.synthetic.main.item_recomendacoes.view.*
import proitappsolutions.com.rumosstore.adapter.RecomendacoesAdapeter
import proitappsolutions.com.rumosstore.adapter.RecomendacoesAdapeterSub

class InicioFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        val adapterConfAtualidade = RecomendacoesAdapeter(view.context, activity)
        recycler_conteiner_recomendacoes.layoutManager = layoutManager
        recycler_conteiner_recomendacoes.adapter = adapterConfAtualidade
    }


}
