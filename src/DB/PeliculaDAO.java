package DB;

import models.Pelicula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    private Connection connection;

    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para insertar una película en la base de datos
    public void insert(Pelicula pelicula) {
        String query = "INSERT INTO pelicula (titulo, genero, director, fecha) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pelicula.getTitulo());
            preparedStatement.setString(2, pelicula.getGenero());
            preparedStatement.setString(3, pelicula.getDirector());
            preparedStatement.setDate(4, new Date(pelicula.getFecha().getTime()));
            preparedStatement.executeUpdate();
            System.out.println("Película insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la película.");
            e.printStackTrace();
        }
    }

    // Método para actualizar una película en la base de datos
    public void update(Pelicula pelicula) {
        String query = "UPDATE pelicula SET titulo = ?, genero = ?, director = ?, fecha = ? WHERE CODPELICULA = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pelicula.getTitulo());
            preparedStatement.setString(2, pelicula.getGenero());
            preparedStatement.setString(3, pelicula.getDirector());
            preparedStatement.setDate(4, new Date(pelicula.getFecha().getTime()));
            preparedStatement.setInt(5, pelicula.getCodigo());
            preparedStatement.executeUpdate();
            System.out.println("Película actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar la película.");
            e.printStackTrace();
        }
    }

    // Método para eliminar una película de la base de datos
    public void delete(int codigo) {
        String query = "DELETE FROM pelicula WHERE CODPELICULA = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            System.out.println("Película eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la película.");
            e.printStackTrace();
        }
    }

    // Método para obtener todas las películas de la base de datos
    public List<Pelicula> selectAll() {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM pelicula";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las películas.");
            e.printStackTrace();
        }
        return peliculas;
    }

    // Método para obtener una película de la base de datos por su código
    public Pelicula select(int codigo) {
        Pelicula pelicula = new Pelicula();
        String query = "SELECT * FROM pelicula WHERE CODPELICULA = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la película.");
            e.printStackTrace();
        }
        return pelicula;
    }

    // Método para obtener una película de la base de datos por su título
    public Pelicula select(String titulo) {
        Pelicula pelicula = new Pelicula();
        String query = "SELECT * FROM pelicula WHERE titulo = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, titulo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la película.");
            e.printStackTrace();
        }
        return pelicula;
    }

    // Método para obtener una película de la base de datos por su director
    public Pelicula selectDirector(String director) {
        Pelicula pelicula = new Pelicula();
        String query = "SELECT * FROM pelicula WHERE director = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, director);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la película.");
            e.printStackTrace();
        }
        return pelicula;
    }

    // Método para obtener una película de la base de datos por su género
    public Pelicula selectGenero(String genero) {
        Pelicula pelicula = new Pelicula();
        String query = "SELECT * FROM pelicula WHERE genero = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genero);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la película.");
            e.printStackTrace();
        }
        return pelicula;
    }

    // Método para obtener una película de la base de datos por su fecha
    public Pelicula selectFecha(Date fecha) {
        Pelicula pelicula = new Pelicula();
        String query = "SELECT * FROM pelicula WHERE fecha = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, fecha);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pelicula.setCodigo(resultSet.getInt("CODPELICULA")); // Cambiar 'codigo' a 'CODPELICULA'
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setFecha(resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la película.");
            e.printStackTrace();
        }
        return pelicula;
    }
}
