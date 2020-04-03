package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.clinicalucreciapain.R
import kotlinx.android.synthetic.main.fragment_detalhe_recomendacao.*

class DetalheRecomendacaoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detalhe_recomendacao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_titulo_recomendacao.text = DetalheRecomendacaoFragmentArgs.fromBundle(
            arguments!!
        ).titulo
        txt_corpo_recomendacao.text = DetalheRecomendacaoFragmentArgs.fromBundle(
            arguments!!
        ).corpo

        Glide.with(view.context)
            .load(
                DetalheRecomendacaoFragmentArgs.fromBundle(
                    arguments!!
                ).foto)
            .into(img_recomendacao)


        imgb_voltar.setOnClickListener { getFragmentManager()?.popBackStack() }
    }


}
