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
import model.Horario;
import model.Login;
import model.Sala;
import model.Reserva;
import model.Situacao;
import model.TipoSala;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author Seolin
 */
public class ReservaDAO {

    private static BDController bd = new BDController();
    private static Connection connection = null;

    public ReservaDAO() {
        connection = bd.conectaBD();
    }

    /**
     * Método responsável por inserir uma instância de reserva no banco de dados
     *
     * @param reserva
     * @return
     */
    protected static boolean insert(Reserva reserva) {
        boolean retorno = false;
        PreparedStatement pstdados = null;
        String sqldml = "Insert into RESERVA (RESER_MOTIVO, RESER_DATA, "
                + " RESER_HORARIO_INICIAL, RESER_HORARIO_FINAL,"
                + " RESER_CONFIRMADA, USU_ID, SALA_ID, SIT_ID) "
                + "values (?,?,?::horario,?::horario,?,?,?,?)";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            
            pstdados.setString(1, reserva.getMotivo());
            pstdados.setDate(2, new java.sql.Date(reserva.getData().getTime()));
            pstdados.setString(3, reserva.getHorarioInicial().getValor());
            pstdados.setString(4, reserva.getHorarioFinal().getValor());
            pstdados.setBoolean(5, reserva.isConfirmada());
            pstdados.setInt(6, reserva.getUsuario().getId());
            pstdados.setString(7, reserva.getSala().getId());
            pstdados.setInt(8, reserva.getSituacao().getId());
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
     * Método responsável por editar uma instância de reserva no banco de dados
     *
     * @param reserva
     * @return
     */
    protected static boolean update(Reserva reserva) {
        boolean retorno = false;
        PreparedStatement pstdados;
        String sqldml = "update RESERVA set RESER_MOTIVO = ? ,"
                + " RESER_DATA = ? ,"
                + " RESER_HORARIO_INICIAL = ?::horario ,"
                + " RESER_HORARIO_FINAL = ?::horario ,"
                + " RESER_CONFIRMADA = ? ,"
                + " USU_ID  = ? ,"
                + " SALA_ID = ? ,"
                + " SIT_ID = ? "
                + "where RESER_ID = ?";

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setString(1, reserva.getMotivo());
            pstdados.setDate(2, new java.sql.Date(reserva.getData().getTime()));
            pstdados.setString(3, reserva.getHorarioInicial().getValor());
            pstdados.setString(4, reserva.getHorarioFinal().getValor());
            pstdados.setBoolean(5, reserva.isConfirmada());
            pstdados.setInt(6, reserva.getUsuario().getId());
            pstdados.setString(7, reserva.getSala().getId());
            pstdados.setInt(8, reserva.getSituacao().getId());
            pstdados.setInt(9, reserva.getId());
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
     * Método responsável por deletar uma instância de reserva no banco de dados
     *
     * @param id
     * @return
     */
    protected static boolean delete(int id) {
        boolean retorno = false;
        PreparedStatement pstdados;

        try {
            String sqldml = "delete from RESERVA where RESER_ID = ?";

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
            connection = bd.close(connection);
        }
        return retorno;
    }

    /**
     * Método responsável por listar todos os registros de reserva
     *
     * @return
     */
    protected static ArrayList<Reserva> selectAll() {
        String sqldml = "select RESER_ID, RESER_MOTIVO, RESER_DATA,"
                + " RESER_HORARIO_INICIAL, RESER_HORARIO_FINAL, RESER_CONFIRMADA, "
                + " USUARIO.USU_ID, USU_PNOME, USU_UNOME, USU_EMAIL, USU_ATIVO, "
                + " USUARIO.DEP_ID, TIPUS_ID, SALA.SALA_ID, SALA_NUM, "
                + " SALA_NUM_CADEIRAS, SALA_NUM_COMP, SALA_DETALHES, "
                + " SALA_ATIVA,TIPSAL_ID, SALA.DEP_ID, BLOC_ID, SITUACAO.SIT_ID, "
                + " SIT_NOME, SIT_MENSAGEM "
                + " from RESERVA, SALA, USUARIO, SITUACAO "
                + " where RESERVA.SALA_ID = SALA.SALA_ID and "
                + "	RESERVA.USU_ID = USUARIO.USU_ID and "
                + "	RESERVA.SIT_ID = SITUACAO.SIT_ID "
                + " order by RESER_DATA desc";
        return select(sqldml);
    }
    
    /**
     * Método responsável por listar todos os registros de reserva daquele usuario
     *
     * @return
     */
    protected static ArrayList<Reserva> selectAllMy() {
        Usuario usuario = Login.getUsuario();
        int idUsuario = usuario.getId();
        String sqldml = "select RESER_ID, RESER_MOTIVO, RESER_DATA, "
                + " RESER_HORARIO_INICIAL, RESER_HORARIO_FINAL, RESER_CONFIRMADA, "
                + " USUARIO.USU_ID, USU_PNOME, USU_UNOME, USU_EMAIL, USU_ATIVO, "
                + " USUARIO.DEP_ID, TIPUS_ID, SALA.SALA_ID, SALA_NUM, "
                + " SALA_NUM_CADEIRAS, SALA_NUM_COMP, SALA_DETALHES, "
                + " SALA_ATIVA,TIPSAL_ID, SALA.DEP_ID, BLOC_ID, SITUACAO.SIT_ID, "
                + " SIT_NOME, SIT_MENSAGEM "
                + " from RESERVA, SALA, USUARIO, SITUACAO "
                + " where RESERVA.SALA_ID = SALA.SALA_ID and "
                + "	RESERVA.USU_ID = USUARIO.USU_ID and "
                + "	RESERVA.SIT_ID = SITUACAO.SIT_ID and "
                + "	USUARIO.USU_ID = " + idUsuario + " "
                + " order by RESER_DATA desc ";
        return select(sqldml);
    }
    
    private static ArrayList<Reserva> select(String sqldml) {
        PreparedStatement pstdados = null;
        ResultSet rs = null;
        ArrayList<Reserva> retornoLista = null;

        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            connection = bd.conectaBD();
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.executeQuery();

            rs = pstdados.executeQuery();
            if (!rs.first()) {
                return null;
            }

            retornoLista = new ArrayList<Reserva>();
            ResultSetMetaData rsmd = rs.getMetaData();

            do {
                ArrayList registros = bd.proximoRegistro(rs, rsmd);

                Iterator iterator = registros.iterator();

                while (iterator.hasNext()) {

                    Reserva reserva = new Reserva(
                            (int) iterator.next(), //id
                            (String) iterator.next().toString(), //motivo
                            (java.util.Date) iterator.next(), //data
                            (Horario) Horario.valueOf(iterator.next().toString()), //data Iniciail
                            (Horario) Horario.valueOf(iterator.next().toString()), //data Final
                            (boolean) iterator.next(), //confirmada
                            new Usuario(
                                    (int) iterator.next(),//id
                                    (String) iterator.next().toString(),//pnome
                                    (String) iterator.next().toString(),//unome
                                    (String) iterator.next().toString(),//email
                                    (boolean) iterator.next(),//ativo
                                    new Departamento(
                                            (int) iterator.next()//id
                                    ),
                                    new TipoUsuario(
                                            (int) iterator.next()//id
                                    )
                            ),
                            new Sala(
                                    (String) iterator.next().toString(),//id
                                    (int) iterator.next(),//numero
                                    (int) iterator.next(),//numero cadeiras
                                    (int) iterator.next(),//numero computadores
                                    (String) iterator.next(),//detalhes
                                    (boolean) iterator.next(),//ativa
                                    new TipoSala(
                                            (int) iterator.next()//id
                                    ),
                                    new Departamento(
                                            (int) iterator.next()//id
                                    ),
                                    new Bloco(
                                            (int) iterator.next()//id
                                    )
                            ),
                            new Situacao(
                                    (int) iterator.next(),//id
                                    (String) iterator.next().toString(),//nome
                                    (String) iterator.next().toString()//mensagem
                            )
                    );
                    retornoLista.add(reserva);
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
