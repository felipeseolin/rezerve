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
import model.Bloco;

/**
 *
 * @author Seolin
 */
public class BlocoDAO {
 
    private static BDController bd = new BDController();
    private static Connection connection = null;

    public BlocoDAO() {
        connection = bd.conectaBD();
    }

    /**
     * Método responsável por inserir uma instância de bloco no banco de
     * dados
     *
     * @param bloco
     * @return
     */
    protected static boolean insert(Bloco bloco) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "Insert into BLOCO (BLOC_LETRA, BLOC_NOME, "
                + "BLOC_DESCRICAO, BLOC_ATIVO)"
                + "values (?,?,?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, Character.toString(bloco.getLetra()));
            pstdados.setString(2, bloco.getNome());
            pstdados.setString(3, bloco.getDescricao());
            pstdados.setBoolean(4, bloco.isAtivo());
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
     * Método responsável por editar uma instância de bloco no banco de
     * dados
     *
     * @param bloco
     * @return
     */
    protected static boolean update(Bloco bloco) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "update BLOCO set BLOC_LETRA= ? ,"
                + "BLOC_NOME = ? ,"
                + "BLOC_DESCRICAO = ? ,"
                + "BLOC_ATIVO = ? "
                + "where BLOC_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, Character.toString(bloco.getLetra()));
            pstdados.setString(2, bloco.getNome());
            pstdados.setString(3, bloco.getDescricao());
            pstdados.setBoolean(4, bloco.isAtivo());
            pstdados.setInt(5, bloco.getId());

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
     * Método responsável por deletar uma instância de bloco no banco de
     * dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;

        try {
            String sqldml = "delete from BLOCO where DEP_ID = ?";

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
     * Método responsável por listar todos os registros de blocos
     *
     * @return
     */
    protected static ArrayList<Bloco> selectAll() {
        CallableStatement cstdados = null;
        ResultSet rs = null;
        ArrayList<Bloco> retornoLista = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            cstdados = connection.prepareCall("{call listaBlocos()}", tipo, concorrencia);
            rs = cstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Bloco>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    Bloco bloco = new Bloco(
                            (int) iterator.next(),
                            (char) iterator.next().toString().charAt(0),
                            (String) iterator.next().toString(),
                            (String) iterator.next().toString(),
                            (boolean) iterator.next()
                    );
                    retornoLista.add(bloco);
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
 