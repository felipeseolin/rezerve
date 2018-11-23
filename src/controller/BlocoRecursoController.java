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

/**
 *
 * @author Seolin
 */
public class BlocoRecursoController {
 
    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarBloco(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();

            Bloco novoBloco = new Bloco(
                    (char) iterator.next(),
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString(),
                    (boolean) iterator.next()
            );
            retorno = novoBloco.insert();
        }

        return retorno;
    }

    public boolean editarBloco(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            Bloco editaBloco = new Bloco(
                    (int) iterator.next(),
                    (char) iterator.next(),
                    (String) iterator.next().toString(),
                    (String) iterator.next().toString(),
                    (boolean) iterator.next()
            );
            retorno = editaBloco.update();
        }
        return retorno;
    }

    public boolean excluirBloco(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Bloco excluiBloco = new Bloco(id);
        return excluiBloco.delete();
    }

    public ArrayList listarBlocos() {
        ArrayList<Bloco> listagem = Bloco.selectAll();
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Bloco listaBloco = (Bloco) iterator.next();
            retorno.add(listaBloco.getId());
            retorno.add(listaBloco.getLetra());
            retorno.add(listaBloco.getNome());
            retorno.add(listaBloco.getDescricao());
            retorno.add(listaBloco.isAtivo());
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
            iterator.next(); //Passa verificação de char
            String nome = (String) iterator.next();
            if (nome.isEmpty()) {
                message += "O campo nome é obrigatório.\n";
                valido = false;
            }
            String descricao = (String) iterator.next();
            if (!descricao.isEmpty() && descricao.trim().isEmpty()) {
                message += "Preencha o campo descricao corretamente.\n";
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
