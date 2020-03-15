package com.example.clinicalucreciapain.fragmentos.navegacao_actividades


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.medicoViewModel
import com.example.clinicalucreciapain.databinding.FragmentMeuMedicoBinding
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoViewModel

/**
 * A simple [Fragment] subclass.
 */
class MeuMedicoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding : FragmentMeuMedicoBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_meu_medico,container,false)

        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        medicoViewModel = ViewModelProviders.of(this).get(MedicoViewModel::class.java)

        gestanteUserViewModel.gestante.observe(this, Observer {

            medicoViewModel.meuMedico(it.get(0).medico).observe(this, Observer {
                binding.medico = it
                binding.imageUrl = it.foto
            })
        })

        binding.imgbVoltar.setOnClickListener { getFragmentManager()?.popBackStack() }

        return binding.root
    }


}
