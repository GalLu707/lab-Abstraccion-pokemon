
package lab3_abstraccion;



import java.util.*;

public class Tablero {

    private Cartas[][] cartas;
    private int filas, columnas;
    private int parejasEncontradas;
    private int totalParejas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cartas = new Cartas[filas][columnas];
        this.totalParejas = (filas * columnas) / 2;
    }

    public void setCarta(int f, int c, Cartas carta) {
        cartas[f][c] = carta;
    }

    public Cartas getCarta(int f, int c) {
        return cartas[f][c];
    }

    public void incrementarParejasEncontradas() {
        parejasEncontradas++;
    }

    public boolean juegoCompletado() {
        return parejasEncontradas == totalParejas;
    }
}