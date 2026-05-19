/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Dao.MaterialDAO;
import Modelo.Material;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Sergio Iturbe Sánchez
 */
public class InformeServicio {

    /**
     * 
     * @author Sergio Iturbe Sánchez
     */
    public void generarInforme() {
        MaterialDAO dao = new MaterialDAO();
        List<Material> materiales = dao.obtenerMateriales();

        try {
            FileWriter writer = new FileWriter("informe.txt");

            writer.write("=== INVENTARIO ===\n\n");

            for (Material m : materiales) {
                writer.write("Nombre: " + m.getNombre() + "\n");
                writer.write("Categoria: " + m.getCategoria() + "\n");
                writer.write("Ubicacion: " + m.getUbicacion() + "\n");
                writer.write("Cantidad: " + m.getCantidad() + "\n");
                writer.write("Estado: " + m.getEstado() + "\n");
                writer.write("-----------------\n");
            }

            writer.close();

            System.out.println("Informe generado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


