/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.SituacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author Seolin
 */
public final class Situacao extends SituacaoDAO {

    private int id;
    private String nome;
    private String mensagem;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Situacao(int id, String nome, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.mensagem = mensagem;
    }
    
    public Situacao(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public Situacao(int id) {
        this.id = id;
    }

    public Situacao() {
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
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return SituacaoDAO.insert(this);
    }

    public boolean update() {
        return SituacaoDAO.update(this);
    }

    public boolean delete() {
        return SituacaoDAO.delete(this.getId());
    }

    public static ArrayList<Situacao> selectAll() {
        return SituacaoDAO.selectAll();
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getNome();
    } 
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((Situacao) obj).getId();
    }
}
