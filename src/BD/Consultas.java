/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Datos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alma Cuevas
 */
public class Consultas {
    Conexion cone;
    public  Consultas(){
        try {
             cone=new Conexion("jdbc:mysql://127.0.0.1/sinav", "root", "morado");
        } catch (Exception e) {
             System.out.println("error con usuario o contraseña de sql ");
        }
    }
    
    public boolean ConsultarUsuario(String usuario,String contra){
        String sentencia="select *from alumnos where Usuario='"+usuario+"' and contraseña='"+contra+"';";
        ResultSet rs=null;

        try {
             PreparedStatement ps = cone.getConexion().prepareCall(sentencia);
             rs=ps.executeQuery();
            rs.first();
            Datos.Usuario.setIdUsuario(rs.getString("IdAlumnos"));
            Datos.Usuario.setNombre(rs.getString("Nombre"));
            Datos.Usuario.setUsuario(rs.getString("contraseña"));
            
            cone.getConexion().close();
            
        } catch (SQLException ex) {
            
            System.out.println("Error en la consulta "+ex.toString());
            return  false;
        }
        return true;
    }
}
