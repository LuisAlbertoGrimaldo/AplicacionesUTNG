package mx.edu.utng.structs_final.questions;

/**
 * Created by Luis Albero Grimaldo  on 25/02/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.structs_final.R;
import mx.edu.utng.structs_final.dbhelper.DBHelperCuestionario;
import mx.edu.utng.structs_final.model.Result;


public class ResultSeisActivity extends Activity {
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
        Intent intent = new Intent(this, QuestionSeisActivity.class);
        startActivity(intent);
    }

    public int calif(int score){
        switch (score){
            case 1:
                return 4;
            case 2:
                return 6;
            case 3:
                return 10;
            case 4:
                return 8;
            case 5:
                return 10;

            default:
                return 0;
        }

    }

    //agregado
    public void saveresult(View r) {
        Result re = new Result();
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
         int ca= calif(score);
        re.setResult(ca);


       // helper.insertResult(re);
        helper.actualizarQuiz(re,6);//id de la tabla resultado donde se guardara
        Toast resul = Toast.makeText(ResultSeisActivity.this, "Resultado Guardado " + ca, Toast.LENGTH_SHORT);
        resul.show();

    }
}
