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
public class MateriasAlumno {
    
    private String id;
    private String  Materia;
    
    
    public MateriasAlumno(String id, String Materia){
    this.Materia = Materia;
    this.id = id;
    }
    
    public String getId(){
    return id;
    }
    public String getMateria(){
    return Materia;
    }
    
}
