package lab3_abstraccion;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class CartaTexto extends Cartas {
    
    private JButton boton;
    private String textoFrontal;
    
    public CartaTexto(String id, JButton boton, String textoFrontal) {
        super(id);
        this.boton = boton;
        this.textoFrontal = textoFrontal;
        ocultar();
    }
    
    @Override
    public void mostrar() {
        this.descubierta = true;
        this.boton.setText(textoFrontal);
        this.boton.setFont(new Font("Arial", Font.BOLD, 20));
        this.boton.setBackground(Color.CYAN);
        this.boton.setEnabled(false);
    }
    
    @Override
    public void ocultar() {
        this.descubierta = false;
        this.boton.setText("?");
        this.boton.setFont(new Font("Arial", Font.BOLD, 24));
        this.boton.setBackground(null);
        this.boton.setEnabled(true);
    }
}