/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.BlocoDAO;
import java.util.ArrayList;

/**
 *
 * @author Seolin
 */
public final class Bloco extends BlocoDAO {
    
    private int id;
    private char letra;
    private String nome;
    private String descricao;
    private boolean ativo;
    
    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Bloco(int id, char letra, String nome, String descricao, 
            boolean ativo
    ) {
        this.id = id;
        this.letra = letra;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public Bloco(char letra, String nome, String descricao, boolean ativo) {
        this.letra = letra;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public Bloco(int id) {
        this.id = id;
    }
    
    public Bloco() { }
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
     * @return the letra
     */
    public char getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(char letra) {
        this.letra = letra;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return BlocoDAO.insert(this);
    }

    public boolean update() {
        return BlocoDAO.update(this);
    }

    public boolean delete() {
        return BlocoDAO.delete(this.getId());
    }

    public static ArrayList<Bloco> selectAll() {
        return BlocoDAO.selectAll();
    }
    // </editor-fold>
    
    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Bloco) obj).getId();
    }
}
