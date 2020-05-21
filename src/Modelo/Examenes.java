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
public class Examenes {

    private String id_Examen, Nombre_Examen, fk_Materias;

    public Examenes(String id, String NombreE, String idMaterias) {

        id_Examen = id;
        Nombre_Examen = NombreE;
        fk_Materias = idMaterias;

    }

    public String getId() {
        return id_Examen;

    }

    public String getNombreE() {
        return Nombre_Examen;
    }

    public String getIdMaterias() {
        return fk_Materias;
    }

}
