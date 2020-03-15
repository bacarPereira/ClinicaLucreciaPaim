package com.example.clinicalucreciapain.comuns

import android.app.Activity
import android.content.Context
import android.util.Log
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast


fun Context.limparErroEditTxt(editexto: EditText){
    editexto.error = null
}

fun Context.validarEmail(email:String): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

fun Context.erroEditText(editexto: EditText,msg:String){
    editexto.requestFocus()
    editexto.error = msg
}

fun esconderTeclado(activity: Activity) {
    try {
        val view = activity.currentFocus
        if (view != null) {
            val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
    } catch (e: Exception) {
        Log.i("TECLADO", "esconder teclado " + e.message)
    }
}

fun Context.mostrarMensagem(mensagem: String){
    Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show()
}