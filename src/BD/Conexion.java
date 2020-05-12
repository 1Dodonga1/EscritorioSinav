package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private static Connection conexion;
    
    private String servidor,user,pass;
    
    public Conexion(String s,String u,String p){
        
        this.servidor=s;
        this.user=u;
        this.pass=p;
        
        hacerConexion();
        
    }
    
    private void hacerConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,user,pass);
            if(conexion!= null)
                System.out.println("se coneceto correctamente"); 
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error con el conector o datos del servidor " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("no" + ex.toString());
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        Conexion.conexion = conexion;
    }
}
