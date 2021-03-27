package com.example.applicationnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.graphics.Color
import android.icu.text.CaseMap
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat


/*Context.showNotification == Método para disparar a Notification
* notificationManager é responsável por gerenciar todas as notificações que sairão pelo App.
* Temos um serviço responsável para isso e a partir dele nós conseguimos instanciar a variável aqui.
* Que é o getSystemService.
* A variável intent será reponsável pelo evento click da ação, toda vez qu tiver uma notificação, o nosso
* App vai parar a Main Activity.
* A variável pendingIntent vai pegar a nossa variável intent criada e passar para notificação.
* requestCode - caso estivesse usando um activity result
* Flag_update_current - toda vez que lançar essa notificação ela poderá entrar na nossa Main Activity
* o If verifica a versão do Android.
* Android Channel é responsável por manipular o objeto da notificação, ou seja, possui os seguintes atributos abaixo.
* Tag IMPORTANCE_HIGH - toda vez que tiver uma notificação ela aparecerá na tela, mostrando ao usuário que chegou
* uma mensagem.
* No notificationManager vamos informar que foi criado uma notificationChannel
* variável builder vai ser responsável pelo disparo da notificação
* */


lateinit var notificationChannel : NotificationChannel
lateinit var notificationManager: NotificationManager
lateinit var builder : NotificationCompat.Builder

fun Context.showNotification(channelId: String, title: String, body:String){
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this,MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        notificationChannel = NotificationChannel(channelId,body,NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.BLUE
            enableVibration(true)
        }
        notificationManager.createNotificationChannel(notificationChannel)
        builder = NotificationCompat.Builder(this,channelId).apply {
            setSmallIcon(R.drawable.ic_refresh)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    }
    notificationManager.notify(channelId.toInt(), builder.build())
}
