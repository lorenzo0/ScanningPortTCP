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
                System.out.println("1: Scanning di una porta");
                System.out.println("2: Scanning range di porte");
                System.out.println("Fai la tua scelta: ");
                dowhile=Integer.parseInt(br.readLine());
                
                if(dowhile == 1)
                {
                    controlloPorta();
                }
                if(dowhile == 2)
                {
                    controlloRangePorte();
                }
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
                System.out.println(i);
                c1.ricavaSocket(port);
                port++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ScanningPort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
