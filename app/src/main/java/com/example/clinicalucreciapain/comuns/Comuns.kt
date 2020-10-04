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
const val unidade_sanitaria = "Lucrecia Paim"
const val msgSemInternet = "A rede 3G ou WI-FI não possui tranferência de dados."
const val relatorio_consulta = "O bebé está saudavel sem nenhuma complicação.\n\n " +
        "Na próxima consulta será examinado outros aspectos que garantem o bom estado do bebé.\n\n"

val nomes = arrayOf("Alessandra Cavaco","Aline Silva","Ariane Pimenta","Ariele Chagas","Ana Ladeira",
                            "Barbara  Santos","Bianca Silva","Bianca Poentes","Bruna Pereira","Beatriz Santos",
                            "Cintia Marques","Dayane Santos","Elaine Santos","Elisa Pinto","Erica Roza")

val email = arrayListOf(nomes.get(0).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(1).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(2).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(3).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(4).replace(" ","").plus("@gmail.com").toLowerCase(), nomes.get(5).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(6).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(7).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(8).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(9).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(10).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(11).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(12).replace(" ","").plus("@gmail.com").toLowerCase(),nomes.get(13).replace(" ","").plus("@gmail.com").toLowerCase(),
    nomes.get(14).replace(" ","").plus("@gmail.com").toLowerCase())

val dataNascimento = arrayListOf("01-01-1990","11-11-1992","06-12-1995","11-08-1996")
val idade = arrayListOf("30","28","25","24")

val medicos = arrayListOf("Joaquim Ferreira","Maria Salmatierra","Miguel Morais")
val n_ordem = arrayListOf("0001","0002","0003")

val datasConsulta = arrayListOf("08:30 ,01-04-2020","09:30 ,02-04-2020","10:30 ,03-04-2020","09:30 ,07-04-2020","10:30 ,08-04-2020",
                                "08:30 ,21-04-2020","09:30 ,22-04-2020","10:30 ,23-04-2020","09:30 ,24-04-2020","10:30 ,25-04-2020",
                                "08:30 ,28-04-2020","09:30 ,29-04-2020","10:30 ,30-04-2020","09:30 ,01-05-2020","10:30 ,05-05-2020",
                                "08:30 ,12-05-2020","09:30 ,13-05-2020","10:30 ,14-05-2020","09:30 ,15-05-2020","10:30 ,19-05-2020",
                                "08:30 ,26-05-2020","09:30 ,27-05-2020","10:30 ,28-05-2020","09:30 ,29-05-2020","10:30 ,30-05-2020")

val parceiros = arrayListOf("Augusto Pina","Miguel Francisco","João Carlos Radeck Neto","Jefferson Figueiredo dos Santos",
    "Heitor Chaves Teixeira da Silva","Giovanny Rodrigues dos Santos","Gabriel Vidal do Nascimento","Fernando Batista Bonadio",
    "Elineu Silva Pinto","Denis Godói de Oliveira Machado","Denis Andrade de Oliveira","Claudio Dias Guilhermino","Caio Rogério","Bruno Ferreira da Silva","Armando Duarte Almeida")

val fotos_gestantes = arrayListOf("android.resource://com.example.clinicalucreciapain/drawable/paciente_um","android.resource://com.example.clinicalucreciapain/drawable/paciente_dois",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_tres","android.resource://com.example.clinicalucreciapain/drawable/paciente_quatro","android.resource://com.example.clinicalucreciapain/drawable/paciente_cinco",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_seis","android.resource://com.example.clinicalucreciapain/drawable/paciente_sete",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_oito","android.resource://com.example.clinicalucreciapain/drawable/paciente_nove",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_dez","android.resource://com.example.clinicalucreciapain/drawable/paciente_onze",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_doze","android.resource://com.example.clinicalucreciapain/drawable/paciente_treze",
    "android.resource://com.example.clinicalucreciapain/drawable/paciente_catorze","android.resource://com.example.clinicalucreciapain/drawable/paciente_quinze")

val telefone = arrayOf("920000001","920000002","920000003","920000004","920000005","920000006", "920000007","920000008","920000009","920000010","920000011","920000012","920000013","920000014","920000015")
val telefone_emergencia = arrayOf("930000001","930000002","930000003","930000004","930000005","930000006", "930000007","930000008","930000009","930000010","930000011","930000012","930000013","930000014","930000015")
val residencia = arrayListOf("Ingombota","Samba","Maculusso","Mutamba","Martiris")
val ponto_ref = arrayListOf("Hotel Milho","Hotel Diamante","Casa da Musica","Universidade Lusiada","INE")

val peso = arrayListOf("71.50","81.56","68.60","61.70","75.70")
val altura = arrayListOf("1.50","1.56","1.60","1.70","1.70")

val provincia = arrayListOf("Luanda")
val bairros = arrayListOf("Samba","Bairro Operario","Estalagem","Bairro Azul","Zona Verde")
val municipios = arrayListOf("Belas","Luanda","Cacuaco","Quilamba","Ícolo e Bengo")
val rua = arrayListOf("Sunset","Estalagem","Antigo Control","Marginal","Sambizanga")

val habilidade_literaria = arrayOf("Médio","Licenciada","Mestre")
val senha = "12345"
val grupo_sanguineo = arrayOf("A+","B-","AB-","O+")

val bi = arrayOf("005710104LA001","005710104LA002","005710104LA003","005710104LA004","005710104LA005",
    "005710104LA006","005710104LA007","005710104LA008","005710104LA009","005710104LA010",
    "005710104LA011","005710104LA012","005710104LA013","005710104LA014","005710104LA015")
val nacionalidade = arrayOf("Angolana","Cubana","Português","Maliana")

val pais = "Angola"
val sexo = arrayOf("Feminino","Masculino")
val estado_civil = arrayOf("Feminino","Masculino")

val raca = arrayOf("Negra","Branca")
val estados_consulta = arrayOf("Pendente","Completa")
const val regex_hora = "(\\d)(\\d):(\\d)(\\d)"
val relatorio = "N/A"
val semValorString = ""
val TEMPO_RUN = 3000
val semInt = -1
val nulo = null
var gest = false
var medi = false