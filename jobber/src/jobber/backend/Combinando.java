/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.backend;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Processo;
import jobber.modelo.Trabalho;

/**
 *
 * @author rfutenma
 */
public class Combinando extends Conexao{
    
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public Combinando(Conexao conexao){
        this.conexao = conexao;
    }
    
    public Processo criaProcesso(Trabalho trabalho,Conta conta){
        
        Processo processo = new Processo();
        boolean adicionouComSucesso;
        try {
            
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO processo (processo_status,trabalho_id,conta_id) VALUES(1,?,?);");
            ps.setInt(1, trabalho.getId());
            ps.setInt(2, conta.getId());
            if(ps.executeUpdate() > 0){
                System.out.println("Processo Criado");
            }
            ps = this.conexao.getConnection().prepareStatement("SELECT*FROM processo WHERE conta_id=? ORDER BY processo_id desc limit 1;");
            ps.setInt(1, conta.getId());
            rs = ps.executeQuery();
            if(rs.last()) {
                processo.setId(rs.getInt("processo_id"));
                processo.setStatus(rs.getInt("processo_status"));
                processo.setIdTrab(rs.getInt("trabalho_id"));
                processo.setIdConta(rs.getInt("conta_id"));                
                processo.setData(rs.getTimestamp("processo_data"));
                System.out.println("Sucesso na Consulta do criaProcesso()");
            } else {
                System.out.println("Falha na Consulta do criaProcesso()");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Adicionado com sucesso");
            closeStatement(stmt, rs);
            return processo;
        }
    }
    
    
    public ArrayList<Processo >listaTrabCombinandoCli(Conta conta){
        ArrayList<Processo> processos = new ArrayList<Processo>();

        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT * FROM processo p INNER JOIN trabalho t ON "+
                    "p.trabalho_id = t.trabalho_id INNER JOIN CONTA c ON t.conta_id = c.conta_id WHERE p.conta_id=? AND p.processo_status between 1 and 5 order by p.processo_status DESC;");
            ps.setInt(1, conta.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Processo processo = new Processo();
                processo.setId(rs.getInt("p.processo_id"));
                processo.setNomeTrabalho(rs.getString("t.trabalho_nome"));
                processo.setNomeTrabalhador(rs.getString("c.conta_nome"));
                processo.setStatus(rs.getInt("p.processo_status"));
                processos.add(processo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return processos;
        }
    }
    
    
    public ArrayList<Processo >listaTrabCombinandoTrab(Conta conta){
        ArrayList<Processo> processos = new ArrayList<Processo>();

        try {
            ps = this.conexao.getConnection().prepareStatement("SELECT*FROM processo p INNER JOIN conta c on p.conta_id = c.conta_id INNER JOIN trabalho t ON t.trabalho_id = p.trabalho_id WHERE t.conta_id=? AND p.processo_status between 1 and 2 order by p.processo_data DESC;");
            ps.setInt(1, conta.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Processo processo = new Processo();
                processo.setId(rs.getInt("p.processo_id"));
                processo.setNomeTrabalho(rs.getString("t.trabalho_nome"));
                processo.setNomeCliente(rs.getString("c.conta_nome"));
                processo.setStatus(rs.getInt("p.processo_status"));
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
                processo.setIdTrab(rs.getInt("p.trabalho_id"));
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
            
    
    
}
