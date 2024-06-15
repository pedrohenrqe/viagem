package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.R

@Composable
fun SignUp(controleNavegacao: NavHostController) {

    var usernameState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var checkState = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFCF06F0),
                        shape = RoundedCornerShape(
                            bottomStart = 16.dp
                        )
                    )
            ) {}
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.signUp_title),
                color = Color(0xffCF06F0),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(id = R.string.signUp_subTitle),
                color = Color(0xFFA09C9C)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
            ) {
                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.eclipse),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp),

                        )
                }

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "oi",
                    tint = Color(0xffCF06F0),
                    modifier = Modifier
                        .size(90.dp)
                        .offset(y = 0.dp, x = 5.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.vectorcam),
                    contentDescription = "Mudar foto de perfil",
                    modifier = Modifier
                        .size(28.dp)
                        .offset(y = 80.dp, x = 80.dp)
                )

            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {

            OutlinedTextField(
                value = usernameState.value,
                onValueChange = {
                    usernameState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_username))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Cadeado",
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
                value = phoneState.value,
                onValueChange = {
                    phoneState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_phone))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Email",
                        tint = Color(0xffCF06F0),
                    )
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

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_email))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xffCF06F0),
                    )
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

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.input_password))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email",
                        tint = Color(0xffCF06F0),
                    )
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

        }
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .padding(start = 37.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {


            Checkbox(
                checked = checkState.value,
                onCheckedChange = {
                    checkState.value = it
                },
                colors = CheckboxDefaults
                    .colors(
                        checkedColor = Color(0xffCF06F0),
                        uncheckedColor = Color(0xffCF06F0)
                    )
            )
            Text(text = stringResource(id = R.string.signUp_boolean_18))
        }

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color((0xffCF06F0)))
            ) {
                Row(
                    modifier = Modifier
                        .width(295.dp)
                        .height(48.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = stringResource(id = R.string.signUp_button_create_account),
                        fontSize = 22.sp
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(end = 32.dp),
            horizontalArrangement = Arrangement.End

        ) {
            Text(
                text = stringResource(id = R.string.signUp_have_account),
                color = Color(0xFFFA09C9C)
            )
            Text(
                text = stringResource(id = R.string.signUp_have_account_nav),
                color = Color(0xFFCF06F0),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .clickable {
                        controleNavegacao.navigate("login")
                    }
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .background(
                    color = Color(0xFFCF06F0),
                    shape = RoundedCornerShape(
                        topEnd = 16.dp
                    )
                )
        ) {}
    }
}


@Preview(showBackground = true)
@Composable
fun SingUPpreview() {
    SignUp(controleNavegacao =  rememberNavController())
}

