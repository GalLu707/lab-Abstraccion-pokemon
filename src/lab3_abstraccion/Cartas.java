package lab3_abstraccion;

public abstract class Cartas {
    
    protected String id;
    protected boolean descubierta;
    protected boolean emparejada;
    //protected JButton boton;
    
    
    public Cartas(String id){
        this.id=id;
        this.descubierta = false;
        this.emparejada= false;
        
    }
    
    
    public abstract void mostrar();
    public abstract void ocultar();
    
    public void marcarComoEmparejada() {
        this.emparejada = true;
        this.descubierta = true;
    }
    
    public boolean estaDescubierta(){
        return descubierta;
    }
    
     public boolean estaEmparejada() {
        return emparejada;
    }
    
    public String getId() {
        return id;
    }
    
    /* public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    public JButton getBoton() {
        return boton;
    }*/
    
    public void voltear() {
        if (!emparejada) {
            descubierta = !descubierta;
            if (descubierta) {
                mostrar();
            } else {
                ocultar();
            }
        }
    }
}
