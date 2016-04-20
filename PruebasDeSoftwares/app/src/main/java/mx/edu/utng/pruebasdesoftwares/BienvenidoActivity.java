package mx.edu.utng.pruebasdesoftwares;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Luis Albero Grimaldo  on 06/02/2016.
 */
public class BienvenidoActivity extends Activity implements View.OnClickListener {
    private Button btnMenu;
    private MediaPlayer mp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenido_layout);
        mp = MediaPlayer.create(this, R.raw.clic);
        initComponets();
    }
    private void initComponets(){
        btnMenu=(Button)findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.btn_menu){
                    mp.start();
                    startActivity(new Intent(BienvenidoActivity.this,MainActivity.class));
                    finish();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
