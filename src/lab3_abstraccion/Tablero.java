
package lab3_abstraccion;

import java.awt.*;
import java.util.*;
import java.util.List;



public class Tablero {

    private Cartas[][] cartas;
    private int filas;
    private int columnas;
    private int parejasEncontradas;
    private int totalParejas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cartas = new Cartas[filas][columnas];
        this.parejasEncontradas = 0;
        this.totalParejas = (filas * columnas) / 2;
        inicializarCartas();
    }

    private void inicializarCartas() {

     
        String[] imagenes = {
            "/imagenes/img1.png",
            "/imagenes/img2.png",
            "/imagenes/img3.png",
            "/imagenes/img4.png",
            "/imagenes/img5.png",
            "/imagenes/img6.png",
            "/imagenes/img7.png",
            "/imagenes/img8.png",
            "/imagenes/img9.png",
            "/imagenes/img10.png",
            "/imagenes/img11.png",
            "/imagenes/img12.png"
        };

        List<Cartas> listaCartas = new ArrayList<>();

        // Crear parejas de cartas con la misma imagen
        for (int i = 0; i < totalParejas; i++) {
            String id = String.valueOf((char) ('A' + i));
            String rutaImagen = imagenes[i];

            listaCartas.add(new CartaImagen(id, rutaImagen));
            listaCartas.add(new CartaImagen(id, rutaImagen));
        }

    
        Collections.shuffle(listaCartas);

   
        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cartas[i][j] = listaCartas.get(indice++);
            }
        }
    }

    public Cartas getCarta(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.err.println("Índice fuera de rango");
            return null;
        }
        return cartas[fila][columna];
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

    public int getParejasEncontradas() {
        return parejasEncontradas;
    }

    public int getTotalParejas() {
        return totalParejas;
    }
}