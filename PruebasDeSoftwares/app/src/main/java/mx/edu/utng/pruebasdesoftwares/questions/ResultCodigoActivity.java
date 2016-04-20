package mx.edu.utng.pruebasdesoftwares.questions;

/**
 * Created by Luis Albero Grimaldo  on 25/02/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.pruebasdesoftwares.R;
import mx.edu.utng.pruebasdesoftwares.dbhelper.DBHelperCuestionario;
import mx.edu.utng.pruebasdesoftwares.model.Result;


public class ResultCodigoActivity extends Activity {
    DBHelperCuestionario helper = new DBHelperCuestionario(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz_uno_layout);
        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textResult.setText("Tu putuación del quiz es " + " " + score + ".");
    }
    public void playagain(View o) {
        Intent intent = new Intent(this, QuestionCodigoActivity.class);
        startActivity(intent);
    }


    public void saveresult(View r) {

    }

}
