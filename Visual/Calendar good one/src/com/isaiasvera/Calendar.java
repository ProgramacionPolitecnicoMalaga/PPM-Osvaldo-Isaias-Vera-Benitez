package com.isaiasvera;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.TimePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class Calendar {
    private JPanel panelMain, panelCalendario1, panelCalendario2, panelTitulo, panelSubTitulo, panelBoton, panelTiempo, panelAMD, panelHMS;
    private JLabel Titulo, Titulo1, Titulo2, Titulo3;
    private CalendarPanel calendarPanel1, calendarPanel2;
    private TimePicker timePicker1, timePicker2;
    private JButton btnCalcular;
    private JLabel Año, Mes, Dia;
    private JTextField txtAño, txtMes, txtDia;
    private JLabel Hora, Minuto, Segundo;
    private JTextField txtHora, txtMinuto, txtSegundo;
    private String hora1 = "", hora2 = "";
    private String[] timeParts1, timeParts2;
    private LocalDate date1, date2;

    public Calendar() {
        timePicker1.getComponentToggleTimeMenuButton().setVisible(false);
        timePicker1.getSettings().setFormatForDisplayTime("HH:mm:ss");
        timePicker1.setEnableArrowKeys(false);
        timePicker2.getComponentToggleTimeMenuButton().setVisible(false);
        timePicker2.getSettings().setFormatForDisplayTime("HH:mm:ss");
        timePicker2.setEnableArrowKeys(false);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hora1 = timePicker1.getText();
                timeParts1 = hora1.split(":");
                hora2 = timePicker2.getText();
                timeParts2 = hora2.split(":");
                if (!hora1.equals("") && !hora2.equals("")){
                    calcularDiferenciaHMS();
                }
                date1 = calendarPanel1.getSelectedDate();
                date2 = calendarPanel2.getSelectedDate();
                if (date1 != null && date2 != null){
                    calcularFechas();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar");
        frame.setContentPane(new Calendar().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void calcularDiferenciaHMS(){
        int resta;
        String temp = "";
        for (int c = 0; c < timeParts1.length; c++){
            resta = Integer.parseInt(timeParts1[c]) - Integer.parseInt(timeParts2[c]);
            if (resta < 0){
                resta = Math.abs(resta);
            }
            temp = String.valueOf(resta);
            if (c == 0){
                txtHora.setText(temp);
            } else if (c == 1){
                txtMinuto.setText(temp);
            } else if (c == 2){
                txtSegundo.setText(temp);
            }
        }
    }

    public void calcularFechas(){
        Period diff = Period.between(date1,date2);
        txtAño.setText(String.valueOf(diff.getYears()));
        txtMes.setText(String.valueOf(diff.getMonths()));
        txtDia.setText(String.valueOf(diff.getDays()));
    }

}
