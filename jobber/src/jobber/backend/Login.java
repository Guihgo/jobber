package jobber.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends Conexao{

    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Login(Conexao conexao){
        this.conexao = conexao;
    }

    public jobber.modelo.Conta tenta(String email, String password){
        jobber.modelo.Conta conta = new jobber.modelo.Conta();
        try {
            ps = this.conexao.getConnection().prepareStatement("SET auto_increment_increment=1;");
            ps.executeUpdate();
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM conta WHERE conta_email=? AND conta_senha=? LIMIT 1");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.last()) {
                conta.setLogado(true);
                conta.setId(rs.getInt("conta_id"));
                conta.setEmail(rs.getString("conta_email"));
                conta.setNome(rs.getString("conta_nome"));
                conta.setTipo(rs.getInt("conta_tipo"));
            } else {
                conta.setLogado(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return conta;
        }

    }
}
