/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicaclienteservidor;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author sala-406
 */
public class FrmCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmCliente
     */
    public FrmCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxenviar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxrespuesta = new javax.swing.JTextField();
        jBtnuevoMensaje = new javax.swing.JButton();
        jBtenviar = new javax.swing.JButton();
        jBtsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cliente:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 54, -1));

        jTxenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxenviarActionPerformed(evt);
            }
        });
        jPanel1.add(jTxenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 70));

        jLabel2.setText("Información de Envío");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 143, -1));

        jLabel3.setText("Respuesta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(jTxrespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 170, 400, 87));

        jBtnuevoMensaje.setText("Nuevo Mensaje");
        jPanel1.add(jBtnuevoMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jBtenviar.setText("Enviar");
        jBtenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtenviarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 115, -1));

        jBtsalir.setText("Salir");
        jPanel1.add(jBtsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 270, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxenviarActionPerformed
        //Codigo del Cliente para realizar petición
    }//GEN-LAST:event_jTxenviarActionPerformed

    private void jBtenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtenviarActionPerformed
      try{
          //Definimos el socket donde se realizará la petición del servidor
          Socket socket = new Socket("172.20.1.66", 9999);
          //Enviamos la petición al servidor
          DataOutputStream enviarDatos = new DataOutputStream(socket.getOutputStream());
          enviarDatos.writeUTF(jTxenviar.getText());
          //Verificamos respuesta
          DataInputStream respuesta = new DataInputStream(socket.getInputStream());
          String mensaje = respuesta.readUTF();
          jTxrespuesta.setText(mensaje);
          //Cerrar el socket
          socket.close();
      }catch (Exception e){
                      System.out.println("Error de Conexión");
                      }
              
    }//GEN-LAST:event_jBtenviarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtenviar;
    private javax.swing.JButton jBtnuevoMensaje;
    private javax.swing.JButton jBtsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxenviar;
    private javax.swing.JTextField jTxrespuesta;
    // End of variables declaration//GEN-END:variables
}