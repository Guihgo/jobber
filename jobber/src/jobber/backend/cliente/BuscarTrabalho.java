/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.backend.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Trabalho;

/**
 *
 * @author rfutenma
 */
public class BuscarTrabalho extends Conexao {
    
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public BuscarTrabalho(Conexao conexao) {
        this.conexao = conexao;
    }
    
    public ArrayList<Trabalho> listar(String nome) {
        ArrayList<Trabalho> trabalhos = new ArrayList<Trabalho>();
        try {    
            ps = this.conexao.getConnection().prepareStatement("SELECT trabalho.* FROM trabalho WHERE trabalho.trabalho_nome LIKE '"+nome+"%' ORDER BY (trabalho_somaNotaDeFeedback/trabalho_qntNotaDeFeedback) DESC");
            rs = ps.executeQuery();
            while(rs.next()) {
                Trabalho trabalho = new Trabalho();
                trabalho.setId(rs.getInt("trabalho_id"));
                trabalho.setContaId(rs.getInt("conta_id"));
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
    
    
    public Trabalho consultarTrab(Trabalho trabalho){
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
    
    
    
    
    
}
