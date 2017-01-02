package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.esiea.chandrakumaran_elbahloul.myapplicationprojet.R.id.Qsuivante;


public class Main2Activity extends AppCompatActivity {


    private static Button button_aide;
    private static WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText fab1 = (EditText) findViewById(R.id.R1);


        fab1.setOnClickListener(new View.OnClickListener() {

               @Override
            public void onClick(View view) {

                String saisie = fab1.getText().toString();

                   if (saisie.contains("wendy"))
                   {
                       Snackbar.make(view, "Bonne réponse !", Snackbar.LENGTH_LONG)
                               .setAction("Action", null).show();

                   }
                   // sinon
                   else
                       Snackbar.make(view, "Mauvaise réponse !!", Snackbar.LENGTH_LONG)
                               .setAction("Action", null).show();

                   return;
                }

        });

        final Button fab2 = (Button) findViewById(R.id.Qsuivante);
        fab2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Main2Activity.this, list3Activity.class);
                startActivity(intent1);
                return;
            }

        });



        button_aide = (Button) findViewById(R.id.button_aide);
        webView = (WebView) findViewById(R.id.webView);

        button_aide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://disney-planet.fr/les-personnages-dans-peter-pan/";
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
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
                Intent intent1 = new Intent(Main2Activity.this, Main6Activitydaate.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
