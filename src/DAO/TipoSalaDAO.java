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
import model.TipoSala;

/**
 *
 * @author Aluno
 */
public class TipoSalaDAO {
    
    private static BDController bd = new BDController();
    private static Connection connection = null;

    public TipoSalaDAO() {
        connection = bd.conectaBD();
    }

    /**
     * Método responsável por inserir uma instância de tipo de sala no
     * banco de dados
     *
     * @param tipoSala
     * @return
     */
    protected static boolean insert(TipoSala tipoSala) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "Insert into TIPO_DE_SALA (TIPSAL_NOME) "
                + "values (?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            
            pstdados.setString(1, tipoSala.getNome());
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
     * Método responsável por editar uma instância de tipo de sala no
     * banco de dados
     *
     * @param tipoSala
     * @return
     */
    protected static boolean update(TipoSala tipoSala) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "update TIPO_DE_SALA set TIPSAL_NOME = ? "
                + "where TIPSAL_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, tipoSala.getNome());
            pstdados.setInt(2, tipoSala.getId());
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
     * Método responsável por deletar uma instância de tipo de sala no
     * banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;

        try {
            String sqldml = "delete from TIPO_DE_SALA where TIPSAL_ID = ?";

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
     * Método responsável por listar todos os registros de tipo de sala
     *
     * @return
     */
    protected static ArrayList<TipoSala> selectAll() {
        CallableStatement cstdados = null;
        ResultSet rs = null;
        ArrayList<TipoSala> retornoLista = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            cstdados = connection.prepareCall("{call listaTipoDeSalas()}", tipo, concorrencia);
            rs = cstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<TipoSala>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    TipoSala tipoSala = new TipoSala(
                            (int) iterator.next(),
                            (String) iterator.next().toString()
                    );
                    retornoLista.add(tipoSala);
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
