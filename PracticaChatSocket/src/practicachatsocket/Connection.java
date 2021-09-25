/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicachatsocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import jdk.nashorn.internal.parser.TokenType;


/**
 *
 * @author prado
 */
class Connection implements Runnable
{
    
    ObjectInputStream in;
    ObjectOutputStream out;
    Socket clientSocket;
    Servidor s;
    
    public Connection(Socket aclientSocket, Servidor s)
    {
        try 
        {
            this.s = s;
            clientSocket = aclientSocket;
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            Thread t = new Thread(this);
            t.start();
            System.out.println("Comunicacion hecha");
        } 
        catch (IOException e) 
        {
            System.out.println("Connection: " + e.getMessage());
        }
    }   
    
    public void run()
    {
        try 
        {
            Object o = in.readObject();
            //Intercambio de datos
            System.out.println("tipo: " + o.getClass().getSimpleName());
            if(o.getClass().getSimpleName().equals("String"))
            {
                System.out.println("Entre");
                String mensaje = (String) o;
                s.setChat(s.getChat() + mensaje + "\n");
                System.out.println("Recibido desde cliente: " + mensaje);

                s.notificar();
            }
            else
            {
                Cliente c = (Cliente) o;
                s.registrar(c);
                System.out.println("Registrado: " + c.getNombre());
                System.out.println("Clientes: " + s.countObservers());
            }
            
        } 
        catch (EOFException e)
        {
	     System.out.println("EOF:"+e.getMessage());
        }
        catch (IOException e) 
        {
            System.out.println("readline:"+e.getMessage());
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("ClassNotFound: " + ex.getMessage());
        }
        finally
        {
            try 
            {
	        clientSocket.close(); 
            }
            catch (IOException e)
            {
                System.out.println("Close Failed: " + e.getMessage());
            }
        }
    }
    
}
