/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Situacao;

/**
 *
 * @author Seolin
 */
public class SituacaoRecursoController {

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarSituacao(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();

            Situacao novoSituacao = new Situacao(
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString()
            );
            retorno = novoSituacao.insert();
        }

        return retorno;
    }

    public boolean editarSituacao(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            Situacao editaSituacao = new Situacao(
                    (int) iterator.next(),
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString()
            );
            retorno = editaSituacao.update();
        }
        return retorno;
    }

    public boolean excluirSituacao(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Situacao excluiSituacao = new Situacao(id);
        return excluiSituacao.delete();
    }

    public ArrayList listarSituacoes() {
        ArrayList<Situacao> listagem = Situacao.selectAll();
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Situacao listaSituacao = (Situacao) iterator.next();
            retorno.add(listaSituacao.getId());
            retorno.add(listaSituacao.getNome());
            retorno.add(listaSituacao.getMensagem());
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
            String nome = (String) iterator.next();
            if (nome.isEmpty()
                    || !nome.isEmpty() && nome.trim().isEmpty()) {
                message += "O campo nome é obrigatório.\n";
                valido = false;
            }
            String mensagem = (String) iterator.next();
            if (mensagem.isEmpty()
                    || !mensagem.isEmpty() && mensagem.trim().isEmpty()) {
                message += "O campo mensagem é obrigatório.\n";
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
