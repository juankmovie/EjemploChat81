/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectochat81;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sala-406
 */
public class Cliente implements Runnable{
    
    private String host;
    private int puerto;
    private String mensaje;

    public Cliente(String host, int puerto, String mensaje) {
        this.host = host;
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    
    
    
    @Override
    public void run() {
      DataOutputStream out;  
      
        try {
            Socket sc = new Socket(host, puerto);
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    
    
}
