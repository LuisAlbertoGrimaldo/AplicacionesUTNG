package mx.edu.utng.structs_final.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.structs_final.R;
import mx.edu.utng.structs_final.dbhelper.DatabaseHelper;

/**
 * Created by Saul on 15/02/2016.
 */
public class LoginActivity  extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void onButtonClick(View view){
        if(view.getId() == R.id.btn_entrar){
            EditText a = (EditText)findViewById(R.id.edt_usuario);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_contrasenia);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra(getString(R.string.usernamee),str);
                startActivity(i);

            }else{
                Toast temp = Toast.makeText(LoginActivity.this, R.string.password, Toast.LENGTH_SHORT);
                temp.show();
            }




        }
        if(view.getId() == R.id.btn_ingresa){
            Intent i = new Intent(LoginActivity.this, RegistrarActivity.class);
            startActivity(i);
        }
    }


}
