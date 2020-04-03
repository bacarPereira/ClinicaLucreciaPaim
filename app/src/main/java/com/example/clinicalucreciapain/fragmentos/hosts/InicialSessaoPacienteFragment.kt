package com.example.clinicalucreciapain.fragmentos.hosts


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.clinicalucreciapain.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class InicialSessaoPacienteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inicial_sessao_paciente, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.contentInicial) as NavHostFragment

        view.findViewById<BottomNavigationView>(R.id.bottom_navigation_)
            .setupWithNavController(navController = navHostFragment.navController)
        return view
    }
}
