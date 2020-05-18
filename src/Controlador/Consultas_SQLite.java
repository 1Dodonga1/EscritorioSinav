/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario_Local;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ftm
 */
public class Consultas_SQLite {

    //Instancia a la clase Conexion_SQLite
    Conexiones.Conexion_SQLite conSQL = new Conexiones.Conexion_SQLite();
    PreparedStatement stmt = null;

    //Metodo para iniciar secion es de tipo Usuario_Local
    public Usuario_Local IniciarSecion(String Usuario, String Contraseña) throws SQLException {
        Usuario_Local usuario = null; //Se instancia un objeto de tipo Usuario_Local
        conSQL.connect();             //Conectarse a la base de datos
        String sql = "select * from Usuarios where (nombre_U = ? and contraseña = ?);";

        try {

            stmt = conSQL.con.prepareStatement(sql);
            stmt.setString(1, Usuario);
            stmt.setString(2, Contraseña);

            ResultSet RS = stmt.executeQuery();
            String idUsuario = RS.getString("id_Usuario");
            if (RS.next()) {
                usuario = new Usuario_Local(Usuario, Contraseña, idUsuario);
            }

        } catch (Exception e) {
            System.out.println("__________________________PROBLEMA EN CONSULTAS_SQLITE (IniciarSecion)" + e);
        }
        conSQL.con.close();
        return usuario;
    }

    //Metodo para insertar los usuarios desde la bd principal hasta la bd de SQlite:
    public void Registrar_Nuevo_Usuario(String id, String nombreU, String contraseña) throws SQLException {
        conSQL.connect();
        String sql = "insert into Usuarios(id_Usuario, nombre_U, contraseña) VALUES (?,?,?);";
        try {

            stmt = conSQL.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, nombreU);
            stmt.setString(3, contraseña);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente, intenta iniciar secion ahora");
        } catch (Exception e) {
            System.out.println("__________________________PROBLEMA EN CONSULTAS_SQLITE (Registrar nuevo usuario)" + e);
        }
        conSQL.con.close();
    }

}
