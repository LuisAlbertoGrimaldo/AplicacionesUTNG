package mx.edu.utng.structs_final.model;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.structs_final.R;

/**
 * Created by Saul on 01/03/2016.
 */
public class ResultadoActivity extends Activity {
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
                t.setText(R.string.again);
                break;

            case 2: t.setText(R.string.reed);
                break;
            case 3:
            case 4:t.setText(R.string.regular);
                break;
            case 5:t.setText(R.string.goog);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_result_dos, menu);
        return true;
    }
}
