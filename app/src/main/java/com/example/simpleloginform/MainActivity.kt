package com.example.simpleloginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var textEmail:TextInputEditText
    lateinit var textPassword:TextInputEditText
    lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textEmail = findViewById(R.id.emailId)
        textPassword = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.loginButton)

        buttonLogin.setOnClickListener {

            LoginFunc()
        }
    }
    private fun LoginFunc(){
        val strEmail = textEmail.text.toString().trim()
        val strPassword = textPassword.text.toString().trim()

        if (TextUtils.isEmpty(strEmail) || TextUtils.isEmpty(strPassword))
        {
            textEmail.error ="Can't be empty"
            textPassword.error ="Can't be Empty"
        }else if (!EmailValidationFunc(strEmail))
        {
            textEmail.error = "Not Valid Email Address..."
        }
        else{
            Toast.makeText(applicationContext,"Login Successful...",Toast.LENGTH_LONG).show()
        }
    }
    private fun EmailValidationFunc(strEmail:String):Boolean{

        val EMAIL_PATTERN = "^[A-Za-z0-9-]+(\\.[_A-za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z]{2,})$"
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val match:Matcher = pattern.matcher(strEmail)
        return match.matches()
    }
}