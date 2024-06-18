package com.example.pruebasegundoparcialmateomoya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SegundaPantalla.this, TerceraPantalla.class);

                String getNombre = nombre.getText().toString();
                String getApellido = apellido.getText().toString();
                String getDividendo = dividendo.getText().toString();
                String getDivisor = divisor.getText().toString();
                String getNumero = numero.getText().toString();

                intent.putExtra("keyName", getNombre);
                intent.putExtra("keyLastName", getApellido);
                intent.putExtra("keyDividendo", getDividendo);
                intent.putExtra("keyDivisor", getDivisor);
                intent.putExtra("keyNumero", getNumero);

                startActivity(intent);
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNombre = nombre.getText().toString();
                String getApellido = apellido.getText().toString();
                String getDividendo = dividendo.getText().toString();
                String getDivisor = divisor.getText().toString();
                String getNumero = numero.getText().toString();

                // Verifica si los campos contienen datos
                if (!getNombre.isEmpty() || !getApellido.isEmpty() || !getDividendo.isEmpty() ||
                        !getDivisor.isEmpty() || !getNumero.isEmpty()) {
                    Intent intent = new Intent(SegundaPantalla.this, MainActivity.class);
                    String numeroInvertido = new StringBuilder(getNumero).reverse().toString();

                    intent.putExtra("keyName", getNombre);
                    intent.putExtra("keyLastName", getApellido);
                    intent.putExtra("keyDividendo", getDividendo);
                    intent.putExtra("keyDivisor", getDivisor);
                    intent.putExtra("keyNumeroInvertido", numeroInvertido);

                    startActivity(intent);
                }
            }
        });

    }

    public void desactivarEditText(){
        dividendo.setEnabled(false);
        divisor.setEnabled(false);
        numero.setEnabled(false);
    }

}
