package lab3_abstraccion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame {
    
    private Cartas[] cartas = new Cartas[36];
    private Jugadores j1, j2;
    private int turnoActu = 1;
    private Acciones control = new Acciones();
    private JPanel panelTablero;
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JLabel lblTurno;
    private JLabel lblMensaje;
    private int primeraCartaSeleccionada = -1;
    private boolean esperando = false; 
    
    public Gui() {
        solicitarNombresJugadores();
        inicializarInterfaz();
    }
    
    private void inicializarInterfaz() {
        setTitle("Juego de Memoria");
        setSize(800, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
      
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));
        
  
        JPanel panelJugadores = new JPanel(new GridLayout(1, 2, 20, 0));
        lblJugador1 = new JLabel(j1.getNombre() + ": 0 aciertos", SwingConstants.CENTER);
        lblJugador1.setFont(new Font("Arial", Font.BOLD, 16));
        lblJugador1.setOpaque(true);
        lblJugador1.setBackground(Color.GREEN);
        lblJugador1.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        lblJugador2 = new JLabel(j2.getNombre() + ": 0 aciertos", SwingConstants.CENTER);
        lblJugador2.setFont(new Font("Arial", Font.BOLD, 16));
        lblJugador2.setOpaque(true);
        lblJugador2.setBackground(Color.LIGHT_GRAY);
        lblJugador2.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panelJugadores.add(lblJugador1);
        panelJugadores.add(lblJugador2);
        
   
        JPanel panelInfo = new JPanel(new GridLayout(2, 1, 5, 5));
        lblTurno = new JLabel("Turno: " + j1.getNombre(), SwingConstants.CENTER);
        lblTurno.setFont(new Font("Arial", Font.BOLD, 18));
        lblTurno.setForeground(Color.BLUE);
        
        lblMensaje = new JLabel("¡Selecciona dos cartas!", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.ITALIC, 14));
        lblMensaje.setForeground(Color.DARK_GRAY);
        
        panelInfo.add(lblTurno);
        panelInfo.add(lblMensaje);
        
        panelSuperior.add(panelJugadores, BorderLayout.NORTH);
        panelSuperior.add(panelInfo, BorderLayout.CENTER);
        
  
        panelTablero = new JPanel(new GridLayout(6, 6, 5, 5));
        panelTablero.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        add(panelSuperior, BorderLayout.NORTH);
        add(panelTablero, BorderLayout.CENTER);
        
        cargarCartas();
    }
    
   private void cargarCartas() {
    try {
        ArrayList<String> imagenes = new ArrayList<>();
        
    
        for (int i = 1; i <= 18; i++) {
       
            String rutaImagen = "/Imagenes/" + i + ".png";
            imagenes.add(rutaImagen);
            imagenes.add(rutaImagen);
        }
        Collections.shuffle(imagenes);
        
        
        for (int i = 0; i < 36; i++) {
            String ruta = imagenes.get(i);
            JButton boton = new JButton("?");
            boton.setFont(new Font("Arial", Font.BOLD, 24));
            boton.setPreferredSize(new java.awt.Dimension(100, 100));
        
            cartas[i] = new CartaImagen(ruta, boton);
            
            final int index = i;
            boton.addActionListener(e -> manejarClick(index));
            
            panelTablero.add(boton);
        }
        
        lblMensaje.setText("¡Juego listo! Selecciona la primera carta");

        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar el juego: " + e.getMessage());
        e.printStackTrace();
    }
}
    
    private void manejarClick(int index) {
    
    if (esperando) return;
    

    if (cartas[index].estaEmparejada()) {
        lblMensaje.setText("¡Esa carta ya está emparejada!");
        return;
    }
    

    if (cartas[index].estaDescubierta()) {
        lblMensaje.setText("¡Esa carta ya está visible!");
        return;
    }
    
 
    if (primeraCartaSeleccionada == index) {
        lblMensaje.setText("¡No puedes seleccionar la misma carta dos veces!");
        return;
    }
    
    if (primeraCartaSeleccionada == -1) {
   
        primeraCartaSeleccionada = index;
        cartas[index].mostrar();
        lblMensaje.setText("Primera carta seleccionada. Selecciona la segunda...");
    } else {
   
        esperando = true;
        cartas[index].mostrar();
        lblMensaje.setText("Verificando pareja...");
        
  
        panelTablero.revalidate();
        panelTablero.repaint();
        
   
        javax.swing.Timer timer = new javax.swing.Timer(1500, e -> {
            VerificarPareja(primeraCartaSeleccionada, index);
            primeraCartaSeleccionada = -1;
            esperando = false;
        });
        timer.setRepeats(false);
        timer.start();
    }
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
    
    public void VerificarPareja(int p1, int p2) {
        if (control.validarPareja(cartas[p1], cartas[p2])) {
    
            control.emparejarCartas(cartas[p1], cartas[p2]);
            
            if (turnoActu == 1) {
                j1.incrementarAcierto();
                lblJugador1.setText(j1.getNombre() + ": " + j1.getAciertos() + " aciertos");
                lblMensaje.setText(j1.getNombre() + "! Encontraste una pareja. Juega de nuevo.");
            } else {
                j2.incrementarAcierto();
                lblJugador2.setText(j2.getNombre() + ": " + j2.getAciertos() + " aciertos");
                lblMensaje.setText(j2.getNombre() + "! Encontraste una pareja. Juega de nuevo.");
            }
            

            if (juegoTerminado()) {
                finalizarPartida();
            }
            
        } else {
        
            lblMensaje.setText("No hay pareja. Las cartas se ocultarán...");
            
         
            javax.swing.Timer timer = new javax.swing.Timer(400, e -> {
                cartas[p1].ocultar();
                cartas[p2].ocultar();
                cambiarTurno();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    public void cambiarTurno() {
        turnoActu = (turnoActu == 1) ? 2 : 1;
        
   
        if (turnoActu == 1) {
            lblTurno.setText("Turno: " + j1.getNombre());
            lblJugador1.setBackground(Color.GREEN);
            lblJugador2.setBackground(Color.LIGHT_GRAY);
            lblMensaje.setText("Turno de " + j1.getNombre() + ". Selecciona dos cartas.");
        } else {
            lblTurno.setText("Turno: " + j2.getNombre());
            lblJugador1.setBackground(Color.LIGHT_GRAY);
            lblJugador2.setBackground(Color.GREEN);
            lblMensaje.setText("Turno de " + j2.getNombre() + ". Selecciona dos cartas.");
        }
    }
    
    private boolean juegoTerminado() {
        for (Cartas carta : cartas) {
            if (!carta.estaEmparejada()) {
                return false;
            }
        }
        return true;
    }
    
    public void finalizarPartida() {
        String ganador;
        if (j1.getAciertos() > j2.getAciertos()) {
            ganador = j1.getNombre() + " GANA!";
        } else if (j2.getAciertos() > j1.getAciertos()) {
            ganador = j2.getNombre() + " GANA!";
        } else {
            ganador = "¡EMPATE!";
        }
        
        JOptionPane.showMessageDialog(this,
                "¡Juego terminado!\n\n" +
                j1.getNombre() + ": " + j1.getAciertos() + " aciertos\n" +
                j2.getNombre() + ": " + j2.getAciertos() + " aciertos\n\n" +
                ganador);
    }
}