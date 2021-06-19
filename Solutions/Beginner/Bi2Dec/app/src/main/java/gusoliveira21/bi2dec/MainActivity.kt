package gusoliveira21.bi2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val campoDeEntradaBinaria: EditText = findViewById(R.id.editNumber)
        val buttonConvertToDecimal: Button = findViewById(R.id.buttonConvertToDecimal)

        buttonConvertToDecimal.setOnClickListener { View ->
            try {

                if (campoDeEntradaBinaria.text.isEmpty())
                    Toast.makeText(this, "Não deixe o campo em branco!", Toast.LENGTH_SHORT).show()
                if (funVerificarDigitos(campoDeEntradaBinaria.text))
                    Toast.makeText(this, "Digite somente 0's e 1's.", Toast.LENGTH_SHORT).show()
                else
                    funCountCaracters(campoDeEntradaBinaria.text)
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun funVerificarDigitos(campoBinario: Editable): Boolean {
        for (i in 0..campoBinario.length - 1) {
            if (campoBinario[i].digitToInt() == 2 ||
                campoBinario[i].digitToInt() == 3 ||
                campoBinario[i].digitToInt() == 4 ||
                campoBinario[i].digitToInt() == 5 ||
                campoBinario[i].digitToInt() == 6 ||
                campoBinario[i].digitToInt() == 7 ||
                campoBinario[i].digitToInt() == 8 ||
                campoBinario[i].digitToInt() == 9) {
                return true
            }
        }
        return false
    }

    private fun funCountCaracters(campoBinario: Editable) {
        var valorResultado: Double = 0.0
        var DoMaiorParaMenor: Int = campoBinario.length

        for (DoMenorParaMaior in 0..(campoBinario.length - 1)) {
            DoMaiorParaMenor = DoMaiorParaMenor - 1

            valorResultado += campoBinario[DoMenorParaMaior].digitToInt() * Math.pow(
                2.0,
                DoMaiorParaMenor.toDouble()
            )
        }

        Toast.makeText(this, valorResultado.toInt().toString(), Toast.LENGTH_LONG).show()

    }


}