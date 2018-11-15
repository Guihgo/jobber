package jobber.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conta extends Conexao{

    Connection conn;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Conta(Connection connection){
        this.conn = connection;
    }

    public jobber.modelo.Conta login(String email, String password){
        jobber.modelo.Conta conta = new jobber.modelo.Conta();
        try {
            System.out.println(conn.getCatalog());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps = this.conn.prepareStatement("SELECT * FROM conta");
//            ps.setString(1, email);
            rs = ps.executeQuery();

            System.out.println("rs: "+ rs.getRow());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return conta;
        }

    }
}
