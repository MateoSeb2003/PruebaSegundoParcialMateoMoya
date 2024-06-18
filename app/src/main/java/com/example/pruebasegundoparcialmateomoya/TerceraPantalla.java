package com.example.pruebasegundoparcialmateomoya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TerceraPantalla extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText dividendo;
    private EditText divisor;
    private EditText numero;
    private Button cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercera_pantalla);

        nombre = findViewById(R.id.editText_nombre);
        apellido = findViewById(R.id.editText_apellido);
        dividendo = findViewById(R.id.editText_dividendo);
        divisor = findViewById(R.id.editText_divisor);
        numero = findViewById(R.id.editText_numero);
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

        nombre.setEnabled(false);
        apellido.setEnabled(false);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TerceraPantalla.this, SegundaPantalla.class);

                String getNombre = nombre.getText().toString();
                String getApellido = apellido.getText().toString();
                String getDividendo = dividendo.getText().toString();
                String getDivisor = divisor.getText().toString();
                String getNumero = numero.getText().toString();

                intent1.putExtra("keyName", getNombre);
                intent1.putExtra("keyLastName", getApellido);
                intent1.putExtra("keyDividendo", getDividendo);
                intent1.putExtra("keyDivisor", getDivisor);
                intent1.putExtra("keyNumero", getNumero);

                startActivity(intent1);
            }
        });

    }
}

