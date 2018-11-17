/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui;

import jobber.backend.Conexao;
import jobber.backend.Combinando;
import jobber.gui.cliente.IFrm_BuscarTrab;
import jobber.gui.cliente.IFrm_CombinandoCli;
import jobber.gui.trabalhador.IFrm_CombinandoTrab;
import jobber.gui.trabalhador.IFrm_GerenciarTrab;
import jobber.modelo.Conta;

/**
 *
 * @author rfutenma
 */
public class Frm_Menu extends javax.swing.JFrame {

    Conexao conexao = null;
    Conta conta;

    /**
     * Creates new form Frm_Menu
     */
    public Frm_Menu() {
        initComponents();
    }

    public Frm_Menu(Conexao conexao, Conta conta) {
        this.conexao = conexao;
        this.conta = conta;
        initComponents();
        init();
    }

    private void init(){
        lbl_nome.setText(this.conta.getNome());
        lbl_email2.setText(this.conta.getEmail());
        gerarUIByContaTipo();
        this.setVisible(true);
    }

    private void gerarUIByContaTipo(){
        if(this.conta.getTipo()==0) { //0=trabalhador
            lbl_tipo.setText("Trabalhador");
            panel_cliente.setVisible(false);
            panel_trabalhador.setVisible(true);
        }
        if(this.conta.getTipo()==1){ //1=cliente
            lbl_tipo.setText("Cliente");
            panel_cliente.setVisible(true);
            panel_trabalhador.setVisible(false);
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

        panel_cliente = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        btn_combinandoCli = new javax.swing.JButton();
        btn_finalizados = new javax.swing.JButton();
        Desktop = new javax.swing.JDesktopPane();
        panel_trabalhador = new javax.swing.JPanel();
        btn_gerenciarTrab = new javax.swing.JButton();
        btn_combinandoTrab = new javax.swing.JButton();
        panel_info = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_tipo = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_email2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        panel_cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar.setText("Buscar Trabalho");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_cliente.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        btn_combinandoCli.setText("Combinando");
        btn_combinandoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_combinandoCliActionPerformed(evt);
            }
        });
        panel_cliente.add(btn_combinandoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, -1));

        btn_finalizados.setText("Finalizados");
        btn_finalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizadosActionPerformed(evt);
            }
        });
        panel_cliente.add(btn_finalizados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, -1));

        getContentPane().add(panel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, 190));
        panel_cliente.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        getContentPane().add(Desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 680, 520));

        panel_trabalhador.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabalhador"));
        panel_trabalhador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_gerenciarTrab.setText("Trabalhos");
        btn_gerenciarTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenciarTrabActionPerformed(evt);
            }
        });
        panel_trabalhador.add(btn_gerenciarTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        btn_combinandoTrab.setText("Combinando");
        btn_combinandoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_combinandoTrabActionPerformed(evt);
            }
        });
        panel_trabalhador.add(btn_combinandoTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, -1));

        getContentPane().add(panel_trabalhador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 160, 130));

        panel_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo:");
        panel_info.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome:");
        panel_info.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Email:");
        panel_info.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_tipo.setForeground(new java.awt.Color(153, 153, 153));
        panel_info.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 20));

        lbl_nome.setForeground(new java.awt.Color(153, 153, 153));
        panel_info.add(lbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        lbl_email2.setForeground(new java.awt.Color(153, 153, 153));
        panel_info.add(lbl_email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 20));

        getContentPane().add(panel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Desktop.removeAll();
        Desktop.repaint();
        IFrm_BuscarTrab frm = new IFrm_BuscarTrab(conexao, conta);
        Desktop.add(frm);
        int x = (Desktop.getWidth()/2) - frm.getWidth()/2;
        int y = (Desktop.getHeight()/2) - frm.getHeight()/2;
        frm.setLocation(x, y);
        frm.show(); 
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_gerenciarTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenciarTrabActionPerformed
        Desktop.removeAll();
        Desktop.repaint();
        IFrm_GerenciarTrab frm = new IFrm_GerenciarTrab(conexao,conta);
        Desktop.add(frm);
        int x = (Desktop.getWidth()/2) - frm.getWidth()/2;
        int y = (Desktop.getHeight()/2) - frm.getHeight()/2;
        frm.setLocation(x, y);
        frm.show(); 
    }//GEN-LAST:event_btn_gerenciarTrabActionPerformed

    private void btn_combinandoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_combinandoCliActionPerformed
        Desktop.removeAll();
        Desktop.repaint();
        IFrm_CombinandoCli frm= new IFrm_CombinandoCli(conexao,conta);
        Desktop.add(frm);
        int x = (Desktop.getWidth()/2) - frm.getWidth()/2;
        int y = (Desktop.getHeight()/2) - frm.getHeight()/2;
        frm.setLocation(x, y);
        frm.show();
        
    }//GEN-LAST:event_btn_combinandoCliActionPerformed

    private void btn_combinandoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_combinandoTrabActionPerformed
        Desktop.removeAll();
        Desktop.repaint();
        IFrm_CombinandoTrab frm = new IFrm_CombinandoTrab(conexao, conta);
        Desktop.add(frm);
        int x = (Desktop.getWidth()/2) - frm.getWidth()/2;
        int y = (Desktop.getHeight()/2) - frm.getHeight()/2;
        frm.setLocation(x, y);
        frm.show();
    }//GEN-LAST:event_btn_combinandoTrabActionPerformed

    private void btn_finalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizadosActionPerformed
        Desktop.removeAll();
        Desktop.repaint();
    }//GEN-LAST:event_btn_finalizadosActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_combinandoCli;
    private javax.swing.JButton btn_combinandoTrab;
    private javax.swing.JButton btn_finalizados;
    private javax.swing.JButton btn_gerenciarTrab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_email2;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JPanel panel_cliente;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_trabalhador;
    // End of variables declaration//GEN-END:variables
}
