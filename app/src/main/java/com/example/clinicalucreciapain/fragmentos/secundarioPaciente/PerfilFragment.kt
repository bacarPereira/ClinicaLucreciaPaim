package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.dataBinding.GestanteBinding
import com.example.clinicalucreciapain.databinding.FragmentPerfilBinding
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel

class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding :FragmentPerfilBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_perfil,container,false)

        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)

        gestanteUserViewModel.gestante.observe(this@PerfilFragment, Observer {
            binding.gestante = GestanteBinding(
                it.get(0).nome, it.get(0).bi,
                it.get(0).nacionalidade, it.get(0).peso,
                it.get(0).altura, it.get(0).sexo,
                it.get(0).grupo_sanguineo, it.get(0).raca,
                it.get(0).provincia, it.get(0).bairro, it.get(0).rua,
                it.get(0).municipio, it.get(0).telefone, it.get(0).email,
                it.get(0).data_nac, it.get(0).senha,it.get(0).foto
            )
            Log.i("imageurl",it.get(0).foto)
            binding.imageUrl = it.get(0).foto
        })

        binding.imgbVoltar.setOnClickListener { getFragmentManager()?.popBackStack() }
        return binding.root
    }


}
