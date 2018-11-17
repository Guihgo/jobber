/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.backend.cliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Processo1;
import jobber.modelo.Trabalho;

/**
 *
 * @author rfutenma
 */
public class CombinandoCli extends Conexao{
    
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public CombinandoCli(Conexao conexao){
        this.conexao = conexao;
    }
    
    public Processo1 criaProcesso(Trabalho trabalho,Conta conta){
        
        Processo1 processo = new Processo1();
        boolean adicionouComSucesso;
        try {
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO processo1 (processo_status,trabalho_id,conta_id) VALUES(1,?,?);");
            ps.setInt(1, trabalho.getId());
            ps.setInt(2, conta.getId());
            if(ps.executeUpdate() > 0){
                System.out.println("PRocesso Criado");
            }
            ps = this.conexao.getConnection().prepareStatement("SELECT*FROM PROCESSO1 WHERE conta_id=? ORDER BY processo_id desc limit 1;");
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
            
            
    
    
}
