package com.umg.juegomatematico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView punteo;
    TextView  Vidas;
    TextView tiempo;
    TextView pregunta;
    EditText respuesta;
    Button ok;
    Button siguiente;
    Random random = new Random();
    int numero1;
    int numero2;
    int respuestaJugador;
    int respuestaCorrecta;
    int puntajeJugador =0;
    int vidas =3;

    CountDownTimer temporizador;
    private static final long INICIO_TEMPORIZADOR = 60000;
    Boolean timerActivo;
    long tiempoRestanteTemporizador = INICIO_TEMPORIZADOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        punteo = findViewById(R.id.textViewPunteo);
        Vidas = findViewById(R.id.textViewTres);
        tiempo = findViewById(R.id.textViewTiempo);
        pregunta = findViewById(R.id.textViewPregunta);
        respuesta = findViewById(R.id.editTextRespuesta);
        ok = findViewById(R.id.btnOk);
        siguiente = findViewById(R.id.btnSiguiente);
        juego();



            ok.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    respuestaJugador = Integer.valueOf(respuesta.getText().toString());
                    pausarTemporizador();

                    if (respuestaJugador == respuestaCorrecta) {
                        puntajeJugador = puntajeJugador + 10;
                        punteo.setText("" + puntajeJugador);
                        pregunta.setText("Respuesta Correcta");

                    }
                    else {
                        vidas = vidas -1;
                        Vidas.setText("" + vidas);
                        pregunta.setText("Respuesta Incorrecta");

                    }
                }


            });



        siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                respuesta.setText("");

                restablecerTemporizador();
                if(vidas == 0){
                    Toast.makeText(getApplicationContext(), "Juego Terminado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( Juego.this, Final2.class);
                    intent.putExtra( "Puntaje Jugador", puntajeJugador);
                    startActivity(intent);
                    finish();
                }
                else{
                    juego();
                }
            }


        });

        }
    public void juego () {
        numero1 = random.nextInt(100);
        numero2 = random.nextInt(100);
        pregunta.setText(numero1 + " + " + numero2);
        respuestaCorrecta = numero1 + numero2;
        inicioTemporizador();

    }






        public void inicioTemporizador() {
            temporizador = new CountDownTimer(tiempoRestanteTemporizador, 1000) {
                @Override
                public void onTick(long l) {
                    tiempoRestanteTemporizador = l;
                    actualizarTexto();
                }

                @Override
                public void onFinish() {
                    timerActivo = false;
                    pausarTemporizador();
                    restablecerTemporizador();
                    actualizarTexto();
                    vidas = vidas - 1;
                    Vidas.setText("" + vidas);
                    pregunta.setText("Tiempo Agotado");
                }

            }.start();
            timerActivo = true;
        }
            public void actualizarTexto(){
                int segundo = (int) (tiempoRestanteTemporizador / 1000) % 60;
                String tiempoRestante = String.format(Locale.getDefault(), "%02d", segundo);
                tiempo.setText(tiempoRestante);
            }
            public void pausarTemporizador () {
            temporizador.cancel();
            timerActivo = false;

            }
            public void restablecerTemporizador () {
            tiempoRestanteTemporizador = INICIO_TEMPORIZADOR;
            actualizarTexto();

            }

    }



