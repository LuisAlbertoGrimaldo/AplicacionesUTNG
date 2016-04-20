package mx.edu.utng.pruebasdesoftwares;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.pruebasdesoftwares.model.Contact;
import mx.edu.utng.pruebasdesoftwares.dbhelper.DatabaseHelperLogin;

/**
 * Created by Luis Albero Grimaldo  on 06/02/2016.
 */
public class RegistrarseActivity extends Activity implements View.OnClickListener {

    DatabaseHelperLogin helper = new DatabaseHelperLogin(this);

private Button btnRegresar;
    private MediaPlayer mp,error;//poner sonido al boton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_layout);
       mp = MediaPlayer.create(this, R.raw.clic);
        btnRegresar =(Button)findViewById(R.id.btn_regresar);
        btnRegresar.setOnClickListener(this);
        error = MediaPlayer.create ( this, R.raw.error );
    }



    public void onSignUpClick(View v){
        if(v.getId() == R.id.btn_guardar){
            EditText name =(EditText)findViewById(R.id.edt_name);
            EditText email =(EditText)findViewById(R.id.edt_correo);
            EditText uname =(EditText)findViewById(R.id.edt_usuario);
            EditText pass1 =(EditText)findViewById(R.id.edt_contrasenia1);
            EditText pass2 =(EditText)findViewById(R.id.edt_contrasenia2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensage
                error.start();
                Toast pass = Toast.makeText(RegistrarseActivity.this, R.string.contrasenia_sin_conincidir, Toast.LENGTH_SHORT);
                pass.show();

            }
            else{
                mp.start();
                //insertar datos en la base de datos
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
                Toast pass = Toast.makeText(RegistrarseActivity.this, R.string.datos_guardados, Toast.LENGTH_SHORT);
                pass.show();

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regresar:
                mp.start();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
        }
    }
}
