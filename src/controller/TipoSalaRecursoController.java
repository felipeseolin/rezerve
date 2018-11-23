/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.TipoSala;

/**
 *
 * @author Aluno
 */
public class TipoSalaRecursoController {
    
    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarTipoSala(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();

            TipoSala novaSala = new TipoSala(
                    (String) iterator.next()
            );
            retorno = novaSala.insert();
        }

        return retorno;
    }

    public boolean editarTipoSala(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            TipoSala editaSala = new TipoSala(
                    (int) iterator.next(),
                    (String) iterator.next()
            );
            retorno = editaSala.update();
        }
        return retorno;
    }

    public boolean excluirTipoSala(int id) {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        TipoSala excluiSala = new TipoSala(id);
        return excluiSala.delete();
    }

    public ArrayList listarTipoSala() {
        ArrayList<TipoSala> listagem = TipoSala.selectAll();
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            TipoSala listaTipoSala = (TipoSala) iterator.next();
            retorno.add(listaTipoSala.getId());
            retorno.add(listaTipoSala.getNome());
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
            if (nome.isEmpty() ||
                !nome.isEmpty() && nome.trim().isEmpty()
            ) {
                message += "O campo nome é obrigatório.\n";
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
