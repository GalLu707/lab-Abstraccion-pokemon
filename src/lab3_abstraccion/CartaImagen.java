package lab3_abstraccion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;

public class CartaImagen extends Cartas {

   
    private JButton boton;
    private ImageIcon imagenFrontal;
    private ImageIcon imagenTrasera;

    public CartaImagen(String rutaImagen, JButton boton) {
        super(rutaImagen); 
        this.boton = boton;

        this.imagenFrontal = escalarImagen(new ImageIcon(rutaImagen));
        this.imagenTrasera = escalarImagen(new ImageIcon("src/img/back.png"));

        ocultar();
    }

    @Override
    public void mostrar() {
        this.descubierta = true;
        this.boton.setIcon(imagenFrontal);
        this.boton.setEnabled(false); 
    }

    @Override
    public void ocultar() {
        this.descubierta = false;
        this.boton.setIcon(imagenTrasera);
        this.boton.setEnabled(true);
    }

    private ImageIcon escalarImagen(ImageIcon icono) {
        Image img = icono.getImage();
       
        Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    public JButton getBoton() {
        return boton;
    }
}


