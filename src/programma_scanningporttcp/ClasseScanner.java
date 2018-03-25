/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programma_scanningporttcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class ClasseScanner {
    
    Socket s1;
    String indirizzoDaControllare;

    public ClasseScanner(String indirizzoDaControllare) {
        this.indirizzoDaControllare = indirizzoDaControllare;
    }
    
    public void ricavaSocket(int port)
    {
        String out="";
        try {
            s1=new Socket(indirizzoDaControllare, port);
            System.out.println("La porta "+port+" dell'indirizzo "+indirizzoDaControllare+" e' aperta!");    
        } catch (ConnectException e1) {
           System.out.println("La porta "+port+" dell'indirizzo "+indirizzoDaControllare+" e' chiusa!");  
        } catch (UnknownHostException e2) {
            System.err.println("Indirizzo sconosciuto!");
        } catch (IOException e3)
        {
            System.err.println("Errore di I/O!");
        } finally {
            if (s1!=null) {
                try {
                    s1.close();
                } catch (IOException e4) {
                    System.err.println("Errore di I/O");
                }
            }
        }
    }
}
    
    