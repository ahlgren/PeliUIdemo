package pelikokeilu;

import javax.swing.*;


public class Objekti {
    
    public Icon kuva;
    public String tiedot;
    
    public Objekti(String kuvatiedoston_nimi, String tietoja) {
         kuva = new ImageIcon(kuvatiedoston_nimi);
         this.tiedot = tietoja;
    }   
    
    public String haeTiedot() {
        return tiedot;
    }
    public void luoTiedot(String dataa) {
        
    }
}
