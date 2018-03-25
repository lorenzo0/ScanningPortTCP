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
                dowhile=Integer.parseInt(br.readLine());
                
                if(dowhile == 1)
                {
                    controlloPorta();
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
    
}
