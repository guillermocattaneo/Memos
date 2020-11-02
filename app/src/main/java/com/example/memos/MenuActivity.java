package com.example.memos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void camara (View view){
        Intent i = new Intent (this, CamaraFoto.class);
        startActivity(i);
    }

    public void NotaEscrita (View view){
        Intent i = new Intent (this, NotaEscrita.class);
        startActivity(i);
    }

    public void NotaDeVoz (View view){
        Intent i = new Intent(this, NotaDeVoz.class);
        startActivity(i);
    }


    public void ubicacion (View view){
        Intent i = new Intent (this, NotaEscrita.class);
        startActivity(i);
    }

}