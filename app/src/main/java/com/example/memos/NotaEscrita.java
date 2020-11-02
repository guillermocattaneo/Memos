package com.example.memos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotaEscrita extends AppCompatActivity {

    private EditText notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_escrita);


        notas = (EditText)findViewById(R.id.txt_bitacora);
        String archivos [] = fileList();

        if (ArchivoExiste (archivos, "bitacora.txt") ){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String bitacoraCompleta = "";

                while (linea != null){
                    bitacoraCompleta = bitacoraCompleta + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                notas.setText(bitacoraCompleta);
            }catch (IOException e){

            }

        }

    }

    private boolean ArchivoExiste (String archivos [], String NombreArchivo){
        for (int i=0; i<archivos.length; i++)
            if (NombreArchivo.equals(archivos[i]) )
                return true;
        return false;
    }

    public void Guardar (View view){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(notas.getText().toString() );
            archivo.flush();
            archivo.close();
        }catch (IOException e){

        }
        Toast.makeText(this, "Se guardo lo escrito", Toast.LENGTH_SHORT).show();
    }

    public void Volver (View view){
        finish();
    }

}