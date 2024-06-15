package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repositorio.CategoriasRepositorio
import br.senai.sp.jandira.mytrips.repositorio.ViagensRepositorio
import br.senai.sp.jandira.mytrips.utilitarios.encurtadorDeDatas

@Composable
fun Home(controleNavegacao: NavHostController) {

    val categorias = CategoriasRepositorio().ListarTodasAsCategorias()
    val viagens = ViagensRepositorio().ListarTodasAsViagens()

    var buscarDestinoState = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffF6F6F6)),
    ){

        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(216.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.backgroundheader),
                contentDescription = "",
                contentScale = ContentScale.Crop

            )


            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    horizontalAlignment = Alignment.End
                ){
                    Surface(modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                        shape = RoundedCornerShape(50.dp)

                    )
                    {
                        Image(painter = painterResource(id = R.drawable.fotoperfil), contentDescription = "Foto de perfil")

                    }
                    Text(text = "Julia Paiva",
                        color = Color.White,)
                }

                Column (modifier = Modifier
                ){
                    Row (modifier = Modifier .offset(x = -6.dp,y = 10.dp), verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.height(16.dp)
                        )
                        Row {
                            Text(text = stringResource(id = R.string.home_subTitle),
                                color = Color.White,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Row {
                                Text(text = "Paris",
                                    color = Color.White,
                                    fontSize = 18.sp)
                            }
                        }
                    }
                    Text(text = "My trips",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Row (modifier = Modifier
            .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.home_categories),
                color = Color(0xFF868181),
                fontSize = 16.sp)
        }
        LazyRow(modifier = Modifier
            .padding(start = 16.dp)

        ){
            items(categorias){
                Card (modifier = Modifier
                    .width(142.dp)
                    .height(64.dp)
                    .padding(end = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFCF06F0)),){
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                                Surface (modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .background(
                                        color = Color(
                                            0x00CF06F0
                                        )
                                    ),
                                    shape = RoundedCornerShape(50.dp)){
                                    Image(painter = if (it.iconImage == null) painterResource(id = R.drawable.noiconimage)else it.iconImage!!, contentDescription = "", contentScale = ContentScale.Crop)
                                }

                            Text(text = it.descricao,
                                color = Color.White
                            )
                    }
                }
            }
        }

        Column (modifier = Modifier.padding(16.dp)){

            OutlinedTextField(
                value = buscarDestinoState.value,
                onValueChange = {
                    buscarDestinoState.value = it
                },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.home_input),
                        color = Color(0xFFADAAAA)
                    )
                },
                shape = RoundedCornerShape(22.dp),
//              colors = TextFieldDefaults.colors(Color.White),

                colors =
                OutlinedTextFieldDefaults
                    .colors(
                        focusedContainerColor = Color(0xFFFFFFFF),
                        focusedBorderColor = Color(0xFFFFFFFF),
                        unfocusedBorderColor = Color(0xffFFFFFF),
                        unfocusedContainerColor = Color(0xffFFFFFF),
                    ),


                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search your destiny",
                            tint = Color(0xFFADAAAA)
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.home_pastTrips),
                color = Color(0xFF868181),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyColumn(){

                items(viagens){
                    Card (
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )

                    ){
                        Column (modifier = Modifier
                            .padding(12.dp)){

                            Surface(modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                                shape = RoundedCornerShape(6.dp)
                            )
                            {
                                Image(painter = if (it.imagem == null) painterResource(id = R.drawable.noimage)else it.imagem!!, contentDescription = "", contentScale = ContentScale.Crop)
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = "${it.destino}, ${it.dataChegada.year}",
                                color = Color(0xFFCF06F0),
                                fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = it.descricao,
                                color = Color(0xFF7A7A7A),
                                fontSize = 11.sp,
                                lineHeight = 15.sp)

                            Row (horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth()){
                                Text(text = encurtadorDeDatas(it.dataChegada, it.dataPartida),
                                    color = Color(0xFFCF06F0),
                                    fontSize = 14.sp)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
   Home(controleNavegacao = rememberNavController())
}