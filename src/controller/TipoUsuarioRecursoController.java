/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.TipoUsuario;

/**
 *
 * @author Aluno
 */
public class TipoUsuarioRecursoController {

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarTipoUsuario(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();
            TipoUsuario novoTipoUsuario = new TipoUsuario(
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString()
            );
            retorno = novoTipoUsuario.insert();
        }

        return retorno;
    }

    public boolean editarTipoUsuario(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            TipoUsuario editaTipoUsuario = new TipoUsuario(
                    (int) iterator.next(),
                    (String) iterator.next(),
                    (String) iterator.next()
            );
            retorno = editaTipoUsuario.update();
        }
        return retorno;
    }

    public boolean excluirTipoUsuario(int id) {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        TipoUsuario excluiTipoUsuario = new TipoUsuario(id);
        return excluiTipoUsuario.delete();
    }

    public ArrayList listarTipoUsuario() {
        ArrayList<TipoUsuario> listagem = TipoUsuario.selectAll();
        if (listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            TipoUsuario listaTipoUsuario = (TipoUsuario) iterator.next();
            retorno.add(listaTipoUsuario.getId());
            retorno.add(listaTipoUsuario.getSigla());
            retorno.add(listaTipoUsuario.getNome());
        }

        return retorno;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" VALIDAÇÕES ">
    private boolean validarDados(ArrayList<String> lista, boolean editar) {
        Iterator iterator = lista.iterator();
        String message = "Erros: \n\n";
        boolean valido = true;
        try {
            if (editar) {
                iterator.next();//Passa verificação de id
            }
            String sigla = (String) iterator.next();
            if (sigla.isEmpty()
                    || !sigla.isEmpty() && sigla.trim().isEmpty()) {
                message += "O campo sigla é obrigatório.\n";
                valido = false;
            }
            String nome = (String) iterator.next();
            if (nome.isEmpty()
                    || !nome.isEmpty() && nome.trim().isEmpty()) {
                message += "O campo nome é obrigatório.\n";
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
