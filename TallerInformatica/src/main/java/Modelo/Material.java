/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author DAM105
 */
public class Material {
    private String nombre;
    private String categoria;
    private String ubicacion;
    private int cantidad;
    private String estado;

    public Material(String nombre, String categoria, String ubicacion,
            int cantidad, String estado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getUbicacion() { return ubicacion; }
    public int getCantidad() { return cantidad; }
    public String getEstado() { return estado; }
}
