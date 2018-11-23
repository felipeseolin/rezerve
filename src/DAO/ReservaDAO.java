package DAO;

import controller.BDController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
     * Método responsável por listar todos os registros de reserva daquele
     * usuario
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

    /**
     * Método responsável por listar todos os registros de reserva daquele
     * usuario
     *
     * @return
     */
    protected static ArrayList<Reserva> selectAllCoord() {
        Usuario usuario = Login.getUsuario();
        String siglaDep = usuario.getDepartamento().getSigla();
        String sqldml = "select RESER_ID, RESER_MOTIVO, RESER_DATA, "
                + " RESER_HORARIO_INICIAL, RESER_HORARIO_FINAL, RESER_CONFIRMADA, "
                + " USUARIO.USU_ID, USU_PNOME, USU_UNOME, USU_EMAIL, USU_ATIVO, "
                + " DEPARTAMENTO.DEP_ID, DEP_NOME, DEP_SIGLA, DEP_ATIVO, "
                + " TIPO_DE_USUARIO.TIPUS_ID, TIPUS_SIGLA, TIPUS_NOME, "
                + " SALA.SALA_ID, SALA_NUM, SALA_NUM_CADEIRAS, SALA_NUM_COMP, "
                + " SALA_DETALHES, SALA_ATIVA, TIPO_DE_SALA.TIPSAL_ID, "
                + " TIPSAL_NOME, BLOCO.BLOC_ID, BLOC_LETRA, BLOC_NOME, "
                + " BLOC_DESCRICAO, BLOC_ATIVO, SITUACAO.SIT_ID, SIT_NOME, "
                + " SIT_MENSAGEM, DEP_SIGLA "
                + " from RESERVA, SALA, USUARIO,  SITUACAO, DEPARTAMENTO, "
                + " TIPO_DE_USUARIO, TIPO_DE_SALA, BLOCO "
                + " where RESERVA.SALA_ID = SALA.SALA_ID and"
                + " RESERVA.USU_ID = USUARIO.USU_ID and "
                + " USUARIO.TIPUS_ID = TIPO_DE_USUARIO.TIPUS_ID and"
                + " DEPARTAMENTO.DEP_ID = USUARIO.DEP_ID and "
                + " RESERVA.SIT_ID = SITUACAO.SIT_ID and "
                + " SALA.TIPSAL_ID = TIPO_DE_SALA.TIPSAL_ID and "
                + " BLOCO.BLOC_ID = SALA.BLOC_ID and "
                + " DEP_SIGLA = '" + siglaDep + "' "
                + " order by RESER_DATA desc";

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

                int idReserva = (int) iterator.next();
                String motivoReserva = iterator.next().toString();
                Date dataReserva = (java.util.Date) iterator.next(); //data
                Horario horarioInicial = (Horario) Horario.valueOf(iterator.next().toString());
                Horario horarioFinal = (Horario) Horario.valueOf(iterator.next().toString()); //data Final
                boolean confirmada = (boolean) iterator.next();

                int idUsuario = (int) iterator.next();//id
                String pnome = (String) iterator.next().toString();//pnome
                String unome = (String) iterator.next().toString();//unome
                String email = (String) iterator.next().toString();//email
                boolean ativo = (boolean) iterator.next();//ativo
                
                int idDepartamento = (int) iterator.next();
                String nomeDepartamento = iterator.next().toString();
                String siglaDepartamento = iterator.next().toString();
                boolean ativoDepartamento = (boolean) iterator.next();
                Departamento departamento = new Departamento(idDepartamento, nomeDepartamento, siglaDepartamento, ativoDepartamento);
                
                int idTipoUsuario = (int) iterator.next();
                String siglaTipoUsuario = iterator.next().toString();
                String nomeTipoUsuario = iterator.next().toString();
                TipoUsuario tipoUsuario = new TipoUsuario(idTipoUsuario, siglaTipoUsuario, nomeTipoUsuario);
                
                String idSala = (String) iterator.next().toString();
                int numeroSala = (int) iterator.next();
                int numeroCadeiras = (int) iterator.next();
                int numeroComputadores = (int) iterator.next();
                String detalhesSala = iterator.next().toString();
                boolean ativaSala = (boolean) iterator.next();
                
                int idTipoSala = (int) iterator.next();
                String nomeTipoSala = iterator.next().toString();
                TipoSala tipoSala = new TipoSala(idTipoSala, nomeTipoSala);
                
                int idBloco = (int) iterator.next();
                char letraBloco = iterator.next().toString().charAt(0);
                String nomeBloco = (String) iterator.next();
                String descricaoBloco = iterator.next().toString();
                boolean ativoBloco = (boolean) iterator.next();
                Bloco bloco = new Bloco(idBloco, letraBloco, nomeBloco, descricaoBloco, ativoBloco);
                
                int idSituacao = (int) iterator.next();
                String nomeSituacao = iterator.next().toString();
                String mensagemSituacao = iterator.next().toString();
                Situacao situacao = new Situacao(idSituacao, nomeSituacao, mensagemSituacao);
                
                Usuario user = new Usuario(idUsuario, pnome, unome, email, 
                        ativo, departamento, tipoUsuario);
                
                Sala sala = new Sala(idSala, numeroSala, numeroCadeiras, 
                        numeroComputadores, detalhesSala, ativaSala, tipoSala,
                        departamento, bloco);
                
                Reserva reserva = new Reserva(idReserva, motivoReserva, 
                        dataReserva, horarioInicial, horarioFinal, confirmada,
                        user, sala, situacao);
                
                retornoLista.add(reserva);

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

                //while (iterator.hasNext()) {
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
