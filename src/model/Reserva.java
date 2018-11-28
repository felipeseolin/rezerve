/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ReservaDAO;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Seolin
 */
public final class Reserva extends ReservaDAO {

    private int id;
    private String motivo;
    private Date data;
    private Horario horarioInicial;
    private Horario horarioFinal;
    private boolean confirmada;
    private Usuario usuario;
    private Sala sala;
    private Situacao situacao;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Reserva(int id, String motivo, Date data, Horario horarioInicial,
            Horario horarioFinal, boolean confirmada, Usuario usuario, 
            Sala sala, Situacao situacao
    ) {
        this.id = id;
        this.motivo = motivo;
        this.data = data;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.confirmada = confirmada;
        this.usuario = usuario;
        this.sala = sala;
        this.situacao = situacao;
    }
    
    public Reserva(int id, String motivo, Date data, String horarioInicial,
            String horarioFinal, boolean confirmada, Usuario usuario,
            Sala sala, Situacao situacao
    ) {
        this.id = id;
        this.motivo = motivo;
        this.data = data;
        Horario horario = Horario.M1;
        horario.setValor(horarioInicial);
        this.horarioInicial = horario;
        horario.setValor(horarioFinal);
        this.horarioFinal = horario;
        this.confirmada = confirmada;
        this.usuario = usuario;
        this.sala = sala;
        this.situacao = situacao;
    }
    
    public Reserva(String motivo, Date data, Horario horarioInicial, 
            Horario horarioFinal, boolean confirmada, Usuario usuario, 
            Sala sala, Situacao situacao
    ) {
        this.motivo = motivo;
        this.data = data;
        this.confirmada = confirmada;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.usuario = usuario;
        this.sala = sala;
        this.situacao = situacao;
    }


    public Reserva(int id) {
        this.id = id;
    }

    public Reserva() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" GETTERS/SETTERS ">
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the horarioInicial
     */
    public Horario getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(Horario horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the horarioFinal
     */
    public Horario getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(Horario horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    /**
     * @return the confirmada
     */
    public boolean isConfirmada() {
        return confirmada;
    }

    /**
     * @param confirmada the confirmada to set
     */
    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the situacao
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return ReservaDAO.insert(this);
    }

    public boolean update() {
        return ReservaDAO.update(this);
    }

    public boolean delete() {
        return ReservaDAO.delete(this.getId());
    }

    public static ArrayList<Reserva> selectAll() {
        return ReservaDAO.selectAll();
    }
    
    public static ArrayList<Reserva> selectAllMy() {
        return ReservaDAO.selectAllMy();
    }
    
    public static ArrayList<Reserva> selectAllCoord() {
        return ReservaDAO.selectAllCoord();
    }
    
    public static ArrayList<Reserva> selectAllSala(String id) {
        return ReservaDAO.selectAllSala(id);
    }
    
    public static ArrayList<Reserva> selectAllFilter(ArrayList filtros) {
        return ReservaDAO.selectAllFilter(filtros);
    }
    // </editor-fold>

    @Override
    public String toString() {
        String retorno = this.getMotivo() == null ?
                "Todas as reservas" :
                "Reserva" + getMotivo();
        return retorno ;
    }    
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((Reserva) obj).getId();
    }
    
}
