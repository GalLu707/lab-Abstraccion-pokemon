/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstraccion;

/**
 *
 * @author USER
 */
public class Jugadores {
    
    private String nombre;
    private int aciertos;

    public Jugadores(String nombre) {
        this.nombre = nombre;
        this.aciertos = 0;
    }

    
    public void incrementarAcierto() {
        this.aciertos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }
    
    @Override
    public String toString() {
        return nombre + " - Aciertos: " + aciertos;
    }

    
}
