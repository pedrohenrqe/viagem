package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun Login(controleDeNavegacao : NavHostController) {

    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var mensagemErroState = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
    ){

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.End
        ){
            Box(modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .background(
                    color = Color(0xFFCF06F0),
                    shape = RoundedCornerShape(
                        bottomStart = 16.dp
                    )
                )
            ){}
        }


        Column (modifier = Modifier
            .padding(22.dp)
        ){
            Text(
                text = stringResource(id = R.string.login_title),
                color = Color(0xffCF06F0),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = stringResource(id = R.string.login_subTitle),
                color = Color(0xFFA09C9C)
            )
        }

        // color = card defuls.card.color


        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ){

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_email))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = stringResource(id = R.string.input_email),
                        tint = Color(0xffCF06F0),
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xffCF06F0),
                        unfocusedBorderColor = Color(0xffCF06F0),
                    ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .width(327.dp),
                maxLines = 1
            )

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_password))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription = "Password",
                        tint = Color(0xffCF06F0),)
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xffCF06F0),
                        unfocusedBorderColor = Color(0xffCF06F0)
                    ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .width(327.dp),
                maxLines = 1
            )

            Text(text = mensagemErroState.value)


        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .padding(28.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ){
            Button(onClick = {

                                 if (emailState.value == "julia" && passwordState.value == "12345"){

                                     controleDeNavegacao.navigate("home")

                                 }else{
                                     mensagemErroState.value = "Usuario ou senha incorretos"
                                 }

                             },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color((0xffCF06F0)))
            ) {
                Row (
                    modifier = Modifier
                        .width(134.dp)
                        .height(48.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(text = stringResource(id = R.string.login_button_signIn),
                        fontSize = 26.sp)
                    Icon(imageVector = Icons.Default.ArrowForward,
                        contentDescription = "seta direita",
                        tint = Color(0xFFFFFFFF),
                    )
                }
            }
            Row {
                Text(text = stringResource(id = R.string.login_create_account),
                    color = Color(0xFFFA09C9C)
                )
                Text(text = stringResource(id = R.string.login_create_account_nav),
                    color = Color(0xFFCF06F0),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .clickable {
                            controleDeNavegacao.navigate("singin")
                        }
                )
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ){
            Box(modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .background(
                    color = Color(0xFFCF06F0),
                    shape = RoundedCornerShape(
                        topEnd = 16.dp
                    )
                )
            ){}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MyTripsTheme {
        Login(controleDeNavegacao = rememberNavController())
    }
}

