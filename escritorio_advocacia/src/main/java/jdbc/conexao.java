package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    
    public static Connection obterConexao() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/escritorio_advocacia", "root", "admin");
            System.out.println("Conexão com o banco de dados estabelecida!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados!");
            e.printStackTrace();
        }
        return con;
    }
}

