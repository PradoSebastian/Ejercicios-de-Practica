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
public class Cliente {
    
    private String nombre = null;
    private ClienteGUI GUI = null;
    private Socket socket = null;
    private BufferedReader lector = null;
    private PrintWriter escritor = null;
    
    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
    
    public Cliente()
    {
        GUI = new ClienteGUI();
        metodoPrincipal();
    }
    
    public void leer ()
    {
        Thread leer_hilo = new Thread(new Runnable() {
            @Override
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
                    GUI.getBtn_enviar().addActionListener(new ActionListener() {
                        
                        @Override
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
            public void run() {
                try 
                {
                    socket = new Socket("localhost", 9000);
                    leer();
                    escribir();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
        principal.start();
    }
}
