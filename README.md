# Application Notification

Exemplo de aplicação desenvolvida em Kotlin para Android de uma aplicação para notificações que utilizam  o NotificationChannel, NotificationManager e NotificationCompat.Builder trabalhando exemplificando um tipo de local notification.
Para testar as funcionalidades fizemos a integração com o Firebase.

Para isso é preciso realizar os seguintes passos:

------------

No Firebase (https://console.firebase.google.com/?hl=pt-br) clicar em "Adicionar Projeto"
Depois clicar em **Adicionar App** e clicar no icone do Android.
Em nome do pacote do Android informar o endereço informado no **Android Manifest**
Preencher todos os dados e finalizar
Após é preciso criar uma **Nova Notificação** no **Cloud Messaging**

Após rodar o aplicativo em algum emulator device ou em um dispositivo físico (para mais informações acesse a documentação oficial do Android em https://developer.android.com/studio/run/device?hl=pt-br)

Após a execução será gerado um token.
O mesmo deverá ser informado no Firebase.
Para isso ir em Cloud Messaging, ir na notificação criada anteriormente, clicar nas 3 bolinhas no lado direito e ir em **Duplicar Notificação**

Em **Visualização do dispositivo** clicar em **Enviar Mensagem de Teste ** e em **Adicione um token de registro do FCM** informar o token gerado no aplicativo e clicar em **Testar**
Após esses passos a notificação informada no Firebase aparecerá na tela do Android.





