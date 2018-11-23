/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.BDController;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Situacao;

/**
 *
 * @author Seolin
 */
public class SituacaoDAO {

    private static BDController bd = new BDController();
    private static Connection connection = null;

    public SituacaoDAO() {
        connection = bd.conectaBD();
    }

    /**
     * Método responsável por inserir uma instância de situacao no banco de dados
     *
     * @param situacao
     * @return
     */
    protected static boolean insert(Situacao situacao) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "Insert into SITUACAO (SIT_NOME, SIT_MENSAGEM)"
                + "values (?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, situacao.getNome());
            pstdados.setString(2, situacao.getMensagem());
            pstdados.executeUpdate();
            //Chama o Commit
            connection = bd.commit(connection);
            //Ocorreu tudo bem e o objeto está salvo
            retorno = true;
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, pstdados);
        }
        return retorno;
    }

    /**
     * Método responsável por editar uma instância de situacao no banco de dados
     *
     * @param situacao
     * @return
     */
    protected static boolean update(Situacao situacao) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "update SITUACAO set SIT_NOME = ? ,"
                + " SIT_MENSAGEM = ? "
                + "where SIT_ID = ? ";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, situacao.getNome());
            pstdados.setString(2, situacao.getMensagem());
            pstdados.setInt(3, situacao.getId());

            pstdados.executeUpdate();
            //Chama o Commit
            connection = bd.commit(connection);
            //Ocorreu tudo bem e o objeto está salvo
            retorno = true;
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, pstdados);
        }
        return retorno;
    }

    /**
     * Método responsável por deletar uma instância de situacao no banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;

        try {
            String sqldml = "delete from SITUACAO where SIT_ID = ?";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            pstdados.setInt(1, id);
            pstdados.executeUpdate();
            //Chama o Commit
            connection = bd.commit(connection);
            //Ocorreu tudo bem e o objeto está salvo
            retorno = true;
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, pstdados);
        }
        return retorno;
    }

    /**
     * Método responsável por listar todos os registros de situacao
     *
     * @return
     */
    protected static ArrayList<Situacao> selectAll() {
        CallableStatement cstdados = null;
        ResultSet rs = null;
        ArrayList<Situacao> retornoLista = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            cstdados = connection.prepareCall("{call listaSituacoes()}", tipo, concorrencia);
            rs = cstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Situacao>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    Situacao situacao = new Situacao(
                            (int) iterator.next(),
                            (String) iterator.next().toString(),
                            (String) iterator.next().toString()
                    );
                    retornoLista.add(situacao);
                }
            } while (rs.next());
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, cstdados, rs);
        }
        return retornoLista;
    }

}
