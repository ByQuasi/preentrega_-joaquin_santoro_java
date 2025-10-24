package pre.entrega;

public class Servicio extends Producto {

    private double duracionHoras;  
    public Servicio(String nombre, double precio, double duracionHoras, int stock) { 
        super(nombre, precio, stock);         
        this.duracionHoras = duracionHoras; 
    }

    public double getDuracionHoras() {   
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) { 
        this.duracionHoras = duracionHoras;
    }

    @Override
    public double calcularDescuento() { 
        return getPrecio() * 0.80;      
    }

    @Override
    public String toString() {          
        return super.toString() + " || [Duracion = " + duracionHoras + "hs]";
    }
}
