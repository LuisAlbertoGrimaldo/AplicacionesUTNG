package mx.edu.utng.hibernate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by erika  on 06/02/2016.
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
        Bundle valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt("posicion")){
            case 0:
                mp.start();
                imvTema.setImageResource(R.drawable.tema);
                break;
            case 1:
                mp.start();
                imvTema.setImageResource(R.drawable.jpa);
                break;
            case 2:
                mp.start();
                imvTema.setImageResource(R.drawable.base);
                break;
            case 3:
                mp.start();
                imvTema.setImageResource(R.drawable.desarrollo);
                break;
            case 4:
                mp.start();
                imvTema.setImageResource(R.drawable.conexion);
                break;
            case 5:
                mp.start();
                imvTema.setImageResource(R.drawable.hiber);
                break;

        }
        txvDescripcion.setText(
                "Tipo: "
                        +valoresRecibidos.getString("elegido")+"\n\n"+
                        "Introduccion: \n"+
                        valoresRecibidos.getString("descripcion")
        );

      //  txvDescripcion.setTextColor(R.color.colorBlanco);
        txvDescripcion.setTextSize(20.0f);

    }
}
