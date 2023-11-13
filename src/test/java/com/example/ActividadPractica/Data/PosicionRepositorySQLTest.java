package com.example.ActividadPractica.Data;

import com.example.ActividadPractica.Application.PosicionUseCases;
import com.example.ActividadPractica.Dominio.Posicion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicionRepositorySQLTest {

    private PosicionUseCases posicionUseCases;
    public PosicionRepositorySQLTest(){
        this.posicionUseCases = new PosicionUseCases(
                new PosicionRepositorySQL()
        );
    }

    @Test
    void getAllPosiciones() {
        assertEquals(0,posicionUseCases.getAllPosiciones().size());
    }

    @Test
    void añadirPoscion() {
        assertEquals(true, posicionUseCases.añadirPoscion(new Posicion(2,2,1)));
    }

    @Test
    void limpiarTablero() {
        assertEquals(true,posicionUseCases.limpiarTablero());
    }
}