package com.example.applicationnotification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/*método responsável por sempre gerar um token novo para nossa requisição do Firebase*/

class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {
    override fun onTokenRefresh(){
        Log.i("**newTokenService", FirebaseInstanceId.getInstance().token.toString())
    }
}