/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seolin
 */
public class BDController {

    /**
     * Método responsável por estabelecer uma conexão com o banco de dados.
     *
     * @return
     */
    Connection connection = null;

    public Connection conectaBD() {
        try {
            String usuario = "postgres";
            String senha = "utfpr";

            Class.forName("org.postgresql.Driver");  //para acesso ao banco de dados Postgre
            String urlconexao = "jdbc:postgresql://127.0.0.1/rezerve"; //para acesso ao banco de dados fabricio, usando o banco de dados Postgre.
            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.
        } catch (ClassNotFoundException error) {
            String msgErro = "Erro ao carregar o driver JDBC/ODBC: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        } catch (SQLException error) {
            String msgErro = "Falha na conexão: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }

    /**
     * Método responsável por commitar as alterações realizadas.
     *
     * @param connection
     * @return
     */
    public Connection commit(Connection connection) {
        try {
            connection.commit();
        } catch (SQLException error) {
            String msgErro = "Erro Commit: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }

    /**
     * Método responsável por dar rollback nas alterações, ou seja, estas não
     * serão salvas no banco de dados.
     *
     * @param connection
     * @return
     */
    public Connection rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException error) {
            String msgErro = "Erro Roolback: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }

    /**
     * Método responsável por encerrar a coxeção com o banco de dados.
     *
     * @param connection
     * @return
     */
    public Connection close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException error) {
            String msgErro = "Erro Close: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }
    
    public Connection close(Connection connection, PreparedStatement stmt) {
        try {
            stmt.close();
            connection.close();
        } catch (SQLException error) {
            String msgErro = "Erro Close: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }
    
    public Connection close(Connection connection, PreparedStatement stmt, ResultSet rs) {
        try {
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException error) {
            String msgErro = "Erro Close: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }
    
    public Connection close(Connection connection, CallableStatement cbmt, ResultSet rs) {
        try {
            rs.close();
            cbmt.close();
            connection.close();
        } catch (SQLException error) {
            String msgErro = "Erro Close: " + error;
            JOptionPane.showMessageDialog(null, msgErro);
            return null;
        }
        return connection;
    }


    public ArrayList proximoRegistro(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        ArrayList registro = new ArrayList();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            if (rsmd.getColumnType(i) == Types.VARCHAR
                    || rsmd.getColumnClassName(i).equalsIgnoreCase("java.lang.String")) {//para string
                registro.add(rs.getString(i));
            } else if (rsmd.getColumnType(i) == Types.INTEGER) {//para inteiros
                registro.add(rs.getInt(i));
            } else if (rsmd.getColumnType(i) == Types.BOOLEAN) {
                registro.add(rs.getBoolean(i));
            } else if (rsmd.getColumnType(i) == Types.FLOAT) {
                registro.add(rs.getFloat(i));
            } else if (rsmd.getColumnType(i) == Types.DOUBLE) {
                registro.add(rs.getDouble(i));
            } else if (rsmd.getColumnType(i) == Types.CHAR) {
                registro.add(rs.getCharacterStream(i));
            } else if (rsmd.getColumnType(i) == Types.TIME) {
                registro.add(rs.getTime(i));
            } else if (rsmd.getColumnType(i) == Types.TIMESTAMP) {
                registro.add(rs.getTimestamp(i));
            } else if (rsmd.getColumnType(i) == Types.DATE) {
                registro.add(rs.getDate(i));
            } else if (rsmd.getColumnType(i) == Types.NULL) {
                registro.add(null);
            } else {
                registro.add(rs.getBoolean(i));
            }
        }
        return registro;
    }
}
