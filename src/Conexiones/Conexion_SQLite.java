/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ftm
 */
public class Conexion_SQLite {

    
  
        String url = "~\\ftm\\SQLite_sinav.db";
        public Connection con = null;

        public void connect() {
            try {
                con = DriverManager.getConnection("jdbc:sqlite:" + url);
                if (con != null) {
                    // System.out.println("Conectado");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("No se ha podido conectar a la base de datos\n");
            }
        }

    

}
