/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *Esta Clase es la que gestiona la conexion a la Base de Datos del MYSQL
 * Se usa el Patron Singlenton que garantiza que solo haya 1 instancia de conex. en la App. 
 * @author Sergio Iturbe Sánchez
 */
public class ConexionDB {

    private static ConexionDB instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3306/taller_informatica";
    private static final String USER = "Equipo1";
    private static final String PASSWORD = "1234";
/**
 * Constructor Privado para establecer la Conexion con la Base de Datos.
 * @author Sergio Iturbe Sánchez
 */
    private ConexionDB() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * Devuelve la unica Instancia de ConexionDB, si no existe la Crea y si existe se Reutiliza.
 * @return
 * @author Sergio Iturbe Sánchez
 */
    public static ConexionDB getInstance() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
