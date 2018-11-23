/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Bloco;
import model.Departamento;
import model.Sala;
import model.TipoSala;

/**
 *
 * @author Aluno
 */
public class SalaRecursoController {

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarSala(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar)) {
            Iterator iterator = listaCriar.iterator();

            Sala novaSala = new Sala(
                    (String) iterator.next(),
                    (int) iterator.next(),
                    (int) iterator.next(),
                    (int) iterator.next(),
                    (String) iterator.next(),
                    (boolean) iterator.next(),
                    (TipoSala) iterator.next(),
                    (Departamento) iterator.next(),
                    (Bloco) iterator.next()
            );
            retorno = novaSala.insert();
        }

        return retorno;
    }

    public boolean editarSala(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar)) {
            Iterator iterator = listaEditar.iterator();
            Sala editaSala = new Sala(
                    (String) iterator.next(),
                    (int) iterator.next(),
                    (int) iterator.next(),
                    (int) iterator.next(),
                    (String) iterator.next(),
                    (boolean) iterator.next(),
                    (TipoSala) iterator.next(),
                    (Departamento) iterator.next(),
                    (Bloco) iterator.next()
            );
            retorno = editaSala.update();
        }
        return retorno;
    }

    public boolean excluirSala(String id) {
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Sala excluiSala = new Sala(id);
        return excluiSala.delete();
    }

    public ArrayList listarSala() {
        ArrayList<Sala> listagem = Sala.selectAll();
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Sala listaSala = (Sala) iterator.next();
            retorno.add(listaSala.getId());
            retorno.add(listaSala.getNumero());
            retorno.add(listaSala.getNumeroCadeiras());
            retorno.add(listaSala.getNumeroComputadores());
            retorno.add(listaSala.getDetalhes());
            retorno.add(listaSala.isAtiva());
            retorno.add(listaSala.getTipoSala());
            retorno.add(listaSala.getDepartamento());
            retorno.add(listaSala.getBloco());
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
            String id = (String) iterator.next();
            if (id.isEmpty()) {
                message += "O campo id é obrigatório.\n";
                valido = false;
            }
            if ((int) iterator.next() <= 0) {
                message += "Número inválido.\n";
                valido = false;
            }
            if ((int) iterator.next() <= 0) {
                message += "Número de cadeiras inválido.\n";
                valido = false;
            }
            if ((int) iterator.next() < 0) {
                message += "Número de computadores inválido.\n";
                valido = false;
            }
            String detalhes = (String) iterator.next();
            if (!detalhes.isEmpty() && detalhes.trim().isEmpty()) {
                message += "Preencha o campo detalhes corretamente.\n";
                valido = false;
            }
            boolean ativo = (boolean) iterator.next();
            if (ativo != true && ativo != false) {
                message += "Preencha o campo ativo corretamente.\n";
                valido = false;
            }
            TipoSala tipoSala = (TipoSala) iterator.next();
            if (tipoSala == null) {
                message += "Preencha o campo tipo de sala corretamente.\n";
                valido = false;
            }
            Departamento departamento = (Departamento) iterator.next();
            if (departamento == null) {
                message += "Preencha o campo departamento corretamente.\n";
                valido = false;
            }
            Bloco bloco = (Bloco) iterator.next();
            if (bloco == null) {
                message += "Preencha o campo bloco corretamente.\n";
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
