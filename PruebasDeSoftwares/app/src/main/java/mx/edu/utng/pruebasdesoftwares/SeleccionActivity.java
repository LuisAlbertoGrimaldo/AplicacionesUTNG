package mx.edu.utng.pruebasdesoftwares;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Luis Albero Grimaldo  on 06/02/2016.
 */
public class SeleccionActivity extends AppCompatActivity {

    private ImageView imvTema;
    private TextView txvDescripcion;
    private MediaPlayer mp;//poner sonido al boton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_layout);
        mp = MediaPlayer.create(this, R.raw.clic);
        initComponents();
    }
    private void initComponents(){
        imvTema = (ImageView)findViewById(R.id.imv_tema);
        txvDescripcion = (TextView)findViewById(R.id.txv_descripcion);

        Bundle valoresRecibidosTemas = getIntent().getExtras();
        valoresRecibidosTemas.getString("elegido");
          // String valoruno =




        Bundle valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicion")){

            case 0:
                mp.start();
                imvTema.setImageResource(R.drawable.img_caja_blanca);
                break;
            case 1:

                mp.start();
                imvTema.setImageResource(R.drawable.pruebasaceptacion);

                break;
            case 2:
                mp.start();
                imvTema.setImageResource(R.drawable.pruebasregrecion);
                break;
            case 3:
                mp.start();
                imvTema.setImageResource(R.drawable.pruebasfuncionales);
                break;
            case 4:
                mp.start();
                imvTema.setImageResource(R.drawable.pruebasintegracion);
                break;
            case 5:
                mp.start();
                imvTema.setImageResource(R.drawable.pruebascalidad);
                break;

        }

        txvDescripcion.setText(
                "Tipo: "
                        +valoresRecibidos.getString("elegido")+"\n\n"+
                        "Introducción: \n"+
                        valoresRecibidos.getString("descripcion")
        );

      //  txvDescripcion.setTextColor(R.color.colorBlanco);
        txvDescripcion.setTextSize(20.0f);

    }
}
