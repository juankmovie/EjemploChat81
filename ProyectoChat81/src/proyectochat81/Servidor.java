/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectochat81;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sala-406
 */
public class Servidor extends Observable implements Runnable {
    private int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        

        
        try {
            servidor = new ServerSocket (puerto);
            System.out.println("Servidor iniciado");
            
            while (true){
                // Esperando que un cliente se conecte
                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                String mensaje = in.readUTF();
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                //sc.close();
                //System.out.println("Cliente desconectado");
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
