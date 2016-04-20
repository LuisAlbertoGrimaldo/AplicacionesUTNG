package mx.edu.utng.hibernate;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import mx.edu.utng.hibernate.adapter.SlidingMenuAdapter;
import mx.edu.utng.hibernate.dbhelper.DBHelperCuestionario;
import mx.edu.utng.hibernate.estrategia.Manager;
import mx.edu.utng.hibernate.grafica.GraphAChartEngineActivity;
import mx.edu.utng.hibernate.model.ItemSlideMenu;
import mx.edu.utng.hibernate.practicas.QuizActivityPracticas;
import mx.edu.utng.hibernate.questions.QuestionCincoActivity;
import mx.edu.utng.hibernate.questions.QuestionCuatroActivity;
import mx.edu.utng.hibernate.questions.QuestionDosActivity;
import mx.edu.utng.hibernate.questions.QuestionTresActivity;
import mx.edu.utng.hibernate.questions.QuestionUnoActivity;


/**
 * Created by erika on 05/02/2016.
 */
public class MainActivity extends ActionBarActivity {

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private MediaPlayer mp;//poner sonido al boton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //Init component
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        mp = MediaPlayer.create ( this, R.raw.clic );
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
        //Add item for sliding list
        listSliding.add(new ItemSlideMenu(R.drawable.settings, "Regresar "));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_temas, "Temas"));
        listSliding.add(new ItemSlideMenu(R.drawable.icon_video,"Video" ));
        listSliding.add(new ItemSlideMenu(R.drawable.icon_mus,"Audio" ));
        listSliding.add(new ItemSlideMenu(R.drawable.configuraricon,"Confiuración" ));
        listSliding.add(new ItemSlideMenu(R.drawable.icon_cuiz,"Prcática" ));
        listSliding.add(new ItemSlideMenu(R.drawable.grafica,"Grafica" ));
        listSliding.add(new ItemSlideMenu(R.drawable.carddoce,"Estrategias Dinamicas" ));
        listSliding.add(new ItemSlideMenu(R.drawable.correo,"Envíar Correos" ));
        listSliding.add(new ItemSlideMenu(R.drawable.icontres,"Acerca De" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_sync_black_24dp,"Salir" ));
        adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

        //Display icon to open/ close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set title
        setTitle(listSliding.get(0).getTitle());
        //item selected
        listViewSliding.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Display fragment 1 when start
        replaceFragment(0);
        //Hanlde on item click

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position).getTitle());
                //item selected
                listViewSliding.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //Create method replace fragment

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void replaceFragment(int pos) {
       // Fragment fragment = null;
        switch (pos) {
            case 0:
                //fragment = new Fragment();
                break;
            case 1:
                mp.start();
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;
            case 2:
                mp.start();
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
                //fragment = new Fragment3();
                break;


            case 3:
                mp.start();
                startActivity(new Intent(MainActivity.this,MusicaActivity.class));
                break;
            case 4:
                mp.start();
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                break;

            case 5:
                mp.start();
                startActivity(new Intent(MainActivity.this,QuizActivityPracticas.class));
                break;

            case 6:
                mp.start();
               startActivity(new Intent(MainActivity.this, GraphAChartEngineActivity.class));
                break;


            case 7:
                mp.start();

                startActivity(new Intent(MainActivity.this, Manager.class));

                break;
            case 8:
                mp.start();

                startActivity(new Intent(MainActivity.this, EmailActivity.class));

                break;

            case 9:
                mp.start();

                startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));

                break;
            case 10:
            mp.start();
                itmSalida();
           // startActivity(new Intent(MainActivity.this, mx.edu.utng.mapa.MapsActivity.class));
            break;

            default:
                break;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {



            case R.id.itm_formularios:

                startActivity(new Intent(MainActivity.this,QuestionUnoActivity.class));

                break;

            case R.id.itm_ognl:
                DBHelperCuestionario helper1= new DBHelperCuestionario(this);
                int a;
                a =helper1.traerResult(1);

                if(a==10){

                    startActivity(new Intent(MainActivity.this, QuestionDosActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "+a+" OBTEN un resultado >3 en el quiz 1", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;


            case R.id.itm_objectos:

                DBHelperCuestionario helper2= new DBHelperCuestionario(this);
                int next;
                next=helper2.traerResult(2);
                if(next==8){

                    startActivity(new Intent(MainActivity.this,QuestionTresActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "+next+" OBTEN un resultado >5 en el quiz 2", Toast.LENGTH_SHORT);
                    temp.show();
                }





                break;
            case R.id.itm_result:


                DBHelperCuestionario helper4= new DBHelperCuestionario(this);
                int pasarCuatro;
                pasarCuatro=helper4.traerResult(3);
                if(pasarCuatro==10){

                    startActivity(new Intent(MainActivity.this,QuestionCuatroActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "
                            +pasarCuatro+" OBTEN un resultado > 3 en el quiz 3", Toast.LENGTH_SHORT);
                    temp.show();
                }



                break;
            case R.id.itm_interceptores:



                int pasarCinco;
                DBHelperCuestionario helper5= new DBHelperCuestionario(this);
                pasarCinco=helper5.traerResult(4);
                if(pasarCinco==10){
                    startActivity(new Intent(MainActivity.this,QuestionCincoActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado obtenido es "
                            +pasarCinco+" OBTEN un resultado > 3 en el quiz 4", Toast.LENGTH_SHORT);
                    temp.show();
                }

                break;

            case R.id.itm_practicas:
                startActivity(new Intent(MainActivity.this, QuizActivityPracticas.class));
                break;


            case R.id.itm_avance:
                DBHelperCuestionario helper= new DBHelperCuestionario(this);
                int po=helper.porsentajeCuerso();

                Toast resul = Toast.makeText(MainActivity.this, "LLevas un porsentaje de:  " + po +"0%", Toast.LENGTH_SHORT);
                resul.show();
                break;



            case R.id.itm_grafica:

                startActivity(new Intent(MainActivity.this, GraphAChartEngineActivity.class));
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
