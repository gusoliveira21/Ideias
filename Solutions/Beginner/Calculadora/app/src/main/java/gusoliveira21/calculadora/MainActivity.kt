package gusoliveira21.calculadora

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

        var valor: Double = 0.0

        binding.bt0.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "0"}
        binding.bt1.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "1"}
        binding.bt2.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "2"}
        binding.bt3.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "3"}
        binding.bt4.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "4"}
        binding.bt5.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "5"}
        binding.bt6.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "6"}
        binding.bt7.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "7"}
        binding.bt8.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "8"}
        binding.bt9.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "9"}

        binding.btSoma.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "+"}
        binding.btVirgula.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "."}
        binding.btDivisao.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "/"}
        binding.btSubtracao.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "-"}
        binding.btMultiplicacao.setOnClickListener {binding.textViewResultado.text = "${binding.textViewResultado.text}" + "*"}

        binding.btDelAll.setOnClickListener { binding.textViewResultado.setText("") }

        binding.btDelLast.setOnClickListener {
            if (binding.textViewResultado.text.isEmpty())
                Toast.makeText(this,"Campo Vazio",Toast.LENGTH_SHORT).show()
            else
                binding.textViewResultado.setText(funDelLastElement(binding.textViewResultado.text))
        }

        binding.btCalcular.setOnClickListener {funCalcularResultado(binding.textViewResultado.text)}
        }

    private fun funDelLastElement(textViewResultado: CharSequence):CharSequence {
        var charCaracteres:String = ""
        for(i in 0..textViewResultado.length-1){
            charCaracteres += textViewResultado[i]
            //Toast.makeText(this,"${textViewResultado[i]}",Toast.LENGTH_SHORT).show()
            if(i == textViewResultado.length-2)
                return charCaracteres
        }
        return ""
    }

    private fun funCalcularResultado(text: CharSequence?) {

        Toast.makeText(this, "${text!![0]}", Toast.LENGTH_SHORT).show()
    }


}


