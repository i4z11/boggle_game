package com.example.boggle;

import java.util.ArrayList;
import java.util.List;

public class Palabra {
    private StringBuilder texto;
    private List<Casilla> recorrido;
    private boolean esValida;

    public Palabra() {
        this.texto = new StringBuilder();
        this.recorrido = new ArrayList<>();
        this.esValida = true;
    }

    /**
     * Intenta agregar una nueva casilla a la palabra siguiendo las reglas del Boggle.
     */
    public boolean agregarCasilla(Casilla nuevaCasilla, char letra) {
        // 1. Regla: No repetir una casilla ya usada dentro de la misma palabra
        if (recorrido.contains(nuevaCasilla)) {
            return false;
        }

        // 2. Regla: Si ya hay letras, la nueva casilla debe ser vecina de la última tocada
        if (!recorrido.isEmpty()) {
            Casilla ultimaCasilla = recorrido.get(recorrido.size() - 1);
            if (!ultimaCasilla.esVecina(nuevaCasilla)) {
                return false;
            }
        }

        // 3. Si pasa todo, la agregamos al recorrido y sumamos la letra
        recorrido.add(nuevaCasilla);
        texto.append(letra);
        return true;
    }

    /**
     * Regla: Mínimo 3 letras.
     */
    public boolean tieneLongitudMinima() {
        return texto.length() >= 3;
    }

    public String getTexto() {
        return texto.toString();
    }

    public boolean isEsValida() {
        return esValida;
    }

    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    public void limpiar() {
        texto.setLength(0);
        recorrido.clear();
    }
}
