package mx.edu.utng.pruebasdesoftwares.grafica;

/**
 * Created by griselda on 05/04/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import mx.edu.utng.pruebasdesoftwares.R;

public class GraphAChartEngineActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_layout);

        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);
        finish();
    }



   /* public void pieGraphHandler (View view)
    {
        PieGraph pie = new PieGraph();
        Intent lineIntent = pie.getIntent(this);
        startActivity(lineIntent);

    }*/



}