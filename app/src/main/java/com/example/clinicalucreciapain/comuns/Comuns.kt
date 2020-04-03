package com.example.clinicalucreciapain.comuns

import proitdevelopers.com.bloomberg.viewModel.*

lateinit var recomendacaoViewModel: RecomendacaoViewModel
lateinit var gestanteViewModel: GestanteViewModel
lateinit var gestanteUserViewModel: GestanteUserViewModel
lateinit var cartaoGestanteViewModel: CartaoGestanteViewModel
lateinit var medicoViewModel: MedicoViewModel
lateinit var medicoUserViewModel: MedicoUserViewModel
lateinit var minhasConsultasViewModel: MinhasConsultasViewModel
lateinit var bebeViewModel: BebeViewModel

const val MSG_ERRO_VAZIO_CAMPO = "Preencha o campo"
const val msg_acarregar = "A carregar ..."
const val ola_gest = "Olá, "
const val unidade_sanitaria = "Lucrêcia Pain"
const val relatorio_consulta = "O bebé está saudavel sem nenhuma complicação.\n\n " +
        "Na próxima consulta será examinado outros aspectos que garantem o bom estado do bebé.\n\n"

val estado_civil = arrayOf("Casada","Solteira")
val habilidade_literaria = arrayOf("Médio","Licenciada","Mestre")
val sexo = arrayOf("Feminino","Masculino")
val nacionalidade = arrayOf("Angolana","Cubana","Português","Maliana")
val raca = arrayOf("Negra","Branca")
val estados_consulta = arrayOf("Pendente","Completa")
const val regex_hora = "(\\d)(\\d):(\\d)(\\d)"
val relatorio = "N/A"
val TEMPO_RUN = 3000
val semInt = -1
val nulo = null
var gest = false
var medi = false