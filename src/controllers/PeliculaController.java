/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DB.PeliculaDAO;
import models.Pelicula;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tavox
 */
public class PeliculaController {
    private PeliculaDAO peliculaDAO;

    public PeliculaController(Connection connection) {
        this.peliculaDAO = new PeliculaDAO(connection);
    }

    // Metodo para insertar una película en la base de datos
    public void insert(String titulo, String genero, String director, Date fecha) {
        Pelicula pelicula = new Pelicula(titulo, genero, director, fecha);
        peliculaDAO.insert(pelicula);
    }

    // Metodo para actualizar una película en la base de datos
    public void update(int codigo, String titulo, String genero, String director, Date fecha) {
        Pelicula pelicula = new Pelicula(codigo, titulo, genero, director, fecha);
        peliculaDAO.update(pelicula);
    }

    // Metodo para eliminar una película de la base de datos
    public void delete(int codigo) {
        peliculaDAO.delete(codigo);
    }

    // Metodo para obtener todas las películas de la base de datos
    public List<Pelicula> selectAll() {
        return peliculaDAO.selectAll();
    }

    // Metodo para obtener una película por su código
    public Pelicula select(int codigo) {
        return peliculaDAO.select(codigo);
    }

    // Metodo para obtener una película por su título
    public Pelicula select(String titulo) {
        return peliculaDAO.select(titulo);
    }

    // Metodo para obtener una película por su director
    public Pelicula selectDirector(String director) {
        return peliculaDAO.selectDirector(director);
    }

    // Metodo para obtener una película por su género
    public Pelicula selectGenero(String genero) {
        return peliculaDAO.selectGenero(genero);
    }

    // Metodo para obtener una película por su fecha
    public Pelicula selectFecha(Date fecha) {
        return peliculaDAO.selectFecha((java.sql.Date) fecha);
    }
}
