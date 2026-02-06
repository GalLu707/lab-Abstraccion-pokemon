
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
        inicializarCartas();
    }

    private void inicializarCartas() {

        String[] imagenes = {
            "/Imagenes/0.png", "/Imagenes/1.png", "/Imagenes/2.png",
            "/Imagenes/3.png", "/Imagenes/4.png", "/Imagenes/5.png",
            "/Imagenes/6.png", "/Imagenes/7.png", "/Imagenes/8.png",
            "/Imagenes/9.png", "/Imagenes/10.png", "/Imagenes/11.png",
            "/Imagenes/12.png", "/Imagenes/13.png", "/Imagenes/14.png",
            "/Imagenes/15.png", "/Imagenes/16.png", "/Imagenes/17.png"
        };

        List<Cartas> lista = new ArrayList<>();

        for (int i = 0; i < totalParejas; i++) {
            String id = "C" + i;
            lista.add(new CartaMemoria(id, imagenes[i]));
            lista.add(new CartaMemoria(id, imagenes[i]));
        }

        Collections.shuffle(lista);

        int index = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                cartas[f][c] = lista.get(index++);
            }
        }
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

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}