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
 * @author Lorenzo Pisanò
 */
public class ClasseScanner {
    
    //dichiaro un socket ed una variabile String
    Socket s1;
    String indirizzoDaControllare;

    /*quando questa classe verrà instanziata in un'altra classe
    verrà richiesto un indirizzo che corrisponde a quello
    della macchina da controllare*/
    public ClasseScanner(String indirizzoDaControllare) {
        this.indirizzoDaControllare = indirizzoDaControllare;
    }
    
    //metodo per il controllo effettivo della porta
    public void ricavaSocket(int port)
    {
        try {
            /*si instanzai il socket con l'indirizzo passato tramite l'instanza della classe
            e quello che si passa quando si invoca questo metodo*/
            s1=new Socket(indirizzoDaControllare, port);
            System.out.println("La porta "+port+" dell'indirizzo "+indirizzoDaControllare+" e' aperta!");   
            //se la porta è chiusa gestisco l'eccezione
        } catch (ConnectException e1) {
           System.out.println("La porta "+port+" dell'indirizzo "+indirizzoDaControllare+" e' chiusa!");  
           //se l'indirizzo non esiste o non viene trovato gestisco l'eccezione
        } catch (UnknownHostException e2) {
            System.err.println("Indirizzo sconosciuto!");
            //eccezione Input/Output
        } catch (IOException e3)
        {
            System.err.println("Errore di I/O!");
        } finally {
            //Se non è stato ancora chiuso il socket
            if (s1!=null) {
                try {
                    //lo chiudo io
                    s1.close();
                } catch (IOException e4) {
                    System.err.println("Errore di I/O");
                }
            }
        }
    }
}
    
    