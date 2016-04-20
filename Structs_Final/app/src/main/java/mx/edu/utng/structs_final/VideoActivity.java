package mx.edu.utng.structs_final;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Saul 01/04/2016
 */
public class



        VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_videos_youtube);
        registrarEventos();
    }

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.listaVideos);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> aprent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=iCUrBGxiUXc")));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=ZkcAlq-yQjY")));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=nBcxzeYh4BY")));
                        break;
                    case 3 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=lfuH2iCcW1g")));
                        break;
                    case 4 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=2FSzImOk-KU")));
                        break;
                    case 5 :
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=0snmJ-uROXU")));
                        break;
                    case  6:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=335nku6eifM")));
                        break;
                    default:
                }

            }
        });

    }



}
