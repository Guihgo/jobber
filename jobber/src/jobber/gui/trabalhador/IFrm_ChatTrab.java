/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.trabalhador;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import jobber.backend.Conexao;
import jobber.backend.Chat;
import jobber.modelo.Conta;
import jobber.modelo.Mensagem;
import jobber.modelo.Processo;



/**
 *
 * @author rfutenma
 */
public class IFrm_ChatTrab extends javax.swing.JInternalFrame implements InternalFrameListener {
    Conexao conexao;
    Conta conta;
    Processo processo;
    ArrayList<Mensagem> mensagens;
    Timer timer;
    
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_ChatTrab() {
        initComponents();
    }
    
    public IFrm_ChatTrab(Conexao conexao,Conta conta,Processo processo){
        this.conexao = conexao;
        this.conta = conta;
        this.processo = processo;
        this.timer = new Timer();
        this.mensagens = new ArrayList<>();
        initComponents();
        ficaAtualizando();
        verifica();
        this.btn_atualizar.setVisible(false);
        addInternalFrameListener(this);
    }

    private void carregaHist(){

        Chat chat = new Chat(this.conexao);
        ArrayList<Mensagem> newMensagens = chat.gerarhistorico(this.processo);
        if(newMensagens.size()>this.mensagens.size()) {
            this.mensagens.clear();
            txt_historico.setText("");
            for(Mensagem mensagem: newMensagens) {
                txt_historico.append(mensagem.getAutor()+"   "+mensagem.getData()+":\n"+mensagem.getMsg()+"\n\n");
                this.mensagens.add(mensagem);
            }
            txt_historico.setCaretPosition(txt_historico.getDocument().getLength());
        }
    }

    private void ficaAtualizando() {
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("ficaAtualizando()");
                carregaHist();
            }
        }, 500, 1000);
    }

    private void verifica(){
        if(processo.getStatus() == 2 ) {
            btn_recusar.setVisible(true);
            btn_confirmar.setVisible(true);
        }
        else {
            btn_recusar.setVisible(false);
            btn_confirmar.setVisible(false);
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
        btn_confirmar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_mensagem = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_historico = new javax.swing.JTextArea();
        btn_recusar = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Chat");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Chat Trabalhador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        btn_voltar.setText("< Combinando");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

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

        btn_recusar.setText("Recusar");
        btn_recusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recusarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_recusar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        Chat chat = new Chat(this.conexao);
        int r = JOptionPane.showConfirmDialog(null, "Deseja Confirmar o trabalho?");
        if(r == 0){
            if(chat.confirma(this.processo)) System.out.println("Trabalho Solicitado");
            else System.out.println("Erro ao confirmar");
            verifica();
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        Mensagem msg = new Mensagem();
        msg.setMsg(txt_mensagem.getText());
        Chat chat = new Chat(conexao);
        if(chat.enviar(processo, msg.getMsg(), conta))         
        carregaHist();
        txt_mensagem.setText("");       
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_recusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recusarActionPerformed
        Chat chat = new Chat(this.conexao);
        int r = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o trabalho?");
        if(r == 0){
            if(chat.recusa(this.processo)) System.out.println("Trabalho Cancelado");
            else System.out.println("Erro ao Cancelar");
            verifica();
        }
    }//GEN-LAST:event_btn_recusarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Chat chat = new Chat(this.conexao);
        int r = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o trabalho?");
        if(r == 0){
            if(chat.cancela(this.processo)) System.out.println("Trabalho Cancelado");
            else System.out.println("Erro ao cancelar");
            verifica();
            JOptionPane.showMessageDialog(null, "Processo Cancelado");
            this.dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        IFrm_CombinandoTrab tela = new IFrm_CombinandoTrab(conexao, conta);
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
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton btn_recusar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_historico;
    private javax.swing.JTextField txt_mensagem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent internalFrameEvent) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent internalFrameEvent) {
        System.out.println("internalFrameDeactivated");
        this.timer.cancel();
    }
}
