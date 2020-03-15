package com.example.clinicalucreciapain.fragmentos.hosts


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.clinicalucreciapain.R
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * A simple [Fragment] subclass.
 */
class HostFragmentActividades : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_host_medico, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.conteiner_medico) as NavHostFragment

        view.findViewById<BottomNavigationView>(R.id.bottom_navigation_)
            .setupWithNavController(navController = navHostFragment.navController)
        return view
    }


}
