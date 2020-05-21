/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alma Cuevas
 */
public class Conexion {
        public  Connection nuevaConexion;
        private String servidor, user,pass;
        
    public Conexion(String s,String u,String p){
       this.servidor=s;
        this.user=u;
        this.pass=p;
        hacerConexion();
  }
      
    
    
  public void hacerConexion(){
      try {
          Class.forName("com.mysql.jdbc.Driver");
          nuevaConexion=DriverManager.getConnection(servidor,user,pass);
          if (nuevaConexion!=null) {
              System.out.println("se coneccto corectamente");
          }
      } catch (ClassNotFoundException e) {
           System.out.println("Error con el conector o datos del servidor " + e.toString());
      }catch (SQLException ex) {
            System.out.println("no " + ex.toString());
        }
  }

}
