/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

/**
 *
 * @author prado
 */
public class Servidor {

    private ServidorGUI GUI = null;
    private ServerSocket server = null;
    private Socket socket = null;
    private BufferedReader lector = null;
    private PrintWriter escritor = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();       
    }
    
    public Servidor ()
    {
        GUI = new ServidorGUI();
        metodoPrincipal();
    }
    
    public void leer ()
    {
        Thread leer_hilo = new Thread(new Runnable() {
            public void run() {
                try 
                {
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while(true)
                    {
                        String msj_recibido = lector.readLine();
                        GUI.actualizarChat(msj_recibido);
                    }
                } 
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        leer_hilo.start();
        
    }
    
    public void escribir()
    {
        Thread escribir_hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try 
                {
                    escritor = new PrintWriter(socket.getOutputStream(), true);
                    GUI.getBtn_enviar().addActionListener(new java.awt.event.ActionListener() 
                    {
                        public void actionPerformed(java.awt.event.ActionEvent evt) 
                        {
                            String msj_enviar = GUI.getTxt_mensaje().getText();
                            GUI.getTxt_mensaje().setText("");
                            escritor.println(msj_enviar);
                        }              
                    });
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
        
        escribir_hilo.start();       
    }
    
    public void metodoPrincipal()
    {
        Thread principal = new Thread(new Runnable() {
            @Override
            public void run() {
                try 
                {
                    server = new ServerSocket(9000);
                    while(true)
                    {
                        socket = server.accept();
                        System.out.println("prueba2");
                        leer();
                        escribir();
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
        
        principal.start();
        
        Thread prueba = new Thread(new Runnable() {
            @Override
            public void run() {
                GUI.getBtn_enviar().addActionListener(new java.awt.event.ActionListener() 
                    {
                        public void actionPerformed(java.awt.event.ActionEvent evt) 
                        {
                            GUI.getTxt_mensaje().setText("");
                        }              
                    });
            }
        });
        prueba.start();
    }
    
}
