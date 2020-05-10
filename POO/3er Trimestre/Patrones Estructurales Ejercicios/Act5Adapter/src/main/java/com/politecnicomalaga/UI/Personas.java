package com.politecnicomalaga.UI;

import com.politecnicomalaga.modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Personas {
    AdaptadorTabla adaptadorTabla;

    private JPanel panelMain;
    private JTable tblMain;
    private JScrollPane jspMain;
    private JButton btnBorrar, btnPrint, btnInsertar;
    private List<Persona> personaList;

    public Personas(){
        personaList = new ArrayList<>(){
            @Override
            public String toString() {
                String temp = "";
                for (Persona p : personaList){
                    temp += p.toString() + "\n";
                }
                return temp;
            }
        };
        init();
        adaptadorTabla = new AdaptadorTabla(personaList);
        tblMain.setModel(adaptadorTabla);
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaptadorTabla.removeRow(tblMain.getSelectedRow());
            }
        });
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(personaList);
            }
        });
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaptadorTabla.addRow();
            }
        });
    }

    public JPanel getPanel(){
        return panelMain;
    }

    private void init(){
        personaList.add(new Persona("Paul","Walker",40));
        personaList.add(new Persona("Kobe","Bryant",41));
        personaList.add(new Persona("Michael","Robinson",61));
        personaList.add(new Persona("Max","Wright",75));
        personaList.add(new Persona("Lisa","Sheridan",44));
        personaList.add(new Persona("Stephen","Hawking",76));
        personaList.add(new Persona("Stan","Lee",95));
        personaList.add(new Persona("Chester","Bennington",41));
        personaList.add(new Persona("Stefán","Stefánsson",43));
    }
}
