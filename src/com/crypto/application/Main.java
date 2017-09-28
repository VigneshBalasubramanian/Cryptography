package com.crypto.application;

import com.crypto.cryptographic.Crypto;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Main extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5407653157797876371L;

	/**
     * Creates new form Find
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jDialog1 = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jColorChooser1.setBackground(java.awt.SystemColor.desktop);

        jColorChooser2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N

        jDialog1.setFont(new java.awt.Font("Baskerville Old Face", 3, 24)); // NOI18N

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MultiSecure File App");
        setBackground(new java.awt.Color(0, 102, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.cyan);
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(5, 5));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/publickey.jpg"))); // NOI18N
        //jButton1.setText("Public Key");
        jButton1.setMaximumSize(new java.awt.Dimension(181, 123));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/hash.jpg"))); // NOI18N
        //jButton5.setText("Hash");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/dig.jpg"))); // NOI18N
        //jButton3.setText("Digital Signature");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/symmetric.jpg"))); // NOI18N
        //jButton4.setText("Symetric Key");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/send_receiver,jpg.jpg"))); // NOI18N
        //jButton6.setText("Send / Receive File");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/exit.jpg"))); // NOI18N
        //jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (digSign == null) {
            digSign = new DigSign();
        }
        digSign.cbKeySize.setSelectedIndex(0);
        Crypto.KEY_SIZE = Integer.parseInt((String) digSign.cbKeySize.getSelectedItem());

        digSign.cbHashType.setSelectedIndex(0);
        digSign.text.setEnabled(true);
        digSign.textInputFile.setEnabled(false);
        digSign.btnFile.setEnabled(false);
        digSign.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pk == null) {
            pk = new PublicKey();
        }
        pk.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (sk == null) {
            sk = new SymmetricKey();
        }
        sk.cbKeySize.setSelectedIndex(0);
        Crypto.KEY_SIZE = Integer.parseInt((String) sk.cbKeySize.getSelectedItem());
        sk.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (hash == null) {
            hash = new Hash();
        }
        hash.cbHashType.setSelectedIndex(0);
        hash.text.setEnabled(true);
        hash.textInputFile.setEnabled(false);
        hash.btnFile.setEnabled(false);
        hash.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (sr == null) {
            sr = new SendReceive();
        }
        sr.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Metal (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Metal".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    private static PublicKey pk = null;
    private static SymmetricKey sk = null;
    private static Hash hash = null;
    private static DigSign digSign = null;
    private static SendReceive sr = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JDialog jDialog1;
    // End of variables declaration//GEN-END:variables

}
