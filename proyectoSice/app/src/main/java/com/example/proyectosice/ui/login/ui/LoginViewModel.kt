package com.example.proyectosice.ui.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    private val _matricula = MutableLiveData<String>()
    val matricula : LiveData<String> = _matricula

    private val _contrasena = MutableLiveData<String>()
    val contrasena : LiveData<String> = _contrasena


    private val _loginEnable = MutableLiveData<String>()
    val loginEnable : LiveData<String> = _loginEnable



    fun onLoginChanged(matricula: String , contrasena: String){
        _matricula.value= matricula
        _contrasena.value = contrasena
  //      _loginEnable.value = isValidMatricula(matricula) && isContrasena(contrasena)

    }

    fun onLoginSelected() {

    }
    /*
        private fun isValidMatricula(matricula: String): Boolean = Patterns.EMAIL_ADDRESS {

        }
    */

}