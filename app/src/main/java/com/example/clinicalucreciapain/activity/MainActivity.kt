package com.example.clinicalucreciapain.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clinicalucreciapain.R
import com.example.clinicalucreciapain.baseDeDados.entidades.*
import com.example.clinicalucreciapain.comuns.*
import proitdevelopers.com.bloomberg.viewModel.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        medicoViewModel = ViewModelProviders.of(this).get(MedicoViewModel::class.java)
        recomendacaoViewModel = ViewModelProviders.of(this).get(RecomendacaoViewModel::class.java)
        gestanteViewModel = ViewModelProviders.of(this).get(GestanteViewModel::class.java)
        cartaoGestanteViewModel = ViewModelProviders.of(this).get(CartaoGestanteViewModel::class.java)
        minhasConsultasViewModel = ViewModelProviders.of(this).get(MinhasConsultasViewModel::class.java)
        bebeViewModel = ViewModelProviders.of(this).get(BebeViewModel::class.java)

        for (e in email)
            Log.i("email__",e)


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

        medicoViewModel.inserir(MedicoEntity(0,medicos.get(0),n_ordem.get(0), sexo.get(1),nacionalidade.get(0),"01-01-1987","joaq@mins.gov.ao","00001","930000000",senha.toString(),medico1))
        medicoViewModel.inserir(MedicoEntity(0,medicos.get(1),n_ordem.get(1), sexo.get(0),nacionalidade.get(1),"01-01-1987","maria@mins.gov.ao","00002","930000001",senha.toString(),medica2))
        medicoViewModel.inserir(MedicoEntity(0,medicos.get(2),n_ordem.get(2), sexo.get(1),nacionalidade.get(2),"01-01-1980","miguelm@mins.gov.ao","00003","930000002",senha.toString(),medico3))

    }

    private fun salvarGestante(gestanteViewModel: GestanteViewModel) {
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(0),bi.get(0), pais,peso.get(0),altura.get(0),sexo.get(0),grupo_sanguineo.get(0),raca.get(0),provincia.get(0),bairros.get(0),rua.get(0),municipios.get(0),telefone.get(0),email.get(0),dataNascimento.get(0),senha,n_ordem.get(0),fotos_gestantes.get(0),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(1),bi.get(1), pais,peso.get(1),altura.get(1),sexo.get(0),grupo_sanguineo.get(1),raca.get(0),provincia.get(0),bairros.get(1),rua.get(1),municipios.get(1),telefone.get(1),email.get(1),dataNascimento.get(1),senha,n_ordem.get(0),fotos_gestantes.get(1),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(2),bi.get(2), pais,peso.get(2),altura.get(2),sexo.get(0),grupo_sanguineo.get(2),raca.get(0),provincia.get(0),bairros.get(2),rua.get(2),municipios.get(2),telefone.get(2),email.get(2),dataNascimento.get(2),senha,n_ordem.get(0),fotos_gestantes.get(2),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(3),bi.get(3), pais,peso.get(3),altura.get(3),sexo.get(0),grupo_sanguineo.get(3),raca.get(0),provincia.get(0),bairros.get(3),rua.get(3),municipios.get(3),telefone.get(3),email.get(3),dataNascimento.get(3),senha,n_ordem.get(0),fotos_gestantes.get(3),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(4),bi.get(4), pais,peso.get(4),altura.get(4),sexo.get(0),grupo_sanguineo.get(0),raca.get(0),provincia.get(0),bairros.get(4),rua.get(4),municipios.get(4),telefone.get(4),email.get(4),dataNascimento.get(0),senha,n_ordem.get(0),fotos_gestantes.get(4),medicos.get(0)))

        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(5),bi.get(5), pais,peso.get(0),altura.get(0),sexo.get(0),grupo_sanguineo.get(1),raca.get(0),provincia.get(0),bairros.get(0),rua.get(0),municipios.get(0),telefone.get(5),email.get(5),dataNascimento.get(1),senha,n_ordem.get(1),fotos_gestantes.get(5),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(6),bi.get(6), pais,peso.get(1),altura.get(1),sexo.get(0),grupo_sanguineo.get(2),raca.get(0),provincia.get(0),bairros.get(1),rua.get(1),municipios.get(1),telefone.get(6),email.get(6),dataNascimento.get(2),senha,n_ordem.get(1),fotos_gestantes.get(6),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(7),bi.get(7), pais,peso.get(2),altura.get(2),sexo.get(0),grupo_sanguineo.get(3),raca.get(0),provincia.get(0),bairros.get(2),rua.get(2),municipios.get(2),telefone.get(7),email.get(7),dataNascimento.get(3),senha,n_ordem.get(1),fotos_gestantes.get(7),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(8),bi.get(8), pais,peso.get(3),altura.get(3),sexo.get(0),grupo_sanguineo.get(0),raca.get(0),provincia.get(0),bairros.get(3),rua.get(3),municipios.get(3),telefone.get(8),email.get(8),dataNascimento.get(0),senha,n_ordem.get(1),fotos_gestantes.get(8),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(9),bi.get(9), pais,peso.get(4),altura.get(4),sexo.get(0),grupo_sanguineo.get(1),raca.get(0),provincia.get(0),bairros.get(4),rua.get(4),municipios.get(4),telefone.get(9),email.get(9),dataNascimento.get(1),senha,n_ordem.get(1),fotos_gestantes.get(9),medicos.get(0)))

        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(10),bi.get(10), pais,peso.get(0),altura.get(0),sexo.get(0),grupo_sanguineo.get(2),raca.get(0),provincia.get(0),bairros.get(0),rua.get(0),municipios.get(0),telefone.get(10),email.get(10),dataNascimento.get(2),senha,n_ordem.get(2),fotos_gestantes.get(10),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(11),bi.get(11), pais,peso.get(1),altura.get(1),sexo.get(0),grupo_sanguineo.get(3),raca.get(0),provincia.get(0),bairros.get(1),rua.get(1),municipios.get(1),telefone.get(11),email.get(11),dataNascimento.get(3),senha,n_ordem.get(2),fotos_gestantes.get(11),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(12),bi.get(12), pais,peso.get(2),altura.get(2),sexo.get(0),grupo_sanguineo.get(0),raca.get(0),provincia.get(0),bairros.get(2),rua.get(2),municipios.get(2),telefone.get(12),email.get(12),dataNascimento.get(0),senha,n_ordem.get(2),fotos_gestantes.get(12),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(13),bi.get(13), pais,peso.get(3),altura.get(3),sexo.get(0),grupo_sanguineo.get(1),raca.get(0),provincia.get(0),bairros.get(3),rua.get(3),municipios.get(3),telefone.get(13),email.get(13),dataNascimento.get(1),senha,n_ordem.get(2),fotos_gestantes.get(13),medicos.get(0)))
        gestanteViewModel.inserir(GestanteEntity(0, nomes.get(14),bi.get(14), pais,peso.get(4),altura.get(4),sexo.get(0),grupo_sanguineo.get(2),raca.get(0),provincia.get(0),bairros.get(4),rua.get(4),municipios.get(4),telefone.get(14),email.get(14),dataNascimento.get(2),senha,n_ordem.get(2),fotos_gestantes.get(14),medicos.get(0)))
    }

    private fun salvarCartaoGestante(cartaoGestanteViewModel: CartaoGestanteViewModel) {

        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(0) , idade.get(0), estado_civil.get(0),habilidade_literaria.get(0), parceiros.get(0),residencia.get(0),ponto_ref.get(0), telefone_emergencia.get(0),"3","2","0","2","0",fotos_gestantes.get(0)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(1) , idade.get(1), estado_civil.get(1),habilidade_literaria.get(1), parceiros.get(1),residencia.get(1),ponto_ref.get(1), telefone_emergencia.get(1),"2","1","0","1","0",fotos_gestantes.get(1)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(2) , idade.get(2), estado_civil.get(0),habilidade_literaria.get(1), parceiros.get(2),residencia.get(2),ponto_ref.get(2), telefone_emergencia.get(2),"3","2","0","2","0",fotos_gestantes.get(2)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(3) , idade.get(3), estado_civil.get(1),habilidade_literaria.get(1), parceiros.get(3),residencia.get(3),ponto_ref.get(3), telefone_emergencia.get(3),"4","3","0","3","0",fotos_gestantes.get(3)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(4) , idade.get(0), estado_civil.get(0),habilidade_literaria.get(1), parceiros.get(4),residencia.get(4),ponto_ref.get(4), telefone_emergencia.get(4),"1","0","0","0","0",fotos_gestantes.get(4)))

        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(5) , idade.get(1), estado_civil.get(1),habilidade_literaria.get(0), parceiros.get(5),residencia.get(0),ponto_ref.get(0), telefone_emergencia.get(0),"3","2","0","2","0",fotos_gestantes.get(5)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(6) , idade.get(2), estado_civil.get(0),habilidade_literaria.get(0), parceiros.get(6),residencia.get(1),ponto_ref.get(1), telefone_emergencia.get(1),"2","1","0","1","0",fotos_gestantes.get(6)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(7) , idade.get(3), estado_civil.get(1),habilidade_literaria.get(0), parceiros.get(7),residencia.get(2),ponto_ref.get(2), telefone_emergencia.get(2),"3","2","0","2","0",fotos_gestantes.get(7)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(8) , idade.get(0), estado_civil.get(0),habilidade_literaria.get(1), parceiros.get(8),residencia.get(3),ponto_ref.get(3), telefone_emergencia.get(3),"4","3","0","3","0",fotos_gestantes.get(8)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(9) , idade.get(1), estado_civil.get(1),habilidade_literaria.get(1), parceiros.get(9),residencia.get(4),ponto_ref.get(4), telefone_emergencia.get(4),"1","0","0","0","0",fotos_gestantes.get(9)))

        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(10) , idade.get(2), estado_civil.get(0),habilidade_literaria.get(1), parceiros.get(10),residencia.get(0),ponto_ref.get(0), telefone_emergencia.get(0),"1","0","0","0","0",fotos_gestantes.get(10)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(11) , idade.get(3), estado_civil.get(1),habilidade_literaria.get(1), parceiros.get(11),residencia.get(1),ponto_ref.get(1), telefone_emergencia.get(1),"4","3","0","3","0",fotos_gestantes.get(11)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(12) , idade.get(0), estado_civil.get(0),habilidade_literaria.get(0), parceiros.get(12),residencia.get(2),ponto_ref.get(2), telefone_emergencia.get(2),"3","2","0","2","0",fotos_gestantes.get(12)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(13) , idade.get(1), estado_civil.get(1),habilidade_literaria.get(1), parceiros.get(13),residencia.get(3),ponto_ref.get(3), telefone_emergencia.get(3),"2","1","0","1","0",fotos_gestantes.get(13)))
        cartaoGestanteViewModel.inserir(CartaoGestanteEntity(0,unidade_sanitaria,nomes.get(14) , idade.get(2), estado_civil.get(0),habilidade_literaria.get(0), parceiros.get(14),residencia.get(4),ponto_ref.get(4), telefone_emergencia.get(4),"3","2","0","2","0",fotos_gestantes.get(14)))
    }

    private fun consultasMed1(minhasConsultasViewModel: MinhasConsultasViewModel){
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(0),nomes.get(0),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(1),nomes.get(0),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(2),nomes.get(0),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(3),nomes.get(0),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(4),nomes.get(0),medicos.get(0)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(5),nomes.get(1),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(6),nomes.get(1),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(7),nomes.get(1),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(8),nomes.get(1),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(9),nomes.get(1),medicos.get(0)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(10),nomes.get(2),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(11),nomes.get(2),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(12),nomes.get(2),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(13),nomes.get(2),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(14),nomes.get(2),medicos.get(0)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(15),nomes.get(3),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(16),nomes.get(3),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(17),nomes.get(3),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(18),nomes.get(3),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(19),nomes.get(3),medicos.get(0)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(20),nomes.get(4),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(21),nomes.get(4),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(22),nomes.get(4),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(23),nomes.get(4),medicos.get(0)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(24),nomes.get(4),medicos.get(0)))
    }

    private fun consultasMed2(minhasConsultasViewModel: MinhasConsultasViewModel){
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(0),nomes.get(5),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(1),nomes.get(5),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(2),nomes.get(5),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(3),nomes.get(5),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(4),nomes.get(5),medicos.get(1)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(5),nomes.get(6),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(6),nomes.get(6),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(7),nomes.get(6),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(8),nomes.get(6),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(9),nomes.get(6),medicos.get(1)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(10),nomes.get(7),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(11),nomes.get(7),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(12),nomes.get(7),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(13),nomes.get(7),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(14),nomes.get(7),medicos.get(1)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(15),nomes.get(8),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(16),nomes.get(8),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(17),nomes.get(8),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(18),nomes.get(8),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(19),nomes.get(8),medicos.get(1)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(20),nomes.get(9),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(21),nomes.get(9),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(22),nomes.get(9),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(23),nomes.get(9),medicos.get(1)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(24),nomes.get(9),medicos.get(1)))
    }

    private fun consultasMed3(minhasConsultasViewModel: MinhasConsultasViewModel){
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(0),nomes.get(10),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(1),nomes.get(10),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(2),nomes.get(10),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(3),nomes.get(10),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(4),nomes.get(10),medicos.get(2)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(5),nomes.get(11),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(6),nomes.get(11),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(7),nomes.get(11),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(8),nomes.get(11),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(9),nomes.get(11),medicos.get(2)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(10),nomes.get(12),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(11),nomes.get(12),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(12),nomes.get(12),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(13),nomes.get(12),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(14),nomes.get(12),medicos.get(2)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(15),nomes.get(13),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(16),nomes.get(13),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(17),nomes.get(13),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(18),nomes.get(13),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(19),nomes.get(13),medicos.get(2)))

        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(20),nomes.get(14),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(21),nomes.get(14),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(22),nomes.get(14),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(23),nomes.get(14),medicos.get(2)))
        minhasConsultasViewModel.inserir(MinhasConsultasEntity(0, relatorio_consulta, estados_consulta.get(1),datasConsulta.get(24),nomes.get(14),medicos.get(2)))
    }

    private fun salvarMinhasCOnsultas(minhasConsultasViewModel: MinhasConsultasViewModel) {
        consultasMed1(minhasConsultasViewModel)
        consultasMed2(minhasConsultasViewModel)
        consultasMed3(minhasConsultasViewModel)

    }

    private fun salvarMeuBebe(bebeViewModel: BebeViewModel) {

        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(0), sexo.get(0),"5 ","20"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(1), sexo.get(0),"3 ","12"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(2), sexo.get(0),"5 ","11"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(3), sexo.get(0),"1 ","4"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(4), sexo.get(0),"5 ","5"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(5), sexo.get(0),"1 ","1"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(6), sexo.get(0),"5 ","3"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(7), sexo.get(0),"5 ","4"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(8), sexo.get(0),"6 ","5"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(9), sexo.get(0),"7 ","6"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(10), sexo.get(0),"8 ","7"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(11), sexo.get(0),"9 ","8"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(12), sexo.get(0),"10 ","9"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(13), sexo.get(0),"3 ","1"))
        bebeViewModel.inserir(BebeEntity(0,10f,15f, nomes.get(14), sexo.get(0),"2 ","2"))

    }
}
