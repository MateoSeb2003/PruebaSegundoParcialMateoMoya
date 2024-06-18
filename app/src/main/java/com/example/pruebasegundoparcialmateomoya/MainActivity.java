package com.example.pruebasegundoparcialmateomoya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText dividendo;
    private EditText divisor;
    private EditText invertido;
    private EditText entero;
    private EditText residuo;
    private Button siguiente;
    private Button mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de EditText y desactivación
        nombre = findViewById(R.id.editText_nombre);
        apellido = findViewById(R.id.editText_apellido);
        dividendo = findViewById(R.id.editText_dividendo);
        divisor = findViewById(R.id.editText_divisor);
        invertido = findViewById(R.id.editText_invertido);
        entero = findViewById(R.id.editText_entero);
        residuo = findViewById(R.id.editText_residuo);
        desactivarEditText();

        // Configuración del botón "Siguiente"
        siguiente = findViewById(R.id.button_siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear intent para la SegundaPantalla
                Intent intent = new Intent(MainActivity.this, SegundaPantalla.class);
                String getNombre = nombre.getText().toString();
                String getApellido = apellido.getText().toString();

                // Pasar datos a través de intent extras
                intent.putExtra("keyName", getNombre);
                intent.putExtra("keyLastName", getApellido);

                startActivity(intent); // Iniciar actividad
            }
        });

        // Obtener datos del intent
        Intent intent = getIntent();
        String getNombre = intent.getStringExtra("keyName");
        String getApellido = intent.getStringExtra("keyLastName");
        String getDividendo = intent.getStringExtra("keyDividendo"); // Asegúrate de definir este extra correctamente en la actividad SegundaPantalla
        String getDivisor = intent.getStringExtra("keyDivisor"); // Asegúrate de definir este extra correctamente en la actividad SegundaPantalla
        String getNumero = intent.getStringExtra("keyNumeroInvertido"); // Asegúrate de definir este extra correctamente en la actividad SegundaPantalla

        // Establecer textos en los EditText correspondientes
        nombre.setText(getNombre);
        apellido.setText(getApellido);
        dividendo.setText(getDividendo);
        divisor.setText(getDivisor);
        invertido.setText(getNumero); // Asignar número invertido al EditText correspondiente

        // Configuración del botón "Mostrar"
        mostrar = findViewById(R.id.button_mostrar);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de dividendo y divisor
                int dividendoInt = Integer.parseInt(dividendo.getText().toString());
                int divisorInt = Integer.parseInt(divisor.getText().toString());
                // Obtener número invertido
                String numeroInvertido = intent.getStringExtra("keyNumeroInvertido");

                // Mostrar número invertido en EditText correspondiente
                invertido.setText(numeroInvertido);

                int enteroInt = 0;
                int residuoInt = 0;

                // Calcular parte entera y residuo de la división
                if (divisorInt != 0) {
                    int signo = 1;

                    if ((dividendoInt < 0 && divisorInt > 0) ||
                            (dividendoInt > 0 && divisorInt < 0)) {
                        signo = -1;
                    }

                    dividendoInt = Math.abs(dividendoInt);
                    divisorInt = Math.abs(divisorInt);

                    while (dividendoInt >= divisorInt) {
                        dividendoInt -= divisorInt;
                        enteroInt++;
                    }
                    enteroInt *= signo;
                    residuoInt = dividendoInt;
                }

                // Mostrar resultados en EditText correspondientes
                entero.setText(String.valueOf(enteroInt));
                residuo.setText(String.valueOf(residuoInt));
            }
        });
    }

    // Método para desactivar todos los EditText
    public void desactivarEditText(){
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        dividendo.setEnabled(false);
        divisor.setEnabled(false);
        invertido.setEnabled(false);
        entero.setEnabled(false);
        residuo.setEnabled(false);
    }
}
