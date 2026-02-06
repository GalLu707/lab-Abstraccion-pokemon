
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
        System.out.println("Tiempo iniciado");
    }
    
    public void finalizarTiempo() {
        this.tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo finalizado");
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
        System.out.println("Movimientos realizados: " + movimientosRealizados);
    }
     
     public void registrarParejaDescubierta() {
        this.parejasDescubiertas++;
        System.out.println("Parejas descubiertas: " + parejasDescubiertas);
    }
      
      public boolean validarPareja(Cartas carta1, Cartas carta2) {
        try {
        
            if (carta1 == null || carta2 == null) {
                throw new NullPointerException("Las cartas no pueden ser nulas");
            }
       if (carta1 == carta2) {
                System.out.println("No se puede seleccionar la misma carta dos veces");
                return false;
            }
       
       if (carta1.estaEmparejada() || carta2.estaEmparejada()) {
                System.out.println("Una o ambas cartas ya están emparejadas");
                return false;
            }
       
        return carta1.getId().equals(carta2.getId());
            
        } catch (NullPointerException e) {
            System.err.println("Error al validar pareja: " + e.getMessage());
            return false;
        }
    }
      
      public void voltearCarta(Cartas carta) {
        try {
            if (carta == null) {
                throw new NullPointerException("La carta no puede ser nula");
            }
            
            if (carta.estaEmparejada()) {
                System.out.println("La carta ya está emparejada, no se puede voltear");
                return;
            }
            carta.voltear();
            System.out.println("Carta volteada: " + carta.getId());
            
        } catch (NullPointerException e) {
            System.err.println("Error al voltear carta: " + e.getMessage());
        }
    }
      
       public void mostrarCarta(Cartas carta) {
        try {
            if (carta == null) {
                throw new NullPointerException("La carta no puede ser nula");
            }
            
            carta.mostrar();
            System.out.println("Mostrando carta: " + carta.getId());
            
        } catch (NullPointerException e) {
            System.err.println("Error al mostrar carta: " + e.getMessage());
        }
    }
       
    public void ocultarCarta(Cartas carta) {
        try {
            if (carta == null) {
                throw new NullPointerException("La carta no puede ser nula");
            }
            
            if (!carta.estaEmparejada()) {
                carta.ocultar();
                System.out.println("Ocultando carta: " + carta.getId());
            }
            
        } catch (NullPointerException e) {
            System.err.println("Error al ocultar carta: " + e.getMessage());
        }
    }
           public void emparejarCartas(Cartas carta1, Cartas carta2) {
        try {
            if (carta1 == null || carta2 == null) {
                throw new NullPointerException("Las cartas no pueden ser nulas");
            }
            
            if (validarPareja(carta1, carta2)) {
                carta1.marcarComoEmparejada();
                carta2.marcarComoEmparejada();
                registrarParejaDescubierta();
                System.out.println("¡Pareja emparejada exitosamente!");
            } else {
                System.out.println("Las cartas no forman una pareja válida");
            }
            
        } catch (NullPointerException e) {
            System.err.println("Error al emparejar cartas: " + e.getMessage());
        }
        
    }
           
           
           
       public int getMovimientosRealizados() {
        return movimientosRealizados;
    }     
       
       
       public int getParejasDescubiertas() {
        return parejasDescubiertas;
    }
}
