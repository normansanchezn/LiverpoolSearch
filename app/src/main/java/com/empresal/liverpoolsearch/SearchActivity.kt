package com.empresal.liverpoolsearch

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.empresal.liverpoolsearch.models.ItemSearchResult
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.item_list_products.view.*

class SearchActivity : AppCompatActivity() {

    private var mockListProducts: MutableList<ItemSearchResult> = mutableListOf()
    private lateinit var lisProdcuts: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btnSearch.setOnClickListener{
            // TODO: Autocomplete del editText
            // Cuando el usuario presione buscar, se tiene que guardar en la lista para poder anexarse
            // a los sugeridos de busqueda


            // TODO: Con courutines manejar la llamada al servicio
            // La llamada al servicio

            // Mock para ver la UI correcta antes de llamar al servicio

            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))
            mockListProducts.add(ItemSearchResult("imagen", "Computadora", "Anaquel 42", "$48562.25"))

            if (mockListProducts.size != 0){
                rvListProducts.visibility = View.VISIBLE
                tvHolderInformation.visibility = View.GONE
            } else {
                rvListProducts.visibility = View.GONE
                tvHolderInformation.visibility = View.VISIBLE
            }

            viewManager = LinearLayoutManager(this)
            viewAdapter = AnimalAdapter(mockListProducts, this)

            lisProdcuts = findViewById<RecyclerView>(R.id.rvListProducts).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = viewManager

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter

            }

        }
    }

    inner class AnimalAdapter(val listaProductos : MutableList<ItemSearchResult>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = listaProductos.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_products, parent, false))

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.nameProduct.text = listaProductos[position].nameProduct
            holder.locProduct.text = listaProductos[position].locProduct
            holder.priceProduct.text = listaProductos[position].priceProduct
        }
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val nameProduct: TextView = view.tvNameProduct!!
        val locProduct:TextView = view.tvProductLoc!!
        val priceProduct: TextView = view.tvPriceProduct!!
    }
}

