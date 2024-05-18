package com.umg.juegomatematico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final2 extends AppCompatActivity {
    TextView total;
    Button jugarDeNuevo;
    Button salir;
    int punteo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);
        Intent intent = getIntent();
        punteo = intent.getIntExtra( "puntajeJugador", 0);
        String punteoJug = String.valueOf(punteo);
        total.setText("Tu punteo es:" +punteoJug);
        total = findViewById(R.id.textViewPunteo2);
        jugarDeNuevo = findViewById(R.id.btnJugardeNuevo);
        salir = findViewById(R.id.btnSalir);

        jugarDeNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Final2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}