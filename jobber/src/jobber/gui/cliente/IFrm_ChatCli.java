/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.cliente;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import jobber.backend.Conexao;
import jobber.backend.cliente.ChatCli;
import jobber.backend.trabalhador.GerenciarTrabalho;
import jobber.gui.trabalhador.*;
import jobber.gui.cliente.*;
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
public class IFrm_ChatCli extends javax.swing.JInternalFrame {

    Conexao conexao;
    Conta conta;
    Processo1 processo;
    ArrayList<Mensagem1> mensagens;
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_ChatCli() {
        initComponents();
    }
    
    public IFrm_ChatCli(Conexao conexao, Conta conta, Processo1 processo){
        this.conexao = conexao;
        this.conta = conta;
        this.processo = processo;
        initComponents();
    }
    
    private void carregaHist(){
        ChatCli chat = new ChatCli(this.conexao);
        mensagens = chat.gerarhistorico(this.processo);
        txt_historico.setText("");        
        for(Mensagem1 mensagem: this.mensagens) { 
            txt_historico.append(mensagem.getAutor()+"   "+mensagem.getData()+":\n"+mensagem.getMsg()+"\n\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        btn_soliciar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_mensagem = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_historico = new javax.swing.JTextArea();

        setClosable(true);
        setResizable(true);
        setTitle("Chat");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Chat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        btn_voltar.setText("< Trabalhos em combinação");
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btn_soliciar.setText("Solicitar");
        getContentPane().add(btn_soliciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        btn_cancelar.setText("Cancelar");
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));
        getContentPane().add(txt_mensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 350, -1));

        btn_enviar.setText("Enviar >");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        txt_historico.setEditable(false);
        txt_historico.setColumns(20);
        txt_historico.setRows(5);
        jScrollPane1.setViewportView(txt_historico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        Mensagem msg = new Mensagem();
        msg.setMsg(txt_mensagem.getText());
        ChatCli chat = new ChatCli(conexao);
        if(chat.enviar(processo, msg.getMsg(), conta))         
        carregaHist();
        txt_mensagem.setText("");
        
    }//GEN-LAST:event_btn_enviarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton btn_soliciar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_historico;
    private javax.swing.JTextField txt_mensagem;
    // End of variables declaration//GEN-END:variables
}
