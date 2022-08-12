package com.example.androidbasico_clase4_sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    String nombre, password;
    TextView tvNombre, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tvNombre = findViewById(R.id.textViewFinalNombre);
        tvPassword = findViewById(R.id.textViewFinalPassword);

        cargarPreferencias();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        nombre = preferences.getString("nombre", "Sin registrar");
        password = preferences.getString("password", "Sin registrar");
        tvNombre.setText(nombre);
        tvPassword.setText(password);
    }
}
