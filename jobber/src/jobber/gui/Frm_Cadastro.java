/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import jobber.backend.Cadastro;
import jobber.backend.Conexao;
import jobber.backend.Login;
import jobber.modelo.Conta;

/**
 *
 * @author rfutenma
 */
public class Frm_Cadastro extends javax.swing.JFrame implements ActionListener {

    Conexao conexao = null;

    /**
     * Creates new form Frm_Cadastro
     */
    public Frm_Cadastro() {
        initComponents();
    }

    public Frm_Cadastro(Conexao conexao){
        this.conexao = conexao;
        initComponents();
        init();
    }

    private void init(){
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==jButton1) {
            Cadastro cadastro = new Cadastro(this.conexao);
            if (txt_nome.getText().replace(" ", "").equals("")||(txt_email.getText().replace(" ", "").equals(""))){
                JOptionPane.showMessageDialog(null, "Digite um nome e email válidos!");
            }
            else if(txt_senha.getText().replace(" "," ").equals("")){
                JOptionPane.showMessageDialog(null, "Senha inválida!");
            }
            else if (txt_senha.getText().equals(txt_confirmarSenha.getText())){
                Conta conta = new Conta();
                conta.setEmail(txt_email.getText());
                conta.setNome(txt_nome.getText());
                conta.setTipo(cb_tipo.getSelectedIndex());
                if(cadastro.emailNaoExiste(conta)){
                    if(cadastro.criaConta(conta,txt_senha.getText())){
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                        Frm_Login l = new Frm_Login(this.conexao);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Erro no processo de criação");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Email já existente!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem!");
            }
        }
        else if (actionEvent.getSource() == jButton2){
            Frm_Login l = new Frm_Login(this.conexao);
            this.dispose();
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

        txt_nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        txt_confirmarSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setMaximumSize(new java.awt.Dimension(340, 295));
        setMinimumSize(new java.awt.Dimension(340, 295));
        setPreferredSize(new java.awt.Dimension(340, 295));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 140, -1));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel2.setText(" Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel4.setText("Tipo :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabalhador", "Cliente" }));
        getContentPane().add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, -1));

        jLabel5.setText("Corfirmar Senha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, -1));

        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));
        getContentPane().add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));
        getContentPane().add(txt_confirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 140, -1));

        jButton1.setText("Cadastrar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jButton2.setText("Já sou cadastrado");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txt_confirmarSenha;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
