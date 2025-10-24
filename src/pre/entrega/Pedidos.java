package pre.entrega;

public class Pedidos {

    private Producto producto;
    private int cantidad;
    private int id;
    private static int count = 1;

    public Pedidos(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        id = count++;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
     public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        if (producto instanceof Articulo) {
            return producto.calcularDescuento() * cantidad;
        }
        if (producto instanceof Servicio) {
            return producto.calcularDescuento() * cantidad;
        }
        return producto.getPrecio() * cantidad;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x " + cantidad + " = $" + getSubtotal();
    }
}
