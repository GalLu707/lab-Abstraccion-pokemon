package lab3_abstraccion;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CartaMemoria extends Cartas {

    private String rutaImagen;

    private JButton boton;
    public CartaMemoria(String id, String rutaImagen) {
        super(id);
        this.rutaImagen = rutaImagen;
        this.boton= boton;
    }

    @Override
    public void mostrar() {
        descubierta = true;
        boton.setIcon(new ImageIcon(getClass().getResource(rutaImagen)));
    }

    @Override
    public void ocultar() {
        descubierta = false;
        boton.setIcon(null);
    }

   
}