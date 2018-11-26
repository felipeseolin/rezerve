/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.BDController;
import model.BCrypt;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import model.Usuario;
import model.Login;

/**
 *
 * @author DIPROSI-01
 */
public class LoginDAO {
    
    private static BDController bd = new BDController();
    private static Connection connection = null;

    public LoginDAO() {
        connection = bd.conectaBD();
    }
    
    public static void autentica(Usuario user) {
        ArrayList usuarios = UsuarioDAO.selectAllWithPass();
        Iterator iterator = usuarios.iterator();
        
        while(iterator.hasNext()) {
            Usuario usuario = (Usuario) iterator.next();
            String email = usuario.getEmail();
            String senha = usuario.getSenha();
            boolean verificaHash = BCrypt.checkpw(user.getSenha(), senha);
            if(verificaHash == true){
                if(email.equals(user.getEmail())) {
                    usuario.setSenha("");
                    Login.setUsuario(usuario);
                    Login.setAutenticado(true);
                    return;
                }
            }
        }
        Login.setSenhaNull();
        Login.setAutenticado(false);
    }   
}
