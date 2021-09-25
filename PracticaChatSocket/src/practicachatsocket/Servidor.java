/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicachatsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author prado
 */
public class Servidor extends Observable
{
    
    public static void main(String[] args)
    {
        Servidor s = new Servidor();
    }
    
    public static final int PUERTO = 7896;
    private String chat = "";
    ArrayList<Cliente> clientes = new ArrayList<>();
    
    public Servidor()
    {
        try 
        {
            ServerSocket listenSocket = new ServerSocket(Servidor.PUERTO);
            System.out.println("Servidor Iniciado");
            Socket clientSocket;
            while(true)
            {
                clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket, this);
                System.out.println(chat);
            }    
        } 
        catch(IOException e)
        {
            System.out.println("Listen socket: "+e.getMessage());
	}
    }

    public String getChat() {
        return chat;
    }
    
    public void setChat(String chat)
    {
        this.chat = chat;
    }
    
    public ArrayList<Cliente> getClientes()
    {
        return clientes;
    }
    
    public void notificar()
    {
        this.setChanged();
        this.notifyObservers(chat);
        this.clearChanged();
    }
    
    public void registrar(Cliente c)
    {
        this.clientes.add(c);
        this.addObserver(c);
    }
    
}
