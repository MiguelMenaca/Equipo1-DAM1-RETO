/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tallerreto.tallerinformatica;

import Servicio.InformeServicio;

/**
 *Clase Main para lanzar la Ventana de Login
 * @author Sergio Iturbe Sánchez
 */
public class TallerInformatica {
/**
 * Se lanza la ventana de Inicio de Sesion
 * @param args
 * @author Sergio Iturbe Sánchez
 */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm login = new LoginForm();
                login.setVisible(true);
            }
        });
    }
}
