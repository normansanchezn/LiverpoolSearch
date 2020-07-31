package com.empresal.liverpoolsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btnSearch.setOnClickListener{
            // TODO: Autocomplete del editText
            // Cuando el usuario presione buscar, se tiene que guardar en la lista para poder anexarse
            // a los sugeridos de busqueda


            // TODO: Con courutines manejar la llamada al servicio
            // La llamada al servicio


        }
    }
}