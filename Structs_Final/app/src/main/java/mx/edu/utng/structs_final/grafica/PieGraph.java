package mx.edu.utng.structs_final.grafica;

/**
 * Created by Saul on 05/04/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import mx.edu.utng.structs_final.dbhelper.DBHelperCuestionario;

public class PieGraph {

  Context context;

    public int getResultadoI(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
       int quizI;
              quizI= helper.traerResult(1);
        return quizI;
    }
    public int getResultadoII(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
        int quizII =helper.traerResult(2);
        return quizII;
    }
    public int getResultadoIII(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
        int quizIII =helper.traerResult(3);
        return quizIII;
    }
    public int getResultadoIV(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
        int quizIV =helper.traerResult(4);
        return quizIV;
    }
    public int getResultadoV(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
        int quizV =helper.traerResult(5);
        return quizV;
    }
    public int getResultadoVI(){
        DBHelperCuestionario helper= new DBHelperCuestionario(context);
        int quizVI =helper.traerResult(6);
        return quizVI;
    }

    public Intent getIntent(Context context) {
        this.context = context;



        // int[] values = { 3, 5, 3, 3, 3 };
      int[] values = { getResultadoI(), getResultadoII(), getResultadoIII(),
              getResultadoIV(),getResultadoV(), getResultadoVI() };
        CategorySeries series = new CategorySeries("Pie Graph");
        int k = 0;
        for (int value : values) {
            series.add("Quiz " + ++k +" Calif:"+value, value);

        }

        int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN,Color.GRAY };

        DefaultRenderer renderer = new DefaultRenderer();
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        renderer.setChartTitle("Pie Chart Demo");
        renderer.setLabelsColor(Color.BLACK);
        renderer.setChartTitleTextSize(7);
        renderer.setZoomButtonsVisible(true);

        Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");
        return intent;
    }
}