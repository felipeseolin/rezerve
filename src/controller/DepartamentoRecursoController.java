/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Departamento;

/**
 *
 * @author Seolin
 */
public class DepartamentoRecursoController {
    
    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarDepartamento(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();

            Departamento novoDepartamento = new Departamento(
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString(),
                    (boolean) iterator.next()
            );
            retorno = novoDepartamento.insert();
        }

        return retorno;
    }

    public boolean editarDepartamento(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            Departamento editaDepartamento = new Departamento(
                    (int) iterator.next(),
                    (String) iterator.next(),
                    (String) iterator.next(),
                    (boolean) iterator.next()
            );
            retorno = editaDepartamento.update();
        }
        return retorno;
    }

    public boolean excluirDepartamento(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Departamento excluiDepartamento = new Departamento(id);
        return excluiDepartamento.delete();
    }

    public ArrayList listarDepartamento() {
        ArrayList<Departamento> listagem = Departamento.selectAll();
        if (listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Departamento listaDepartamento = (Departamento) iterator.next();
            retorno.add(listaDepartamento.getId());
            retorno.add(listaDepartamento.getNome());
            retorno.add(listaDepartamento.getSigla());
            retorno.add(listaDepartamento.isAtivo());
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
            if(editar) {
                iterator.next();//Passa verificação de id
            }
            String nome = (String) iterator.next();
            if (nome.isEmpty()) {
                message += "O campo nome é obrigatório.\n";
                valido = false;
            }
            String sigla = (String) iterator.next();
            if (sigla.isEmpty()) {
                message += "O campo sigla é obrigatório.\n";
                valido = false;
            }
            boolean ativo = (boolean) iterator.next();
            if (ativo != true && ativo != false) {
                message += "Preencha o campo ativo corretamente.\n";
                valido = false;
            }
        } catch (Exception errror) {
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
