package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.fragment;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetBiersServices extends IntentService {

    private static final String ACTION_get_all_biers = "org.esiea.chandrakumaran_elbahloul.myapplicationprojet.action.FOO";
    private static final String TAG = "org.esiea.chandrakumaran_elbahloul.myapplicationprojet.TAG";

    public GetBiersServices() {
        super("GetBiersServices");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    //  public static void startActionFoo(Context context, String param1, String param2) {
    //    Intent intent = new Intent(context, MyIntentService.class);
    //   intent.setAction(ACTION_FOO);
    //  intent.putExtra(EXTRA_PARAM1, param1);
    // intent.putExtra(EXTRA_PARAM2, param2);
    //context.startService(intent);
    //}

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("Mon_Tag", "i");
        URL url = null;
        try {
            url = new URL("http://binouze.fabrigli.fr/bieres.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "bieres.json"));

                Log.d("TAG", "Bieres json downloaded !");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast( new Intent(Main5Activity.BIERS_UPDATE));

    }

   // Log.i("Mon_Tag","i");
    private void copyInputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                String category = finalobj.getString(Integer.parseInt("category_id"));
                int country = finalobj.getInt(Integer.parseInt("country_id"));
                int created = finalobj.getInt(Integer.parseInt("created_at"));
                String Description = finalobj.getString(Integer.parseInt("description"));

                String names = finalobj.getString(Integer.parseInt("name"));
                String notes = finalobj.getString(Integer.parseInt("note"));

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



