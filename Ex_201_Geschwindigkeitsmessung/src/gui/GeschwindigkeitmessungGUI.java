
import BL.Measurement;
import BL.VelocityTableRenderer;
import gui.VelocityDLG;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sabrina
 */
public class GeschwindigkeitmessungGUI extends javax.swing.JFrame {

    private VelocityTableModel vtm = new VelocityTableModel();

    /**
     * Creates new form GeschwindigkeitmessungGUI
     */
    public GeschwindigkeitmessungGUI() {
        initComponents();

        this.setLocationRelativeTo(this);
        initTable();

        try {
            vtm.loadFromBinaryFile();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public void initTable() {
        int[] colWidth = {200, 200, 350, 200, 200, 200};
        DefaultTableColumnModel dtcm = new DefaultTableColumnModel();

        for (int i = 0; i < colWidth.length; i++) {
            TableColumn tc = new TableColumn(i, colWidth[i]);
            tc.setResizable(false);
            dtcm.addColumn(tc);

        }

        tbGeschwindigkeitsmessung.setModel(vtm);
        tbGeschwindigkeitsmessung.setColumnModel(dtcm);
        tbGeschwindigkeitsmessung.setDefaultRenderer(Object.class, new VelocityTableRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miHinzufügen = new javax.swing.JMenuItem();
        miLoeschen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDurchschnitt = new javax.swing.JMenuItem();
        plGeschwindigkeitsmessung = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGeschwindigkeitsmessung = new javax.swing.JTable();
        mbMenu = new javax.swing.JMenuBar();
        meDatei = new javax.swing.JMenu();

        miHinzufügen.setText("Hinzufügen");
        miHinzufügen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddMeasure(evt);
            }
        });
        jPopupMenu1.add(miHinzufügen);

        miLoeschen.setText("Löschen");
        miLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveMeasure(evt);
            }
        });
        jPopupMenu1.add(miLoeschen);
        jPopupMenu1.add(jSeparator1);

        miDurchschnitt.setText("Durchschnitt");
        miDurchschnitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gitDisplayAverage(evt);
            }
        });
        jPopupMenu1.add(miDurchschnitt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClosing(evt);
            }
        });

        plGeschwindigkeitsmessung.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        tbGeschwindigkeitsmessung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbGeschwindigkeitsmessung.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbGeschwindigkeitsmessung);

        plGeschwindigkeitsmessung.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(plGeschwindigkeitsmessung, java.awt.BorderLayout.CENTER);

        meDatei.setText("Datei");
        mbMenu.add(meDatei);

        setJMenuBar(mbMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAddMeasure(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddMeasure
        try {
            VelocityDLG vdlg = new VelocityDLG(this, true);
            vdlg.setVisible(true);
            vtm.add((Measurement) vdlg.getM());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_onAddMeasure

    private void onRemoveMeasure(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveMeasure
        try {
            int[] indicies = tbGeschwindigkeitsmessung.getSelectedRows();
            vtm.remove(indicies);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_onRemoveMeasure

    private void gitDisplayAverage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gitDisplayAverage
        try {
            double durchschnitt = vtm.berechneDurchschnitt();
            String s = "Durchschnittsübertretung: " + durchschnitt + " km/h";
            JOptionPane.showMessageDialog(null, s);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_gitDisplayAverage

    private void onClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClosing
        vtm.saveToBinaryFile();
    }//GEN-LAST:event_onClosing

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
            java.util.logging.Logger.getLogger(GeschwindigkeitmessungGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeschwindigkeitmessungGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeschwindigkeitmessungGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeschwindigkeitmessungGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeschwindigkeitmessungGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenu meDatei;
    private javax.swing.JMenuItem miDurchschnitt;
    private javax.swing.JMenuItem miHinzufügen;
    private javax.swing.JMenuItem miLoeschen;
    private javax.swing.JPanel plGeschwindigkeitsmessung;
    private javax.swing.JTable tbGeschwindigkeitsmessung;
    // End of variables declaration//GEN-END:variables
}
