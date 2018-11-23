/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.LoginDAO;

/**
 *
 * @author DIPROSI-01
 */
public class Login{
    
    private static Usuario usuario;
    private static boolean autenticado;
    
    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    public Login(Usuario usuario) {
        Login.usuario = usuario;
    }
    
    public Login(Usuario usuario, boolean autenticado) {
        Login.usuario = usuario;
        Login.autenticado = autenticado;
    }
    
    public Login() { }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" CONSTRUTORES ">
    /**
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public static void setUsuario(Usuario usuario) {
        Login.usuario = usuario;
    }

    /**
     * @return the autenticado
     */
    public static boolean isAutenticado() {
        return autenticado;
    }

    /**
     * @param autenticado the autenticado to set
     */
    public static void setAutenticado(boolean autenticado) {
        Login.autenticado = autenticado;
    }
// </editor-fold>    
    
    public static void doLogin() {
        LoginDAO.autentica(usuario);
    }
    
    public static void setSenha(String senha){
        Usuario user = Login.getUsuario();
        user.setSenha(senha);
        Login.setUsuario(user);
    }
    
    public static void setSenhaNull() {
        Usuario user = Login.getUsuario();
        user.setSenha("");
        Login.setUsuario(user);
    }
    
}
