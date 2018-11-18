/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.cliente;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import jobber.backend.Conexao;
import jobber.backend.Chat;
import jobber.modelo.Conta;
import jobber.modelo.Mensagem;
import jobber.modelo.Processo;

/**
 *
 * @author rfutenma
 */
public class IFrm_ChatCli extends javax.swing.JInternalFrame {

    Conexao conexao;
    Conta conta;
    Processo processo;
    ArrayList<Mensagem> mensagens;
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_ChatCli() {
        initComponents();
    }
    
    public IFrm_ChatCli(Conexao conexao, Conta conta, Processo processo){
        this.conexao = conexao;
        this.conta = conta;
        this.processo = processo;
        initComponents();
        carregaHist();
        verificaSolicitado();
    }
    
    private void carregaHist(){
        
        Chat chat = new Chat(this.conexao);
        mensagens = chat.gerarhistorico(this.processo);
        txt_historico.setText("");        
        for(Mensagem mensagem: this.mensagens) { 
            txt_historico.append(mensagem.getAutor()+"   "+mensagem.getData()+":\n"+mensagem.getMsg()+"\n\n");
        }
    }
    
    private void verificaSolicitado(){
        if(processo.getStatus()>=2) btn_soliciar.setVisible(false);
        else btn_soliciar.setVisible(true);
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
        btn_atualizar = new javax.swing.JButton();

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

        btn_voltar.setText("< Combinando");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btn_soliciar.setText("Solicitar");
        btn_soliciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soliciarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_soliciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));
        getContentPane().add(txt_mensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 260, -1));

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

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        Mensagem msg = new Mensagem();
        msg.setMsg(txt_mensagem.getText());
        Chat chat = new Chat(conexao);
        if(chat.enviar(processo, msg.getMsg(), conta))         
        carregaHist();
        txt_mensagem.setText("");
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_soliciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soliciarActionPerformed
        Chat chat = new Chat(this.conexao);
        int r = JOptionPane.showConfirmDialog(null, "Deseja Solicitar o trabalho?");
        if(r == 0){
            if(chat.solicita(this.processo)) System.out.println("Trabalho Solicitado");
            else System.out.println("Erro ao solicitar");
            verificaSolicitado();
        }
        
        
        
    }//GEN-LAST:event_btn_soliciarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Chat chat = new Chat(this.conexao);
        int r = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o trabalho?");
        if(r == 0){
            if(chat.cancela(this.processo)) System.out.println("Trabalho Cancelado");
            else System.out.println("Erro ao cancelar");
            verificaSolicitado();
            JOptionPane.showMessageDialog(null, "Processo Cancelado");
            this.dispose();
        }
        
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        IFrm_CombinandoCli tela = new IFrm_CombinandoCli(conexao, conta);
        getParent().add(tela);
        int x = (getParent().getWidth()/2) - tela.getWidth()/2;
        int y = (getParent().getHeight()/2) - tela.getHeight()/2;
        tela.setLocation(x, y);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        carregaHist();
    }//GEN-LAST:event_btn_atualizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
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
