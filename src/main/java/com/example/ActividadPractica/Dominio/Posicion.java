package com.example.ActividadPractica.Dominio;

public class Posicion {

    private Integer columna,fila,jugador;

    public Posicion( Integer fila, Integer columna,Integer jugador) {
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public void setJugador(Integer jugador) {
        this.jugador = jugador;
    }

    public Integer getColumna() {
        return columna;
    }

    public Integer getFila() {
        return fila;
    }

    public Integer getJugador() {
        return jugador;
    }
}
