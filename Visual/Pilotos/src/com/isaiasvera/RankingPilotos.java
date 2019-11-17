package com.isaiasvera;

import java.util.ArrayList;
import java.util.Random;

public class RankingPilotos {
    private ArrayList<Piloto> pilotos = new ArrayList<>();

    public void añadirPiloto (Piloto piloto, int posicionActual){
        pilotos.add(posicionActual,piloto);
    }

    public Piloto getPiloto (int pos){
        return pilotos.get(pos);
    }
    public void adelantarPiloto(Piloto piloto){
        int posActual = piloto.getPosicionActual()-1;
        System.out.println(piloto.getNombre());
        System.out.println("Pos actual: " + (posActual+1));
        int posicionAMover = posActual-2;
        System.out.println("Pos a mover: " + (posicionAMover+1));
        if (posActual == 0){
            pilotos.add(1, pilotos.remove(posActual));
        } else if (posActual == 1){
            pilotos.add(0, pilotos.remove(posActual));
        } else {
            pilotos.add(posicionAMover, pilotos.remove(posActual));
        }
        actualizarPosicionPiloto();
    }
    public void eliminarPilotosDescalificados(){
        pilotos.removeIf(Piloto::isDescalificado);
        actualizarPosicionPiloto();
    }
    public void actualizarPosicionPiloto (){
        for (Piloto pil: pilotos){
            int temp = pilotos.indexOf(pil);
            pilotos.get(temp).setPosicionActual(temp+1);
        }
    }
    public void marcarComoDescalificado(int pos){
        pilotos.get(pos).setDescalificado(true);
    }
    public int random (int from, int to){
        return new Random().ints(from,to).findAny().getAsInt();
    }

    @Override
    public String toString() {
        return "RankingPilotos{" +
                "pilotos=" + pilotos +
                '}';
    }
}
