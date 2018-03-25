/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programma_scanningporttcp;

/**
 *
 * @author Lorenzo Pisanò
 */
public class Programma_ScanningPortTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //dichiaro e instanzio un oggetto della classe ScanningPort
        ScanningPort sp;
        sp = new ScanningPort();
        
        //richiamo il metodo per il controllo delle porte
        sp.esegui();
    }
    
}
