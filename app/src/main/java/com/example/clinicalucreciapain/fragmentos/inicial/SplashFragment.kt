package com.example.clinicalucreciapain.fragmentos.inicial


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoUserEntity
import com.example.clinicalucreciapain.comuns.gest
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.medi
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoViewModel

class SplashFragment : Fragment() {

    val TEMPO_SPLASH = 3000

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)

        lancarJanelaHome()

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun lancarJanelaHome() {
        Handler().postDelayed(object : Runnable {
            override fun run() {

                gestanteUserViewModel.gestante.observe(this@SplashFragment, Observer {

                    if (it.size>0){
                        gest = true
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToInicialSessaoPacienteFragment2())
                    } else{
                        medicoUserViewModel.medicos.observe(this@SplashFragment, Observer {
                            if (it.size>0){
                                medi = true
                                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHostFragmentActividades())
                            }else{
                                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToTelaInicialFragment2())
                            }
                        })
                    }
                })

            }
        }, TEMPO_SPLASH.toLong())
    }


}
