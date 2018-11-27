/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Horario;
import model.Reserva;
import model.Sala;
import model.Situacao;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class ReservaRecursoController {

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    public boolean criarReserva(ArrayList listaCriar) {
        boolean retorno = false;
        if (this.validarDados(listaCriar, false)) {
            Iterator iterator = listaCriar.iterator();

            Reserva novaReserva = new Reserva(
                    (String) iterator.next().toString(), //motivo
                    (Date) iterator.next(),//data
                    (Horario) iterator.next(),//horarioInicial
                    (Horario) iterator.next(),//horarioFinal
                    (boolean) iterator.next(),//confirmada
                    (Usuario) iterator.next(),//usuario
                    (Sala) iterator.next(),//sala
                    (Situacao) iterator.next()//situacao
            );
            retorno = novaReserva.insert();
        }

        return retorno;
    }

    public boolean editarReserva(ArrayList listaEditar) {

        boolean retorno = false;

        if (this.validarDados(listaEditar, true)) {
            Iterator iterator = listaEditar.iterator();
            Reserva editaReserva = new Reserva(
                    (int) iterator.next(),//id
                    (String) iterator.next().toString(), //motivo
                    (Date) iterator.next(),//data
                    (Horario) iterator.next(),//horarioInicial
                    (Horario) iterator.next(),//horarioFinal
                    (boolean) iterator.next(),//confirmada
                    (Usuario) iterator.next(),//usuario
                    (Sala) iterator.next(),//sala
                    (Situacao) iterator.next()//situacao
            );
            retorno = editaReserva.update();
        }
        return retorno;
    }

    public boolean excluirReserva(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão.\n");
            return false;
        }
        Reserva excluiReserva = new Reserva(id);
        return excluiReserva.delete();
    }

    public ArrayList listarTodasReservas() {
        ArrayList<Reserva> listagem = Reserva.selectAll();
        if(listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Reserva listaReserva = (Reserva) iterator.next();
            retorno.add(listaReserva.getId());
            retorno.add(listaReserva.getMotivo());
            retorno.add(listaReserva.getData());
            retorno.add(listaReserva.getHorarioInicial());
            retorno.add(listaReserva.getHorarioFinal());
            retorno.add(listaReserva.isConfirmada());
            retorno.add(listaReserva.getUsuario());
            retorno.add(listaReserva.getSala());
            retorno.add(listaReserva.getSituacao());
        }
        return retorno;
    }
    
    public ArrayList listarMinhasReservas() {
        ArrayList<Reserva> listagem = Reserva.selectAllMy();
        if (listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Reserva listaReserva = (Reserva) iterator.next();
            retorno.add(listaReserva.getId());
            retorno.add(listaReserva.getMotivo());
            retorno.add(listaReserva.getData());
            retorno.add(listaReserva.getHorarioInicial());
            retorno.add(listaReserva.getHorarioFinal());
            retorno.add(listaReserva.isConfirmada());
            retorno.add(listaReserva.getUsuario());
            retorno.add(listaReserva.getSala());
            retorno.add(listaReserva.getSituacao());
        }
        return retorno;
    }
    
    public ArrayList listarReservasDecisoes() {
        ArrayList<Reserva> listagem = Reserva.selectAllCoord();
        if(listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Reserva listaReserva = (Reserva) iterator.next();
            retorno.add(listaReserva.getId());
            retorno.add(listaReserva.getMotivo());
            retorno.add(listaReserva.getData());
            retorno.add(listaReserva.getHorarioInicial());
            retorno.add(listaReserva.getHorarioFinal());
            retorno.add(listaReserva.isConfirmada());
            retorno.add(listaReserva.getUsuario());
            retorno.add(listaReserva.getSala());
            retorno.add(listaReserva.getSituacao());
        }
        return retorno;
    }
    
    public ArrayList listarTodasReservasPorSala(String id) {
        ArrayList<Reserva> listagem = Reserva.selectAllSala(id);
        if (listagem == null) {
            return null;
        }
        Iterator iterator = listagem.iterator();
        ArrayList retorno = new ArrayList();

        if (listagem.isEmpty()) {
            return null;
        }

        while (iterator.hasNext()) {
            Reserva listaReserva = (Reserva) iterator.next();
            retorno.add(listaReserva.getId());
            retorno.add(listaReserva.getMotivo());
            retorno.add(listaReserva.getData());
            retorno.add(listaReserva.getHorarioInicial());
            retorno.add(listaReserva.getHorarioFinal());
            retorno.add(listaReserva.isConfirmada());
            retorno.add(listaReserva.getUsuario());
            retorno.add(listaReserva.getSala());
            retorno.add(listaReserva.getSituacao());
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
            String motivo = (String) iterator.next();
            if (motivo.isEmpty()) {
                message += "O campo motivo é obrigatório.\n";
                valido = false;
            }
            Date data = (Date) iterator.next();
            if (data == null) {
                message += "O campo data é obrigatório.\n";
                valido = false;
            }
            Horario horarioInicial = (Horario) iterator.next();
            if (horarioInicial == null) {
                message += "O campo horário inicial é obrigatório.\n";
                valido = false;
            }
            Horario horarioFinal = (Horario) iterator.next();
            if (horarioFinal == null) {
                message += "O campo horário final é obrigatório.\n";
                valido = false;
            }
            boolean confirmada = (boolean) iterator.next();
            if (confirmada != true && confirmada != false) {
                message += "Preencha o campo confirmada corretamente.\n";
                valido = false;
            }
            Usuario usuario = (Usuario) iterator.next();
            if (usuario == null) {
                message += "Preencha o campo usuário corretamente.\n";
                valido = false;
            }
            Sala sala = (Sala) iterator.next();
            if (sala == null) {
                message += "Preencha o campo sala corretamente.\n";
                valido = false;
            }
            Situacao situacao = (Situacao) iterator.next();
            if (situacao == null) {
                message += "Preencha o campo situação corretamente.\n";
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
