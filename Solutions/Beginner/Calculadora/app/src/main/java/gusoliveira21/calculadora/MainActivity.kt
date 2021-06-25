package gusoliveira21.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import gusoliveira21.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var valor: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            textViewResultado.setText("")

            bt0.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "0"
            }
            bt1.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "1"
            }
            bt2.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "2"
            }
            bt3.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "3"
            }
            bt4.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "4"
            }
            bt5.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "5"
            }
            bt6.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "6"
            }
            bt7.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "7"
            }
            bt8.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "8"
            }
            bt9.setOnClickListener {
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "9"
            }


            btSoma.setOnClickListener{
                if (funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                    binding.textViewResultado.text = "${binding.textViewResultado.text}" + "+"
                else
                    Toast.makeText(this@MainActivity, "Informe a expressão corretamente!", Toast.LENGTH_SHORT)
                        .show()
            }
            btVirgula.setOnClickListener{
                if ((funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text)) &&
                    (funVerificaSeJaTemUmPonto(binding.textViewResultado.text)))
                    binding.textViewResultado.text = "${binding.textViewResultado.text}" + "."
                else
                    Toast.makeText(this@MainActivity, "Informe a expressão corretamente!", Toast.LENGTH_SHORT)
                        .show()
            }
            btDivisao.setOnClickListener{
                if (funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                    binding.textViewResultado.text = "${binding.textViewResultado.text}" + "/"
                else
                    Toast.makeText(this@MainActivity, "Informe a expressão corretamente!", Toast.LENGTH_SHORT)
                        .show()

            }
            btSubtracao.setOnClickListener{
                if (funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                    binding.textViewResultado.text = "${binding.textViewResultado.text}" + "-"
                else
                    Toast.makeText(this@MainActivity, "Informe a expressão corretamente!", Toast.LENGTH_SHORT)
                        .show()

            }
            btMultiplicacao.setOnClickListener{
                if (funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                    binding.textViewResultado.text = "${binding.textViewResultado.text}" + "*"
                else
                    Toast.makeText(this@MainActivity, "Informe a expressão corretamente!", Toast.LENGTH_SHORT)
                        .show()
            }

            btDelAll.setOnClickListener{binding.textViewResultado.setText("") }
            btDelLast.setOnClickListener{
                if (binding.textViewResultado.text.isEmpty())
                    Toast.makeText(this@MainActivity, "Campo Vazio", Toast.LENGTH_SHORT).show()
                else
                    binding.textViewResultado.setText(funDelLastElement(binding.textViewResultado.text))
            }

            btCalcular.setOnClickListener{funCalcularResultado(binding.textViewResultado.text)}
        }
    }

    private fun funVerificaSeJaTemUmPonto(ViewCampoDigitado: CharSequence): Boolean {
        try{
            for (i in ViewCampoDigitado.length - 1 downTo 0) {
                if (ViewCampoDigitado[i].toString() == ".")
                    return false
                else
                    when (ViewCampoDigitado[i].toString()) {
                        "+" -> return true
                        "-" -> return true
                        "/" -> return true
                        "*" -> return true
                    }
            }
            return true
        }catch(e:Exception){
            Toast.makeText(this, "${e}", Toast.LENGTH_SHORT).show()
            return false
        }
    }

    private fun funVerificaSeUltimoElementoDaListaEUmSimbolo(ViewCampoDigitado: CharSequence): Boolean {
        if ((ViewCampoDigitado.length - 1).toString() == "-1")
            return false
        else {

            when (ViewCampoDigitado[ViewCampoDigitado.length - 1].toString()) {
                "+" -> return false
                "-" -> return false
                "/" -> return false
                "*" -> return false
                "." -> return false
            }
        }
        return true
    }

    private fun funDelLastElement(ViewCampoDigitado: CharSequence): CharSequence {
        if (ViewCampoDigitado.length == 1) return ""
        var charCaracteres: String = ""
        for (i in 0..ViewCampoDigitado.length - 1) {
            charCaracteres += ViewCampoDigitado[i]
            if (i == ViewCampoDigitado.length - 2)
                return charCaracteres
        }
        return ""
    }

    private fun funVerificaSeEUmSimbolo(posicaoParaVerificarSeESimbolo: String): Boolean {
        when (posicaoParaVerificarSeESimbolo) {
            "+" -> return false
            "-" -> return false
            "/" -> return false
            "*" -> return false
            "." -> return false
        }
        return true
    }

        //TODO 5: Criar uma estrutura para ler uma lista de caracteres.
        //        A leitura dessa estrutura deve ser feita até que uma expressão seja apertada.
        //        Nesse ponto, os elementos selecionados no momento da escolha da expressão devem ser guardados.
        //        Se o usuario digitar o restante dos números após escolher a expressão, este restante deve ser armazenado.
        //        Este ciclo deve ser mantido até que o botão CALCULAR seja apertado.


    private fun funCalcularResultado(ViewCampoDigitado: CharSequence?) {
        //TODO 6: SE NÃO HOUVER ELEMENTO OU SE HOUVER E FOR UM SIMBOLO, SAIA (Se o campo estiver em branco)
        if (funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text) == false)
        //break
        else
        //TODO 7: SE FOR UM SIMBOLO, ELE PEGA O ELEMENTO DA PRIMEIRA POSIÇÃO, E FAZ A OPERAÇÃO
        //        DO SIMBOLO COM O ELEMENTO DA SEGUNDA POSIÇÃO
            for (i in 0..ViewCampoDigitado!!.length - 1) {
                if (funVerificaSeEUmSimbolo(ViewCampoDigitado[i].toString()) == false){
                    when (ViewCampoDigitado[i].toString()){
                        "+" -> Toast.makeText(this, "Tem SOMA", Toast.LENGTH_SHORT).show()//funSoma()
                        "-" -> Toast.makeText(this, "Tem SUBTRACAO", Toast.LENGTH_SHORT).show()//funSubtracao()
                        "/" -> Toast.makeText(this, "Tem DIVISAO", Toast.LENGTH_SHORT).show()//funDivisao()
                        "*" -> Toast.makeText(this, "Tem MULTIPLICACAO", Toast.LENGTH_SHORT).show()//funMultiplicacao()
                        "." -> Toast.makeText(this, "Tem PONTO", Toast.LENGTH_SHORT).show()//funPonto()
                    }
                } else {
                    //TODO 4: É necessário inicializar a variável listaDeValoresParaCalcular
                    //Toast.makeText(this, "Aqui acontece a inserção do numero na lista", Toast.LENGTH_SHORT).show()
                    var listaDeValoresParaCalcular:MutableList<String> = mutableListOf()
                    listaDeValoresParaCalcular.add(ViewCampoDigitado[i].toString())
                    //listaDeValoresParaCalcular[i] = textViewResultado[i].toString()
                    listaDeValoresParaCalcular.forEach { Log.e("GUSTAVO","${it}") }


                }
            }
        //Toast.makeText(this, "${textViewResultado!![0]}", Toast.LENGTH_SHORT).show()

        //TODO 8: É NECESSÁRIO SEGUIR A ORDEM CORRETA DO USO DAS EXPREÇÕES MATEMATICAS,
        //        O RESULTADO DE 25 + 18 * 3 É DIFERENTE DEPENDENDO DA ABORDAGEM
        //        > Potenciação e Radiciação
        //        > Multiplicação e Divisão
        //        > Adição (soma) e Subtração
    }


}


