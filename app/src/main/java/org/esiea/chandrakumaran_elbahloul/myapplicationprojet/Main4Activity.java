package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.view.View.OnClickListener;


    public class Main4Activity extends AppCompatActivity {



        NotificationManager notificationManager;
        private final String reponse = "http://www.utc.fr/~aupetit/rep_general.shtml";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            Button buttonSend = (Button)findViewById(R.id.notification);
            buttonSend.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(reponse));
                    myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    PendingIntent pendingIntent = PendingIntent.getActivity(
                            Main4Activity.this,
                            0,
                            myIntent,
                            0);

                    Notification.Builder myNotification = new Notification.Builder(context);
                    myNotification.setContentTitle("Quizz - Réponses!");
                    myNotification.setContentText("Cliquez pour accéder aux réponses");
                    myNotification.setTicker("Notification!");
                    myNotification.setWhen(System.currentTimeMillis());
                    myNotification.setContentIntent(pendingIntent);
                    myNotification.setDefaults(Notification.DEFAULT_SOUND);
                    myNotification.setAutoCancel(true);
                    myNotification.setSmallIcon(R.drawable.ic_stat_name);
                    myNotification.build();
                            myNotification.setContentIntent(pendingIntent);
                    notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(0, myNotification.build());

                    Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                    startActivity(intent);
                    return;
                }
            });

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_search:
                    Uri uri = Uri.parse("http://www.google.fr");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    return true;
                case R.id.menu_date:
                    Intent intent1 = new Intent(Main4Activity.this, Main6Activitydaate.class);
                    startActivity(intent1);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

    }

