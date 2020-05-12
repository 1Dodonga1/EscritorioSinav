/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Alma Cuevas
 */
public class Usuario {
    private static String idUsuario;
    private static String nombre;
    private static String usuario;

    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }

    public static void setUsuario(String usuario) {
        Usuario.usuario = usuario;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getUsuario() {
        return usuario;
    }
   
    
    
}
