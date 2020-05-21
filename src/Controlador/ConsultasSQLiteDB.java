/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Examenes;
import Modelo.MateriasAlumno;
import Modelo.Usuarios;
import VIsta.Examen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ftm
 */
public class ConsultasSQLiteDB {

    private static Conexiones.ConexionSQLite conSQL = new Conexiones.ConexionSQLite();
    private static PreparedStatement stmt = null;
    private Usuarios usuario = null;

    //Metodo para iniciar secion es de tipo Usuario_Local
    public Usuarios IniciarSecion(String Usuario, String Contraseña) throws SQLException {
        //Se instancia un objeto de tipo Usuario _Local        
        String sql = "select * from Usuarios where (nombre_U = ? and contraseña = ?);";
        usuario = null;
        try {
            conSQL.connect();  //Conectarse a la base de datos
            stmt = conSQL.nuevaConexion.prepareStatement(sql);
            stmt.setString(1, Usuario);
            stmt.setString(2, Contraseña);

            ResultSet RS = stmt.executeQuery();
            String idUsuario = RS.getString("id_Usuario");
            if (RS.next()) {
                usuario = new Usuarios(idUsuario, Usuario, Contraseña);
            }

        } catch (Exception e) {
            System.out.println("__________________________PROBLEMA EN CONSULTAS_SQLITE (IniciarSecion)" + e);
        }
        conSQL.nuevaConexion.close();
        return usuario;
    }

    public void Registrar_Nuevo_Usuario(String id, String nombreU, String contraseña) throws SQLException {
        conSQL.connect();
        String sql = "insert into Usuarios(id_Usuario, nombre_U, contraseña) VALUES (?,?,?);";
        try {

            stmt = conSQL.nuevaConexion.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, nombreU);
            stmt.setString(3, contraseña);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "USUARIO AGREGADO CORRECTAMENTE INTENTA INICIAR AHORA");
        } catch (Exception e) {
            System.out.println("__________________________PROBLEMA EN CONSULTAS_SQLITE (Registrar nuevo usuario)" + e);
        }
        conSQL.nuevaConexion.close();
    }

//    public static ArrayList<MateriasAlumno> obtenerMaterias() throws SQLException {
//        String sql = "Select * from Materias";
//        ArrayList<MateriasAlumno> ListaMaterias = new ArrayList<>();
//        try {
//            conSQL.connect();
//            try {
//                stmt = conSQL.nuevaConexion.prepareStatement(sql);
//                ResultSet rs = stmt.executeQuery();
//                while (rs.next()) {
//                    MateriasAlumno MA = new MateriasAlumno(rs.getString("id_Materia"), rs.getString("Materia"));
//                    ListaMaterias.add(MA);
//                }
//            } catch (Exception e) {
//                System.out.println("NO SE PUDO CONTINUAR CON LA OPERACION DE OBTENER MATERIAS" + e);
//            }
//            conSQL.nuevaConexion.close();
//        } catch (Exception e) {
//            System.out.println("ERROR EN LA CONEXION DE OBTENER MATERIAS" + e);
//        }
//
//        return ListaMaterias;
//    }
    public static ArrayList<String> ObtenerIdMaterias(String idAlumno) throws SQLException {
        String sql = "SELECT * FROM Materias_del_Alumno WHERE fk_usuario = ?;";
        ArrayList<String> ListaDEid = new ArrayList<>();
        try {
            conSQL.connect();
            try {
                stmt = conSQL.nuevaConexion.prepareStatement(sql);
                stmt.setString(1, idAlumno);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    ListaDEid.add(rs.getString("fk_materia"));
                }

            } catch (SQLException e) {
                System.out.println("NO SE PUDO CONTINUAR CON LA OPERACION DE OBTENER MATERIAS" + e);
            }
        } catch (Exception e) {
            System.out.println("ERROR EN LA CONEXION DE OBTENER ID MATERIAS" + e);
        }
        conSQL.nuevaConexion.close();
        return ListaDEid;
    }

    public static ArrayList<MateriasAlumno> obtenerMaterias(ArrayList<String> ListaIds) {
        String sql = "Select * from Materias where id_Materia= ";
        String sql2 = " or id_Materia= ";

        int x = ListaIds.size();

        for (String ListaId : ListaIds) {
            sql += ListaId;
            if (x > 1) {
                x -= 1;
                sql += sql2;
            }
        }
        sql += ";";
        ArrayList<MateriasAlumno> ListaMaterias = new ArrayList<>();
        try {
            conSQL.connect();
            try {
                stmt = conSQL.nuevaConexion.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    MateriasAlumno MA = new MateriasAlumno(rs.getString("id_Materia"), rs.getString("Materia"));
                    ListaMaterias.add(MA);
                }
            } catch (Exception e) {
                System.out.println("NO SE PUDO CONTINUAR CON LA OPERACION DE OBTENER MATERIAS" + e);
            }
            conSQL.nuevaConexion.close();
        } catch (Exception e) {
            System.out.println("ERROR EN LA CONEXION DE OBTENER MATERIAS" + e);
        }

        //System.out.println(sql);
        return ListaMaterias;

    }

    public static ArrayList<Examenes> obtenerExamenes(String idMateria) throws SQLException {
        String sql = "Select * from Examen where fk_Materias = ?;";
        ArrayList<Examenes> ListaExamenes = new ArrayList<>();
        try {
            conSQL.connect();
            try {
                stmt = conSQL.nuevaConexion.prepareStatement(sql);
                stmt.setString(1, idMateria);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                Modelo.Examenes ex = new Modelo.Examenes(rs.getString("id_Examen"), rs.getString("Nombre_Examen"), rs.getString("fk_Materias"));
                ListaExamenes.add(ex);
                }
            } catch (SQLException e) {
                System.out.println("NO SE PUDO PROCEDER CON LA OPERACION EN OBTENER_EXAMENES "+e);
            }
            
            
        } catch (Exception e) {
            System.out.println("ERROR EN LA CONEXION EN OBTENER EXAMENES "+e);
        }
        
        
        conSQL.nuevaConexion.close();
        return ListaExamenes;
    }

}
