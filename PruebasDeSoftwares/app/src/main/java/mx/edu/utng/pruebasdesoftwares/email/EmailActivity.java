package mx.edu.utng.pruebasdesoftwares.email;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mx.edu.utng.pruebasdesoftwares.R;
import mx.edu.utng.pruebasdesoftwares.dbhelper.DBHelperCuestionario;
import mx.edu.utng.pruebasdesoftwares.dbhelper.DatabaseHelperLogin;
import mx.edu.utng.pruebasdesoftwares.grafica.PieGraph;


/**
 * Created by griselda on 17/04/2016.
 */
public class EmailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);


        DatabaseHelperLogin login= new DatabaseHelperLogin(this);
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

        enviar(to, cc, "Resultados de Prueba de Software",
                "Esto es un email enviado desde una app de Pruebas de Software.\n\n" +
                        "Calif Quiz I: "+ res +
                        "\nCalif Quiz II: "+ resII+
                        "\nCalif Quiz III: "+ resIII+
                        "\nCalif Quiz IV: "+ resIV+
                        "\nCalif Quiz V: "+ resV+
                        "\nCalif Quiz VI: "+ resVI
                        + "\nAcreditaste el curso: " + po + "0%."
        );
        finish();
    }

   /* public void onClick(View v) {

        DatabaseHelperLogin login= new DatabaseHelperLogin(this);
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

        enviar(to, cc, "Resultados de Prueba de Software",
                "Esto es un email enviado desde una app de Pruebas de Software.\n\n" +
                 "Calif Quiz I: "+ res +
                "\nCalif Quiz II: "+ resII+
                "\nCalif Quiz III: "+ resIII+
                "\nCalif Quiz IV: "+ resIV+
                "\nCalif Quiz V: "+ resV+
                "\nCalif Quiz VI: "+ resVI
                        + "\nAcreditaste el curso: " + po + "0%."
        );
        }
*/
    private void enviar(String[] to, String[] cc, String asunto, String mensaje) {
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