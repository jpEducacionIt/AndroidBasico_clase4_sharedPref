package com.example.androidbasico_clase4_sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etPassword;
    TextView tvNombre, tvPassword;
    Button buttonGuardar, buttonContinuar;

    String nombre, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.editTextNombre);
        etPassword = findViewById(R.id.editTextPassword);
        tvNombre = findViewById(R.id.textViewNombre);
        tvPassword = findViewById(R.id.textViewPassword);
        buttonGuardar = findViewById(R.id.buttonContinuar);
        buttonContinuar = findViewById(R.id.buttonIntent);

        cargarPreferencias();

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = etNombre.getText().toString();
                password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", nombre);
                editor.putString("password" , password);
                editor.commit();
            }
        });

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityFinal.class);
                startActivity(intent);
            }
        });
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        nombre = preferences.getString("nombre", "Sin registrar");
        password = preferences.getString("password", "Sin registrar");
        tvNombre.setText(nombre);
        tvPassword.setText(password);
    }
}