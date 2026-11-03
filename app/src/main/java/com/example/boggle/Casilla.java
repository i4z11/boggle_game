package com.example.boggle;

public class Casilla {

    int fila;
    int col;
    public Casilla(int fila, int col) {
        this.fila = fila;
        this.col = col;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Casilla casilla = (Casilla) obj;
        return fila == casilla.fila && col == casilla.col;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fila, col);
    }
    public boolean esVecina(Casilla otra){
        int difFila = Math.abs(this.fila - otra.fila);
        int difCol = Math.abs(this.col - otra.col);

        // Deben estar a 1 paso o menos en fila y columna,
        // y no ser exactamente la misma casilla (diffFila y diffCol no pueden ser 0 al mismo tiempo)
        boolean esAdyacente = difFila <= 1 && difCol <= 1;
        boolean esMismaCasilla = (difFila == 0 && difCol == 0);

        return esAdyacente && !esMismaCasilla;

    }

}
