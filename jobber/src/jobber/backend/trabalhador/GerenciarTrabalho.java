package jobber.backend.trabalhador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Feedback;
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
            ps = this.conexao.getConnection().prepareStatement("SELECT trabalho.* FROM trabalho NATURAL JOIN conta WHERE conta.conta_id=?");
            ps.setInt(1, conta.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Trabalho trabalho = new Trabalho();
                trabalho.setId(rs.getInt("trabalho_id"));
                trabalho.setContaId(conta.getId());
                trabalho.setDescricao(rs.getString("trabalho_descricao"));
                trabalho.setNome(rs.getString("trabalho_nome"));
                trabalho.setSomaNotaDeFeedback(rs.getFloat("trabalho_somaNotaDeFeedback"));
                trabalho.setQntDeFeedback(rs.getInt("trabalho_qntNotaDeFeedback"));
                trabalhos.add(trabalho);
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
    
    
    public boolean remover(Trabalho trabalho){
        boolean removeuComSucesso = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("DELETE FROM trabalho WHERE trabalho_id = ?");
            ps.setInt(1, trabalho.getId());
            if(ps.executeUpdate() > 0){
                removeuComSucesso =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Removido com sucesso");
            return removeuComSucesso;
        }
    }

    public boolean editar(Trabalho trabalho) {
        boolean editouComSucesso = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("UPDATE trabalho SET trabalho_nome = ? , trabalho_descricao=?  WHERE trabalho_id = ?");
            ps.setString(1, trabalho.getNome());
            ps.setString(2, trabalho.getDescricao());
            ps.setInt(3, trabalho.getId());
            if(ps.executeUpdate() > 0){
                editouComSucesso =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Editado com sucesso");
            return editouComSucesso;
        }
    }
    
    public Trabalho consultar(Trabalho trabalho){
        jobber.modelo.Trabalho trab = new Trabalho();
        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM trabalho WHERE trabalho_id=? LIMIT 1");
            ps.setInt(1, trabalho.getId());
            rs = ps.executeQuery();
            if(rs.last()) {
                trab.setNome(rs.getString("trabalho_nome"));
                trab.setDescricao(rs.getString("trabalho_descricao"));
                trab.setId(rs.getInt("trabalho_id"));
                trab.setQntDeFeedback(rs.getInt("trabalho_qntNotaDeFeedback"));
                trab.setSomaNotaDeFeedback(rs.getFloat("trabalho_somaNotaDeFeedback"));
                trab.setContaId(rs.getInt("conta_id"));
                System.out.println("Sucesso na Consulta");
            } else {
                System.out.println("Falha na Consulta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return trab;
        }
    }

    public ArrayList<Feedback> listaFeedbackByTrabalho(Trabalho trabalho){
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();

        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM feedback WHERE trabalho_id=?;");
            ps.setInt(1, trabalho.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("feedback_id"));
                feedback.setComentario(rs.getString("feedback_comentario"));
                feedback.setNota(rs.getFloat("feedback_nota"));
                feedback.setConta_id(rs.getInt("conta_id"));
                feedback.setTrabalho_id(trabalho.getId());

                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return feedbacks;
        }
    }
    
}
