package pre.entrega;

import java.util.Scanner;

public abstract class CrudConsola<T> {

    protected final Scanner scanner = new Scanner(System.in);

    public abstract void crear();

    public abstract void leer();

    public abstract void actualizar();

    public abstract void borrar();

    public void mostrarOpciones() {
        System.out.println("=== Menu de Creacion ===");
        System.out.println("1) Crear");
        System.out.println("2) Mostrar");
        System.out.println("3) Actualizar");
        System.out.println("4) Eliminar");
        System.out.println("0) Volver");
        System.out.print("Opcion: ");
    }

    protected int leerInt() {
        while (true) {
            try {
                String linea;
                do {
                    linea = scanner.nextLine().trim();
                } while (linea.isEmpty());
                int aux = Integer.parseInt(linea.trim());
                if (aux < 0) {
                    System.out.println("Tiene que ser positivo");
                    continue;
                }
                return aux;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un numero entero.");
            }
        }
    }

    protected double leerDouble() {
        while (true) {
            try {
                String linea;
                do {
                    linea = scanner.nextLine().trim();
                } while (linea.isEmpty());
                double aux = Double.parseDouble(linea.trim());
                if (aux < 0) {
                    System.out.println("Tiene que ser positivo ");
                    continue;
                }
                return aux;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un numero.");
            }
        }
    }

    protected String leerString() {

        return scanner.nextLine();
    }
}
