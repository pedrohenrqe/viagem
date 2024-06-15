package br.senai.sp.jandira.mytrips.model

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.painter.Painter

data class Categorias(

    var id: Int = 0,
    var descricao: String = "",
    var iconImage: Painter? = null

)