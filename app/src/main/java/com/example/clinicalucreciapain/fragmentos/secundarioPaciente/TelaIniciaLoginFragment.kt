package com.example.clinicalucreciapain.fragmentos.secundarioPaciente


import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.GestanteUserEntity
import com.example.clinicalucreciapain.baseDeDados.entidades.MedicoUserEntity
import com.example.clinicalucreciapain.comuns.*
import kotlinx.android.synthetic.main.fragment_tela_inicial.view.*
import proitdevelopers.com.bloomberg.viewModel.GestanteUserViewModel
import proitdevelopers.com.bloomberg.viewModel.GestanteViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoUserViewModel
import proitdevelopers.com.bloomberg.viewModel.MedicoViewModel

class TelaIniciaLoginFragment : Fragment() {

    var email = ""
    var senha = ""
    var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tela_inicial, container, false)
        gestanteViewModel = ViewModelProviders.of(this).get(GestanteViewModel::class.java)
        gestanteUserViewModel = ViewModelProviders.of(this).get(GestanteUserViewModel::class.java)
        medicoViewModel = ViewModelProviders.of(this).get(MedicoViewModel::class.java)
        medicoUserViewModel = ViewModelProviders.of(this).get(MedicoUserViewModel::class.java)
        progressDialog(view.context)
        inicializarRole()
        onClick(view)
        return view
    }

    private fun inicializarRole() {
        gest = true
        medi = false
    }


    private fun progressDialog(context: Context) {
        progressDialog = ProgressDialog(context,
            R.style.MyStyleProgress
        )
        progressDialog!!.setCancelable(false)
    }

    private fun onClick(view: View) {
        view.btnLogin.setOnClickListener{
            if (validarCampos(view)){
                activity?.let { esconderTeclado(it) }
                autenticarUsuario(email,senha)
            }
        }

        view.txt_gestant.setOnClickListener {
            view.txt_gestant.setTextColor(resources.getColor(R.color.colorAccent))
            view.txt_med.setTextColor(resources.getColor(R.color.colorBlack))
            gest = true
            medi = false
        }

        view.txt_med.setOnClickListener {
            view.txt_med.setTextColor(resources.getColor(R.color.colorAccent))
            view.txt_gestant.setTextColor(resources.getColor(R.color.colorBlack))
            gest = false
            medi = true
        }
    }

    private fun autenticarUsuario(usuario: String, senha: String) {
        progressDialog?.setMessage(msg_acarregar)
        progressDialog?.show()

        Handler().postDelayed(object : Runnable {
            override fun run() {
                progressDialog?.dismiss()
                if (gest){
                    autenticarPaciente(usuario)
                }else{
                    autenticarMedico(usuario)
                }
            }
        }, TEMPO_RUN.toLong())
    }

    private fun autenticarPaciente(usuario: String) {
        gestanteViewModel.login(usuario,senha).observe(this@TelaIniciaLoginFragment, Observer { gestante ->
            gestante?.id.let {
                if (it != null){
                    gestanteUserViewModel.delete()
                    gestanteUserViewModel.inserir(GestanteUserEntity(0,gestante.nome,gestante.bi,gestante.nacionalidade,
                        gestante.peso,gestante.altura,gestante.sexo,gestante.grupo_sanguineo,gestante.raca,gestante.provincia,
                        gestante.bairro,gestante.rua,gestante.municipio,gestante.telefone,gestante.email,
                        gestante.data_nac,gestante.senha,gestante.medico,gestante.foto))

                    gestanteUserViewModel.gestante.observe(this@TelaIniciaLoginFragment, Observer {

                        if (it.size>0)
                            Log.i("log_user",gestante.nome)
                    })

                    findNavController().navigate(TelaIniciaLoginFragmentDirections.actionTelaInicialFragmentToInicialSessaoPacienteFragment2())
                }else{
                    context?.mostrarMensagem("Credenciais inválidas")
                }
            }

        })
    }

    private fun autenticarMedico(usuario: String) {
        medicoViewModel.login(usuario,senha).observe(this@TelaIniciaLoginFragment, Observer { medico ->
            medico?.id.let {
                if (it != null){
                    medicoUserViewModel.delete()
                    medicoUserViewModel.inserir(
                        MedicoUserEntity(0,medico.nome,medico.n_ordem,
                        medico.sexo,medico.nacionalidade,medico.data_nasc,medico.email,medico.num_documento,medico.telefone,medico.senha,medico.foto)
                    )

                    findNavController().navigate(TelaIniciaLoginFragmentDirections.actionTelaInicialFragmentToHostFragmentMedico())
                }else{
                    context?.mostrarMensagem("Credenciais inválidas")
                }
            }

        })
    }

    private fun validarCampos(view: View): Boolean {

        view.textUsuario?.let {
            view.context.limparErroEditTxt(view.textUsuario)
            email = view.textUsuario.text.toString().trim()
            Log.i("log_user",email)
        }

        view.textUsuarioSenha?.let {
            view.context.limparErroEditTxt(view.textUsuarioSenha)
            senha = view.textUsuarioSenha.text.toString()
            Log.i("log_user",senha)
        }

        if (TextUtils.isEmpty(email)) {
            view.context.erroEditText(view.textUsuario, MSG_ERRO_VAZIO_CAMPO)
            return false
        }

        if (TextUtils.isEmpty(senha)) {
            view.context.erroEditText(view.textUsuarioSenha, MSG_ERRO_VAZIO_CAMPO)
            return false
        }

        return true
    }


}
