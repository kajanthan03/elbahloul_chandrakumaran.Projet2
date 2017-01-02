package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

       // IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
       // LocalBroadcastManager.getInstance(this).registerReceiver(new Main5Activity.BierUpdate(),intentFilter);

        final TextView tex = (TextView) findViewById(R.id.textView);
        final Button TEL = (Button) findViewById(R.id.buttonJSON);
        TEL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Main5Activity.this, GetBiersServices.class);
                startService(intent1);

                return;
            }


        });

        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(),intentFilter);
    }

    public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";
    public class BierUpdate extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
           // Log.d("TAG", BIERS_UPDATE);
            Log.d("TAG", "gg");



        }
        public String getBiersFromFile(){
            try{
                InputStream is = new FileInputStream(getCacheDir()+"/"+"biers.json");
                byte[]buffer= new byte[is.available()];
                is.read(buffer);
                is.close();


                String finalJson = buffer.toString();

                JSONObject obj = new JSONObject(finalJson);
                JSONArray array = obj.getJSONArray("biers");

                StringBuffer finalBufferedData = new StringBuffer();

                for (int i = 0; i < array.length(); i++) {

                    JSONArray finalobj = array.getJSONArray(i);

                    int idd = finalobj.getInt(Integer.parseInt("id"));
                   // String category = finalobj.getString(Integer.parseInt("category_id"));
                   // int country = finalobj.getInt(Integer.parseInt("country_id"));
                    int created = finalobj.getInt(Integer.parseInt("created_at"));
                    String Description = finalobj.getString(Integer.parseInt("description"));

                    String names = finalobj.getString(Integer.parseInt("name"));
                    //String notes = finalobj.getString(Integer.parseInt("note"));

                    finalBufferedData.append(idd+":"+names+" "+"'"+Description+"'"+created);

                }
                return finalBufferedData.toString();
                //return new JSONArray(new String(buffer,"UTF-8"));
            }catch (IOException e){
                e.printStackTrace();
                return new String();
            } catch (JSONException e) {
                e.printStackTrace();
            }return String.valueOf(new JSONArray());
        }


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
                Intent intent1 = new Intent(Main5Activity.this, Main6Activitydaate.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
