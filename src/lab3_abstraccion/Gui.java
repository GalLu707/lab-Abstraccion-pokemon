/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstraccion;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Gui extends JFrame implements Acciones{
    
    private Cartas[] cartas = new Cartas[36];
    private Jugadores j1, j2;
    private int turnoActu = 1;
    
    public void cargarCartas(){
        try{
            ArrayList<String> imagenes = new ArrayList<>();
            
            for (int i = 0; i < 18; i++) {
                imagenes.add("/Imagenes/" + i + ".png");
                imagenes.add("/Imagenes/" + i + ".png");
                
            }
            Collections.shuffle(imagenes);
            
            for(int i =0; i<=18; i++){
                cartas[i]= new CartaMemoria(imagenes.get(i));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "error al cargar Imagen"+ e.getMessage());
        }
    }
    public void VerificarPareja(int p1, int p2){
        
        
        if (cartas[p1].getId().equals(cartas[p2].getId())) {
            
            if(turnoActu == 1){
                j1.incrementarAcierto();
            }else {
                j2.incrementarAcierto();
            }
        }else{
            
            //cc
            
            cartas[p1].ocultar();
            cartas[p2].ocultar();
            
            cambiarTurno();
        } 
        
    }
  
    public void iniciarPartida(){
        //cc2
         turnoActu = 1;
    }
    public void cambiarTurno(){
        
        turnoActu = (turnoActu==1)?2:1;
        
    }
    public void finalizarPartida(){
        JOptionPane.showMessageDialog(this,
                "Juego terminado\n" +
                j1.getNombre() + ": " + j1.getAciertos() + "\n" +
                j2.getNombre() + ": " + j2.getAciertos());
    }
    
    
    
}

class CartaMemoria extends Cartas{

    public CartaMemoria(String ruta){
        super(ruta);
    }
    @Override
    public void mostrar(){
        this.descubierta = true;
    }
    
    @Override
    public void ocultar(){
        this.descubierta=false;
    }
    
}