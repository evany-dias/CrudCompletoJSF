package br.com.mensagem.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.jboss.logging.Logger;

public class FabricaConexao {

    public static Connection conexao;
    private static final String URL_SERVIDOR = "jdbc:mysql://localhost/mensagemjsf";//parametro nome do servidor e banco
    private static final String URL_USUARIO = "root";//parametro usuario do banco
    private static final String URL_SENHA = "";//senha do usuario do banco

    public static Connection getConexao() throws ClassNotFoundException {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");//classe para utilização do arquivo com configurções do serivdor mysql
                conexao = (Connection) DriverManager.getConnection(URL_SERVIDOR, URL_USUARIO, URL_SENHA);

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }

    public static void fecharConexao() throws ClassNotFoundException, SQLException {//fechando a conexao
        if (conexao != null) {
            conexao.close();
            conexao = null;
        }

    }
}
