package com.example.ActividadPractica;

public class TresEnRaya {

    private char[][] tablero;
    private char jugadorActual;

    public TresEnRaya() {
        tablero = new char[3][3];
        jugadorActual = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Getters y setters para tablero y jugadorActual
}

