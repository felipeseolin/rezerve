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
import model.Bloco;
import model.Departamento;
import model.Sala;
import model.TipoSala;

/**
 *
 * @author Seolin
 */
public class SalaDAO {

    /**
     * Método responsável por inserir uma instância de sala no banco de dados
     *
     * @param sala
     * @return
     */
    protected static boolean insert(Sala sala) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        BDController bd = new BDController();
        Connection connection = null;
        String sqldml = "Insert into SALA (SALA_NUM,SALA_NUM_CADEIRAS,"
                + "SALA_NUM_COMP,SALA_DETALHES,SALA_ATIVA, SALA_ID,"
                + "TIPSAL_ID,DEP_ID,BLOC_ID) "
                + "values (?,?,?,?,?,?,?,?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setInt(1, sala.getNumero());
            pstdados.setInt(2, sala.getNumeroCadeiras());
            pstdados.setInt(3, sala.getNumeroComputadores());
            pstdados.setString(4, sala.getDetalhes());
            pstdados.setBoolean(5, sala.isAtiva());
            pstdados.setString(6, sala.getId());
            pstdados.setInt(7, sala.getTipoSala().getId());
            pstdados.setInt(8, sala.getDepartamento().getId());
            pstdados.setInt(9, sala.getBloco().getId());
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
     * Método responsável por editar uma instância de sala no banco de dados
     *
     * @param sala
     * @return
     */
    protected static boolean update(Sala sala) {
        boolean retorno = false;
        PreparedStatement pstdados;
        BDController bd = new BDController();
        Connection connection = null;
        String sqldml = "update SALA set SALA_NUM = ? ,"
                + "SALA_NUM_CADEIRAS = ? ,"
                + "SALA_NUM_COMP = ? ,"
                + "SALA_DETALHES  = ? ,"
                + "SALA_ATIVA = ? ,"
                + "TIPSAL_ID = ? ,"
                + "DEP_ID = ? ,"
                + "BLOC_ID = ? "
                + "where SALA_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setInt(1, sala.getNumero());
            pstdados.setInt(2, sala.getNumeroCadeiras());
            pstdados.setInt(3, sala.getNumeroComputadores());
            pstdados.setString(4, sala.getDetalhes());
            pstdados.setBoolean(5, sala.isAtiva());
            pstdados.setInt(6, sala.getTipoSala().getId());
            pstdados.setInt(7, sala.getDepartamento().getId());
            pstdados.setInt(8, sala.getBloco().getId());
            pstdados.setString(9, sala.getId());
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
            connection = bd.close(connection);
        }
        return retorno;
    }

    /**
     * Método responsável por deletar uma instância de sala no banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(String id) {
        boolean retorno = false;
        PreparedStatement pstdados;
        BDController bd = new BDController();
        Connection connection = null;

        try {
            String sqldml = "delete from SALA where SALA_ID = ?";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            pstdados.setString(1, id);
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
            connection = bd.close(connection);
        }
        return retorno;
    }

    /**
     * Método responsável por listar todos os registros de sala
     *
     * @return
     */
    protected static ArrayList<Sala> selectAll() {
        PreparedStatement pstdados = null;
        ResultSet rs = null;
        ArrayList<Sala> retornoLista = null;
        BDController bd = new BDController();
        Connection connection = null;

        try {
            String sqldml = "select SALA_ID, SALA_NUM, SALA_NUM_CADEIRAS, "
                    + "SALA_NUM_COMP, SALA_DETALHES, SALA_ATIVA, TIPSAL_ID, "
                    + "TIPSAL_NOME, DEP_ID, DEP_NOME, DEP_SIGLA, DEP_ATIVO, "
                    + "BLOC_ID, BLOC_LETRA, BLOC_NOME, BLOC_DESCRICAO, BLOC_ATIVO "
                    + "from sala natural join departamento natural join bloco "
                    + "natural join tipo_de_sala"
                    + " order by  SALA_ID  ASC ";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.executeQuery();

            rs = pstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Sala>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {
                    String id = (String) iterator.next().toString();
                    int numero = (int) iterator.next();
                    int cadeira = (int) iterator.next();
                    int computadores = (int) iterator.next();
                    String detalhes = (String) iterator.next().toString();
                    boolean ativa = (boolean) iterator.next();
                    TipoSala tipoSala = new TipoSala((int) iterator.next(),
                            (String) iterator.next());
                    Departamento departamento = new Departamento(
                            (int) iterator.next(),
                            (String) iterator.next(),
                            (String) iterator.next(),
                            (boolean) iterator.next()
                    );
                    Bloco bloco = new Bloco(
                            (int) iterator.next(),
                            (char) iterator.next().toString().charAt(0),
                            (String) iterator.next().toString(),
                            (String) iterator.next().toString(),
                            (boolean) iterator.next()
                    );

                    Sala sala = new Sala(id, numero, cadeira, computadores,
                            detalhes, ativa, tipoSala, departamento, bloco);
                    retornoLista.add(sala);
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
