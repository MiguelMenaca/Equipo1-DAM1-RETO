/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conectar = null;
    
    // Datos EC2 de AWS
    private static final String URL = "jdbc:mysql://TU_IP_ELASTICA_AWS:3306/taller_informatica";
    private static final String USER = "tu_usuario"; 
    private static final String PASS = "tu_password";

    public static Connection getConexion() throws SQLException {
        if (conectar == null || conectar.isClosed()) {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                conectar = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión exitosa a AWS");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: No se encontró el driver.");
            }
        }
        return conectar;
    }
}
