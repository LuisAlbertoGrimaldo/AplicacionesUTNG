package mx.edu.utng.structs_final.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import mx.edu.utng.structs_final.R;
import mx.edu.utng.structs_final.SettingsActivity;
import mx.edu.utng.structs_final.VideoActivity;
import mx.edu.utng.structs_final.correo.EmailActivity;
import mx.edu.utng.structs_final.juego.Manager;
import mx.edu.utng.structs_final.practicas.QuizActivityPracticas;
import mx.edu.utng.structs_final.questions.QuestionDosActivity;
import mx.edu.utng.structs_final.questions.QuestionUnoActivity;










/*veriicar cuales funcionan*/

import mx.edu.utng.structs_final.dbhelper.DBHelperCuestionario;
import mx.edu.utng.structs_final.grafica.GraphAChartEngineActivity;
import mx.edu.utng.structs_final.questions.QuestionCincoActivity;
import mx.edu.utng.structs_final.questions.QuestionCuatroActivity;
import mx.edu.utng.structs_final.questions.QuestionSeisActivity;
import mx.edu.utng.structs_final.questions.QuestionTresActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        if (id == R.id.nav_temario) {
            //  temario
            startActivity(new Intent(MainActivity.this, ListViewActivity.class));
        } else if (id == R.id.nav_video) {
            // videos


            startActivity(new Intent(MainActivity.this, VideoActivity.class));

        } else if (id == R.id.nav_audio) {
            // Handle the action audio
            startActivity(new Intent(MainActivity.this, MusicaActivity.class));
        } else if (id == R.id.nav_pruebas_codigo) {
            // Handle pruebas de codigo

            startActivity(new Intent(MainActivity.this, QuizActivityDos.class));

         }

        else if (id == R.id.nav_pruebas) {
            // Handle the acerca de
            startActivity(new Intent(MainActivity.this, QuizActivityPracticas.class));

        }

        else if (id == R.id.nav_configuracion) {
            // Handle the acerca de
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }


        else if (id == R.id.nav_juego) {
            // Handle the acerca de
            startActivity(new Intent(MainActivity.this, Manager.class));

        }
        else if (id == R.id.nav_correo) {
            // Handle the acerca de
            startActivity(new Intent(MainActivity.this, EmailActivity.class));

        } else if (id == R.id.nav_acerca_de) {
            // Handle the acerca de
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));

        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;


    }
    DBHelperCuestionario helper= new DBHelperCuestionario(this);
    @Override
    public boolean onOptionsItemSelected(MenuItem item)

    {
        switch (item.getItemId()) {

            case R.id.itm_video:


            DBHelperCuestionario helper= new DBHelperCuestionario(this);
            int po=helper.porsentajeCuerso();

            Toast resul = Toast.makeText(MainActivity.this, "LLevas un porsentaje de:  " + po +"0%", Toast.LENGTH_SHORT);
            resul.show();
                break;
            case R.id.itm_ognl:
                startActivity(new Intent(MainActivity.this,QuestionUnoActivity.class));





                break;

            case R.id.itm_formularios:


               /* DBHelperQuizOgnlResultado helperOgnl = new DBHelperQuizOgnlResultado(this);
                // helper.traerResult();
                int nextFormulario;
                nextFormulario=helperOgnl.traerResult();
                if(nextFormulario>=3){
                    startActivity(new Intent(MainActivity.this,QuizActivityFormularios.class));
                }else{
                    //startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
                    Toast tempFormulario = Toast.makeText(MainActivity.this,"Resultado traido es "+nextFormulario+" Necesitas tener todas las respuestas correctass en el quiz anterior", Toast.LENGTH_SHORT);
                    tempFormulario.show();
                }

                //startActivity(new Intent(MainActivity.this, QuizActivityFormularios.class));
                break;*/
                DBHelperCuestionario helper1= new DBHelperCuestionario(this);
                int a;
                a =helper1.traerResult(1);

                if(a==10){

                    startActivity(new Intent(MainActivity.this, QuestionDosActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,getString(R.string.resultado1)+a+getString(R.string.resultado2), Toast.LENGTH_SHORT);
                    temp.show();
                }




            case R.id.itm_objectos:



                DBHelperCuestionario helper2= new DBHelperCuestionario(this);
                int next;
                next=helper2.traerResult(2);
                if(next==8){

                    startActivity(new Intent(MainActivity.this,QuestionTresActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,getString(R.string.resultado3)+next+getString(R.string.resultadoquiz3), Toast.LENGTH_SHORT);
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
                    Toast temp = Toast.makeText(MainActivity.this,getString(R.string.resultado_4)
                            +pasarCuatro+getString(R.string.resultado_quiz_4), Toast.LENGTH_SHORT);
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
                    Toast temp = Toast.makeText(MainActivity.this,getString(R.string.resultado_quiz_5)
                            +pasarCinco+getString(R.string.resultado_quiz_6), Toast.LENGTH_SHORT);
                    temp.show();
                }




                break;


            case R.id.itm_action:



                int pasarSeis;
                DBHelperCuestionario helper6= new DBHelperCuestionario(this);
                pasarSeis=helper6.traerResult(5);
                if(pasarSeis==10){


                    startActivity(new Intent(MainActivity.this,QuestionSeisActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,getString(R.string.resultado_6)+pasarSeis+getString(R.string.treaer_resultado6), Toast.LENGTH_SHORT);
                    temp.show();
                }
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
