/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio Iturbe Sánchez
 */
public class Material {
    private int id;
    private String nombre;
    private String categoria;
    private String ubicacion;
    private int cantidad;
    private String estado;
/**
 * 
 * @param id
 * @param nombre
 * @param categoria
 * @param ubicacion
 * @param cantidad
 * @param estado 
 * @author Sergio Iturbe Sánchez
 */
    public Material(int id, String nombre, String categoria, String ubicacion,
                    int cantidad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
        this.estado = estado;
    }
/**
 * 
 * @return 
 * @author Sergio Iturbe Sánchez
 */
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getUbicacion() { return ubicacion; }
    public int getCantidad() { return cantidad; }
    public String getEstado() { return estado; }
}
