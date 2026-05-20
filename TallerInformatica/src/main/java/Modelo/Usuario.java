/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *Esta clase representa un Usuario de la App junto a sus atributos
 * @author Sergio Iturbe Sánchez
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String rol;

    /**
     * Este Constructor inicializa los Atributos del Usuario
     * @param id "Identificador del Usuario"
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
 * Getters para obtener los Atributos del Usuario
 * @return 
 * @author Sergio Iturbe Sánchez
 */
    public String getRol() { return rol; }
    public String getNombre() { return nombre; }
}