package mx.edu.utng.hibernate;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import mx.edu.utng.hibernate.R;

/**
 * Created by erika on 24/03/2016.
 */
public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_layout);
        registrarEventos();
    }

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.miLista);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> aprent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=3CPJN8gj_f0")));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=d8VoofXO-QA")));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=fmTbTgW19D0")));
                    break;
                    case 3 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=5c0CJV4wSNg&list=PL8R29l8KkRsjQDEjRm6laLT2oa8YtalUx&index=2")));
                        break;
                    case 4 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=Yv2xctJxE-w&list=PL4AFF701184976B25")));
                        break;
                    case 5 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=bzPkebUXxn0&list=PL4AFF701184976B25&index=2")));
                        break;

                    default:
                }

            }
        });

    }



}
