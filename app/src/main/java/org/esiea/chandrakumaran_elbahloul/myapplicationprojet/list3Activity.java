package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static org.esiea.chandrakumaran_elbahloul.myapplicationprojet.R.id.spinner;

public class list3Activity extends AppCompatActivity {


    //private final Button active = (Button) findViewById(R.id.button_valide);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        final Spinner spin = (Spinner) findViewById(R.id.spinner);
        String[] sens={"La vue", "L'odorat", "L'ouïe", "Le goût", "Le toucher"};
        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,sens);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapterR);

        final Button active = (Button) findViewById(R.id.button_valide);
        active.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(list3Activity.this, Main4Activity.class);
                startActivity(intent2);
                return;
            }

        });
    }
    static final String [] sens = {"La vue", "L'odorat", "L'ouïe", "Le goût", "Le toucher"};

    public void option() {
        View view = null;
        final Button active = (Button) findViewById(R.id.button_valide);
        if(active!= null){
            final Spinner spin = (Spinner) findViewById(spinner);
            if (spin != null) {
                switch (spin.getSelectedItemPosition()) {
                    case 0:
                        Snackbar.make(view, "Mauvaise réponse !!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 1:
                        Snackbar.make(view, "Mauvaise réponse !!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 2:
                        Snackbar.make(view, "Bonne réponse !", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 3:
                        Snackbar.make(view, "Mauvaise réponse !!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 4:
                        Snackbar.make(view, "Mauvaise réponse !!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    default:
                        break;
                }
                spin.setEnabled(false);
                active.setText("Désactivé");
                //Snackbar.make(view, "Sélection une réponse", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();

            } else {
                spin.setEnabled(true);
                active.setText("Activé");

            }
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
                Intent intent1 = new Intent(list3Activity.this, Main6Activitydaate.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
