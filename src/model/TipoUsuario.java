/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.TipoUsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public final class TipoUsuario extends TipoUsuarioDAO {

    private int id;
    private String sigla;
    private String nome;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public TipoUsuario(int id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla.toUpperCase();
        this.nome = nome;
    }
    
    public TipoUsuario(String sigla, String nome) {
        this.sigla = sigla.toUpperCase();
        this.nome = nome;
    }

    public TipoUsuario(int id) {
        this.id = id;
    }

    public TipoUsuario(String nome) {
        this.nome = nome;
    }

    public TipoUsuario() {    }
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
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
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
        return TipoUsuarioDAO.insert(this);
    }

    public boolean update() {
        return TipoUsuarioDAO.update(this);
    }

    public boolean delete() {
        return TipoUsuarioDAO.delete(this.getId());
    }

    public static ArrayList<TipoUsuario> selectAll() {
        return TipoUsuarioDAO.selectAll();
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.nome == null ?
                "Todos" : this.getNome();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((TipoUsuario) obj).getId();
    }
}
