package com.example.ActividadPractica.Data;

import com.example.ActividadPractica.Application.PosicionUseCases;
import com.example.ActividadPractica.Dominio.Posicion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PosicionController {

    private PosicionUseCases posicionUseCases;
    public PosicionController(){
        this.posicionUseCases = new PosicionUseCases(
                new PosicionRepositorySQL()
        );
    }
    @GetMapping("/tablero")
    public String mostrarTablero(Model model) {
        List<Posicion> posiciones = posicionUseCases.getAllPosiciones();
        String [][] matriz = new String[3][3];
        for(int i=0;i < matriz.length;i++){
            for(int j=0;j < matriz.length;j++){
                matriz[i][j]= "□";
            }
        }
        for (Posicion p : posiciones) {
            if (p.getJugador()==1){
                matriz [p.getFila()-1][p.getColumna()-1]= "X";
            }
            if (p.getJugador()==2){
                matriz [p.getFila()-1][p.getColumna()-1]= "0";
            }

        }

        model.addAttribute("matriz", matriz);
        return "index";
    }
}
