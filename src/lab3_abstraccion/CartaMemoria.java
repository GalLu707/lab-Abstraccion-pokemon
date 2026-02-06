package lab3_abstraccion;

public class CartaMemoria extends Cartas {

    private String rutaImagen;

    public CartaMemoria(String id, String rutaImagen) {
        super(id);
        this.rutaImagen = rutaImagen;
    }

    @Override
    public void mostrar() {
        descubierta = true;
    }

    @Override
    public void ocultar() {
        descubierta = false;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}