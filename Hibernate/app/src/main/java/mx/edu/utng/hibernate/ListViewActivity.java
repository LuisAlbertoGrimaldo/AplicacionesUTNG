package mx.edu.utng.hibernate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import mx.edu.utng.hibernate.R;
import mx.edu.utng.hibernate.dbhelper.DBHelperCuestionario;
/**
 * Created by erika on 3/02/16.
 */
public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener{
    private ListView lsvTema;

    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_example_layout);
        initComponents();
    }
    private void initComponents(){
        lsvTema = (ListView)findViewById(R.id.lsv_java);
        String [] temas = getResources().getStringArray(R.array.temas);
        ArrayAdapter adapter = new ArrayAdapter(
                getApplication(),
                R.layout.item_layout,
                R.id.txv_item,
                temas);
        lsvTema.setAdapter(adapter);
        lsvTema.setOnItemClickListener(this);
        bundle = new Bundle();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DBHelperCuestionario helper = new DBHelperCuestionario(this);
        String [] descripciones = getResources().getStringArray(R.array.descripciones);
        //Poner la posicion de cada tema
        switch (position) {
            case 0:


                bundle.putString("elegido", parent.getAdapter().getItem(0).toString());
                bundle.putInt("posicion", position);
                bundle.putString("descripcion", descripciones[0]);

                Intent intent = new Intent(ListViewActivity.this,
                        SeleccionActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();

                break;
            case 1:

                int a;
                a = helper.traerResult(1);

                if (a == 10) {


                    bundle.putString("elegido", parent.getAdapter().getItem(1).toString());
                    bundle.putInt("posición", position);
                    bundle.putString("descripción", descripciones[1]);

                    Intent intentI = new Intent(ListViewActivity.this,
                            SeleccionActivity.class);
                    intentI.putExtras(bundle);
                    startActivity(intentI);
                    Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();

                } else {
                    Toast temp = Toast.makeText(ListViewActivity.this, "Resultado traido es " + a + " Aprueba el Quiz I", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            case 2:


                int resultQuizII;
                resultQuizII = helper.traerResult(2);

                if (resultQuizII == 10) {
                    bundle.putString("elegido", parent.getAdapter().getItem(2).toString());
                    bundle.putInt("posición", position);
                    bundle.putString("descripción", descripciones[2]);

                    Intent intentII = new Intent(ListViewActivity.this,
                            SeleccionActivity.class);
                    intentII.putExtras(bundle);
                    startActivity(intentII);
                    Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();


                } else {
                    Toast temp = Toast.makeText(ListViewActivity.this, "Resultado traido es " + resultQuizII
                            + " Aprueba el Quiz II", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            case 3:
                int resultQuizIII;
                resultQuizIII = helper.traerResult(3);
                if (resultQuizIII == 10) {


                    bundle.putString("elegido", parent.getAdapter().getItem(3).toString());
                    bundle.putInt("posición", position);
                    bundle.putString("descripción", descripciones[3]);

                    Intent intentIII = new Intent(ListViewActivity.this,
                            SeleccionActivity.class);
                    intentIII.putExtras(bundle);
                    startActivity(intentIII);
                    Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();

                } else {
                    Toast temp = Toast.makeText(ListViewActivity.this, "Resultado traido es " + resultQuizIII
                            + " Aprueba el Quiz III", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            case 4:
                int resultQuizIV;
                resultQuizIV = helper.traerResult(4);
                if (resultQuizIV == 10) {
                    bundle.putString("elegido", parent.getAdapter().getItem(4).toString());
                    bundle.putInt("posición", position);
                    bundle.putString("descripción", descripciones[4]);
                    Intent intentIV = new Intent(ListViewActivity.this,
                            SeleccionActivity.class);
                    intentIV.putExtras(bundle);
                    startActivity(intentIV);
                    Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();
                } else {
                    Toast temp = Toast.makeText(ListViewActivity.this, "Resultado traido es " + resultQuizIV
                            + " Aprueba el Quiz IV", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            case 5:
                int resultQuizV;
                resultQuizV = helper.traerResult(5);
                if (resultQuizV == 10) {

                    bundle.putString("elegido", parent.getAdapter().getItem(5).toString());
                    bundle.putInt("posición", position);
                    bundle.putString("descripción", descripciones[5]);

                    Intent intentV = new Intent(ListViewActivity.this,
                            SeleccionActivity.class);
                    intentV.putExtras(bundle);
                    startActivity(intentV);
                    Toast.makeText(this, "Selección:  " + Integer.toString(position), Toast.LENGTH_SHORT).show();


                } else {
                    Toast temp = Toast.makeText(ListViewActivity.this, "Resultado traido es " + resultQuizV
                            + " Aprueba el Quiz V", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            default:
                break;
        }
    }
}