package com.example.applicationnotification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/*Esse Service será responsável por funcionar em background enquanto nosso App não esteja funcionando
* e recebê-lo mesmo assim.*/


class MyFirebaseMessagingService : FirebaseMessagingService() {
    val tag = "FirebaseMessagingServ"
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(tag, remoteMessage.from.toString())

        if(remoteMessage != null){
            this.showNotification("1234",
            remoteMessage.notification?.title.toString(),
            remoteMessage.notification?.body.toString())
        }
    }


}