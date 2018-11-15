package jobber.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
    private static String url = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net/heroku_b0965c26597b33a?reconnect=true";
    private static String user = "b8cad8e341f4a3";
    private static String password = System.getenv("HEROKU_DB_PASS");
    private static String fullUrlConnection = "mysql://b8cad8e341f4a3:2b01e897@us-cdbr-iron-east-01.cleardb.net/heroku_b0965c26597b33a?reconnect=true";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public boolean carregaDriver() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return true;
        }catch(Exception ex) {
            // handle the error
            System.out.print('a');
            return false;
        }

    }

    public boolean conecta() {
        try {
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso " + this.conn.getCatalog());
            return true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeStatement(Statement stmt, ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) {}

            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {}

            stmt = null;
        }
    }

}