package jobber.backend.cliente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
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
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM conta natural join trabalho join processo on trabalho.trabalho_id = processo.trabalho_id where processo.conta_id = ? and processo_status >= 2;");
            ps.setInt(1,conta.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Processo processo = new Processo();
                processo.setNomeTrabalho(rs.getString("trabalho_nome"));
                processo.setNomeTrabalhador(rs.getString("conta_nome"));
                processo.setStatus(rs.getInt("processo_status"));
                processos.add(processo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return processos;
        }
    }
}
