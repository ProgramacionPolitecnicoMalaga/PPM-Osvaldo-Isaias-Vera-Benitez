package com.isaiasvera;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Race {
    private JPanel panelMain, panelActions, panelStartRace, panelMovePilots, panelStopRace, panelResults;
    private JTable table1;
    private JButton btnStart, btnMove, btnStop;
    private int pilotosActuales;
    private RankingPilotos rankingPilotos = new RankingPilotos();

    private Race(){
        configurarTabla();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargarPilotos();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverPilotos();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumenCarrera();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Race");
        frame.setContentPane(new Race().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cargarPilotos() throws FileNotFoundException {
        String linea;
        String[] participantes;
        File file = new File ("./src/pilotos.csv");
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        try {
            while ((linea = bReader.readLine()) != null){
                participantes = linea.split(";");
                Piloto piloto = new Piloto(participantes[1],participantes[2],Integer.parseInt(participantes[0]));
                rankingPilotos.añadirPiloto(piloto, piloto.getPosicionActual()-1);
                agregarATabla(piloto);
                pilotosActuales++;
            }
        } catch (IOException io){
            io.printStackTrace();
        }
    }

    private void moverPilotos (){
        Set<Integer> pilotosAMover = new HashSet<>();
        obtenerPosicionesAMover(pilotosAMover);
        Set<Integer> pilotosADescalificar = new HashSet<>();
        obtenerPosicionesADescalificar(pilotosADescalificar);
        int queHacer = rankingPilotos.random(0,3);
        System.out.println(queHacer);
        if (queHacer == 0){ // Solo se adelantan pilotos
            adelantarPilotos(pilotosAMover);
        } else if (queHacer == 1){ // Solo se descalifican
            marcarDescalificado(pilotosADescalificar);
        } else { // Se adelantan y descalifican
            adelantarPilotos(pilotosAMover);
            marcarDescalificado(pilotosADescalificar);
        }
        recargarTabla();
    }

    private void resumenCarrera(){
        File file = new File ("./src/resumen.csv");
        FileWriter writer = null;
        BufferedWriter bWriter = null;
        try {
            writer = new FileWriter(file);
            bWriter = new BufferedWriter(writer);
            for (int c = 0; c < pilotosActuales; c++){
                bWriter.write(rankingPilotos.getPiloto(c).getPosicionActual() +";"+rankingPilotos.getPiloto(c).getNombre() +";"+rankingPilotos.getPiloto(c).getEscuderia());
                if (c != pilotosActuales-1){
                    bWriter.write("\n");
                }
            }
        } catch (IOException io){
            io.printStackTrace();
        } finally {
            try {
                bWriter.close();
                writer.close();
            } catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    private void obtenerPosicionesAMover(Set<Integer> pilotosAMover) {
        int temp = pilotosActuales * 27 / 100;
        for (int c = 0; c < temp; c++){
            pilotosAMover.add(rankingPilotos.random(0,pilotosActuales));
        }
        System.out.println(pilotosAMover);
    }
    private void obtenerPosicionesADescalificar(Set<Integer> pilotosADescalificar) {
        int temp = pilotosActuales * 11 / 100;
        for (int c = 0; c < temp; c++){
            pilotosADescalificar.add(rankingPilotos.random(0,pilotosActuales));
        }
        System.out.println(pilotosADescalificar);
    }

    private void marcarDescalificado(Set pilotosADescalificar){
        for (Object in: pilotosADescalificar){
            rankingPilotos.marcarComoDescalificado((Integer) in);
            System.out.println(rankingPilotos.getPiloto((Integer) in));
            pilotosActuales--;
        }
        rankingPilotos.eliminarPilotosDescalificados();
    }
    private void adelantarPilotos(Set pilotosAMover){
        for (Object in: pilotosAMover){
            rankingPilotos.adelantarPiloto(rankingPilotos.getPiloto((Integer) in));
        }
    }

    private void configurarTabla(){
        DefaultTableModel tableModel = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){return false;}
        };
        tableModel.addColumn("Posición");
        tableModel.addColumn("Piloto");
        tableModel.addColumn("Escudería");
        table1.setModel(tableModel);
    }

    private void agregarATabla(Piloto piloto){
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addRow(new Object[]{piloto.getPosicionActual(),piloto.getNombre(),piloto.getEscuderia()});
    }

    private void recargarTabla(){
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int rowCount = model.getRowCount();
        for (int c = rowCount - 1; c >= 0; c--){
            model.removeRow(c);
        }

        for (int c = 0; c < pilotosActuales; c++){
            agregarATabla(rankingPilotos.getPiloto(c));
        }
    }

/*    private void descalificar(){
        int random1 = rankingPilotos.random(1,pilotosActuales);
        int random2 = rankingPilotos.random(1,pilotosActuales);
        int tmp = pilotosActuales/2;
        if (random1 > tmp){
            for (int c = random1; c < pilotosActuales; c++){
                if (c%random2 == 0){
                    rankingPilotos.marcarComoDescalificado(c);
                    pilotosActuales--;
                }
            }
        } else {
            for (int c = random1; c > 0; c--){
                if (c%random2 == 0){
                    rankingPilotos.marcarComoDescalificado(c);
                    pilotosActuales--;
                }
            }
        }
        rankingPilotos.eliminarPilotosDescalificados();
    }*/


}
