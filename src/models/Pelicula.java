/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Tavox
 */
public class Pelicula {
    
    private int codigo;
    private String titulo;
    private String genero;
    private String director;
    private Date fecha;

    public Pelicula() {
    }
    

    public Pelicula(int codigo, String titulo, String genero, String director, Date fecha) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.fecha = fecha;
    }

    public Pelicula(String titulo, String genero, String director, Date fecha) {
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "codigo=" + codigo + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + ", fecha=" + fecha + '}';
    }
    
    
    
    
    
    
    
}
