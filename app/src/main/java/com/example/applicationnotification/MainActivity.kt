package com.example.applicationnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    /*Esse tipo de notificação é a local notification, usado quando uma aplicação terminou de carregar, etc*/

    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.button_send_notification)
        btnSend.setOnClickListener{
            this.showNotification("1234","bootcamp Android","Kotlin Android Curso")
        }
        //fazendo disparos manuais pelo Firebase
        Log.i("***newToken***",FirebaseInstanceId.getInstance().token.toString())
    }
}