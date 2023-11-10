package com.example.ActividadPractica.Data;

import com.example.ActividadPractica.Connexion.ConnexionBD;
import com.example.ActividadPractica.Dominio.Posicion;
import com.example.ActividadPractica.Dominio.PosicionRepository;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosicionRepositorySQL implements PosicionRepository {


    @Override
    public List<Posicion> getAllPosiciones() {
        List<Posicion> lista = new ArrayList<>();
        try {
            String Query = "SELECT * FROM datos";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("actividadpractica").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer fila = rs.getInt("filas");
                Integer columna = rs.getInt("columnas");
                Integer jugador = rs.getInt("jugador");
                lista.add(new Posicion(fila, columna, jugador));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public boolean añadirPoscion(Posicion posicion) {
        try {
            String Query = "INSERT INTO datos (filas, columnas, jugador) VALUES ('"+posicion.getFila()+"', '"+posicion.getColumna()+"', '"+posicion.getJugador()+"')";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("actividadpractica").prepareStatement(Query);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean limpiarTablero() {
        try {
            String Query = "DELETE FROM datos";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("actividadpractica").prepareStatement(Query);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
