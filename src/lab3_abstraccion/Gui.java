package lab3_abstraccion;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Gui extends JFrame{
    
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

    
    
    
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    
    public Gui() {
        solicitarNombresJugadores();
        inicializarLabels();
    }
    
    private void solicitarNombresJugadores() {
        
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        JLabel label1 = new JLabel("Nombre Jugador 1:");
        JTextField txtJugador1 = new JTextField(15);
        
        JLabel label2 = new JLabel("Nombre Jugador 2:");
        JTextField txtJugador2 = new JTextField(15);
        
        panel.add(label1);
        panel.add(txtJugador1);
        panel.add(label2);
        panel.add(txtJugador2);
        
        int resultado = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Ingrese los nombres de los jugadores",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );
        
        if (resultado == JOptionPane.OK_OPTION) {
            String nombre1 = txtJugador1.getText().trim();
            String nombre2 = txtJugador2.getText().trim();
            
            if (nombre1.isEmpty() || nombre2.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Ambos jugadores deben tener un nombre",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                solicitarNombresJugadores();
            } else {
                j1 = new Jugadores(nombre1);
                j2 = new Jugadores(nombre2);
            }
        } else {
            System.exit(0);
        }
    }
    
    private void inicializarLabels() {
        
        lblJugador1 = new JLabel("Jugador 1: " + j1.getNombre());
        lblJugador2 = new JLabel("Jugador 2: " + j2.getNombre());
        
    }
    
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