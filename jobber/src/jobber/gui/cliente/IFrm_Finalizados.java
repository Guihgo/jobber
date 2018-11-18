/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber.gui.cliente;
import jobber.backend.Conexao;
import jobber.backend.cliente.Finalizado;
import jobber.modelo.Processo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rfutenma
 */
public class IFrm_Finalizados extends javax.swing.JInternalFrame {

    Conexao conexao = null;
    jobber.modelo.Conta conta = null;
    ArrayList<Processo> processos;
    /**
     * Creates new form IFrm_Combinando
     */
    public IFrm_Finalizados() {
        initComponents();
    }

    public IFrm_Finalizados(Conexao conexao, jobber.modelo.Conta conta) {
        this.conexao = conexao;
        this.conta = conta;
        initComponents();
        init();
    }

    public void init() {
        Finalizado finalizado = new Finalizado(this.conexao, this.conta);
        this.processos = finalizado.listar(this.conta);
        String status = null;
        DefaultTableModel dtm = (DefaultTableModel) tbl_combinando.getModel();

        dtm.setNumRows(0);
        for(Processo processo: this.processos) {
            switch(processo.getStatus()){
                case 1:
                    status = "Combinando";
                    break;
                case 2:
                    status = "Solicitado";
                    break;
                case 3:
                    status = "Confirmado";
                    break;
                case 4:
                    status = "Recusado";
                    break;
                case 5:
                    status = "Avaliado";
                    break;
                case 6:
                    status = "Cancelado";
                    break;

            }
            dtm.addRow(new Object[]{
                    processo.getNomeTrabalho(),
                    processo.getNomeTrabalhador(),
                    status
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_combinando = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Trabalhos Finalizados");
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 290));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Trabalhos Finalizados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jButton1.setText("< Voltar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButton2.setText("Dar Feedback");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_combinando;
    // End of variables declaration//GEN-END:variables
}
