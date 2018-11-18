/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.cliente;

import javax.swing.JOptionPane;
import jobber.backend.Conexao;
import jobber.backend.cliente.Finalizado;
import jobber.modelo.Conta;
import jobber.modelo.Feedback;
import jobber.modelo.Processo;



/**
 *
 * @author rfutenma
 */
public class IFrm_DarFeedback extends javax.swing.JInternalFrame {

    Conexao conexao;
    Processo processo;
    Conta conta;
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_DarFeedback() {
        initComponents();
    }
    
    public IFrm_DarFeedback(Conexao conexao,Conta conta,Processo processo){
        this.conexao = conexao;
        this.conta = conta;
        this.processo = processo;
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txt_nota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_comentario = new javax.swing.JTextArea();
        btn_add = new javax.swing.JButton();

        setClosable(true);
        setTitle("Dar Feedback");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Dar Feedback");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        btn_voltar.setText("< Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setText("Nota:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));
        getContentPane().add(txt_nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, -1));

        jLabel3.setText("Comentário:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        txt_comentario.setColumns(20);
        txt_comentario.setRows(5);
        jScrollPane2.setViewportView(txt_comentario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 420, -1));

        btn_add.setText("Dar Feedback");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
        Finalizado fin = new Finalizado(conexao, conta);
        Feedback feedback = new Feedback();
        feedback.setNota(Float.parseFloat(txt_nota.getText()));
        feedback.setComentario(txt_comentario.getText());
        fin.criarFeedback(processo, feedback);
        JOptionPane.showMessageDialog(null, "Feedback postado!");
        IFrm_Finalizados tela = new IFrm_Finalizados(conexao, conta);
        getParent().add(tela);
        int x = (getParent().getWidth()/2) - tela.getWidth()/2;
        int y = (getParent().getHeight()/2) - tela.getHeight()/2;
        tela.setLocation(x, y);
        tela.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        IFrm_Finalizados tela = new IFrm_Finalizados(conexao, conta);        
        getParent().add(tela);
        int x = (getParent().getWidth()/2) - tela.getWidth()/2;
        int y = (getParent().getHeight()/2) - tela.getHeight()/2;
        tela.setLocation(x, y);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_comentario;
    private javax.swing.JTextField txt_nota;
    // End of variables declaration//GEN-END:variables
}
