package mx.edu.utng.hibernate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Created by erika on 04/04/2016.
 */
public class ItemActivity extends AppCompatActivity
{




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.itm_ognl:
                //startActivity(new Intent(ItemActivity.this, QuizActivityRelacion.class));
                break;

            case R.id.itm_formularios:
               // startActivity(new Intent(ItemActivity.this, QuizActivityPersisitencia.class));
                break;

            case R.id.itm_objectos:
              // startActivity(new Intent(ItemActivity.this, QuizActivityCodigo.class));
                break;
            case R.id.itm_result:
               // startActivity(new Intent(ItemActivity.this, QuizActivityTiposResullt.class));
                break;
            case R.id.itm_interceptores:
               // startActivity(new Intent(ItemActivity.this, QuizActivityConcepto.class));
                break;

            case R.id.itm_salir:
                itmSalida();
                break;



        }
        return super.onOptionsItemSelected(item);
    }
    private void itmSalida(){
        finish();
        Intent intent1=new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }
}

