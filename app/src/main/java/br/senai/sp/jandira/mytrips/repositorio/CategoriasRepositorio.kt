package br.senai.sp.jandira.mytrips.repositorio

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categorias

class CategoriasRepositorio {
    @Composable
    fun ListarTodasAsCategorias(): List <Categorias>{
        val Montain = Categorias(
            id = 1,
            descricao = stringResource(id = R.string.category1),
            iconImage = painterResource(id = R.drawable.beach)
        )

        val Snow = Categorias(
            id = 2,
            descricao = stringResource(id = R.string.category2)
        )

        val Beach = Categorias(
            id = 3,
            descricao = stringResource(id = R.string.category3),
            iconImage = painterResource(id = R.drawable.beach)
        )

        return listOf(Montain, Snow, Beach)

    }
}
