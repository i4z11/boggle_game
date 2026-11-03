package com.example.boggle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tablero {
    private char[][] grilla;
    private static final int TAMANIO = 4;

    // Los 16 dados adaptados para español con buena proporción de vocales y consonantes comunes
    private static final String[] DADOS = {
        "AAEEGN", "ELRTTI", "AOOTTC", "ABBJOO",
        "EHRFVS", "HIMNQU", "DISTTE", "EIISTT",
        "ACIOMT", "EZAVNL", "IOMTTS", "EEFHIE",
        "CIMOTU", "COPSHA", "DELRVO", "ACHOPS"
    };

    public Tablero() {
        grilla = new char[TAMANIO][TAMANIO];
        generarTableroAlAzar();
    }

    /**
     * Simula el "agitado" de los 16 dados de Boggle y selecciona una letra al azar de cada uno.
     */
    public void generarTableroAlAzar() {
        List<String> listaDados = new ArrayList<>();
        for (String dado : DADOS) {
            listaDados.add(dado);
        }
        
        // "Agitamos" los dados cambiando su orden al azar
        Collections.shuffle(listaDados);
        
        Random random = new Random();
        int indiceDado = 0;
        
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int col = 0; col < TAMANIO; col++) {
                String dadoActual = listaDados.get(indiceDado);
                indiceDado++;
                
                // Elegimos una de las 6 caras del dado al azar (0 a 5)
                int caraAleatoria = random.nextInt(6);
                grilla[fila][col] = dadoActual.charAt(caraAleatoria);
            }
        }
    }

    /**
     * Devuelve la letra ubicada en una posición específica del tablero.
     */
    public char obtenerLetra(int fila, int columna) {
        if (fila >= 0 && fila < TAMANIO && columna >= 0 && columna < TAMANIO) {
            return grilla[fila][columna];
        }
        return ' ';
    }

    /**
     * Devuelve la matriz completa de letras.
     */
    public char[][] getGrilla() {
        return grilla;
    }
}
