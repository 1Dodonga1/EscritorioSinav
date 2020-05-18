/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ftm
 */
public class Usuario_Local {

    public String usuario;
    public String contraseña;
    public String id;

    public Usuario_Local(String Usuario, String Contraseña,String id) {
        this.usuario = Usuario;
        this.contraseña = Contraseña;
        this.id = id;
    }
    
    public String getId(){
    return this.id;
    }

}
