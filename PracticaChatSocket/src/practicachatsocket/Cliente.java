/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicachatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author prado
 */
public class Cliente extends Thread implements Observer, Serializable
{
    private String nombre;
    private String direccion;
    private int puerto;
    private String chat = "";
    
    public Cliente(String direccion, int puerto)
    {        
        this.puerto = puerto;
        this.direccion = direccion;
    }
    
    public static void main (String[] args)
    {
        Cliente c = new Cliente("192.168.0.8", Servidor.PUERTO);
        c.start();
    }

    @Override
    public void run() 
    {
        Scanner sc = new Scanner(System.in);
        Socket s = null;
        //direccion = args[1];
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine().trim();    
        String opcion = "2";
        int i = 0;
        while(opcion.equals("2"))
        {
          
            try 
            {
                s = new Socket(direccion, puerto);
                //ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                if(i == 0)
                {
                    out.writeObject(this);
                    i = 1;
                    System.out.println("Registrado");
                    sleep(100);
                }
                else
                {
                    System.out.println("Ingrese el mensaje: ");
                    String mensaje = sc.nextLine().trim();
                    out.writeObject(nombre + ": " + mensaje);
                    System.out.println("Oprima 2 si quiere enviar otro mensaje, de lo comtrario otra tecla");
                    opcion = sc.nextLine().trim();
                }
//                chat = in.readUTF();
//                System.out.println("CHAT: \n" + chat);
            } 
            catch (UnknownHostException e)
            {
               System.out.println("Socket:"+e.getMessage());
            }
            catch (EOFException e)
            {
               System.out.println("EOF:"+e.getMessage());
            }
            catch (IOException e)
            {
               System.out.println("readline:"+e.getMessage());
                System.out.println(e);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                if(s!=null) 
                    try 
                    { 
                        s.close(); 
                    }
                    catch (IOException e)
                    {
                        System.out.println("close:"+e.getMessage());
                    }
            }
                    System.out.println(chat);

        }
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        //System.out.println("CHAT: \n" + o1);
        //JOptionPane.showMessageDialog(null, "CHAT: \n" + (String) o1);
        chat = (String) o1;
        
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
