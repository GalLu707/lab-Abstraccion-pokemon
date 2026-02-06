package lab3_abstraccion;


public abstract class Cartas {

    protected String id;
    protected boolean descubierta;
    protected boolean emparejada;

    public Cartas(String id) {
        this.id = id;
        this.descubierta = false;
        this.emparejada = false;
    }

    public abstract void mostrar();
    public abstract void ocultar();

    public void marcarComoEmparejada() {
        emparejada = true;
        descubierta = true;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public boolean estaEmparejada() {
        return emparejada;
    }

    public String getId() {
        return id;
    }
}