/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.BDController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Departamento;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author Seolin
 */
public class UsuarioDAO {

    private static BDController bd = new BDController();
    private static Connection connection = null;

    public UsuarioDAO() {
        connection = bd.conectaBD();
    }

    /**
     * Método responsável por inserir uma instância de usuario no banco de dados
     *
     * @param usuario
     * @return
     */
    protected static boolean insert(Usuario usuario) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml;
        if (usuario.getId() > 0) {
            sqldml = "Insert into USUARIO (USU_ID, USU_PNOME, USU_UNOME, "
                    + "USU_EMAIL, USU_SENHA, USU_ATIVO, DEP_ID, TIPUS_ID)"
                    + "values (?,?,?,?,?,?,?,?)";
        } else {
            sqldml = "Insert into USUARIO (USU_PNOME, USU_UNOME, "
                    + "USU_EMAIL, USU_SENHA, USU_ATIVO, DEP_ID, TIPUS_ID)"
                    + "values (?,?,?,?,?,?,?)";
        }

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            int i = 0;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            if(usuario.getId() > 0) {
                pstdados.setInt(++i, usuario.getId());
            }
            pstdados.setString(++i, usuario.getpNome());
            pstdados.setString(++i, usuario.getuNome());
            pstdados.setString(++i, usuario.getEmail());
            pstdados.setString(++i, usuario.getSenha());
            pstdados.setBoolean(++i, usuario.isAtivo());
            pstdados.setInt(++i, usuario.getDepartamento().getId());
            pstdados.setInt(++i, usuario.getTipoUsuario().getId());

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
     * Método responsável por editar uma instância de usuario no banco de dados
     *
     * @param usuario
     * @return
     */
    protected static boolean update(Usuario usuario) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "update USUARIO set USU_PNOME = ? ,"
                + "USU_UNOME = ? ,"
                + "USU_EMAIL = ? ,"
                + "USU_SENHA = ? ,"
                + "USU_ATIVO = ? ,"
                + "DEP_ID = ? , "
                + "TIPUS_ID = ? "
                + "where USU_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, usuario.getpNome());
            pstdados.setString(2, usuario.getuNome());
            pstdados.setString(3, usuario.getEmail());
            pstdados.setString(4, usuario.getSenha());
            pstdados.setBoolean(5, usuario.isAtivo());
            pstdados.setInt(6, usuario.getDepartamento().getId());
            pstdados.setInt(7, usuario.getTipoUsuario().getId());
            pstdados.setInt(8, usuario.getId());

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
     * Método responsável por deletar uma instância de usuario no banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados = null;

        try {
            String sqldml = "delete from USUARIO where USU_ID = ?";

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
     * Método responsável por listar todos os registros de usuarios
     *
     * @return
     */
    protected static ArrayList<Usuario> selectAll() {
        PreparedStatement pstdados = null;
        ResultSet rs = null;
        ArrayList<Usuario> retornoLista = null;

        try {
            String sqldml = "select USU_ID, USU_PNOME, USU_UNOME, USU_EMAIL, "
                    + " USU_ATIVO, DEP_ID, DEP_NOME, DEP_SIGLA, "
                    + " DEP_ATIVO, TIPUS_ID, TIPUS_SIGLA, TIPUS_NOME "
                    + " from USUARIO natural join DEPARTAMENTO natural join "
                    + " TIPO_DE_USUARIO"
                    + " order by USU_PNOME ASC ";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.executeQuery();

            rs = pstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Usuario>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {
                    int id = (int) iterator.next();
                    String pnome = (String) iterator.next().toString();
                    String unome = (String) iterator.next().toString();
                    String email = (String) iterator.next().toString();
                    boolean ativo = (boolean) iterator.next();

                    Departamento departamento = new Departamento(
                            (int) iterator.next(),
                            (String) iterator.next(),
                            (String) iterator.next(),
                            (boolean) iterator.next()
                    );
                    TipoUsuario tipoUsuario = new TipoUsuario(
                            (int) iterator.next(),
                            (String) iterator.next(),
                            (String) iterator.next()
                    );

                    Usuario usuario = new Usuario(id, pnome, unome, email,
                            ativo, departamento, tipoUsuario);
                    retornoLista.add(usuario);
                }
            } while (rs.next());
            //Chama o Commit
            connection = bd.commit(connection);
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, pstdados, rs);
        }
        return retornoLista;
    }

    /**
     * Método responsável por listar todos os registros de usuarios com senha
     *
     * @return
     */
    protected static ArrayList<Usuario> selectAllWithPass() {
        PreparedStatement pstdados = null;
        ResultSet rs = null;
        ArrayList<Usuario> retornoLista = null;

        try {
            String sqldml = "select USU_ID, USU_PNOME, USU_UNOME, USU_EMAIL, "
                    + " USU_SENHA, USU_ATIVO, DEP_ID, DEP_NOME, DEP_SIGLA, "
                    + " DEP_ATIVO, TIPUS_ID, TIPUS_SIGLA, TIPUS_NOME "
                    + " from USUARIO natural join DEPARTAMENTO natural join "
                    + " TIPO_DE_USUARIO"
                    + " order by USU_PNOME ASC ";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.executeQuery();

            rs = pstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Usuario>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {
                    int id = (int) iterator.next();
                    String pnome = (String) iterator.next().toString();
                    String unome = (String) iterator.next().toString();
                    String email = (String) iterator.next().toString();
                    String senha = (String) iterator.next().toString();
                    boolean ativo = (boolean) iterator.next();

                    Departamento departamento = new Departamento(
                            (int) iterator.next(),
                            (String) iterator.next(),
                            (String) iterator.next(),
                            (boolean) iterator.next()
                    );
                    TipoUsuario tipoUsuario = new TipoUsuario(
                            (int) iterator.next(),
                            (String) iterator.next(),
                            (String) iterator.next()
                    );

                    Usuario usuario = new Usuario(id, pnome, unome, email, senha,
                            ativo, departamento, tipoUsuario);
                    retornoLista.add(usuario);
                }
            } while (rs.next());
            //Chama o Commit
            connection = bd.commit(connection);
        } catch (SQLException error) {
            String msgErro = "Erro com o banco de dados: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            //Dá Roolback
            connection = bd.rollback(connection);
        } finally {
            //Termina connecção
            connection = bd.close(connection, pstdados, rs);
        }
        return retornoLista;
    }

}
