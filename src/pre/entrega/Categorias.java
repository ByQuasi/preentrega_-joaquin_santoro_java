/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pre.entrega;

/**
 *
 * @author User
 */
public class Categorias {

    private int id;                 
    private String nombre;         
    private static int contador = 1; 

    public Categorias(String nombre) { 
        this.id = contador++;         
        this.nombre = nombre;        
    }

    public int getId() {           
        return id;
    }

    public String getNombre() {       
        return nombre;
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }

    public String toString() {       
        return "Categoria: [ID = " + id + " || Nombre = " + nombre + "]";
    }
}
