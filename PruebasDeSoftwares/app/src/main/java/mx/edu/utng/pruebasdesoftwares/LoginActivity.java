package mx.edu.utng.pruebasdesoftwares;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import mx.edu.utng.pruebasdesoftwares.dbhelper.DatabaseHelperLogin;

/**
 * Created by Luis Albero Grimaldo  on 06/02/2016.
 */
public class LoginActivity extends AppCompatActivity   {

    private MediaPlayer mp,error ;

    DatabaseHelperLogin helper = new DatabaseHelperLogin(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mp = MediaPlayer.create ( this, R.raw.clic );
        error = MediaPlayer.create ( this, R.raw.error );
    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_entrar){
            EditText a = (EditText)findViewById(R.id.edt_usuario);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_password);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){
                mp.start();
                Intent i = new Intent(LoginActivity.this, BienvenidoActivity.class);
                i.putExtra("Username",str);
                startActivity(i);
                finish();

            }else{
                error.start();
                Toast temp = Toast.makeText(LoginActivity.this, R.string.contrasenia_invalida, Toast.LENGTH_SHORT);
                temp.show();

            }




        }
        if(view.getId() == R.id.btn_registar){
            mp.start();
            Intent i = new Intent(LoginActivity.this, RegistrarseActivity.class);
            startActivity(i);
            finish();
        }
    }
}
