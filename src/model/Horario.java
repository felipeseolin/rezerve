/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Seolin
 */
public enum Horario {
    M1("M1 (07h30 - 08h20)"),
    M2("M2 (08h20 - 09h10)"),
    M3("M3 (09h10 - 10h00)"),
    M4("M4 (10h20 - 11h10)"),
    M5("M5 (11h10 - 12h00)"),
    M6("M6 (12h00 - 12h50)"),
    T1("T1 (13h00 - 13h50)"),
    T2("T2 (13h50 - 14h40)"),
    T3("T3 (14h40 - 15h30)"),
    T4("T4 (15h50 - 16h40)"),
    T5("T5 (16h40 - 17h30)"),
    T6("T6 (17h50 - 18h40)"),
    N1("N1 (18h40 - 19h30)"),
    N2("N2 (19h30 - 20h20)"),
    N3("N3 (20h20 - 21h10)"),
    N4("N4 (21h20 - 22h10)"),
    N5("N5 (22h10 - 23h00)");
    
    public String valorHorario;

    Horario(String valor) {
        this.valorHorario = valor;
    }
    
    public String getValor() {
        return valorHorario;
    }
    
    public void setValor(String valor) {
        this.valorHorario = valor;
    }
    
    public static Horario valorHorario(String horario) {
        switch (horario) {
            case "M1 (07h30 - 08h20)":
                return Horario.M1;
            case "M2 (08h20 - 09h10)":
                return Horario.M2;
            case "M3 (09h10 - 10h00)":
                return Horario.M3;
            case "M4 (10h20 - 11h10)":
                return Horario.M4;
            case "M5 (11h10 - 12h00)":
                return Horario.M5;
            case "M6 (12h00 - 12h50)":
                return Horario.M6;
            case "T1 (13h00 - 13h50)":
                return Horario.T1;
            case "T2 (13h50 - 14h40)":
                return Horario.T2;
            case "T3 (14h40 - 15h30)":
                return Horario.T3;
            case "T4 (15h50 - 16h40)":
                return Horario.T4;
            case "T5 (16h40 - 17h30)":
                return Horario.T5;
            case "T6 (17h50 - 18h40)":
                return Horario.T6;
            case "N1 (18h40 - 19h30)":
                return Horario.N1;
            case "N2 (19h30 - 20h20)":
                return Horario.N2;
            case "N3 (20h20 - 21h10)":
                return Horario.N3;
            case "N4 (21h20 - 22h10)":
                return Horario.N4;
            case "N5 (22h10 - 23h00)":
                return Horario.N5;
            default:
                return null;
        }
    }

    public static int valorHorario(Horario horario) {
        switch (horario.toString()) {
            case "M1 (07h30 - 08h20)":
                return 1;
            case "M2 (08h20 - 09h10)":
                return 2;
            case "M3 (09h10 - 10h00)":
                return 3;
            case "M4 (10h20 - 11h10)":
                return 4;
            case "M5 (11h10 - 12h00)":
                return 5;
            case "M6 (12h00 - 12h50)":
                return 6;
            case "T1 (13h00 - 13h50)":
                return 7;
            case "T2 (13h50 - 14h40)":
                return 8;
            case "T3 (14h40 - 15h30)":
                return 9;
            case "T4 (15h50 - 16h40)":
                return 10;
            case "T5 (16h40 - 17h30)":
                return 11;
            case "T6 (17h50 - 18h40)":
                return 12;
            case "N1 (18h40 - 19h30)":
                return 13;
            case "N2 (19h30 - 20h20)":
                return 14;
            case "N3 (20h20 - 21h10)":
                return 15;
            case "N4 (21h20 - 22h10)":
                return 16;
            case "N5 (22h10 - 23h00)":
                return 17;
            default:
                return 0;
        }
    }
    
    @Override
    public String toString() {
        return getValor(); //To change body of generated methods, choose Tools | Templates.
    }
}
