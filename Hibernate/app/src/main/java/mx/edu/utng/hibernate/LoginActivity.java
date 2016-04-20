package mx.edu.utng.hibernate;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.hibernate.dbhelper.DatabaseHelper;

/**
 * Created by erika  on 06/02/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private MediaPlayer mp ;

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mp = MediaPlayer.create ( this, R.raw.clic );
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

            }else{
                Toast temp = Toast.makeText(LoginActivity.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }




        }
        if(view.getId() == R.id.btn_registar){
            mp.start();
            Intent i = new Intent(LoginActivity.this, RegistrarseActivity.class);
            startActivity(i);
        }
    }
}
