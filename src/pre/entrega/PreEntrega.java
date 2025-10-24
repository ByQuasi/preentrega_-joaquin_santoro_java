package pre.entrega;

import java.util.ArrayList;

public class PreEntrega {

    public static void main(String[] args) {
        final ArrayList<Producto> producto = new ArrayList<>();
        final ArrayList<Categorias> categoria = new ArrayList<>();

        categoria.add(new Categorias("Literatura"));
        categoria.add(new Categorias("Muebles"));
        categoria.add(new Categorias("Tecnologia"));
        final CrudProducto crudProd = new CrudProducto(producto, categoria);
        final CrudCategoria crudCat = new CrudCategoria(categoria);
        final CrudPedidos crudPed = new CrudPedidos(crudProd);
        var opcion = -1;
        do {
            System.out.println("------Bienvenido-------");
            System.out.println("----Quasi | Store-----");
            System.out.println("=== Menu Principal ===");
            System.out.println("1) Hacer un pedido");
            System.out.println("2) Modificar productos");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = crudProd.scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    if (producto.isEmpty()) {
                        System.out.println("No hay productos");
                        System.out.println("Volviendo...");
                        continue;
                    }

                    int op;
                    do {
                        crudProd.mostrarOpciones();
                        op = crudProd.leerInt();
                        switch (op) {
                            case 1 ->
                                crudPed.crear();
                            case 2 ->
                                crudPed.leer();
                            case 3 ->
                                crudPed.actualizar();
                            case 4 ->
                                crudPed.borrar();
                            case 0 ->
                                System.out.println("Volviendo!");
                            default ->
                                System.out.println("Opcion invalida");
                        }
                    } while (op != 0);

                }
                case 2 -> {
                    int op;
                    System.out.println("1) CRUD Productos");
                    System.out.println("2) CRUD Categorias");
                    System.out.println("0) Volver");
                    System.out.print("Opcion: ");
                    op = crudProd.scanner.nextInt();
                    switch (op) {
                        case 1 -> {

                            do {
                                crudProd.mostrarOpciones();
                                op = crudProd.leerInt();
                                switch (op) {
                                    case 1 ->
                                        crudProd.crear();
                                    case 2 ->
                                        crudProd.leer();
                                    case 3 ->
                                        crudProd.actualizar();
                                    case 4 ->
                                        crudProd.borrar();
                                    case 0 ->
                                        System.out.println("Volviendo!");
                                    default ->
                                        System.out.println("Opcion invalida");
                                }
                            } while (op != 0);
                        }
                        case 2 -> {
                            do {
                                crudCat.mostrarOpciones();
                                op = crudCat.leerInt();
                                switch (op) {
                                    case 1 ->
                                        crudCat.crear();
                                    case 2 ->
                                        crudCat.leer();
                                    case 3 ->
                                        crudCat.actualizar();
                                    case 4 ->
                                        crudCat.borrar();
                                    case 0 ->
                                        System.out.println("Volviendo!");
                                    default ->
                                        System.out.println("Opcion invalida");
                                }
                            } while (op != 0);
                        }
                        case 0 -> {
                            break;
                        }
                        default -> {
                            System.out.println("Incorrecto");
                        }
                    }

                }
                case 0 -> {
                    System.out.println("Hasta Pronto!!");
                }
                default -> {
                    System.out.println("No es una opcion");
                }

            }
        } while (opcion != 0);
    }
}
