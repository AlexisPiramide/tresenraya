package com.example.ActividadPractica.Data;

import com.example.ActividadPractica.Application.PosicionUseCases;
import com.example.ActividadPractica.Dominio.Posicion;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PosicionRESController {

        private PosicionUseCases posicionUseCases;
        public PosicionRESController(){
            this.posicionUseCases = new PosicionUseCases(
                    new PosicionRepositorySQL()
            );
        }

        @PostMapping(path = "/movimiento", consumes = MediaType.APPLICATION_JSON_VALUE)
        boolean movimiento(@RequestBody Posicion posicion){
            int jugador1 =0;
            int jugador2 =0;
            List<Posicion> Lista = posicionUseCases.getAllPosiciones();
            if(Lista.size()==0){
                posicion.setJugador(1);
            }else {
                for (Posicion p : Lista) {
                    if (p.getJugador()==1){
                        jugador1++;
                    }
                    if (p.getJugador()==2){
                        jugador2++;
                    }
                }
            }

            if(jugador1==jugador2){
                posicion.setJugador(1);
            }
            if(jugador1>jugador2){
                posicion.setJugador(2);
            }
            this.posicionUseCases.añadirPoscion(posicion);
            return true;
        }

        @PostMapping("/limpia")
        boolean limpiartablero(){
            return this.posicionUseCases.limpiarTablero();
        }

    }
