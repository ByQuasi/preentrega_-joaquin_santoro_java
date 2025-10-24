package pre.entrega;

import java.util.ArrayList;

public class CrudCategoria extends CrudConsola<Categorias> {

    private final ArrayList<Categorias> categorias;

    public CrudCategoria(ArrayList<Categorias> categorias) {
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        System.out.print("Nombre de la nueva categoria: ");
        String nombre = leerString();
        categorias.add(new Categorias(nombre));
        System.out.println("Categoria creada.");
    }

    @Override
    public void leer() {
        if (categorias.isEmpty()) {
            System.out.println("Sin categorias");
        } else {
            for (Categorias c : categorias) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        System.out.print("ID de la categoria: ");
        int id = leerInt();
        for (Categorias c : categorias) {
            if (c.getId() == id) {
                System.out.print("Nuevo nombre: ");
                String nuevo = leerString();
                c.setNombre(nuevo);
                System.out.println("Actualizado: " + c);
                return;
            }
        }
        System.out.println("No se encontro categoria " + id);
    }

    @Override
    public void borrar() {
        System.out.print("ID de la categoria a eliminar: ");
        int id = leerInt();
        boolean eliminado = categorias.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "Categoria eliminada." : "No existe ese ID.");
    }

}
