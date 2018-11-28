/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.TipoSalaDAO;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public final class TipoSala extends TipoSalaDAO {
    
    private int id;
    private String nome;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public TipoSala(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public TipoSala(int id) {
        this.id = id;
    }
    
    public TipoSala(String nome) {
        this.nome = nome;
    }
    
    public TipoSala() { }
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
    // </editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return TipoSalaDAO.insert(this);
    }

    public boolean update() {
        return TipoSalaDAO.update(this);
    }

    public boolean delete() {
        return TipoSalaDAO.delete(this.id);
    }

    public static ArrayList<TipoSala> selectAll() {
        return TipoSalaDAO.selectAll();
    }
    // </editor-fold>

    @Override
    public String toString() {
        return getNome() == null ? 
                "Todos" : getNome();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((TipoSala) obj).getId();
    }
}
