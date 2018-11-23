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
import model.Departamento;

/**
 *
 * @author Seolin
 */
public class DepartamentoDAO {
    
    private static BDController bd = new BDController();
    private static Connection connection = null;

    public DepartamentoDAO() {
        connection = bd.conectaBD();
    }
    
    /**
     * Método responsável por inserir uma instância de departamento no 
     * banco de dados
     * @param departamento
     * @return 
     */
    protected static boolean insert(Departamento departamento) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "Insert into DEPARTAMENTO (DEP_NOME,DEP_SIGLA,"
                + " DEP_ATIVO)"
                + "values (?,?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            
            pstdados.setString(1, departamento.getNome());
            pstdados.setString(2, departamento.getSigla());
            pstdados.setBoolean(3, departamento.isAtivo());
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
     * Método responsável por editar uma instância de departamento no 
     * banco de dados
     * @param departamento
     * @return 
     */
    protected static boolean update(Departamento departamento) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "update DEPARTAMENTO set DEP_NOME = ? ,"
                + "DEP_SIGLA = ? ,"
                + "DEP_ATIVO = ? "
                + "where DEP_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, departamento.getNome());
            pstdados.setString(2, departamento.getSigla());
            pstdados.setBoolean(3, departamento.isAtivo());
            pstdados.setInt(4, departamento.getId());
            
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
     * Método responsável por deletar uma instância de departamento no
     * banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;

        try {
            String sqldml = "delete from DEPARTAMENTO where DEP_ID = ?";

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
     * Método responsável por listar todos os registros de departamentos
     *
     * @return
     */
    protected static ArrayList<Departamento> selectAll() {
        CallableStatement cstdados = null;
        ResultSet rs = null;
        ArrayList<Departamento> retornoLista = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            cstdados = connection.prepareCall("{call listaDepartamentos()}", tipo, concorrencia);
            rs = cstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Departamento>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    Departamento departamento = new Departamento(
                            (int) iterator.next(),
                            (String) iterator.next().toString(),
                            (String) iterator.next().toString(),
                            (boolean) iterator.next()
                    );
                    retornoLista.add(departamento);
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
