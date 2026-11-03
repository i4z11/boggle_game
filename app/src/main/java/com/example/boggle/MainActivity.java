package com.example.boggle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Creamos el tablero y la palabra actual
        Tablero tablero = new Tablero();
        Palabra palabraActual = new Palabra();

        // Referencia al TextView de la palabra y al botón enviar
        TextView tvPalabraActual = findViewById(R.id.tvPalabraActual);
        Button btnEnviarPalabra = findViewById(R.id.btnEnviarPalabra);

        // 2. Recorremos la matriz 4x4 para configurar los botones
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                String nombreId = "btn_" + fila + "_" + col;
                int idBtn = getResources().getIdentifier(nombreId, "id", getPackageName());
                Button boton = findViewById(idBtn);

                // Obtenemos la letra del tablero y se la asignamos al botón
                char letra = tablero.obtenerLetra(fila, col);
                boton.setText(String.valueOf(letra));

                // Guardamos las coordenadas actuales para usarlas dentro del Clic
                final int f = fila;
                final int c = col;

                // 3. Listener cuando el usuario toca un botón de letra
                boton.setOnClickListener(v -> {
                    Casilla casillaTocada = new Casilla(f, c);
                    boolean exito = palabraActual.agregarCasilla(casillaTocada, letra);

                    if (exito) {
                        // Actualizamos el TextView con la palabra en construcción
                        tvPalabraActual.setText("Palabra: " + palabraActual.getTexto());
                        // Opcional: marcar visualmente el botón (ej. cambiar color)
                        boton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    }
                });
            }
        }

        // 4. Botón Enviar Palabra
        btnEnviarPalabra.setOnClickListener(v -> {
            if (palabraActual.tieneLongitudMinima()) {
                String palabraTerminada = palabraActual.getTexto();

                // Mostramos un mensajito temporal (Toast) indicando que se guardó
                Toast.makeText(this, "¡Palabra guardada: " + palabraTerminada + "!", Toast.LENGTH_SHORT).show();

                // Limpiamos para la siguiente palabra
                palabraActual.limpiar();
                tvPalabraActual.setText("Palabra: ");

                // Restauramos el aspecto de todos los botones de la grilla
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        String idName = "btn_" + i + "_" + j;
                        int id = getResources().getIdentifier(idName, "id", getPackageName());
                        Button b = findViewById(id);
                        b.setBackgroundResource(android.R.drawable.btn_default);
                    }
                }
            } else {
                Toast.makeText(this, "La palabra debe tener al menos 3 letras", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
