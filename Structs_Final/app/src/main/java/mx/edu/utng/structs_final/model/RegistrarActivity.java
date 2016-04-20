package mx.edu.utng.structs_final.model;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.structs_final.R;
import mx.edu.utng.structs_final.dbhelper.DatabaseHelper;

/**
 * Created by Saul on 15/02/2016.
 */
public class RegistrarActivity  extends Activity{

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
    }
    public void onSignUpClick(View v){
        if(v.getId() == R.id.btn_registrar){
            EditText name =(EditText)findViewById(R.id.edt_nombre);
            EditText email =(EditText)findViewById(R.id.edt_email);
            EditText uname =(EditText)findViewById(R.id.edt_usuario);
            EditText pass1 =(EditText)findViewById(R.id.edt_contrasenia);
            EditText pass2 =(EditText)findViewById(R.id.edt_contrasenia2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensage
                Toast pass = Toast.makeText(RegistrarActivity.this, R.string.not, Toast.LENGTH_SHORT);
                pass.show();

            }
            else{
                //insertar datos en la base de datos
                ContactActivity c = new ContactActivity();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
                Toast pass = Toast.makeText(RegistrarActivity.this, R.string.datasave, Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }
}
