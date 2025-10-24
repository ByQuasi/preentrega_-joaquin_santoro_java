package pre.entrega;

import java.util.ArrayList;

public class CrudPedidos extends CrudConsola<Pedidos> {

    private int id;

    private ArrayList<Pedidos> pedidosTotales;
    private Producto produc;
    private CrudProducto prod;
    private ArrayList<Producto> productos;
    private static int count = 1;

    public CrudPedidos(CrudProducto prod) {
        this.id = count++;
        this.pedidosTotales = new ArrayList<>();
        this.prod = prod;
    }

    @Override
    public void crear() {
        prod.leer();
        System.out.print("ID del producto: ");
        int id = leerInt();
        productos = prod.getProductos();
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.toString();
                System.out.println("¿Desea agregar?");
                System.out.println("1) Si");
                System.out.println("2) No");
                int aux = leerInt();
                if (aux == 1) {
                    System.out.println("Indique cantidad: ");
                    int cant = leerInt();
                    if (cant > p.getStock()) {
                        System.out.println("No hay suficientes, solo hay " + p.getStock());
                        return;
                    }
                    pedidosTotales.add(new Pedidos(p, cant));
                    p.setStock(p.getStock() - cant);
                    System.out.println("Pedido creado!");
                    return;
                }
            }
        }
        System.out.println("No existe ID.");

    }

    @Override
    public void leer() {
        if (pedidosTotales.isEmpty()) {
            System.out.println("Sin pedidos");
        } else {
            for (Pedidos p : pedidosTotales) {
                System.out.println(p + " " + p.getId());
            }
        }
    }

    @Override
    public void actualizar() {
        System.out.print("ID del pedido: ");
        int id = leerInt();
        for (Pedidos p : pedidosTotales) {
            if (id == p.getId()) {
                p.toString();
                System.out.println("¿Desea agregar o sacar?");
                System.out.println("1) Agregar");
                System.out.println("2) Sacar");
                int aux = leerInt();
                switch (aux) {
                    case 1:
                        System.out.print("Ingrese cantidad a agregar: ");
                        aux = leerInt();
                        produc = p.getProducto();
                        if (produc.getStock() < aux) {
                            System.out.println("No hay suficiente stock, solo hay " + produc.getStock());
                            return;
                        }
                        p.setCantidad(p.getCantidad() + aux);
                        produc = p.getProducto();
                        produc.setStock(produc.getStock() - aux);
                        break;

                    case 2:
                        System.out.print("Ingrese cantidad a restar: ");
                        aux = leerInt();
                        if (aux > p.getCantidad()) {
                            System.out.println("No podes restar mas de lo que tenias");
                            return;
                        }
                        p.setCantidad(p.getCantidad() - aux);
                        produc = p.getProducto();
                        produc.setStock(produc.getStock() + aux);
                        break;

                }
                System.out.println("Actualizado!");
                return;
            }
        }
        System.out.println("No se encontro pedido.");

    }

    @Override
    public void borrar() {
        System.out.print("ID del pedido a eliminar: ");
        int id = leerInt();
        for (Pedidos p : pedidosTotales) {
            if (id == p.getId()) {
                p.toString();
                System.out.println("¿Desea eliminar?");
                System.out.println("1) Si");
                System.out.println("2) No");
                int aux = leerInt();
                switch (aux) {
                    case 1:
                        produc = p.getProducto();
                        produc.setStock(produc.getStock() + p.getCantidad());
                        pedidosTotales.remove(p);
                        System.out.println("Eliminado con exito!");
                        return;
                    case 2:
                        System.out.println("Volviendo... ");
                        return;
                }

            }

        }
        System.out.println("No existe Pedido");
    }
}
