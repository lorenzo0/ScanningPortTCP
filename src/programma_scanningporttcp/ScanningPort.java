/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programma_scanningporttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo Pisanò
 */
public class ScanningPort {
    
    //Dichiarazione della ClasseScanner e del BufferedReader
    ClasseScanner c1;
    BufferedReader br;
    //Dichiarazione variabile utili per diversi metodi quindi la rendo globale
    int port;
    //Dichiarazioni stringhe per colori come nella chat
    public static final String ColoreCyan = "\u001B[36m";
    public static final String ColoreReset = "\u001B[0m";

    //non richiedo niente quando verrà instanziata la classe
    public ScanningPort() {
    }
    
    //metodo dove l'utente si interfaccia per un corretto funzionamento del programma
    public void esegui()
    {
        //variabile utile per il corretto funzionamento del metodo
        int dowhile;
        try {
            //faccio inserire all'utente l'indirizzo IP della macchina da controllare
            System.out.println("Inserire l'indirizzo dove si vuole eseguire uno scanning: ");
            //instanzio un bufferedReader per raccogliere le informazioni
            br = new BufferedReader(new InputStreamReader(System.in));
            /*Dichiaro ed instanzio la variabile indirizzoInseritoUtente a cui assegno le 
            informazioni precedentemente raccolte con il BufferedReader*/
            String indirizzoInseritoUtente = br.readLine();
            /*Instanzio l'oggetto della ClasseScanner e gli passo la variabile con l'indirizzo
            della macchina da controllare*/
            c1 = new ClasseScanner(indirizzoInseritoUtente);
            
            do{
                //stampo a video il menu dei servizi che l'utente può usufruire
                System.out.println(ColoreCyan + "1: Scanning di una porta");
                System.out.println(ColoreCyan + "2: Scanning range di porte");
                System.out.println(ColoreCyan + "3: Scanning porte conosciute");
                System.out.println(ColoreCyan + "4: Esci dal programma");
                System.out.println(ColoreCyan + "Fai la tua scelta: " + ColoreReset);
                //prendo il valore inserito dall'utente che corrisponde al servizio che vuole usare
                dowhile=Integer.parseInt(br.readLine());
                
                //se ha scelto lo scanning di una porta
                if(dowhile == 1)
                {
                    controlloPorta();
                }
                //se ha scelto lo scanning di un range di porte
                if(dowhile == 2)
                {
                    controlloRangePorte();
                }
                //se ha scelto lo scanning delle porte well-known
                if(dowhile == 3)
                {
                    controlloServizi();
                }
                if(dowhile == 4)
                {
                    System.out.println("Grazie per aver utilizzato il mio programma!");
                }
                //lascio uno spazio nella stampa
                System.out.println("\n");
                //questo ciclo si ripete finche l'utente non decide di chiudere il programma
            }while (dowhile != 4);
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloPorta()
    {
        try {
            //faccio inserire la porta
            System.out.println("Inserire la porta che si vuole controllare: ");
            //la assegno alla variabile port
            port = Integer.parseInt(br.readLine());
            //invoco il metodo passandogli la porta
            c1.ricavaSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloRangePorte()
    {
        //variabili utili per il corretto funzionamento del metodo
        int ultimaPorta, sottrazione;
        try {
            //faccio inserire la prima porta da controllare
            System.out.println("Inserire la prima porta che si vuole controllare: ");
            //la assegno alla variabile port
            port = Integer.parseInt(br.readLine());
            //faccio inserire l'ultima porta da controllare
            System.out.println("Inserire l'ultima porta che si vuole controllare: ");
            //la assegno alla variabile ultimaPorta
            ultimaPorta = Integer.parseInt(br.readLine());
            //con questa variabile capisco quante porte devo controllare
            sottrazione = ultimaPorta-port;
            sottrazione++;
            //ciclo for che viene ripetuto in base al numero di porte da controllare
            for(int i=0;i<sottrazione;i++)
            {
                //invoco il metodo della ClasseScanner
                c1.ricavaSocket(port);
                //controllo la prossima porta
                port++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloServizi()
    {
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        21, che corrisponde a controllare se in quel momento il servizio FTP è attivo,
        protocollo che permette un corretto trasferimento di file*/
        System.out.println(ColoreCyan + "FTP");
        port=21;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        22, che corrisponde a controllare se in quel momento il servizio SSH è attivo,
        protocollo che permette di stabilire una sessione remota tramite 
        interfaccia a riga di comando (criptata, quindi sicura)*/
        System.out.println(ColoreCyan + "SSH");
        port=22;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        25, che corrisponde a controllare se in quel momento il servizio SMTP è attivo,
        protocollo che permette di inviare messaggi di posta, ma non di richiederli 
        al server, vedi POP3 ed IMAP*/
        System.out.println(ColoreCyan + "SMTP");
        port=25;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        80, che corrisponde a controllare se in quel momento il servizio HTTP è attivo,
        protocollo che permette una corretta trasmissione di informazioni nel web 
        con un'architettura client-server*/
        System.out.println(ColoreCyan + "HTTP");
        port=80;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        110, che corrisponde a controllare se in quel momento il servizio POP3 è attivo,
        con questo procollo è possibile scaricare sul pc locale tutta la posta compresi
        allegati non lasciando traccia sul server delle informazioni*/
        System.out.println(ColoreCyan + "POP3");
        port=110;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        143, che corrisponde a controllare se in quel momento il servizio IMAP4 è attivo,
        questo protollo permette di visualizzare la posta senza scaricarla dal server per un
        uso più efficiente e veloce*/
        System.out.println(ColoreCyan + "IMAP");
        port=143;
        c1.ricavaSocket(port);
        
        /*invoco il metodo della ClasseScanner per controllare la porta numero
        3306, che corrisponde a controllare se in quel momento il servizio MySQL è attivo,
        questo protocollo permette di controllare se esiste la connessione a MySQL dell'host*/
        System.out.println(ColoreCyan + "MySQL" + ColoreReset);
        port=3306;
        c1.ricavaSocket(port);
    }
    
}
