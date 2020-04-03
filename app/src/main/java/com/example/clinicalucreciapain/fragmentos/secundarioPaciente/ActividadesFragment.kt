package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.fragmentos.hosts.InicialSessaoPacienteFragmentDirections
import kotlinx.android.synthetic.main.fragment_actividades.*

class ActividadesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_actividades, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardMeuCartao.setOnClickListener {
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                InicialSessaoPacienteFragmentDirections.actionInicialSessaoPacienteFragment2ToMeuCartGestanteFragment2()
            )
        }

        cardMeuMedico.setOnClickListener {
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                InicialSessaoPacienteFragmentDirections.actionInicialSessaoPacienteFragment2ToMeuMedicoFragment2()
            )
        }

        cardMinhasConsultas.setOnClickListener {
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                InicialSessaoPacienteFragmentDirections.actionInicialSessaoPacienteFragment2ToMinhasConsultasFragment()
            )
        }

        cardProximaConsulta.setOnClickListener {
            activity?.findNavController(R.id.fragmentConteinerSplash)?.navigate(
                InicialSessaoPacienteFragmentDirections.actionInicialSessaoPacienteFragment2ToProximaConsultaFragment()
            )
        }

    }

}
