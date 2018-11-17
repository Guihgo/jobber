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
import jobber.modelo.Conta;
import jobber.modelo.Feedback;
import jobber.modelo.Mensagem;
import jobber.modelo.Mensagem1;
import jobber.modelo.Processo1;
import jobber.modelo.Trabalho;

/**
 *
 * @author rfutenma
 */
public class ChatCli extends Conexao{
    private Conexao conexao;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public ChatCli(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean enviar(Processo1 processo,String mensagem, Conta conta){
        boolean enviouComSucesso = false;
        try {
            ps = this.conexao.getConnection().prepareStatement("INSERT INTO CHAT1(processo_id,chat_mensagem,conta_id) VALUES(?,?,?);");
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
    
    public ArrayList<Mensagem1> gerarhistorico(Processo1 processo){
        ArrayList<Mensagem1> mensagens = new ArrayList<Mensagem1>();

        try {
            ps = this.conexao.getConnection().prepareStatement(" SELECT * FROM chat1 c1 inner join conta c on c1.conta_id = c.conta_id where c1.processo_id=?");
            ps.setInt(1, processo.getId());
            rs = ps.executeQuery();
            while(rs.next()) {
                Mensagem1 mensagem = new Mensagem1();
                mensagem.setMsg(rs.getString("chat_mensagem"));
                mensagem.setIdAutor(rs.getInt("conta_id"));
                mensagem.setAutor(rs.getString("conta_nome"));                
                mensagem.setData(rs.getTimestamp("chat_data"));
                System.out.println(mensagem.getAutor());
                mensagens.add(mensagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt, rs);
            return mensagens;
        }
    }
    
    
    
    
}
