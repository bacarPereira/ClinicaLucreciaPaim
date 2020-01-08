package com.example.clinicalucreciapain


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_tela_inicial.view.*

class TelaInicialFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tela_inicial, container, false)
        onClick(view)
        return view
    }

    private fun onClick(view: View) {
        view.btnLogin.setOnClickListener{
            findNavController().navigate(TelaInicialFragmentDirections.actionTelaInicialFragmentToInicialSessaoPacienteFragment2())
        }
    }
}
