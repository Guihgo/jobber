/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.trabalhador;

import jobber.gui.cliente.*;

/**
 *
 * @author rfutenma
 */
public class IFrm_CombinandoTrab extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_CombinandoTrab() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_combinando = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Combinando");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_combinando.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_combinando.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do trabalho", "Trabalhador", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_combinando);
        if (tbl_combinando.getColumnModel().getColumnCount() > 0) {
            tbl_combinando.getColumnModel().getColumn(0).setResizable(false);
            tbl_combinando.getColumnModel().getColumn(0).setPreferredWidth(250);
            tbl_combinando.getColumnModel().getColumn(1).setResizable(false);
            tbl_combinando.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_combinando.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 440, 310));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Combinando");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_combinando;
    // End of variables declaration//GEN-END:variables
}