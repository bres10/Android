package com.umg.juegomatematico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Suma;
        Button Resta;
        Button Multiplicacion;
        Button Division;
        Suma = findViewById(R.id.btnSuma);
        Resta = findViewById(R.id.btnResta);
        Multiplicacion = findViewById(R.id.btnMultiplicacion);
        Division = findViewById(R.id.btnDivision);

        Suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Juego.class);
                startActivity(intent);


            }
        });
        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Juego.class);
                startActivity(intent);


            }
        });
        Multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Juego.class);
                startActivity(intent);


            }
        });
        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Juego.class);
                startActivity(intent);


            }
        });

    }
}

