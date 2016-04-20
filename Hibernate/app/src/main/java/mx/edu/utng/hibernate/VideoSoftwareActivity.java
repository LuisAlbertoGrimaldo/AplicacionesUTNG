package mx.edu.utng.hibernate;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by erika on 15/02/2016.
 */
public class VideoSoftwareActivity extends Activity {

    private VideoView videoSoftware;
    private Button btnReferencia;
    private MediaPlayer mp;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_pruebas_software_layout);
        videoSoftware =(VideoView)findViewById(R.id.video_software);

        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=3CPJN8gj_f0")));


        videoSoftware.setMediaController(new MediaController(this));
        videoSoftware.requestFocus();
        mp = MediaPlayer.create ( this, R.raw.clic );
        initComponets();

    }
    private void initComponets(){
        btnReferencia=(Button)findViewById(R.id.btn_referencia_temas);
        btnReferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_referencia_temas) {
                    mp.start();
                    startActivity(new Intent(VideoSoftwareActivity.this, ListViewActivity.class));
                }
            }
        });
    }

}
