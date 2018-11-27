/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Departamento;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioRecursoController {

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarUsuario(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar)) {
            Iterator iterator = listaCriar.iterator();
            Usuario novoUsuario = null;
            int id = (int) iterator.next();
            if (id > 0) {
                novoUsuario = new Usuario(
                        id,
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (boolean) iterator.next(),
                        (Departamento) iterator.next(),
                        (TipoUsuario) iterator.next()
                );
            } else {
                novoUsuario = new Usuario(
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (String) iterator.next(),
                        (boolean) iterator.next(),
                        (Departamento) iterator.next(),
                        (TipoUsuario) iterator.next()
                );
            }
            retorno = novoUsuario.insert();
        }

        return retorno;
    }

    public boolean editarUsuario(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar)) {
            Iterator iterator = listaEditar.iterator();
            Usuario editaUsuario = new Usuario(
                    (int) iterator.next(),
                    (String) iterator.next(),
                    (String) iterator.next(),
                    (String) iterator.next(),
                    (String) iterator.next(),
                    (boolean) iterator.next(),
                    (Departamento) iterator.next(),
                    (TipoUsuario) iterator.next()
            );
            retorno = editaUsuario.update();
        }
        return retorno;
    }

    public boolean excluirUsuario(int id) {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Usuario excluiUsuario = new Usuario(id);
        return excluiUsuario.delete();
    }

    public ArrayList listarUsuarios() {
        ArrayList<Usuario> listagem = Usuario.selectAll();
        if (listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Usuario listaUsuario = (Usuario) iterator.next();
            retorno.add(listaUsuario.getId());
            retorno.add(listaUsuario.getpNome());
            retorno.add(listaUsuario.getuNome());
            retorno.add(listaUsuario.getEmail());
            retorno.add(listaUsuario.isAtivo());
            retorno.add(listaUsuario.getDepartamento());
            retorno.add(listaUsuario.getTipoUsuario());
        }

        return retorno;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" VALIDAÇÕES ">
    private boolean validarDados(ArrayList<String> lista) {
        Iterator iterator = lista.iterator();
        String message = "Erros: \n\n";
        boolean valido = true;
        try {
            iterator.next();//Passa verificação de id
            String pnome = (String) iterator.next();
            if (pnome.isEmpty()
                    || !pnome.isEmpty() && pnome.trim().isEmpty()
                    || !pnome.matches("[A-Z][a-zA-Z]*")) {
                message += "O campo pnome é obrigatório.\n";
                valido = false;
            }
            String unome = (String) iterator.next();
            if (unome.isEmpty()
                    || !unome.isEmpty() && unome.trim().isEmpty()
                    || !unome.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
                message += "O campo unome é obrigatório.\n";
                valido = false;
            }
            String email = (String) iterator.next();
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (email.isEmpty()
                    || !email.isEmpty() && email.trim().isEmpty()
                    || !matcher.matches()) {
                message += "O campo email é obrigatório.\n";
                valido = false;
            }
            String senha = (String) iterator.next();
            if (senha.isEmpty()
                    || !senha.isEmpty() && senha.trim().isEmpty()) {
                message += "O campo senha é obrigatório.\n";
                valido = false;
            }
            boolean ativo = (boolean) iterator.next();
            if (ativo != true && ativo != false) {
                message += "Preencha o campo ativo corretamente.\n";
                valido = false;
            }
            Departamento departamento = (Departamento) iterator.next();
            if (departamento == null) {
                message += "Preencha o campo departamento corretamente.\n";
                valido = false;
            }
            TipoUsuario tipoUsuario = (TipoUsuario) iterator.next();
            if (tipoUsuario == null) {
                message += "Preencha o campo tipo de usuário corretamente.\n";
                valido = false;
            }
        } catch (Exception error) {
            message += "\nConfira todos os campos!\n";
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(null, message);
        }
        return valido;
    }
// </editor-fold>

}
