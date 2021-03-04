/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manduca.fabio
 */
public class ServerThread implements Runnable {

    private Socket clientSocket;
    int num;

    public ServerThread(Socket clientSocket, int num) {
        this.clientSocket = clientSocket;
        this.num=num;
    }

    @Override
    public void run() {
            PrintWriter out
                    = null;
        try {
            System.out.println("Serverino  partito: "
                    + clientSocket.getInetAddress()+" "+num);
            
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
           
            //TOT = TOT + num;
           
          
            out.close();
            clientSocket.close();
            System.out.println("chiusura connessione effettuata");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

       
    }

}