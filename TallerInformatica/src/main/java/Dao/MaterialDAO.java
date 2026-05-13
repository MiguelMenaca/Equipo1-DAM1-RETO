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
 *
 * @author DAM105
 */
public class MaterialDAO {

    String url = "jdbc:mysql://localhost:3306/taller_informatica";
    String user = "Equipo1";
    String password = "1234";

    public List<Material> obtenerMateriales() {
        List<Material> lista = new ArrayList<>();

        String sql = """
            SELECT m.nombre,
                   c.nombre AS categoria,
                   CONCAT(u.armario, ' - ', u.balda) AS ubicacion,
                   m.cantidad,
                   m.estado
            FROM Material m
            JOIN Categorias c ON m.id_categoria = c.id_categoria
            JOIN Ubicacion u ON m.id_ubicacion = u.id_ubicacion
        """;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Material(
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
}
