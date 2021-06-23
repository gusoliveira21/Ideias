package gusoliveira21.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import gusoliveira21.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listaDeValoresParaCalcular:MutableList<String>
    var valor: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.textViewResultado.setText("")

        binding.bt0.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "0"
        }
        binding.bt1.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "1"
        }
        binding.bt2.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "2"
        }
        binding.bt3.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "3"
        }
        binding.bt4.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "4"
        }
        binding.bt5.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "5"
        }
        binding.bt6.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "6"
        }
        binding.bt7.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "7"
        }
        binding.bt8.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "8"
        }
        binding.bt9.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "9"
        }

        binding.btSoma.setOnClickListener {
            if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "+"
            else
                Toast.makeText(this,"Informe a expressão corretamente!", Toast.LENGTH_SHORT).show()
        }
        binding.btVirgula.setOnClickListener {
            if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "."
            else
                Toast.makeText(this,"Informe a expressão corretamente!", Toast.LENGTH_SHORT).show()

        }
        binding.btDivisao.setOnClickListener {
            if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "/"
            else
                Toast.makeText(this,"Informe a expressão corretamente!", Toast.LENGTH_SHORT).show()

        }
        binding.btSubtracao.setOnClickListener {
            if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "-"
            else
                Toast.makeText(this,"Informe a expressão corretamente!", Toast.LENGTH_SHORT).show()

        }
        binding.btMultiplicacao.setOnClickListener {
            if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text))
                binding.textViewResultado.text = "${binding.textViewResultado.text}" + "*"
            else
                Toast.makeText(this,"Informe a expressão corretamente!", Toast.LENGTH_SHORT).show()
        }

        binding.btDelAll.setOnClickListener { binding.textViewResultado.setText("") }
        binding.btDelLast.setOnClickListener {
            if (binding.textViewResultado.text.isEmpty())
                Toast.makeText(this, "Campo Vazio", Toast.LENGTH_SHORT).show()
            else
                binding.textViewResultado.setText(funDelLastElement(binding.textViewResultado.text))
        }

        binding.btCalcular.setOnClickListener { funCalcularResultado(binding.textViewResultado.text) }
    }

    private fun funVerificaSeUltimoElementoDaListaEUmSimbolo(textViewResultado: CharSequence):Boolean {
        if ((textViewResultado.length-1).toString() == "-1")
            return false
        else {
            when(textViewResultado[textViewResultado.length - 1].toString()) {
                "+" -> return false
                "-" -> return false
                "/" -> return false
                "*" -> return false
                "." -> return false
            }
    }
        return true
    }

    private fun funDelLastElement(textViewResultado: CharSequence): CharSequence {
        if(textViewResultado.length == 1) return ""
        var charCaracteres: String = ""
        for (i in 0..textViewResultado.length - 1) {
            charCaracteres += textViewResultado[i]
            if (i == textViewResultado.length - 2)
                return charCaracteres
        }
        return ""
    }

    private fun funVerificaSeESimbolo(posicaoParaVerificarSeESimbolo: String):Boolean{
        when(posicaoParaVerificarSeESimbolo){
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


    private fun funCalcularResultado(textViewResultado: CharSequence?) {
    //TODO 6: SE NÃO HOUVER ELEMENTO OU SE HOUVER E FOR UM SIMBOLO, SAIA
        if(funVerificaSeUltimoElementoDaListaEUmSimbolo(binding.textViewResultado.text) == false)
            //break
        else
            for (i in 0..textViewResultado!!.length - 1){

    //TODO 7: SE FOR UM SIMBOLO, ELE PEGA O ELEMENTO DA PRIMEIRA POSIÇÃO, E FAZ A OPERAÇÃO
    //        DO SIMBOLO COM O ELEMENTO DA SEGUNDA POSIÇÃO

                if(funVerificaSeESimbolo(textViewResultado[i].toString())) {
                    when (textViewResultado[i].toString()){

                    }
                }
                else
                    listaDeValoresParaCalcular[i] = textViewResultado[i].toString()
            }
    //TODO 8: É NECESSÁRIO SEGUIR A ORDEM CORRETA DO USO DAS EXPREÇÕES MATEMATICAS,
    //        O RESULTADO DE 25 + 18 * 3 É DIFERENTE DEPENDENDO DA ABORDAGEM
    //        > Potenciação e Radiciação
    //        > Multiplicação e Divisão
    //        > Adição (soma) e Subtração




        Toast.makeText(this, "${textViewResultado!![0]}", Toast.LENGTH_SHORT).show()
    }





}


