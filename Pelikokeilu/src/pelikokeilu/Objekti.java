package pelikokeilu;

import javax.swing.*;
import java.awt.*;

/**
 * Objekti-luokka tallettaa tiedot kaikista objekteista mitä ohjausluokka luo.
 * @author Pena
 */
public class Objekti {
    
    public Icon kuva;
    public String tiedot;
    public int paikka_x, paikka_y;
    
    /**
     * 
     * @param kuvatiedoston_nimi - yleensä .png tiedosto, jossa on objektin kuvake
     * @param x - ekat koordinaatit objektille näytöllä, kun ko sivua näytetään
     * @param y - ekat koordinaatit objektille näytöllä, kun ko sivua näytetään
     * @param tietoja - tietoa, jota objekti voi jakaa muille
     */
    public Objekti(String kuvatiedoston_nimi, int x, int y, String tietoja) {
         kuva = new ImageIcon(kuvatiedoston_nimi);
         this.paikka_x = x;
         this.paikka_y = y;
         this.tiedot = tietoja;
    }   
    
    /**
     * Palauttaa objektin tiedot
     * @return 
     */
    public String haeTiedot() {
        return tiedot;
    }
    
    /**
     * Lisätään objektille tietoja
     * @param dataa 
     */
    public void luoTiedot(String dataa) {   
    }
    
    /**
     * Muutetaan objektin paikkaa näytöllä kyseisellä sivulla
     * @param paikka_x
     * @param paikka_y 
     */
    public void muutaPaikkaa(int paikka_x, int paikka_y) {
        this.paikka_x = (int) paikka_x;
        this.paikka_y = (int) paikka_y;
    }
}
