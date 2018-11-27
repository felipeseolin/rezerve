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
import model.TipoUsuario;

/**
 *
 * @author Aluno
 */
public class TipoUsuarioDAO {

    /**
     * Método responsável por inserir uma instância de tipo de usuario no banco de
     * dados
     *
     * @param tipoUsuario
     * @return
     */
    protected static boolean insert(TipoUsuario tipoUsuario) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        BDController bd = new BDController();
        Connection connection = null;
        String sqldml = "Insert into TIPO_DE_USUARIO (TIPUS_SIGLA, TIPUS_NOME) "
                + "values (?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, tipoUsuario.getSigla());
            pstdados.setString(2, tipoUsuario.getNome());
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
     * Método responsável por editar uma instância de tipo de usuario no banco de
     * dados
     *
     * @param tipoUsuario
     * @return
     */
    protected static boolean update(TipoUsuario tipoUsuario) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        BDController bd = new BDController();
        Connection connection = null;
        String sqldml = "update TIPO_DE_USUARIO set TIPUS_SIGLA= ?, "
                + " TIPUS_NOME = ? "
                + " where TIPUS_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, tipoUsuario.getSigla());
            pstdados.setString(2, tipoUsuario.getNome());
            pstdados.setInt(3, tipoUsuario.getId());
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
     * Método responsável por deletar uma instância de tipo de usuario no banco de
     * dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        BDController bd = new BDController();
        Connection connection = null;

        try {
            String sqldml = "delete from TIPO_DE_USUARIO where TIPUS_ID = ?";

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
     * Método responsável por listar todos os registros de tipo de usuario
     *
     * @return
     */
    protected static ArrayList<TipoUsuario> selectAll() {
        CallableStatement cstdados = null;
        ResultSet rs = null;
        ArrayList<TipoUsuario> retornoLista = null;
        BDController bd = new BDController();
        Connection connection = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            cstdados = connection.prepareCall("{call listaTipoDeUsuarios()}", tipo, concorrencia);
            rs = cstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<TipoUsuario>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    TipoUsuario tipoUsuario = new TipoUsuario(
                            (int) iterator.next(),
                            (String) iterator.next().toString(),
                            (String) iterator.next().toString()
                    );
                    retornoLista.add(tipoUsuario);
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