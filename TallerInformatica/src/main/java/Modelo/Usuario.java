/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio Iturbe Sánchez
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String rol;

    /**
     * 
     * @param id
     * @param nombre
     * @param email
     * @param rol 
     * @author Sergio Iturbe Sánchez
     */
    public Usuario(int id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }
/**
 * 
 * @return 
 * @author Sergio Iturbe Sánchez
 */
    public String getRol() { return rol; }
    public String getNombre() { return nombre; }
}