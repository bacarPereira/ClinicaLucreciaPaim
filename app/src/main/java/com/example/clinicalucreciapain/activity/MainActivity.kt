package com.example.clinicalucreciapain.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.*
import com.example.clinicalucreciapain.comuns.*
import proitdevelopers.com.bloomberg.viewModel.*

class MainActivity : AppCompatActivity() {

    val senha = 12345

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        medicoViewModel = ViewModelProviders.of(this).get(MedicoViewModel::class.java)
        recomendacaoViewModel = ViewModelProviders.of(this).get(RecomendacaoViewModel::class.java)
        gestanteViewModel = ViewModelProviders.of(this).get(GestanteViewModel::class.java)
        cartaoGestanteViewModel = ViewModelProviders.of(this).get(CartaoGestanteViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        bebeViewModel = ViewModelProviders.of(this).get(BebeViewModel::class.java)


        recomendacaoViewModel.recomendacao.observe(this@MainActivity, Observer { recomendacoes ->
            if (recomendacoes.size == 0) {
                recomendacaoViewModel.deleteRecomendacoes()
                gestanteViewModel.delete()
                cartaoGestanteViewModel.delete()
                medicoViewModel.delete()
                minhasConsultasViewModel.delete()
                salvarRecomendacoes(recomendacaoViewModel)
                salvarMedico(medicoViewModel)
                salvarGestante(gestanteViewModel)
                salvarCartaoGestante(cartaoGestanteViewModel)
                salvarMinhasCOnsultas(minhasConsultasViewModel)
                salvarMeuBebe(bebeViewModel)
            }
        })
    }

    private fun salvarRecomendacoes(recomendacaoViewModel: RecomendacaoViewModel) {

        val gravida_auto_med = "android.resource://com.example.clinicalucreciapain/drawable/gravida_auto_med"
        val uri_alimentacao = "android.resource://com.example.clinicalucreciapain/drawable/gravida_alimentacao"
        val gravida_act_fisica = "android.resource://com.example.clinicalucreciapain/drawable/gravida_act_fisica"
        val gravida_exerci = "android.resource://com.example.clinicalucreciapain/drawable/gravida_exerci"
        val auto_medicacao = "android.resource://com.example.clinicalucreciapain/drawable/auto_medicacao"
        val gravida_fumadora = "android.resource://com.example.clinicalucreciapain/drawable/gravida_fumadora"
        val uri_alimentacao_cuidado = "android.resource://com.example.clinicalucreciapain/drawable/gravida_alimentacao"
        val gravida_descanco = "android.resource://com.example.clinicalucreciapain/drawable/gravida_descanco"

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Alimente-se bem",
            resumo = "Você não precisa comer mais porque está grávida (a história de que grávida tem que comer por dois é mito),",
            foto = uri_alimentacao,
            corpo = "Você não precisa comer mais porque está grávida (a história de que grávida tem " +
                    "que comer por dois é mito), mas é importante ter uma alimentação equilibrada e saudável." +
                    " \n\n Muitas mulheres param de comer certo tipo de alimento por causa do enjoo, mas é sempre" +
                    " possível arranjar um substituto que tenha valor nutricional parecido. \n\n O ideal é ter uma dieta " +
                    "que inclua verduras, legumes e frutas, alimentos integrais, proteína -- que pode vir do peixe, da carne, " +
                    "do frango, dos ovos, de castanhas ou sementes -- e também leite e laticínios em geral. ",cor = "#9675CE"))


        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Comece a exercitar os músculos da região da vagina",
            resumo = "Pode ser que você nunca tenha ouvido falar disso, mas esse tipo de exercício, nos músculos da região pélvica, " +
                    "devia ser feito por todas as mulheres desde a adolescência. ",
            foto = gravida_act_fisica,
            corpo = "Pode ser que você nunca tenha ouvido falar disso, mas esse tipo de exercício, nos músculos da " +
                    "região pélvica, devia ser feito por todas as mulheres desde a adolescência.\n\n" +
                    "Além de combater o problema da incontinência urinária, ele contribui para aumentar o prazer " +
                    "sexual -- por isso é usado nas técnicas de pompoarismo.\n" +
                    "A vantagem é que você pode fazê-lo a qualquer hora, em qualquer lugar, sem ninguém perceber.\n\n" +
                    "Várias vezes por dia -- por exemplo, enquanto lava as mãos, escova os dentes ou prepara o café --, faça " +
                    "dez contrações lentas e dez rápidas dos músculos do assoalho pélvico.\n\n" +
                    "Um bom jeito de sentir como fazer essas contrações é imaginar que está fazendo xixi e interromper o fluxo imaginário de urina. ",cor = "#4386F5"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Tome suplemento de ácido fólico",
            resumo = "O suplemento de ácido fólico é considerado vital na gravidez, porque ajuda a prevenir problemas " +
                    "congênitos no bebê ligados ao fechamento do tubo neural, como a espinha bífida, ou mielomeningocele.",
            foto = gravida_auto_med,
            corpo = "O suplemento de ácido fólico é considerado vital na gravidez, porque ajuda a prevenir problemas " +
                    "congênitos no bebê ligados ao fechamento do tubo neural, como a espinha bífida, ou mielomeningocele.\n\n" +
                    "Todas as mulheres que estejam pensando em engravidar devem tomar um suplemento diário de pelo menos 400 mcg de " +
                    "ácido fólico, desde antes da concepção. Se você ainda não toma, comece já.\n\n" +
                    "Outros nutrientes importantes para sua saúde e para a do bebê são o ferro e o cálcio, que podem ser supridos " +
                    "normalmente pela alimentação. No entanto, muitos médicos receitam suplementos vitamínicos especiais para grávidas, " +
                    "que contêm reforços desses nutrientes.\n\nA gordura natural dos peixes, como o ômega 3, também tem um efeito " +
                    "benéfico no peso do bebê e no desenvolvimento do cérebro e dos nervos no final da gravidez. Os peixes que mais" +
                    " contêm esse tipo de ácido graxo são o salmão, a sardinha, a truta, a cavalinha e o arenque.\n\n" +
                    "Se você não come peixe, converse com o médico. Ele pode receitar um suplemento de ômega 3.\n\n" +
                    "O médico também vai decidir se você precisa de algum suplemento de vitamina D.",cor = "#479050"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Tome cuidado com o que come",
            resumo = "É melhor evitar certos alimentos na gravidez, porque eles podem representar risco para o bebê se estiverem contaminados.",
            foto = uri_alimentacao_cuidado,
            corpo = "É melhor evitar certos alimentos na gravidez, porque eles podem representar risco para o bebê se estiverem contaminados. \n\n" +
                    "A listeriose, doença que provoca aborto espontâneo ou problemas graves no recém-nascido," +
                    " pode ser transmitida por queijos como o brie, camembert, roquefort, gorgonzola e os queijos " +
                    "brancos tipo frescal ou de Minas, se não forem industrializados.\n\n Devido ao risco de toxoplasmose, que embora seja" +
                    " pequeno existe, evite comer carne crua ou malpassada. Lave bem verduras, legumes e frutas " +
                    "para tirar todo resquício de terra ou sujeira, e lave bem as mãos antes de comer.\n\n Infecções alimentares por salmonela " +
                    "(salmonelose) são transmitidas por alimentos de origem animal, como carnes, peixes, ovos e leite, " +
                    "portanto segure a vontade de lamber a colher de massa de bolo crua. ",cor = "#EC8232"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Faça atividade física regularmente",
            resumo = "Um bom programa de exercícios vai lhe dar a força e a resistência necessárias para carregar" +
                    " o peso extra da gravidez e para aguentar o estresse físico do parto.",
            foto = gravida_exerci,
            corpo = "Um bom programa de exercícios vai lhe dar a força e a resistência necessárias para carregar o " +
                    "peso extra da gravidez e para aguentar o estresse físico do parto.\n\n" +
                    "Também contribui para que você entre em forma mais rápido depois que o bebê " +
                    "nascer. Sem contar que ajuda a melhorar o humor, com a liberação da serotonina -- o que" +
                    " reduz o risco de você sucumbir a uma certa tristeza comum nessa fase.\n\n" +
                    "Se você já está acostumada a se exercitar, o mais provável é que possa continuar com a " +
                    "mesma atividade, desde que esteja se sentindo confortável. Converse com a pessoa que orienta " +
                    "seu treino e avise que está grávida.",cor = "#5AC7DB"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Não tome remédios sem falar com o médico",
            resumo = "Agora que está grávida, não tome nenhum tipo de remédio sem antes perguntar para o médico se pode.",
            foto = auto_medicacao,
            corpo = "Agora que está grávida, não tome nenhum tipo de remédio sem antes perguntar para o médico se pode.\n\n" +
                    "Por outro lado, se você faz uso de um medicamento contínuo, como para hipotireoidismo ou depressão, " +
                    "pergunte na primeira consulta do pré-natal se vai poder manter a mesma medicação e dose.\n\n" +
                    "Antes da consulta, tente lembrar ainda os problemas que você costuma ter com frequência e os remédios que toma (como para alergia, " +
                    "cólicas, dor de cabeça, problemas de pele etc.). Faça uma lista e verifique com o médico o que vai poder tomar se precisar. ",cor = "#52C3FA"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Pare de fumar e de beber",
            resumo = "Mulheres que fumam têm risco maior de aborto espontâneo, de parto prematuro e " +
                    "de ter um bebê de baixo peso. Quanto antes você parar de fumar, mais o bebê vai se beneficiar.",
            foto = gravida_fumadora,
            corpo = "Mulheres que fumam têm risco maior de aborto espontâneo, de parto prematuro e de ter um bebê de " +
                    "baixo peso. Quanto antes você parar de fumar, mais o bebê vai se beneficiar.\n\n" +
                    "Se você não conseguir parar, qualquer redução no número de cigarros que você fuma por dia " +
                    "já facilita um pouco a vida do seu bebê.",cor = "#9675CE"))

        recomendacaoViewModel.insertUsuario(RecomendacaoEntity(id = 0,titulo = "Descanse",
            resumo = "O cansaço e o sono que você sente no primeiro e no terceiro trimestre da " +
                    "   gravidez não são nada mais que seu corpo pedindo para você pegar leve.",
            foto = gravida_descanco,
            corpo = "O cansaço e o sono que você sente no primeiro e no terceiro trimestre da " +
                    "gravidez não são nada mais que seu corpo pedindo para você pegar leve.\n\n" +
                    "No melhor dos mundos, uma soneca todo dia depois do almoço seria perfeita. " +
                    "Se não dá, tente dar uma relaxadinha de meia hora, pôr os pés para cima, do " +
                    "jeito que conseguir.\n\nNão estranhe se começar a preferir ficar em casa em " +
                    "vez de sair à noite. Escute seu corpo.",cor = "#4386F5"))


    }

    private fun salvarMedico(medicoViewModel: MedicoViewModel) {

        val medico1 = "android.resource://com.example.clinicalucreciapain/drawable/medico_um"
        val medica2 = "android.resource://com.example.clinicalucreciapain/drawable/medica_um"
        val medico3 = "android.resource://com.example.clinicalucreciapain/drawable/medico_dois"

        medicoViewModel.inserir(MedicoEntity(0,"Joaquim Ferreira","0001", sexo.get(1),nacionalidade.get(0),"01-01-1987","joaq@mins.gov.ao","00001","930000000",senha.toString(),medico1))
        medicoViewModel.inserir(MedicoEntity(0,"Maria Salmatierra","0002", sexo.get(0),nacionalidade.get(1),"01-01-1987","maria@mins.gov.ao","00002","930000001",senha.toString(),medica2))
        medicoViewModel.inserir(MedicoEntity(0,"Miguel Morais","0003", sexo.get(1),nacionalidade.get(2),"01-01-1980","miguelm@mins.gov.ao","00003","930000002",senha.toString(),medico3))

    }

    private fun salvarGestante(gestanteViewModel: GestanteViewModel) {

        val paciente1 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_um"
        val paciente2 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_dois"
        val paciente3 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_tres"

        gestanteViewModel.inserir(GestanteEntity(0,"Elizabeth Da Costa Pina","005819182LA955","Angolana", "66.7","1.70", sexo.get(0),"O+", raca.get(0),"Luanda", "Catambor","Catambor","Belas","920000000","elizabth@gmail.com", "11-11-1990",senha.toString(),"0001",paciente1,"Joaquim Ferreira"))
        gestanteViewModel.inserir(GestanteEntity(0,"Maria Florentina","015812182LA945","Angolana", "77.7","1.60",sexo.get(0),"O-", raca.get(1),"Luanda", "Maianga","Maianga","Belas","920000001","mariaflorentina@gmail.com", "09-02-1985",senha.toString(),"0002",paciente2,"Maria Salmatierra"))
        gestanteViewModel.inserir(GestanteEntity(0,"Josefina Armando","005819182LA955","Angolana", "66.7","1.70",sexo.get(0),"O+", raca.get(0),"Luanda", "Sunset","Sunset","Belas","920000002","josejinaarmando@gmail.com", "02-06-1987",senha.toString(),"0003",paciente3,"Miguel Morais"))
        gestanteViewModel.inserir(GestanteEntity(0,"Daniela Armando","005819182LA922","Angolana", "66.7","1.70",sexo.get(0),"O+", raca.get(0),"Luanda", "Sunset","Sunset","Belas","920000003","josejinaarmando@gmail.com", "02-06-1987",senha.toString(),"0003",paciente3,"Miguel Morais"))

    }

    private fun salvarCartaoGestante(cartaoGestanteViewModel: CartaoGestanteViewModel) {
        val paciente1 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_um"
        val paciente2 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_dois"
        val paciente3 = "android.resource://com.example.clinicalucreciapain/drawable/paciente_tres"
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria, "Elizabeth Da Costa Pina","25", estado_civil.get(0),habilidade_literaria.get(0), "Augusto Pina","Ingombota", "Hotel Diamante", "999999991","1","1","0","1","0",paciente1))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria, "Maria Florentina","33", estado_civil.get(1),habilidade_literaria.get(1), "Miguel Francisco","Maianga", "Hotel Tivoli", "999999992","5","3","1","2","1",paciente2))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria, "Josefina Armando","40", estado_civil.get(1),habilidade_literaria.get(1), "Augusto Pina","Sunset", "Hotel Rancho Del Tesouro", "999999993","3","2","0","2","0",paciente3))
    }

    private fun salvarMinhasCOnsultas(minhasConsultasViewModel: MinhasConsultasViewModel) {
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"14:30 , 12-01-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"12:39 , 12-02-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"14:00 , 22-02-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"08:00 , 07-03-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"09:30 , 15-03-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"10:00 , 20-03-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),"11:30 , 17-04-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio, estados_consulta.get(0),"14:30 , 13-05-2020","Elizabeth Da Costa Pina","Joaquim Ferreira"))

    }

    private fun salvarMeuBebe(bebeViewModel: BebeViewModel) {

        bebeViewModel.inserir(BebeEntity(0,100f,150f,"Elizabeth Da Costa Pina","Feminino","1 ","2"))
        bebeViewModel.inserir(BebeEntity(0,140f,150f,"Maria Florentina","Masculino","1 ","2"))
        bebeViewModel.inserir(BebeEntity(0,190f,150f,"Josefina Armando","Feminino","1 ","2"))

    }
}
