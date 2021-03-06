/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.trabalhador;

import javax.swing.JOptionPane;
import jobber.backend.Conexao;
import jobber.backend.trabalhador.GerenciarTrabalho;
import jobber.modelo.Trabalho;

/**
 *
 * @author rfutenma
 */
public class IFrm_EditarTrab extends javax.swing.JInternalFrame {

    Conexao conexao = null;
    jobber.modelo.Conta conta = null;
    Trabalho trabalho = null;
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_EditarTrab() {
        initComponents();
    }
    
    public IFrm_EditarTrab(Conexao conexao, jobber.modelo.Conta conta, Trabalho trabalho){
        this.conexao = conexao;
        this.conta = conta;
        this.trabalho = trabalho;
        initComponents();
        init();
    }
    
    private void init(){
        txt_id.setText(trabalho.getId()+"");
        txt_nome.setText(trabalho.getNome());
        txt_desc.setText(trabalho.getDescricao());
        float media = (trabalho.getQntDeFeedback()==0)? 0:(trabalho.getSomaNotaDeFeedback()/trabalho.getQntDeFeedback());
        txt_notamedia.setText(media+"");
        txt_qtdfeedbacks.setText(trabalho.getQntDeFeedback()+"");
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
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        btn_alterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_notamedia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_qtdfeedbacks = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Editar Trabalho");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Editar Trabalho");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        btn_voltar.setText("< Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setText("Nome do trabalho:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 330, 30));

        jLabel3.setText("Descrição:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txt_desc.setColumns(20);
        txt_desc.setRows(5);
        jScrollPane2.setViewportView(txt_desc);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 330, -1));

        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel4.setText("id:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txt_id.setEnabled(false);
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, -1));

        jLabel5.setText("Nota Média:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        txt_notamedia.setEnabled(false);
        getContentPane().add(txt_notamedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 60, -1));

        jLabel6.setText("Feedbacks:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        txt_qtdfeedbacks.setEnabled(false);
        getContentPane().add(txt_qtdfeedbacks, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        Trabalho trab = new Trabalho();
        trab.setNome(txt_nome.getText());
        trab.setId(Integer.parseInt(txt_id.getText()));
        trab.setDescricao(txt_desc.getText());
        int r = JOptionPane.showConfirmDialog(null, "Deseja alterar esse trabalho?");
        if (r == 0) {            
            jobber.backend.trabalhador.GerenciarTrabalho ger = new GerenciarTrabalho(conexao);            
            if(ger.editar(trab)){
                JOptionPane.showMessageDialog(null, "Editado com sucesso!");
                this.trabalho = ger.consultar(trab);
                IFrm_EditarTrab tela = new IFrm_EditarTrab(conexao, conta, trabalho);        
                getParent().add(tela);
                int x = (getParent().getWidth()/2) - tela.getWidth()/2;
                int y = (getParent().getHeight()/2) - tela.getHeight()/2;
                tela.setLocation(x, y);
                tela.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro!");
            }
            
        }
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        IFrm_GerenciarTrab tela = new IFrm_GerenciarTrab(conexao, conta);        
        getParent().add(tela);
        int x = (getParent().getWidth()/2) - tela.getWidth()/2;
        int y = (getParent().getHeight()/2) - tela.getHeight()/2;
        tela.setLocation(x, y);
        tela.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_btn_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_desc;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_notamedia;
    private javax.swing.JTextField txt_qtdfeedbacks;
    // End of variables declaration//GEN-END:variables
}
