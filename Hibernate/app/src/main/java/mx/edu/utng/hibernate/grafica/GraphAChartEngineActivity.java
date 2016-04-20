package mx.edu.utng.hibernate.grafica;

/**
 * Created by Erika Cabrera on 05/04/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.hibernate.R;
import mx.edu.utng.hibernate.Result;
import mx.edu.utng.hibernate.dbhelper.DBHelperCuestionario;
import mx.edu.utng.hibernate.dbhelper.DatabaseHelper;

public class GraphAChartEngineActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_layout);
    }

    public void lineGraphHandler(View view) {
        LineGraph line = new LineGraph();
        Intent lineIntent = line.getIntent(this);
        startActivity(lineIntent);
    }

    public void barGraphHandler(View view) {
        BarGraph bar = new BarGraph();
        Intent lineIntent = bar.getIntent(this);
        startActivity(lineIntent);
    }

    public void pieGraphHandler(View view) {
        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);

    }

    public void scatterGraphHandler(View view) {
        ScatterGraph scatter = new ScatterGraph();
        Intent lineIntent = scatter.getIntent(this);
        startActivity(lineIntent);
    }

    //Metodo de Correo Activity
    public void onClick(View v) {

        DatabaseHelper login = new DatabaseHelper(this);
        String email = login.traerEmail();

        // Reemplazamos el email por algun otro real
        String[] to = {email, email};
        String[] cc = {email};

        DBHelperCuestionario helper = new DBHelperCuestionario(this);
        int po = helper.porsentajeCuerso();
        int res = helper.traerResult(1);
        int resII = helper.traerResult(2);
        int resIII = helper.traerResult(3);
        int resIV = helper.traerResult(4);
        int resV = helper.traerResult(5);
        int resVI = helper.traerResult(6);

        enviar(to, cc, getString(R.string.result),
                getString(R.string.email) + getString(R.string.quiz_1) + res +
                        getString(R.string.quiz_2) + resII +
                        getString(R.string.quiz_3) + resIII +
                        getString(R.string.quiz_4) + resIV +
                        getString(R.string.quiz_5) + resV +
                        getString(R.string.quiz6) + resVI
                        + getString(R.string.curso) + po + getString(R.string.porcentaje)
        );
    }

    //para enviar correo
    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        // String[] to = direccionesEmail;
        //String[] cc = copias;

        //esto le quite para lol correo

        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, getString(R.string.email_1)));
    }


}
