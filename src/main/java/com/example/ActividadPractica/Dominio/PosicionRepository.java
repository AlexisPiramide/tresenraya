package com.example.ActividadPractica.Dominio;

import java.util.List;

public interface PosicionRepository {

    List<Posicion> getAllPosiciones();
    boolean añadirPoscion(Posicion posicion);

    boolean limpiarTablero();
}
