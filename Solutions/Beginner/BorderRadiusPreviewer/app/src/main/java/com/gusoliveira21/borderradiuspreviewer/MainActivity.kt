package com.gusoliveira21.borderradiuspreviewer

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private val webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TextView: TextView = findViewById(R.id.textView_exemplo)
        val webView = findViewById<WebView>(R.id.web_view)

        title = "KotlinApp"

        webView.webViewClient = WebViewClient()
        webView.loadUrl("file:///android_asset/web_form.html")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val fileName = "test.txt"
        val fileBody = "teste"


        /**
         * openFileOutput() é usado para especificar o nome do arquivo
         * modos de operação:
         * >Context.MODE_APPEND = 32768
         * >Context.MODE_WORLD_READABLE = 1
         * >Context.MODE_WORLD_WRITEABLE = 2
         *
         * >MODE_PRIVATE: é o modo de operação padrão, o que significa que o arquivo é um dado
         * privado e só pode ser acessado pelo próprio aplicativo. Neste modo, o conteúdo escrito
         * sobrescreverá o conteúdo do arquivo original, se você quiser anexar o conteúdo
         * recém-escrito ao original no arquivo. Pode usar Context.MODE_APPEND
         *
         * >Context.MODE_APPEND: O modo verifica se o arquivo existe. Se existir, ele anexa o conteúdo
         * ao arquivo, caso contrário, ele cria um novo arquivo.
         *
         * >Context.MODE_WORLD_READABLE e Context.MODE_WORLD_WRITEABLE são usados para
         * controlar se outros aplicativos têm permissão para ler e gravar o arquivo.
         *
         * >MODE_WORLD_READABLE: indica que o arquivo atual pode ser lido por outros aplicativos;
         *
         * >MODE_WORLD_WRITEABLE: indica que o arquivo atual pode ser escrito por outros aplicativos.
         *
         * Se você quiser que o arquivo seja lido e escrito por outros aplicativos, pode passar:
        openFileOutput (“itcast.txt”, Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        https://en.proft.me/2019/10/14/reading-and-writing-files-android-using-kotlin/

        https://www.programmersought.com/article/5626394340/
         * **/
        openFileOutput("fileName.txt", MODE_PRIVATE).use { output ->
            output.write(fileBody.toByteArray())
        }



        openFileInput(fileName).use { stream ->
            val text = stream.bufferedReader().use {
                it.readText()
            }
            Log.d("TAG", "LOADED: $ text")
        }

    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }


}

