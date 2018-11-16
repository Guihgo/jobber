package jobber.backend.trabalhador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Trabalho;

public class GerenciarTrabalho extends Conexao{

    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public GerenciarTrabalho(Conexao conexao) {
        this.conexao = conexao;
    }

    public ArrayList<Trabalho> listar(Conta conta) {
        ArrayList<Trabalho> trabalhos = new ArrayList<Trabalho>();

        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT trabalho.* FROM trabalho NATURAL JOIN conta;");
            rs = ps.executeQuery();
            showTableResultSet(rs);
            while(rs.next()) {

                System.out.println("rs.getString(): "+rs.getString("trabalho_nome"));
//                conta.setLogado(true);
//                conta.setId(rs.getInt("conta_id"));
//                conta.setEmail(rs.getString("conta_email"));
//                conta.setNome(rs.getString("conta_nome"));
//                conta.setTipo(rs.getInt("conta_tipo"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return trabalhos;
        }
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
