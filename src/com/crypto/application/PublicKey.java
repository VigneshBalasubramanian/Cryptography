package com.crypto.application;

import com.crypto.cryptographic.Crypto;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class PublicKey extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3090357391444628903L;

	/** 
	 * Creates new form Find 
	 */
    public PublicKey() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private static Encrypt encryptForm = null;
    private static Decrypt decryptForm = null;
    private static KeyPairGenerator kpg = null;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Cryptography");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/KpGenerator.jpg"))); // NOI18N
        //jButton5.setText("Key Pair Generator");
        jButton5.setMaximumSize(new java.awt.Dimension(640, 400));
        jButton5.setMinimumSize(new java.awt.Dimension(640, 400));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/enc.jpg"))); // NOI18N
        //jButton4.setText("Encrypt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/Decrypt Icon Base.jpg"))); // NOI18N
        //jButton3.setText("Decrypt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/crypto/application/back.jpg"))); // NOI18N
        //jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (decryptForm == null) {
            decryptForm = new Decrypt();
        }
        decryptForm.cbKeySize.setSelectedIndex(0);
        Crypto.KEY_SIZE = Integer.parseInt((String) decryptForm.cbKeySize.getSelectedItem());
        decryptForm.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (encryptForm == null) {
            encryptForm = new Encrypt();
        }
        encryptForm.cbKeySize.setSelectedIndex(0);
        Crypto.KEY_SIZE = Integer.parseInt((String) encryptForm.cbKeySize.getSelectedItem());
        encryptForm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (kpg == null) {
            kpg = new KeyPairGenerator();
        }
        kpg.cbKeySize.setSelectedIndex(0);
        Crypto.KEY_SIZE = Integer.parseInt((String) kpg.cbKeySize.getSelectedItem());
        kpg.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
    
}