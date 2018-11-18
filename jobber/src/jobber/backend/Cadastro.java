package jobber.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jobber.modelo.Conta;

public class Cadastro extends Conexao{

    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Cadastro(Conexao conexao) {
        this.conexao = conexao;
    }

    public boolean criaConta(Conta conta, String pass){
        boolean adicionouComSucesso = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO conta(conta_nome,conta_senha,conta_email,conta_tipo) VALUES (?,?,?,?)");
            ps.setString(1, conta.getNome());
            ps.setString(2, pass);
            ps.setString(3, conta.getEmail());
            ps.setInt(4, conta.getTipo());
            if(ps.executeUpdate() > 0){
                adicionouComSucesso =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Conta criada com sucesso");
            return adicionouComSucesso;
        }
    }

    public boolean emailNaoExiste(Conta conta){
        boolean emailNaoExiste = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM conta WHERE conta_email=? LIMIT 1");
            ps.setString(1, conta.getEmail());
            rs = ps.executeQuery();
            if(rs.last()) {
                emailNaoExiste=false;
            } else {
                emailNaoExiste=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return emailNaoExiste;
        }

    }
}
