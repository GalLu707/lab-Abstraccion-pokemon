package lab3_abstraccion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CartaImagen extends Cartas {
   
    private JButton boton;
    private ImageIcon imagenFrontal;
    private ImageIcon imagenTrasera;
    
    public CartaImagen(String rutaImagen, JButton boton) {
        super(rutaImagen); 
        this.boton = boton;
        

        this.boton.setFocusPainted(false);
        this.boton.setBorderPainted(true);
        this.boton.setContentAreaFilled(true);
        
       
    
            URL urlFrontal = getClass().getResource(rutaImagen);
            if (urlFrontal != null) {
                this.imagenFrontal = escalarImagen(new ImageIcon(urlFrontal));
            
        
     
        this.imagenTrasera = crearImagenTrasera();
        
        ocultar();
    }}
    
    @Override
    public void mostrar() {
        this.descubierta = true;
        this.boton.setIcon(imagenFrontal);
        this.boton.setText("");
        this.boton.setEnabled(true); 
        this.boton.setDisabledIcon(imagenFrontal); 
        this.boton.setBorderPainted(true);
    }
    
    @Override
    public void ocultar() {
        this.descubierta = false;
        this.boton.setIcon(imagenTrasera);
        this.boton.setText("");
        this.boton.setEnabled(true);
        this.boton.setDisabledIcon(imagenTrasera);
        this.boton.setBorderPainted(true);
    }
    
    private ImageIcon escalarImagen(ImageIcon icono) {
        if (icono == null) return null;
        Image img = icono.getImage();
        Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    
  private ImageIcon crearImagenTrasera() {
    ImageIcon icon = new ImageIcon(
        getClass().getResource("/imagenes/0.png")
    );
    Image img = icon.getImage().getScaledInstance(
        120, 120, Image.SCALE_SMOOTH
    );

    return new ImageIcon(img);
}

    
  
    public JButton getBoton() {
        return boton;
    }
}