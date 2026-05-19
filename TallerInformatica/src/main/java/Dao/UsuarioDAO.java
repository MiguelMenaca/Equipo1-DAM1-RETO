/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Usuario;
import java.sql.*;
/**
 *
 * @author Sergio Iturbe Sánchez
 */
public class UsuarioDAO {

   
 
/**
 * 
 * @param nombre
 * @param pass
 * @return 
 * @author Sergio Iturbe Sánchez
 */
    public Usuario login(String nombre, String pass) {
        Usuario u = null;
        String sql = "SELECT * FROM Usuarios WHERE nombre = ? AND password = ?";
        try {
           Connection conn = ConexionDB.getInstance().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
