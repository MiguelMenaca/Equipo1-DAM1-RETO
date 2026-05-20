/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Esta clase MATERIALDAO gestiona el acceso a los Datos de la tabla Material de la Base De Datos.
 * @author Sergio Iturbe Sánchez
 */
public class MaterialDAO {
/**
 * Se obtienen los materiales registrados en la Base de datos
 * Se realiza un JOIN con las Tablas "Categoria" y "Ubicacion" para obtener los nombres completos de ambas.
 * @return 
 * @author Sergio Iturbe Sánchez
 */
    public List<Material> obtenerMateriales() {
        List<Material> lista = new ArrayList<>();

        String sql = """
            SELECT m.id_material,
                   m.nombre,
                   c.nombre AS categoria,
                   CONCAT(u.armario, ' - ', u.balda) AS ubicacion,
                   m.cantidad,
                   m.estado
            FROM Material m
            JOIN Categorias c ON m.id_categoria = c.id_categoria
            JOIN Ubicacion u ON m.id_ubicacion = u.id_ubicacion
            """;

        try {
            Connection conn = ConexionDB.getInstance().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Material(
                        rs.getInt("id_material"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getString("ubicacion"),
                        rs.getInt("cantidad"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
/**
 * Sirve para Introducir un nuevo material en la Base.
 * @param nombre
 * @param descripcion
 * @param cantidad
 * @param estado "Disponible-prestado-reparacion-Baja"
 * @param idCategoria
 * @param idUbicacion 
 * @author Sergio Iturbe Sánchez
 */
    public void insertar(String nombre, String descripcion, int cantidad, String estado, int idCategoria, int idUbicacion) {
        String sql = "INSERT INTO Material (nombre, descripcion, cantidad, estado, id_categoria, id_ubicacion) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = ConexionDB.getInstance().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, cantidad);
            ps.setString(4, estado);
            ps.setInt(5, idCategoria);
            ps.setInt(6, idUbicacion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * Con su ID, sirve para eliminar el Material
 * @param id 
 * @author Sergio Iturbe Sánchez
 */
    public void eliminar(int id) {
        String sql = "DELETE FROM Material WHERE id_material = ?";
        try {
            Connection conn = ConexionDB.getInstance().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * Actualiza los datos de un Material existente en la Base de Datos
 * @param id
 * @param nombre
 * @param cantidad
 * @param estado 
 * @author Sergio Iturbe Sánchez
 */
    public void actualizar(int id, String nombre, int cantidad, String estado) {
        String sql = "UPDATE Material SET nombre=?, cantidad=?, estado=? WHERE id_material=?";
        try {
            Connection conn = ConexionDB.getInstance().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setString(3, estado);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
