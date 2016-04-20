package mx.edu.utng.structs_final.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import mx.edu.utng.structs_final.R;

public class SeleccionActivity extends AppCompatActivity {

    private ImageView imvStruts;
    private TextView txvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        initComponents();
    }
    private void initComponents(){
        imvStruts = (ImageView)findViewById(R.id.imv_temas);
        txvDescripcion = (TextView)findViewById(R.id.txv_descripcion);
        Bundle valoresRecibidos = getIntent().getExtras();
        switch (valoresRecibidos.getInt(getString(R.string.posisicion))){

            case 0:
                imvStruts.setImageResource(R.drawable.configg);
                break;
            case 1:
                imvStruts.setImageResource(R.drawable.ognl);
                break;
            case 2:
                imvStruts.setImageResource(R.drawable.formularios);
                break;
            case 3:
                imvStruts.setImageResource(R.drawable.structs);
                break;
            case 4:
                imvStruts.setImageResource(R.drawable.difeere);
                break;
            case 5:
                imvStruts.setImageResource(R.drawable.formularios);
                break;

        }
        txvDescripcion.setText(
                getString(R.string.name_1)
                        +valoresRecibidos.getString(getString(R.string.chose))+"\n\n"+
                        getString(R.string.description)+
                        valoresRecibidos.getString(getString(R.string.descrption_1))
        );

        txvDescripcion.setTextSize(20.0f);

    }
}
