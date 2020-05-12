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
import java.util.Arrays;
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
            Datos.Usuario.setUsuario(rs.getString("Usuario"));
            System.out.println(Datos.Usuario.getIdUsuario());
            
            //cone.getConexion().close();
            
        } catch (SQLException ex) {
            
            System.out.println("Error en la consulta "+ex.toString());
            return  false;
        }
        return true;
    }
    
    public String[] materias(String idAlu){
         String sentencia="select  m.Materia from sinav.materias as m inner join  listaasistencia as l  on l.Alumnos_IdAlumnos="+idAlu+" and m.IdMaterias=l.Materias_IdMaterias;";
        ResultSet rs=null;
        String datos []=null;
        
        try {
            PreparedStatement ps=cone.getConexion().prepareCall(sentencia);
            rs=ps.executeQuery();
            int contador=0;
            
            while(rs.next()){
                contador++;
            }
            rs.first();
            datos= new String [contador];
            int i=0;
            do{
                datos[i]=rs.getString(1);
                i++;
            }while(rs.next());
            
        } catch (Exception e) {
            System.out.println("no puedo traer los datos de materia"+e);
        }
        
        return datos;
    }
    
    
    public String[] Examenes(String idmateria){
         String sentencia="select Nombre from examen where Materias_IdMaterias="+idmateria+";";
        ResultSet rs=null;
        String datos []=null;
        
        try {
            PreparedStatement ps=cone.getConexion().prepareCall(sentencia);
            rs=ps.executeQuery();
            int contador=0;
            
            while(rs.next()){
                contador++;
            }
            rs.first();
            datos= new String [contador];
            int i=0;
            do{
                datos[i]=rs.getString(1);
                i++;
            }while(rs.next());
            
        } catch (Exception e) {
            System.out.println("no puedo traer los datos de examen"+e);
        }
        
        return datos;
    }
    
    public static void main(String[] args) {
        Consultas consul=new Consultas();
       
       // System.out.println(Arrays.toString(consul.Examenes("1")));
        //consul.ConsultarUsuario("m", "m");
        //System.out.println(Arrays.toString(consul.materias(Datos.Usuario.getIdUsuario())));
        
    }
}
