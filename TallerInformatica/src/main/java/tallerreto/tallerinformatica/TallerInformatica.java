/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tallerreto.tallerinformatica;

import Servicio.InformeServicio;

/**
 *
 * @author DAM105
 */
public class TallerInformatica {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
