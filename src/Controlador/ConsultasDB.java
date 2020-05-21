/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexiones.Conexion;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ftm
 */
public class ConsultasDB {

    Conexiones.Conexion conexion;

    public ConsultasDB() {
        try {
            conexion = new Conexiones.Conexion("jdbc:mysql://127.0.0.1/sinav", "root", "3f3e0c7289");
        } catch (Exception e) {
            System.out.println("ERROR EN CONSULTASDB AL HACER LA CONEXION");
        }
    }

    /**
     *
     * @param Usuario
     * @param Contraseña
     * @return
     */
    public Usuarios verificarUsuario(String Usuario, String Contraseña) {
        Modelo.Usuarios usuario = null;
        String sql = "Select * from alumnos where Usuario = ? and Contraseña = ?;";
        ResultSet rsts = null;
        try {
            PreparedStatement ps = conexion.nuevaConexion.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Contraseña);
            rsts = ps.executeQuery();

            if (rsts.next()) {
                //Obtener el idAlumno en base al nombre de usuario;
                usuario = new Usuarios(rsts.getString("IdAlumnos"), Usuario, Contraseña);

            }

        } catch (SQLException e) {
            System.out.println("EL ERROR ESTA EN USUARIOS VERIFICARUSUARIO");
        }
        return usuario;
    }

}
