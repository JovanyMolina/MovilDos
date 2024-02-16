package com.example.proyectosice.ui.login.ui

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(viewmodel: LoginViewModel){
    Box (

        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Login(Modifier.align(Alignment.Center),viewmodel)
    }
}

@Composable
fun Login(modifier: Modifier,viewModel: LoginViewModel) {
    //val LoginEnable:Boolean by viewModel.loginEnable.observeAsState(initial = false)


    val Matricula : String by viewModel.matricula.observeAsState(initial = "")
    val Contrasena : String by viewModel.contrasena.observeAsState(initial = "")

    Column(modifier = modifier){
        Spacer(modifier=Modifier.padding(2.dp))
        Matricula(Matricula){viewModel.onLoginChanged(it,Contrasena)}
        Spacer(modifier=Modifier.padding(7.dp))
        Contrasena(Contrasena){viewModel.onLoginChanged(Matricula,it)}
        Spacer(modifier=Modifier.padding(7.dp))
       LoginButton()
       //LoginButton(LongiEnable){viewModel.onLoginSelected()}
    }
}

@Composable
fun LoginButton(/*LoginEnable: Boolean, onLoginSelected : () -> Unit*/) {
    Button(
        onClick = {/*onLoginSelected()*/},
        modifier= Modifier
        .fillMaxWidth()
        .height(48.dp),
        colors= ButtonDefaults.buttonColors(
        )//, enabled = LoginEnable
    ) {
        Text(text = "Iniciar")
    }

}

@Composable
fun Contrasena(Contrasena: String,onTexFieldChanged: (String) -> Unit) {
    TextField(value = Contrasena, onValueChange ={onTexFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Text),
        singleLine = true,
        maxLines = 1
        )

}

@Composable
fun Matricula(Matricula: String,onTexFieldChanged: (String) -> Unit) {

    TextField(value = Matricula, onValueChange ={onTexFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Matricula")},
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Text),
        singleLine = true,
        maxLines = 1
    )

}
