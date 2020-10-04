package com.example.clinicalucreciapain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clinicalucreciapain.comuns.cartaoGestanteViewModel
import com.example.clinicalucreciapain.databinding.FragmentCartaoGestantePacienteBinding
import com.example.clinicalucreciapain.databinding.FragmentMeuCartGestanteBinding
import proitdevelopers.com.bloomberg.viewModel.CartaoGestanteViewModel

class CartaoGestantePacienteFragment : Fragment() {

    lateinit var binding:FragmentCartaoGestantePacienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cartao_gestante_paciente,container,false)
        binding.imgbVoltar.setOnClickListener { getFragmentManager()?.popBackStack() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartaoGestanteViewModel = ViewModelProviders.of(this).get(CartaoGestanteViewModel::class.java)

        cartaoGestanteViewModel.getCartao(CartaoGestantePacienteFragmentArgs.fromBundle(requireArguments()).nomeGestante).observe(this, Observer {
            binding.cartao = it
            binding.imageUrl = it.foto
        })

    }

}