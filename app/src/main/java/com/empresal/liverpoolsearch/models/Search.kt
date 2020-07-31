package com.empresal.liverpoolsearch.models

data class Search(
    var criterioBusqueda: String,
    var paginaConsultada:Int,
    var items:Int
)