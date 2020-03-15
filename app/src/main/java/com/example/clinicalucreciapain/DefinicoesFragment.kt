package com.example.clinicalucreciapain


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.clinicalucreciapain.comuns.gest
import com.example.clinicalucreciapain.comuns.gestanteUserViewModel
import com.example.clinicalucreciapain.comuns.gestanteViewModel
import com.example.clinicalucreciapain.comuns.medicoUserViewModel
import com.example.clinicalucreciapain.fragmentos.hosts.HostFragmentActividadesDirections
import com.example.clinicalucreciapain.fragmentos.hosts.InicialSessaoPacienteFragmentDirections
import kotlinx.android.synthetic.main.dialogo_sair.*
import kotlinx.android.synthetic.main.fragment_definicoes.view.*
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.GestanteViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel

class DefinicoesFragment : Fragment() {

    var dialogSair: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_definicoes, container, false)
        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        initDialogoSair(view)
        view.btn_sair_log_out.setOnClickListener { dialogSair?.show() }
        return view
    }

    private fun initDialogoSair(view: View) {
        dialogSair = Dialog(view.context)
        dialogSair?.setContentView(R.layout.dialogo_sair)
        dialogSair?.btnNao?.setOnClickListener {
            dialogSair?.dismiss()

        }
        dialogSair?.btn_sim?.setOnClickListener {
            dialogSair?.dismiss()
            logOut()
        }
    }

    private fun logOut() {
        if (gest){
            gestanteUserViewModel.delete()
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                InicialSessaoPacienteFragmentDirections.actionInicialSessaoPacienteFragment2ToTelaInicialFragment()
            )
        }else{
            medicoUserViewModel.delete()
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                HostFragmentActividadesDirections.actionHostFragmentMedicoToTelaInicialFragment()
            )
        }
    }

}
