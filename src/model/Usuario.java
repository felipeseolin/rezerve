/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Seolin
 */
public final class Usuario extends UsuarioDAO {

    private int id;
    private String pNome;
    private String uNome;
    private String email;
    private String senha;
    private boolean ativo;
    private Departamento departamento;
    private TipoUsuario tipoUsuario;

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Usuario(int id, String pNome, String uNome, String email, String senha,
            boolean ativo
    ) {
        this.id = id;
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(int id, String pNome, String uNome, String email, boolean ativo
    ) {
        this.id = id;
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.ativo = ativo;
    }
    
    public Usuario(String pNome, String uNome, String email, boolean ativo) {
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.ativo = ativo;
    }
    
    public Usuario(int id, String pNome, String uNome, String email, boolean ativo,
            Departamento departamento, TipoUsuario tipoUsuario
    ) {
        this.id = id;
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.ativo = ativo;
        this.departamento = departamento;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String pNome, String uNome, String email, boolean ativo,
        Departamento departamento, TipoUsuario tipoUsuario
    ) {
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.ativo = ativo;
        this.departamento = departamento;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(int id, String pNome, String uNome, String email, String senha,
            boolean ativo, Departamento departamento, TipoUsuario tipoUsuario
    ) {
        this.id = id;
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.departamento = departamento;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String pNome, String uNome, String email, String senha,
            boolean ativo, Departamento departamento, TipoUsuario tipoUsuario
    ) {
        this.pNome = pNome;
        this.uNome = uNome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.departamento = departamento;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario() {
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
     * @return the pNome
     */
    public String getpNome() {
        return pNome;
    }

    /**
     * @param pNome the pNome to set
     */
    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    /**
     * @return the uNome
     */
    public String getuNome() {
        return uNome;
    }

    /**
     * @param uNome the uNome to set
     */
    public void setuNome(String uNome) {
        this.uNome = uNome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
     * @return the tipoUsuario
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" CONEXÃO COM BANCO ">
    public boolean insert() {
        return UsuarioDAO.insert(this);
    }

    public boolean update() {
        return UsuarioDAO.update(this);
    }

    public boolean delete() {
        return UsuarioDAO.delete(this.getId());
    }

    public static ArrayList<Usuario> selectAll() {
        return UsuarioDAO.selectAll();
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getpNome() + " "+ this.getuNome();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id == ((Usuario) obj).getId();
    }
    
}
