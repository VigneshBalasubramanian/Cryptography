package com.crypto.application;

import java.io.File;

import javax.swing.JFileChooser;

import com.crypto.cryptographic.SHA;

public class Hash extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6199448185392486835L;

    /**
     * Creates new form Find
     */
    public Hash() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private SHA sha = new SHA(true);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        text = new javax.swing.JTextField();
        textInputFile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnFile = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cbHashType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hashText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbInputType = new javax.swing.JComboBox<>();

        setTitle("Hash with SHA");
        setResizable(false);

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Text");

        textInputFile.setEditable(false);

        jLabel4.setText("Input File");

        btnFile.setText("...");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        jButton7.setText("Hash");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbHashType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SHA-1", "SHA-256", "SHA-384", "SHA-512" }));

        jLabel3.setText("Hash Type");

        jLabel2.setText("Hash Text");

        jLabel6.setText("Input Type");

        cbInputType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Text", "File" }));
        cbInputType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInputTypeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cbHashType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel6)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cbInputType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(textInputFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 415, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(btnFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, text, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                        .add(hashText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbHashType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(cbInputType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(text, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textInputFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(hashText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jButton7))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        int returnValue = fc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            if (selectedFile.exists() && selectedFile.isFile()) {
                textInputFile.setText(selectedFile.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (cbInputType.getSelectedIndex() == 0) {
            hashText.setText(sha.generateSHA(text.getText(), (String) cbHashType.getSelectedItem()));
        } else {
            hashText.setText(sha.generateSHA(fc.getSelectedFile(), (String) cbHashType.getSelectedItem()));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbInputTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInputTypeActionPerformed
        if (cbInputType.getSelectedIndex() == 0) {
            text.setEnabled(true);
            textInputFile.setEnabled(false);
            btnFile.setEnabled(false);
        } else {
            text.setEnabled(false);
            textInputFile.setEnabled(true);
            btnFile.setEnabled(true);
        }
    }//GEN-LAST:event_cbInputTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFile;
    public javax.swing.JComboBox<String> cbHashType;
    public javax.swing.JComboBox<String> cbInputType;
    private static javax.swing.JFileChooser fc;
    private javax.swing.JTextField hashText;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField text;
    public javax.swing.JTextField textInputFile;
    // End of variables declaration//GEN-END:variables

}
