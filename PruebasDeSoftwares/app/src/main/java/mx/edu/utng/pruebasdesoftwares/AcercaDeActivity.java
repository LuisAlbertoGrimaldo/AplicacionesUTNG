package mx.edu.utng.pruebasdesoftwares;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Luis Albero Grimaldo on 16/02/2016.
 */
public class AcercaDeActivity extends Activity implements View.OnClickListener {
    private Button btnRegresarAcercaDe;
    private MediaPlayer mp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de_layout);
        mp = MediaPlayer.create(this, R.raw.clic);
        initComponents();
    }


    private void initComponents(){
        btnRegresarAcercaDe=(Button)findViewById(R.id.btn_regresar_acerca);
        btnRegresarAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.btn_regresar_acerca){
                    mp.start();
                    startActivity(new Intent(AcercaDeActivity.this,MainActivity.class));
                    finish();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

