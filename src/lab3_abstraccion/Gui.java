/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstraccion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Gui extends JFrame {
    private Cartas[] cartas = new Cartas[36];
    private Jugadores j1, j2;
    private int turnoActu = 1;
    private Acciones control = new Acciones();
   
    private JPanel panelTablero;

    public JFrame Gui() {

        JFrame panel = new JFrame();
        panel.setTitle("Juego de Memoria");
        panel.setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLocationRelativeTo(null);
       JPanel panelInfo = new JPanel(new GridLayout(1,2));
       panelInfo.add(new JLabel ("jugador 1 : 0 aciertos"));
         panelInfo.add(new JLabel ("jugador 2 : 0 aciertos"));
        
         add(panelInfo, BorderLayout.NORTH);
         
         
         panelTablero = new JPanel(new GridLayout(6,6,5,5));
         cargarCartas();
         add(panelTablero);
panel.add(panelInfo);
        panel.setVisible(true);
        return panel;
    }

    
    
    public void cargarCartas(){
        try{
            ArrayList<String> imagenes = new ArrayList<>();
            for (int i = 0; i < 18; i++) {
                imagenes.add("src/Imagenes"+i+".png");
                imagenes.add("src/Imagenes"+i+".png");
                
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
        
        if(control.validarPareja(cartas[p1], cartas[p2])){
            control.emparejarCartas(cartas[p1], cartas[p2]);
            if(turnoActu ==1){
                j1.incrementarAcierto();
            }else{
                j2.incrementarAcierto();
            }
        }else{
            control.ocultarCarta(cartas[p1]);
            control.ocultarCarta(cartas[p2]);
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