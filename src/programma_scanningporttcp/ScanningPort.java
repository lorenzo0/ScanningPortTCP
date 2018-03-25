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
 * @author loren
 */
public class ScanningPort {
    
    ClasseScanner c1;
    BufferedReader br;
    int dowhile, port;
    boolean check;
    public static final String ColoreCyan = "\u001B[36m";
    public static final String ColoreReset = "\u001B[0m";

    public ScanningPort() {
    }
    
    public void esegui()
    {
        try {
            System.out.println("Inserire l'indirizzo dove si vuole eseguire uno scanning: ");
            br = new BufferedReader(new InputStreamReader(System.in));
            String indirizzoInseritoUtente = br.readLine();
            c1 = new ClasseScanner(indirizzoInseritoUtente);
            
            do{
                System.out.println(ColoreCyan + "1: Scanning di una porta");
                System.out.println(ColoreCyan + "2: Scanning range di porte");
                System.out.println(ColoreCyan +"3: Scanning porte conosciute");
                System.out.println(ColoreCyan + "Fai la tua scelta: " + ColoreReset);
                dowhile=Integer.parseInt(br.readLine());
                
                if(dowhile == 1)
                {
                    controlloPorta();
                }
                if(dowhile == 2)
                {
                    controlloRangePorte();
                }
                if(dowhile == 3)
                {
                    controlloServizi();
                }
                System.out.println("\n");
            }while (check != true);
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloPorta()
    {
        try {
            System.out.println("Inserire la porta che si vuole controllare: ");
            port = Integer.parseInt(br.readLine());
            c1.ricavaSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloRangePorte()
    {
        int ultimaPorta, sottrazione;
        try {
            System.out.println("Inserire la prima porta che si vuole controllare: ");
            port = Integer.parseInt(br.readLine());
            System.out.println("Inserire l'ultima porta che si vuole controllare: ");
            ultimaPorta = Integer.parseInt(br.readLine());
            sottrazione = ultimaPorta-port;
            sottrazione++;
            for(int i=0;i<sottrazione;i++)
            {
                c1.ricavaSocket(port);
                port++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlloServizi()
    {
        System.out.println(ColoreCyan + "FTP");
        port=21;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "SSH");
        port=21;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "SMTP");
        port=25;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "HTTP");
        port=25;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "POP3");
        port=110;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "IMAP4");
        port=143;
        c1.ricavaSocket(port);
        
        System.out.println(ColoreCyan + "MySQL" + ColoreReset);
        port=3306;
        c1.ricavaSocket(port);
    }
    
}
