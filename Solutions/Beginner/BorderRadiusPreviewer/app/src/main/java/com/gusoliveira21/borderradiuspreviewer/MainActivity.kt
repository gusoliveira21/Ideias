package com.gusoliveira21.borderradiuspreviewer

import android.gesture.GestureUtils
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    //lateinit var box: View

    //var image: Drawable = getResources().getDrawable(R.drawable.box)

    /**
     * Drawable image = context.getResources().getDrawable( R.drawable.ic_action );

     * int h = image.getIntrinsicHeight();
     * int w = image.getIntrinsicWidth();
     * image.setBounds( 0, 0, w, h );

     * button.setCompoundDrawables( image, null, null, null );
     *
     * setCompoundDrawables()
     * Drawable.setBounds()
     *
     **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btCima: Button = findViewById(R.id.bt_cima)
        var btBaixo: Button = findViewById(R.id.bt_baixo)
        var btDireita: Button = findViewById(R.id.bt_direita)
        var btEsquerda: Button = findViewById(R.id.bt_esquerda)
        var image: Drawable = getResources().getDrawable(R.drawable.box)
        btCima.setOnClickListener {


            //setCompoundDrawablesWithIntrinsicBounds()
            image.setBounds(
                20,80,20,80
            )


        }

    }


}


/*
*

-Caixa com a propriedade Border radius.

-O ucuário pode alterar os 4 valores de uma borda.

-Copiar o css resultante.


-O usuário pode alterar todos os 8 valores possíveis do raio da borda para criar uma forma complexa






var image: Drawable = context.getResources().getDrawable(R.drawable.ic_action)
Drawable image = context.getResources().getDrawable( R.drawable.ic_action );



Drawable image = context.getResources().getDrawable( R.drawable.ic_action );
int h = image.getIntrinsicHeight();
int w = image.getIntrinsicWidth();
image.setBounds( 0, 0, w, h );
button.setCompoundDrawables( image, null, null, null );


setCompoundDrawables()
Drawable.setBounds()





view.setCompoundDrawablesWithIntrinsicBounds(
    null,
    getResources().getDrawable(R.drawable.some_img),
    null,
    null
);
ordem dos argumentos: (esquerda, superior, direita, inferior)
* */