package mx.edu.utng.structs_final.practicas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.structs_final.R;

/**
 * Created by Saul on 01/03/2016.
 */
public class ResultadoActivityPracticas extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 1:
                t.setText("Opps,intenta otra vez,Tienes que leer mas sobre Struts ");
                break;

            case 2: t.setText("Opps,intenta otra vez,Tienes que leer mas sobre Struts ");
                break;
            case 3:
            case 4:t.setText("Regular.    ");
                break;
            case 5:t.setText("Excelente vas muy bien");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result_dos, menu);
        return true;
    }
}
