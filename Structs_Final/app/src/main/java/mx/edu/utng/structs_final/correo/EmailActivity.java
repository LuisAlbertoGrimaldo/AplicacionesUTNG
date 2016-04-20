package mx.edu.utng.structs_final.correo;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mx.edu.utng.structs_final.R;
import mx.edu.utng.structs_final.dbhelper.DBHelperCuestionario;
import mx.edu.utng.structs_final.dbhelper.DatabaseHelper;
import mx.edu.utng.structs_final.grafica.PieGraph;


/**
 * Created by Erika Cabrera on 17/04/2016.
 */
public class EmailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);
    }

    public void onClick(View v) {

        DatabaseHelper login= new DatabaseHelper(this);
        String email=login.traerEmail();



        // Reemplazamos el email por algun otro real
        String[] to = { email, email };
        String[] cc = { email };

        DBHelperCuestionario helper= new DBHelperCuestionario(this);
        int po=helper.porsentajeCuerso();
        int res= helper.traerResult(1);
        int resII= helper.traerResult(2);
        int resIII= helper.traerResult(3);
        int resIV= helper.traerResult(4);
        int resV= helper.traerResult(5);
        int resVI= helper.traerResult(6);

        enviar(to, cc, "Resultados de Struts",
                "Esto es un email enviado desde una aplicación de struts.\n\n" +
                        "Calificaión Quiz I: "+ res +
                        "\nCalificación Quiz II: "+ resII+
                        "\nCalificación Quiz III: "+ resIII+
                        "\nCalificación Quiz IV: "+ resIV+
                        "\nCalificación Quiz V: "+ resV+
                        "\nCalificación Quiz VI: "+ resVI
                        + "\nAcreditaste el curso: " + po + "0%."


        );
    }

    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        // String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }



}