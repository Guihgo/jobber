/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.backend.trabalhador;

import jobber.backend.cliente.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jobber.backend.Conexao;
import jobber.modelo.Conta;
import jobber.modelo.Mensagem;
import jobber.modelo.Processo;

/**
 *
 * @author rfutenma
 */
public class ChatTrab extends Conexao{
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public ChatTrab(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean enviar(Processo processo,String mensagem, Conta conta){
        boolean enviouComSucesso = false;
        try {
            
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO chat(processo_id,chat_mensagem,conta_id) VALUES(?,?,?);");
            ps.setInt(1, processo.getId());
            ps.setString(2, mensagem);
            ps.setInt(3, conta.getId());
            if(ps.executeUpdate() > 0){
                enviouComSucesso =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return enviouComSucesso;
        }
    }
    
    public ArrayList<Mensagem> gerarhistorico(Processo processo){
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

        try {
            ps = this.conexao.getConnection().prepareStatement(" SELECT * FROM chat c1 inner join conta c on c1.conta_id = c.conta_id where c1.processo_id=?");
            ps.setInt(1, processo.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Mensagem mensagem = new Mensagem();
                mensagem.setMsg(rs.getString("chat_mensagem"));
                mensagem.setIdAutor(rs.getInt("conta_id"));
                mensagem.setAutor(rs.getString("conta_nome"));                
                mensagem.setData(rs.getTimestamp("chat_data"));
                mensagens.add(mensagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return mensagens;
        }
    }
    
    public boolean confirma(Processo processo){
        boolean solicitouComSucesso = false;
        try{
            ps = this.conexao.getConnection().prepareStatement("UPDATE processo SET processo_status = 3 WHERE processo_id = ?");
            ps.setInt(1, processo.getId());
            if(ps.executeUpdate() > 0){
                solicitouComSucesso =true;
                processo.setStatus(2);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeStatement(stmt, rs);
            return solicitouComSucesso;
        }
    }
    
    public boolean recusa(Processo processo){
        boolean solicitouComSucesso = false;
        try{
            ps = this.conexao.getConnection().prepareStatement("UPDATE processo SET processo_status = 4 WHERE processo_id = ?");
            ps.setInt(1, processo.getId());
            if(ps.executeUpdate() > 0){
                solicitouComSucesso =true;
                processo.setStatus(2);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeStatement(stmt, rs);
            return solicitouComSucesso;
        }
    }
    
    
    public boolean cancela(Processo processo){
        boolean cancelouComSucesso = false;
        try{
            ps = this.conexao.getConnection().prepareStatement("UPDATE processo SET processo_status = 6 WHERE processo_id = ?");
            ps.setInt(1, processo.getId());
            if(ps.executeUpdate() > 0){
                cancelouComSucesso =true;
                processo.setStatus(6);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            closeStatement(stmt, rs);
            return cancelouComSucesso;
        }
    }
    
    
}
