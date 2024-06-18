package com.example.pruebasegundoparcialmateomoya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText dividendo;
    private EditText divisor;
    private EditText numero;
    private Button siguiente;
    private Button cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pantalla);

        nombre = findViewById(R.id.editText_nombre);
        apellido = findViewById(R.id.editText_apellido);
        dividendo = findViewById(R.id.editText_dividendo);
        divisor = findViewById(R.id.editText_divisor);
        numero = findViewById(R.id.editText_numero);
        desactivarEditText();
        siguiente = findViewById(R.id.button_siguiente);
        cerrar = findViewById(R.id.button_cerrar);

        Intent intent = getIntent();
        String getNombre = intent.getStringExtra("keyName");
        String getApellido = intent.getStringExtra("keyLastName");
        String getDividendo = intent.getStringExtra("keyDividendo");
        String getDivisor = intent.getStringExtra("keyDivisor");
        String getNumero = intent.getStringExtra("keyNumero");


        nombre.setText(getNombre);
        apellido.setText(getApellido);
        dividendo.setText(getDividendo);
        divisor.setText(getDivisor);
        numero.setText(getNumero);


    }
    public void desactivarEditText(){
        dividendo.setEnabled(false);
        divisor.setEnabled(false);
        numero.setEnabled(false);
    }



}
