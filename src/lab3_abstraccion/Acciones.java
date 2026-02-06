
package lab3_abstraccion;

public class Acciones {
    private int movimientosRealizados;
    private int parejasDescubiertas;
    private long tiempoInicio;
    private long tiempoFin;
    
    public Acciones() {
        this.movimientosRealizados = 0;
        this.parejasDescubiertas = 0;
        this.tiempoInicio = 0;
        this.tiempoFin = 0;
    }
    
    
 
    public void iniciarTiempo() {
        this.tiempoInicio = System.currentTimeMillis();

    }
    
 
    public void finalizarTiempo() {
        this.tiempoFin = System.currentTimeMillis();

    }
    

    public long calcularTiempoTranscurrido() {
        if (tiempoInicio == 0) {
            return 0;
        }
        
        long tiempoActual = (tiempoFin == 0) ? System.currentTimeMillis() : tiempoFin;
        return (tiempoActual - tiempoInicio) / 1000; 
    }
    

    public void registrarMovimiento() {
        this.movimientosRealizados++;

    }
    

    public void registrarParejaDescubierta() {
        this.parejasDescubiertas++;

    }
    

    public boolean validarPareja(Cartas carta1, Cartas carta2) {
        try {
          
     
            if (carta1 == carta2) {
              
                return false;
            }
            
       
            if (carta1.estaEmparejada() || carta2.estaEmparejada()) {
      
                return false;
            }
            

            return carta1.getId().equals(carta2.getId());
            
        } catch (NullPointerException e) {
        
            return false;
        }
    }
    

    public void voltearCarta(Cartas carta) {
      
            if (!carta.estaDescubierta()) {
       carta.mostrar();
          } else {
        carta.ocultar();
    
          
        }
    }
    

    public void mostrarCarta(Cartas carta) {
            carta.mostrar();
    }
    
   
    public void ocultarCarta(Cartas carta) {
        
            if (!carta.estaEmparejada()) {
                carta.ocultar();
            
            }
    }
    

    public void emparejarCartas(Cartas carta1, Cartas carta2) {
  
            
            if (validarPareja(carta1, carta2)) {
                carta1.marcarComoEmparejada();
                carta2.marcarComoEmparejada();
                registrarParejaDescubierta();
    
            }
            
     
    }

 

    public void reiniciar() {
        this.movimientosRealizados = 0;
        this.parejasDescubiertas = 0;
        this.tiempoInicio = 0;
        this.tiempoFin = 0;
   
    }
    

    public int getMovimientosRealizados() {
        return movimientosRealizados;
    }
    
    public int getParejasDescubiertas() {
        return parejasDescubiertas;
    }
    
   
    

    public boolean validarAccion(String tipoAccion, Object... parametros) {
        try {
            switch (tipoAccion.toLowerCase()) {
                case "voltear":
                    if (parametros.length > 0 && parametros[0] instanceof Cartas) {
                        Cartas carta = (Cartas) parametros[0];
                        return !carta.estaEmparejada() && !carta.estaDescubierta();
                    }
                    return false;
                    
                case "emparejar":
                    if (parametros.length >= 2 && 
                        parametros[0] instanceof Cartas && 
                        parametros[1] instanceof Cartas) {
                        return validarPareja((Cartas) parametros[0], (Cartas) parametros[1]);
                    }
                    return false;
                    
                case "iniciar":
                    return tiempoInicio == 0;
                    
                case "finalizar":
                    return tiempoInicio != 0 && tiempoFin == 0;
                    
                
            }
        } catch (Exception e) {
        
        }     return false;
    }    
    
}
