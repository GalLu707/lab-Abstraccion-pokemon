/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstraccion;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Gui extends JFrame implements Acciones {
    private Cartas[] cartas = new Cartas[36];
    private Jugadores j1, j2;
    private int turnoActu = 1;
    
    public void cargarCartas(){
        try{
            ArrayList<String> imagenes = new ArrayList<>();
            for (int i = 0; i < 18; i++) {
                imagenes.add("");
                imagenes.add("");
                
            }
            Collections.shuffle(imagenes);
            
            for(int i =1; i<=18; i++){
                cartas[i]= new CartaMemoria(imagenes.get(i));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "error al cargar Imagen"+ e.getMessage());
        }
    }
    public void VerificarPareja(int p1, int p2){
        
        
        if (cartas[p1].imagenRuta.equals(cartas[p2].imagenRuta)) {
            
            if(turnoActual == 1){
                j1.sumarAcierto();
            }else {
                j2.sumaAciertos();
            }
        }else{
            cambiarTurno();
        } 
        
    }
  
    public void iniciarPartida(){
        
    }
    public void cambiarTurno(){
        
        turnoActu = (turnoActu==1)?2:1;
        
    }
    public void finalizarPartida(){
        
    }
    
    
    
}
