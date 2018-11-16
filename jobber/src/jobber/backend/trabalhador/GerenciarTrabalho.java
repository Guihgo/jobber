package jobber.backend.trabalhador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jobber.backend.Conexao;
import jobber.modelo.Trabalho;

public class GerenciarTrabalho extends Conexao{

    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public GerenciarTrabalho(Conexao conexao) {
        this.conexao = conexao;
    }

    public Trabalho[] listar() {
        /*
        jobber.modelo.Conta conta = new jobber.modelo.Conta();
        try {
//            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM conta WHERE conta_email=? AND conta_senha=? LIMIT 1");
//            ps.setString(1, email);
//            ps.setString(2, password);
//            rs = ps.executeQuery();
//            if(rs.last()) {
//                conta.setLogado(true);
//                conta.setId(rs.getInt("conta_id"));
//                conta.setEmail(rs.getString("conta_email"));
//                conta.setNome(rs.getString("conta_nome"));
//                conta.setTipo(rs.getInt("conta_tipo"));
//            } else {
//                conta.setLogado(false);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return conta;
        }
        */
        return null;
    }

    public boolean adicionar(Trabalho trabalho, jobber.modelo.Conta conta) {
        boolean adicionouComSucesso = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO trabalho(trabalho_nome,trabalho_descricao,conta_id) VALUES (?,?,?)");
            ps.setString(1, trabalho.getNome());
            ps.setString(2, trabalho.getDescricao());
            ps.setInt(3, conta.getId());
            if(ps.executeUpdate() > 0){
                adicionouComSucesso =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Adicionado com sucesso");
            return adicionouComSucesso;
        }
    }

    public void editar() {

    }
}
