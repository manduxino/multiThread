/*
sviluppare un applicativo client server che generi tanti thread 
quanti dichiarati dall'utente attraverso un thread a lui dedicato.
ogni thread sommerà a una variabile globale contenuta nel server il proprio valore
incrementale assegnatogli dal server da 1 ad n dove n è il numero dei thread.
il server killerà ogni processo dopo aver svolto l'operazione. quando tutti i processi
saranno killati il sever stamperà a console il risultato
 */
package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author manduca.fabio
 */
public class MultiThread {
    
    static int TOT;

     public static void main(String[] args) {
    
         TOT = 0;
     
         try {
             ServerSocket server = new ServerSocket(5500);
             System.out.println("Server è attivo e in ascolto");
             
             while (true) {
                 Socket client = server.accept();
                 System.out.println("connessione ricevuta, quanti thread vuoi che generi?");
                
                 BufferedReader in = new BufferedReader( new InputStreamReader(server.getInputStream())); //TODO ricevi input, costruttore
      
               
                 for (int i = 0; i <in.read() ; i++) {
                
                     Thread Serverino = new Thread(new ServerThread(client,i));
                     Serverino.start();
                 }
               
                 
             }    } catch (IOException ex) {
             Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

   
    }

      
    
    

