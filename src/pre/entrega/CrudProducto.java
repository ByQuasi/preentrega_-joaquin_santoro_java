
package pre.entrega;

import java.util.ArrayList;

public class CrudProducto extends CrudConsola<Producto> {

    private final ArrayList<Producto> productos;
    private final ArrayList<Categorias> categorias;

    public CrudProducto(ArrayList<Producto> productos, ArrayList<Categorias> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    @Override
    public void crear() {
        System.out.print("Nombre: ");
        String nombre = leerString();
        System.out.print("Precio: ");
        double precio = leerDouble();

        int stock = -1;
        do {
            System.out.print("Stock: ");
            stock = leerInt();

            if (stock < 0) {
                System.out.println("No podes tener un stock negativo");
            }
        } while (stock < 0);

        System.out.println("¿Es servicio?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int opcioon = leerInt();
        switch (opcioon) {
            case 1: System.out.print("Indique cantidad de horas: ");
                    double horas = leerDouble();
                    productos.add(new Servicio(nombre, precio, horas, stock));   
                    System.out.println("Servicio creado.");
                break;
            case 2:
                if (categorias.isEmpty()) {
                    System.out.println("Crea una categoria primero.");
                    return;
                }
                System.out.println("Categorias:");
                for (Categorias c : categorias) {
                    System.out.println(c.getId() + ") " + c.getNombre());
                }
                System.out.print("Elegi ID de categoria: ");
                int id = leerInt();
                Categorias seleccionada = null;
                for (Categorias c : categorias) {
                    if (c.getId() == id) {
                        seleccionada = c;
                        break;
                    }
                }
                if (seleccionada != null) {
                    productos.add(new Articulo(nombre, precio, seleccionada, stock));
                    System.out.println("Articulo creado.");
                } else {
                    System.out.println("Categoria inválida.");
                }
                break;

        }

    }

    @Override
    public void leer() {
        if (productos.isEmpty()) {
            System.out.println("Sin productos!!");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void actualizar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }
        System.out.print("ID del producto: ");
        int id = leerInt();
        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = leerString();
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = leerDouble();
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);
                if (p instanceof Servicio) {
                    System.out.println("¿Cambiar la duracion?");
                    System.out.println("1) Si");
                    System.out.println("2) No");
                    System.out.println("Opción: ");
                    int cam = leerInt();
                    if (cam == 1) {
                        System.out.print("Nueva duracion en horas: ");
                        int dur = leerInt();
                        ((Servicio) p).setDuracionHoras(dur);
                    }
                }

                if (p instanceof Articulo) {
                    System.out.println("¿Cambiar categoria?");
                    System.out.println("1) Si");
                    System.out.println("2) No");
                    System.out.print("Opcion: ");
                    int cam = leerInt();
                    if (cam == 1) {
                        for (Categorias c : categorias) {
                            System.out.println(c.getId() + ") " + c.getNombre());
                        }
                        System.out.print("Elegi id de categoria: ");
                        int idCat = leerInt();
                        for (Categorias c : categorias) {
                            if (c.getId() == idCat) {
                                ((Articulo) p).setCategoria(c);
                                break;
                            }
                        }
                    }
                }

                System.out.println("Actualizado: " + p);
                return;
            }
        }
        System.out.println("No se encontro producto con ID " + id);
    }

    @Override
    public void borrar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }
        System.out.println("ID del producto a eliminar: ");
        int id = leerInt();
        boolean eliminado = productos.removeIf(p -> p.getId() == id);
        System.out.println(eliminado ? "Producto eliminado." : "No existe ese ID.");
    }

}
