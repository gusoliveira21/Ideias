package gusoliveira21.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import gusoliveira21.calculadora.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.textViewResultado.setText("")
        var valor: Double = 0.0

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

        //TODO 1: Não deixar ser possível a inserção de dois, ou mais, simbolos aritiméticos em seguida.

        //TODO 2: Caso o campo esteja sem nenhum elemento numério e seja colocado algum elemento aritimético,
        //        é necessário colocar o simbolo Zero na frente.
        binding.btSoma.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "+"
        }
        binding.btVirgula.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "."
        }
        binding.btDivisao.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "/"
        }
        binding.btSubtracao.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "-"
        }
        binding.btMultiplicacao.setOnClickListener {
            binding.textViewResultado.text = "${binding.textViewResultado.text}" + "*"
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

    private fun funDelLastElement(textViewResultado: CharSequence): CharSequence {
        var charCaracteres: String = ""
        for (i in 0..textViewResultado.length - 1) {
            charCaracteres += textViewResultado[i]
            if (i == textViewResultado.length - 2)
                return charCaracteres
        }
        return "${
            Toast.makeText(this, "Desculpe, houve um erro ao deletar!", Toast.LENGTH_SHORT).show()
        }"
    }

    //TODO 5: Criar uma estrutura para ler uma lista de caracteres.
    //        A leitura dessa estrutura deve ser feita até que uma expressão seja apertada.
    //        Nesse ponto, os elementos selecionados no momento da escolha da expressão devem ser guardados.
    //        Se o usuario digitar o restante dos números após escolher a expressão, este restante deve ser armazenado.
    //        Este ciclo deve ser mantido até que o botão CALCULAR seja apertado.


    private fun funCalcularResultado(text: CharSequence?) {
        Toast.makeText(this, "${text!![0]}", Toast.LENGTH_SHORT).show()
    }

    private fun funVerificaSeTemUmElementoAritimeticoPorUltimo(){

    }

}


