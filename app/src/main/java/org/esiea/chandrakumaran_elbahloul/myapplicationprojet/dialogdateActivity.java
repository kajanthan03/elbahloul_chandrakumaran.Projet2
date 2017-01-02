package org.esiea.chandrakumaran_elbahloul.myapplicationprojet;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class dialogdateActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogdate);

        final Calendar date= Calendar.getInstance();

        final TextView dateTexte=(TextView)findViewById(R.id.dateTexte);
        DatePickerDialog.OnDateSetListener listenerDate=new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int annee, int mois, int jour) {
                date.set(Calendar.YEAR, annee);
                date.set(Calendar.MONTH, mois);
                date.set(Calendar.DAY_OF_MONTH, jour);
                // On affiche la nouvelle date dans le texteview
                dateTexte.setText(jour+"/"+mois+"/"+annee);
            }
        };


        DatePickerDialog datePicker=new DatePickerDialog(this, listenerDate,
                // Et on va définir la date initiale !
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));

// Affichage de la dialogue
        datePicker.show();

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

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
