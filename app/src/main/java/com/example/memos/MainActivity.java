package com.example.memos;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



public class MainActivity extends AppCompatActivity {

    private View registrar;
    EditText vUsuario, vPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //permisos grabar audio
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
        //permisos sacar foto
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        vUsuario = (EditText)findViewById(R.id.etUsuario);
        vPassword = (EditText)findViewById(R.id.etPassword);

        //Llamada para registrar
        registrar = (Button)findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "A Registrarse!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent (MainActivity.this, MainActivity_abm.class);
                startActivity(i);
            }
        });




    }

    //Iniciar debe ir al menu, con notas, camara, maps
    public void iniciar (View view) {
        String txtUsuario = vUsuario.toString();
        String txtPassword = vPassword.toString();

        /*
        if (txtUsuario.isEmpty() && txtPassword.isEmpty()) {
            Toast.makeText(this, "Completa los datos", Toast.LENGTH_SHORT).show();
        } else if (txtUsuario.isEmpty() || txtPassword.isEmpty()) {
            Toast.makeText(this, "Completa los datos", Toast.LENGTH_SHORT).show();
        } else if (!(txtUsuario.isEmpty() &&  txtPassword.isEmpty() ) ) {

            //   AdminSQLite admin = new AdminSQLite(getBaseContext());
            //   SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

            Cursor fila = baseDeDatos.rawQuery
                    ("Select usuario, password from usuarios where usuario ='" + txtUsuario + "' and password = '" + txtPassword + "'", null);

            if (fila.moveToFirst()) {
                usuario.setText(fila.getString(0));
                password.setText(fila.getString(1));
                Toast.makeText(this, "Bienvenido!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, MainActivity2Notas.class);

                //i.putExtra("datos", usuario.getText().toString());
                startActivity(i);

//                baseDeDatos.close();
            }
        }

*/
    Intent i = new Intent(this, MenuActivity.class);
    //i.putExtra("datos", usuario.getText().toString());
    startActivity(i);
    }

}