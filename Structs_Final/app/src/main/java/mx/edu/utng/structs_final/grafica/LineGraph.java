package mx.edu.utng.structs_final.grafica;

/**
 * Created by Saul on 05/04/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LineGraph{

    public Intent getIntent(Context context) {

        // Nuestros primeros Datos
        int[] x = { 1 }; // x valores!
        int[] y =  { 30 }; // y valores!
        TimeSeries series = new TimeSeries("Line1");
        for( int i = 0; i < x.length; i++)
        {
            series.add(x[i], y[i]);
        }

        // Nuestros segundos datos
        int[] x2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // x valores!
        int[] y2 =  { 145, 123, 111, 100, 89, 77, 57, 45, 34, 30}; // y valores!
        TimeSeries series2 = new TimeSeries("Line2");
        for( int i = 0; i < x2.length; i++)
        {
            series2.add(x2[i], y2[i]);
        }

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);
        dataset.addSeries(series2);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer(); // Esta es usada en la perzonalizacion linea 1
        XYSeriesRenderer renderer2 = new XYSeriesRenderer(); // Esta es usada en la perzonalizacion linea 1 2
        mRenderer.addSeriesRenderer(renderer);
        mRenderer.addSeriesRenderer(renderer2);

        // ayuda en perzonalizacion  la linea 1!
        renderer.setColor(Color.BLUE);
        renderer.setPointStyle(PointStyle.SQUARE);
        renderer.setFillPoints(true);
        // ayuda en la linea perzonalizacion 2!
        renderer2.setColor(Color.YELLOW);
        renderer2.setPointStyle(PointStyle.DIAMOND);
        renderer2.setFillPoints(true);

        Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
        return intent;

    }

}