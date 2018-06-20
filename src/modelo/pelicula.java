/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mabel
 */
public class pelicula {
   private String nombre;
   private int anio;
   private String director;
   private String pais;
   private String clasificacion;
   private boolean disponible;

    public pelicula() {
    }

    public pelicula(String nombre, int anio, String director, String pais, String clasificacion, boolean disponible) {
        this.nombre = nombre;
        this.anio = anio;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.disponible = disponible;
    }

    public pelicula(int anio, String director, String pais, String clasificacion, boolean disponible) {
        this.anio = anio;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.disponible = disponible;
    }

    

    public pelicula(String director, String pais, String clasificacion, boolean disponible) {
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
   
     
}
