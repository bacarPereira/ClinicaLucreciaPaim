package com.example.clinicalucreciapain.fragmentos.inicial


import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.comuns.*
import kotlinx.android.synthetic.main.dialogo_conexao_internet.*
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel

class SplashFragment : Fragment() {

    val TEMPO_SPLASH = 3000
    var dialog_inf_red: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_splash, container, false)

            InternetCheck(object : InternetCheck.Consumer {
                override fun accept(internet: Boolean?) {
                    if (internet != true){
                        view.context.mostrarMensagem(msgSemInternet)
                        dialog_inf_red?.show()
                    } else{
                        lancarJanelaHome()
                    }
                }
            })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDialogo(view)
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

    private fun initDialogo(view: View) {
        dialog_inf_red = Dialog(view.context)
        dialog_inf_red?.setContentView(R.layout.dialogo_conexao_internet)
        dialog_inf_red?.setCancelable(false)
        dialog_inf_red?.ben_refresh?.setOnClickListener {
            dialog_inf_red?.dismiss()
            InternetCheck(object : InternetCheck.Consumer {
                override fun accept(internet: Boolean?) {
                    if (internet != true){
                        view.context.mostrarMensagem(msgSemInternet)
                        dialog_inf_red?.show()
                    }
                    else{
                        lancarJanelaHome()
                        Log.i("test_______________", "COM NET")
                    }
                }
            })
        }
    }


}
