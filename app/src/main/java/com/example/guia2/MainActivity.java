package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button btnIniciarSesion;
    EditText textCorreo, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnLongClickListener(this);

        textCorreo = findViewById(R.id.textCorreo);
        textPassword = findViewById(R.id.textPassword);
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.btnIniciarSesion: {
                if (textCorreo.getText().toString().isEmpty() && textPassword.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Digite el correo y la contraseña", Toast.LENGTH_SHORT).show();
                } else if (textCorreo.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Digite el correo", Toast.LENGTH_SHORT).show();
                } else if (textPassword.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Digite la contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Intent in = new Intent(this, SegundaActivity.class);
                    in.putExtra("Correo", textCorreo.getText().toString());
                    startActivity(in);
                }
                break;
            }
        }
        return false;
    }
}
