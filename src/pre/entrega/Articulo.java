package pre.entrega;

public class Articulo extends Producto {

    private Categorias categoria; 
   

    public Articulo(String nombre, double precio, Categorias categoria, int stock) { 
        super(nombre, precio, stock);        
        this.categoria = categoria; 
       
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) { 
        this.categoria = categoria;
    }

    
    @Override
    public double calcularDescuento() { 
        return getPrecio() * 0.90;      
    }

    @Override
    public String toString() {        
        return super.toString() + " || Categoria = " + (categoria != null ? categoria.getNombre() : "Sin categoria");
    }
}
