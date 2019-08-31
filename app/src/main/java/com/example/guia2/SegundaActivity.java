package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnProcesar, btnDatos;
    Handler h = new Handler();
    ProgressBar Barra;
    AutoCompleteTextView fruta, animal, lenProg;
    String [] Lisfruta = {"Uva", "Fresa", "Sandía"};
    String [] Lisanimal = {"Gatito", "Perro", "Perico"};
    String [] Lislenguaje = {"C#", "Java", "C++"};
    int i = 0;
    boolean Activo = false;
    TextView textPorcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btnProcesar = findViewById(R.id.btnProcesar);
        btnProcesar.setOnClickListener(this);
        btnDatos = findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(this);

        textPorcentaje = findViewById(R.id.textPorcentaje);
        Barra = findViewById(R.id.Barra);
        fruta = findViewById(R.id.fruta);
        animal = findViewById(R.id.animal);
        lenProg = findViewById(R.id.lenProg);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, Lisfruta);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, Lisanimal);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, Lislenguaje);


        fruta.setThreshold(1);
        animal.setThreshold(2);
        lenProg.setThreshold(3);

        fruta.setAdapter(adapter1);
        animal.setAdapter(adapter2);
        lenProg.setAdapter(adapter3);

    }

    @Override
    public void onClick(View view) {

            // Intent i = new Intent(this,Calculadora.class);
            //startActivity(i);
            switch (view.getId()){
                case R.id.btnProcesar: {if(!Activo){
                    Thread hr = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while(i <= 100){
                                h.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        textPorcentaje.setText(i +" %");
                                        Barra.setProgress(i);
                                    }
                                });
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(i == 100) {
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Fruta: " + fruta.getText().toString() + "\n" +
                                                    "Animal: " + animal.getText().toString() + "\n" +
                                                    "Lenguaje: " + lenProg.getText().toString(), Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                                i++;
                                Activo = true;
                            }
                        }
                    });
                    hr.start();
                }
                    break;
                }
                case R.id.btnDatos: {
                    Intent i = new Intent(this, Datos.class);
                    startActivity(i);
                    break;
                }
        }


    }
}
