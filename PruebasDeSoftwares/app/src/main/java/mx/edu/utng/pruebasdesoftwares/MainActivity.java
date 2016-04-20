package mx.edu.utng.pruebasdesoftwares;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
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

import mx.edu.utng.pruebasdesoftwares.adapter.SlidingMenuAdapter;
import mx.edu.utng.pruebasdesoftwares.dbhelper.DBHelperCuestionario;
import mx.edu.utng.pruebasdesoftwares.email.EmailActivity;
import mx.edu.utng.pruebasdesoftwares.grafica.GraphAChartEngineActivity;
import mx.edu.utng.pruebasdesoftwares.juego.Manager;
import mx.edu.utng.pruebasdesoftwares.model.ItemSlideMenu;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionCincoActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionCodigoActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionCuatroActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionDosActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionSeisActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionTresActivity;
import mx.edu.utng.pruebasdesoftwares.questions.QuestionUnoActivity;


/**
 * Created by Luis Grimaldo on 05/02/2016.
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
        setContentView(R.layout.main_activity_layout);

        //Init component
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        mp = MediaPlayer.create ( this, R.raw.clic );
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
        //Add item for sliding list
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_about, " <---"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_temas, "Temas"));
        listSliding.add(new ItemSlideMenu(R.drawable.icon_video,"Video" ));
        listSliding.add(new ItemSlideMenu(R.drawable.robot_pensativo,"I.- Pruebas Unitarias Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_quiz,"II.- Pruebas de Aceptación de Usuario Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_quiz_iii,"III.- Pruebas de Regreción Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_quiz_iv,"IV.- Pruebas Funcionales Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_quiz_v,"V.- Pruebas de Integración Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_quiz_vi,"VI.- Pruebas de Calidad de Código Quiz" ));
        listSliding.add(new ItemSlideMenu(R.drawable.folder_music,"Música" ));
        listSliding.add(new ItemSlideMenu(R.drawable.folder_music,"Videos Desarrollador" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_pruebasoftware,"Juego de Prueba Software" ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_cloud, "Acerca de"));
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
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_item_uno:
                mp.start();
                startActivity(new Intent(MainActivity.this, GraphAChartEngineActivity.class));
            break;
            case R.id.menu_item_dos:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;

            case R.id.menu_item_tres:
                DBHelperCuestionario helper= new DBHelperCuestionario(this);
                int po=helper.porsentajeCuerso();

                Toast resul = Toast.makeText(MainActivity.this, "LLevas un porcentaje de:  " + po +"0%", Toast.LENGTH_SHORT);
                resul.show();

                break;
            case  R.id.menu_item_cuatro:
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
                break;

            case  R.id.menu_item_cinco:
                startActivity(new Intent(MainActivity.this, QuestionCodigoActivity.class));
                break;

            default:
                break;


        }
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void replaceFragment(int pos) {
        DBHelperCuestionario helper= new DBHelperCuestionario(this);

        switch (pos) {
            case 0:

                break;
            case 1:
                mp.start();
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;
            case 2:
                mp.start();
               // startActivity(new Intent(MainActivity.this,VideoSoftwareActivity.class));
                // al implementar este la clase ya no se nesecita
                  startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=CSgdhH5gp_U")));

                break;
            case 3:
                    mp.start();
                    startActivity(new Intent(MainActivity.this,QuestionUnoActivity.class));
                break;
            case 4:

               // helper.traerResult();
                int a;
                a =helper.traerResult(1);

                if(a==10){
                    mp.start();
                    startActivity(new Intent(MainActivity.this, QuestionDosActivity.class));
                }else{
                Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "+a+" OBTEN un resultado >3 en el quiz 1", Toast.LENGTH_SHORT);
                temp.show();
                }


                break;
            case 5:

                int next;
                next=helper.traerResult(2);
                if(next==10){
                    mp.start();
                    startActivity(new Intent(MainActivity.this,QuestionTresActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "+next+" OBTEN un resultado >5 en el quiz 2", Toast.LENGTH_SHORT);
                    temp.show();
                }

                break;
            case 6:
                int pasarCuatro;
                pasarCuatro=helper.traerResult(3);
                if(pasarCuatro==10){
                    mp.start();
                    startActivity(new Intent(MainActivity.this,QuestionCuatroActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "
                            +pasarCuatro+" OBTEN un resultado > 3 en el quiz 3", Toast.LENGTH_SHORT);
                    temp.show();
                }

                break;
            case 7:
                int pasarCinco;
                pasarCinco=helper.traerResult(4);
                if(pasarCinco==10){
                    mp.start();
                    mp.start();
                    startActivity(new Intent(MainActivity.this,QuestionCincoActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado obtenido es "
                            +pasarCinco+" OBTEN un resultado > 3 en el quiz 4", Toast.LENGTH_SHORT);
                    temp.show();
                }

                break;
            case 8:

                int pasarSeis;
                pasarSeis=helper.traerResult(5);
                if(pasarSeis==10){

                    mp.start();
                    startActivity(new Intent(MainActivity.this,QuestionSeisActivity.class));
                }else{
                    Toast temp = Toast.makeText(MainActivity.this,"Resultado traido es "+pasarSeis+" OBTEN un resultado > 3 en el quiz 5", Toast.LENGTH_SHORT);
                    temp.show();
                }

                break;
            case 9:
                mp.start();
                startActivity(new Intent(MainActivity.this, MusicaActivity.class));
                break;
            case 10:

                mp.start();
                  startActivity(new Intent(Intent.ACTION_VIEW,
                       Uri.parse("https://www.youtube.com/watch?v=b13iaiyWbMY")));

                break;
            case 11:

                mp.start();
                startActivity(new Intent(MainActivity.this, Manager.class));

                  break;

            case 12:
                mp.start();
                startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
                break;

            default:
                break;
        }
    }
}
