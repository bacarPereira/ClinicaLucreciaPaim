package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.fragmentos.hosts.InicialSessaoPacienteFragmentDirections
import com.example.clinicalucreciapain.fragmentos.navegacao_actividades.MeuCartGestanteFragment
import com.example.clinicalucreciapain.fragmentos.navegacao_actividades.MeuCartGestanteFragmentDirections
import kotlinx.android.synthetic.main.fragment_actividades.*
import kotlinx.android.synthetic.main.fragment_meu_cart_gestante.*

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
