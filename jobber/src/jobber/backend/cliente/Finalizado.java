package jobber.backend.cliente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Feedback;
import jobber.modelo.Processo;

public class Finalizado extends Conexao {
    private Conta conta;
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Finalizado(Conexao conexao, Conta conta) {
        this.conexao = conexao;
        this.conta = conta;
    }

    public ArrayList<Processo> listar(Conta conta) {
        ArrayList<Processo> processos = new ArrayList<Processo>();
        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM conta natural join trabalho join processo on trabalho.trabalho_id = processo.trabalho_id where processo.conta_id = ? and processo_status = 3;");
            ps.setInt(1,conta.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Processo processo = new Processo();
                processo.setNomeTrabalho(rs.getString("trabalho_nome"));
                processo.setId(rs.getInt("processo_id"));
                processo.setNomeTrabalhador(rs.getString("conta_nome"));
                processo.setStatus(rs.getInt("processo_status"));
                processo.setIdTrab(rs.getInt("trabalho_id"));
                processos.add(processo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return processos;
        }
    }
    
    public Processo consultar(Processo processo){
        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM processo p INNER JOIN trabalho t ON p.trabalho_id = t.trabalho_id INNER JOIN CONTA c ON t.conta_id = c.conta_id WHERE p.processo_id=? limit 1;");
            ps.setInt(1, processo.getId());
            rs = ps.executeQuery();
            if(rs.last()) {
                processo.setId(rs.getInt("p.processo_id"));
                processo.setIdTrab(rs.getInt("trabalho_id"));
                processo.setNomeTrabalho(rs.getString("t.trabalho_nome"));
                processo.setNomeTrabalhador(rs.getString("c.conta_id"));
                processo.setStatus(rs.getInt("p.processo_status"));
                System.out.println("Sucesso na Consulta do processo");
            } else {
                System.out.println("Falha na Consulta do processo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return processo;
        }
    }
    
    
    
    public void criarFeedback(Processo processo, Feedback feedback){
        boolean criouComSucesso;
        Feedback feed = new Feedback();
        try {
            
            ps = this.conexao.getConnection().prepareStatement("insert into feedback (feedback_nota,feedback_comentario,conta_id,trabalho_id) VALUES(?,?,?,?);");
            ps.setFloat(1, feedback.getNota());
            ps.setString(2, feedback.getComentario());
            ps.setInt(3, conta.getId());
            ps.setInt(4, processo.getIdTrab());
            if(ps.executeUpdate() > 0){
                System.out.println("Feedback Criado");
            }
            
            ps = this.conexao.getConnection().prepareStatement("UPDATE processo set processo_status = 5 where processo_id =?;");
            ps.setInt(1, processo.getId());
            if(ps.executeUpdate() > 0){
                System.out.println("Status do processo mudado");
            }
            
            ps = this.conexao.getConnection().prepareStatement("UPDATE trabalho set trabalho_somaNotaDeFeedback = trabalho_somaNotaDeFeedback + ?, trabalho_qntNotaDeFeedback = trabalho_qntNotaDeFeedback + 1 where trabalho_id = ?;");
            ps.setFloat(1, feedback.getNota());
            ps.setInt(2, processo.getIdTrab());
            if(ps.executeUpdate() > 0){
                System.out.println("Feedback Criado");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Adicionado com sucesso");
        }
        
        
    }
    
    
}
