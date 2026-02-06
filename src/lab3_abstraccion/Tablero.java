
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


    private void inicializarCartas() {

     
        String[] imagenes = {
            "/imagenes/0.png",
             "/imagenes/1.png",
            "/imagenes/2.png",
            "/imagenes/3.png",
            "/imagenes/4.png",
            "/imagenes/5.png",
            "/imagenes/6.png",
            "/imagenes/7.png",
            "/imagenes/8.png",
            "/imagenes/9.png",
            "/imagenes/10.png",
            "/imagenes/11.png",
            "/imagenes/12.png",
            "/imagenes/13.png",
            "/imagenes/14.png",
            "/imagenes/15.png",
            "/imagenes/16.png",
            "/imagenes/17.png"
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