package com.example.memos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_abm extends AppCompatActivity {

    public EditText et_usuario, et_nombre, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_abm);
        et_usuario = (EditText)findViewById(R.id.txt_usuario);
        et_password = (EditText)findViewById(R.id.txt_password);
        et_nombre = (EditText)findViewById(R.id.txt_nombre);
    }


    public void registrar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String usuario = et_usuario.getText().toString();
        String password = et_password.getText().toString();
        String nombre = et_nombre.getText().toString();

        if ( !usuario.isEmpty() && !password.isEmpty() && !nombre.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("usuario", usuario);
            registro.put("password", password);
            registro.put("nombre", nombre);
            baseDeDatos.insert("usuarios", null, registro);
            baseDeDatos.close();
            et_usuario.setText("");
            et_password.setText("");
            et_nombre.setText("");
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Debe llenar TODOS los campos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String usuario = et_usuario.getText().toString();
        if ( !usuario.isEmpty() ){
            int cantidad = baseDeDatos.delete("usuarios", "usuario=" +usuario, null );
            baseDeDatos.close();
            et_usuario.setText("");
            et_password.setText("");
            et_nombre.setText("");
            if (cantidad==1){
                Toast.makeText(this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No se ingreso Codigo", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String usuario = et_usuario.getText().toString();
        if (!usuario.isEmpty() ){
            Cursor fila = baseDeDatos.rawQuery("select password, nombre from usuarios where usuario =" + usuario, null);
            if (fila.moveToFirst() ){
                et_password.setText(fila.getString(0));
                et_nombre.setText(fila.getString(1));
                baseDeDatos.close();
            }else{
                Toast.makeText(this, "No existe el articulo/producto", Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
            }
        }else{
            Toast.makeText(this, "No hay codigo de Usuario", Toast.LENGTH_SHORT).show();
        }
    }


}