/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectochat81;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author sala-406
 */
public class FrmUsuario2 extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form FrmUsuario1
     */
    public FrmUsuario2() {
        initComponents();
        this.setTitle("Usuario Secundario 2");
        //Atento al uso del boton enviar
        this.getRootPane().setDefaultButton(jBtEnviar2);
        //Define un objeto de la clase servidor y se abre un puerto para conexion.
        Servidor serv = new Servidor(7000);
        //Servidor atento a cualquier notificacion
        serv.addObserver(this);
        Thread t = new Thread (serv);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTaChat2 = new javax.swing.JTextArea();
        jTxMensaje2 = new javax.swing.JTextField();
        jBtEnviar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTaChat2.setColumns(20);
        jTaChat2.setRows(5);
        jScrollPane1.setViewportView(jTaChat2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 36, 454, 276));
        jPanel1.add(jTxMensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 344, 371, -1));

        jBtEnviar2.setText("Enviar");
        jBtEnviar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviar2ActionPerformed(evt);
            }
        });
        jPanel1.add(jBtEnviar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEnviar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviar2ActionPerformed
        String mensaje = "2. " + jTxMensaje2.getText()+"\n";
        jTaChat2.append(mensaje);
        jTxMensaje2.setText("");
        Cliente clie = new Cliente("172.16.5.38", 6000, mensaje);
        Thread t = new Thread(clie);
        t.start();
    }//GEN-LAST:event_jBtEnviar2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsuario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuario2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtEnviar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTaChat2;
    private javax.swing.JTextField jTxMensaje2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       jTaChat2.append((String)arg);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
    }
}
