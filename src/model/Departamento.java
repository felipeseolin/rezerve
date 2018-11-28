/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DepartamentoDAO;
import java.util.ArrayList;

/**
 *
 * @author Seolin
 */
public final class Departamento extends DepartamentoDAO {
    
    private int id;
    private String nome;
    private String sigla;
    private boolean ativo;
    
    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Departamento(int id, String nome, String sigla, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ativo = ativo;
    }
    
    public Departamento(String nome, String sigla, boolean ativo) {
        this.nome = nome;
        this.sigla = sigla;
        this.ativo = ativo;
    }
    
    public Departamento(int id) {
        this.id = id;
    }
    
    public Departamento() { }
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return DepartamentoDAO.insert(this);
    }

    public boolean update() {
        return DepartamentoDAO.update(this);
    }

    public boolean delete() {
        return DepartamentoDAO.delete(this.id);
    }

    public static ArrayList<Departamento> selectAll() {
        return DepartamentoDAO.selectAll();
    }
    // </editor-fold>

    @Override
    public String toString() {
        if (this.sigla == null && this.nome == null) {
            return "Todos";
        }
        return this.sigla + " - " + this.nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((Departamento) obj).getId();
    }
}
