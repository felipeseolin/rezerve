/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.SalaDAO;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public final class Sala extends SalaDAO {

    private String id;
    private int numero;
    private int numeroCadeiras;
    private int numeroComputadores;
    private String detalhes;
    private boolean ativa;
    private TipoSala tipoSala;
    private Departamento departamento;
    private Bloco bloco;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Sala(String id, int numero, int numeroCadeiras,
            int numeroComputadores, String detalhes, boolean ativa,
            TipoSala tipoSala, Departamento departamento, Bloco bloco
    ) {
        this.id = id;
        this.numero = numero;
        this.numeroCadeiras = numeroCadeiras;
        this.numeroComputadores = numeroComputadores;
        this.detalhes = detalhes;
        this.ativa = ativa;
        this.tipoSala = tipoSala;
        this.departamento = departamento;
        this.bloco = bloco;
    }

    public Sala(String id) {
        this.id = id;
    }

    public Sala() {
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" GETTERS/SETTERS ">
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the numeroCadeiras
     */
    public int getNumeroCadeiras() {
        return numeroCadeiras;
    }

    /**
     * @param numeroCadeiras the numeroCadeiras to set
     */
    public void setNumeroCadeiras(int numeroCadeiras) {
        this.numeroCadeiras = numeroCadeiras;
    }

    /**
     * @return the numeroComputadores
     */
    public int getNumeroComputadores() {
        return numeroComputadores;
    }

    /**
     * @param numeroComputadores the numeroComputadores to set
     */
    public void setNumeroComputadores(int numeroComputadores) {
        this.numeroComputadores = numeroComputadores;
    }

    /**
     * @return the detalhes
     */
    public String getDetalhes() {
        return detalhes;
    }

    /**
     * @param detalhes the detalhes to set
     */
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    /**
     * @return the ativa
     */
    public boolean isAtiva() {
        return ativa;
    }

    /**
     * @param ativa the ativa to set
     */
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    /**
     * @return the tipoSala
     */
    public TipoSala getTipoSala() {
        return tipoSala;
    }

    /**
     * @param tipoSala the tipoSala to set
     */
    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the bloco
     */
    public Bloco getBloco() {
        return bloco;
    }

    /**
     * @param bloco the bloco to set
     */
    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return SalaDAO.insert(this);
    }

    public boolean update() {
        return SalaDAO.update(this);
    }

    public boolean delete() {
        return SalaDAO.delete(this.getId());
    }

    public static ArrayList<Sala> selectAll() {
        return SalaDAO.selectAll();
    }
    
    public static ArrayList<Sala> selectAllFilter(ArrayList filtros) {
        return SalaDAO.selectAllFilter(filtros);
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getId() == null ?
                "Todas" : this.getId();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this.getId() == null) {
            return false;
        } else {
            return this.getId().equals(((Sala) obj).getId());
        }
    }

}
