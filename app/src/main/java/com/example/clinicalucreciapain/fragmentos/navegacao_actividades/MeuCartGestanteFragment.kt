package com.example.clinicalucreciapain.fragmentos.navegacao_actividades


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.cartaoGestanteViewModel
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.databinding.FragmentMeuCartGestanteBinding
import kotlinx.android.synthetic.main.fragment_meu_cart_gestante.*
import proitdevelopers.com.bloomberg.viewModel.CartaoGestanteViewModel
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel

class MeuCartGestanteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentMeuCartGestanteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_meu_cart_gestante,container,false)

        cartaoGestanteViewModel = ViewModelProviders.of(this).get(CartaoGestanteViewModel::class.java)
        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)

        gestanteUserViewModel.gestante.observe(this, Observer {
            cartaoGestanteViewModel.getCartao(it.get(0).nome).observe(this, Observer {
                binding.cartao = it
                binding.imageUrl = it.foto
            })
        })

        binding.imgbVoltar.setOnClickListener { getFragmentManager()?.popBackStack() }

        return binding.root
    }


}
