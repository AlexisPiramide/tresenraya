package com.example.ActividadPractica.Application;

import com.example.ActividadPractica.Dominio.Posicion;
import com.example.ActividadPractica.Dominio.PosicionRepository;

import java.util.List;

public class PosicionUseCases {

    private PosicionRepository posicionRepository;

    public PosicionUseCases(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }


    public List<Posicion> getAllPosiciones() {
        return this.posicionRepository.getAllPosiciones();
    }

    public boolean añadirPoscion(Posicion posicion) {
        return this.posicionRepository.añadirPoscion(posicion);
    }

    public boolean limpiarTablero() {
        return this.posicionRepository.limpiarTablero();
    }

}
