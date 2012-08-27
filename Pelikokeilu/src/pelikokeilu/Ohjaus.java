package pelikokeilu;

import java.awt.Point;
import java.util.Scanner;
import javax.swing.*;

public class Ohjaus {

    public static void main(String[] args) {
        Scanner lue = new Scanner(System.in);
        Point raahaus;
        Point koord = new Point();
        Sivu s = new Sivu();
        JLabel objektinOsoitin1, objektinOsoitin2, objektinOsoitin3, objektinOsoitin4;
        JLabel sivuOsoitin;
        JLabel valikkoOsoitin;
                
        Objekti tytto = new Objekti("tytto.png", "tyttö");
        Objekti luuri = new Objekti("luuri.png", "luuri");
        Objekti viesti = new Objekti("kirje.png", "kirje");
        Objekti teksti = new Objekti("tekstilappu.png", "tekstiä");
        Objekti muistilappu = new Objekti("keltlappu.png", "keltainen lappu");
        Objekti naytto1 = new Objekti("sivu_ei_valikkoa.png","");
        Objekti naytto2 = new Objekti("pelkka_sivu.png","");
        objektinOsoitin1 = s.luoObjekti(tytto, 220, 110);
       //koord = s.luePaikka();
        //System.out.println("Mainista: viimeisin paikka, x= " + koord.x +" y= " + koord.y);
        //System.out.println("\n Raahattu koord x: "+koord.x+" koord y "+koord.y);    
        objektinOsoitin2 = s.luoObjekti(luuri, 220, 170);
        //s.raahaaObjektia(viesti);
        //s.raahaaObjektia(muistilappu);
        valikkoOsoitin = s.luoValikko();
        //s.luoSivu(naytto1);
        objektinOsoitin3 = s.luoObjekti(muistilappu, 220, 210);
        objektinOsoitin4 = s.luoObjekti(teksti, 220, 260);
        sivuOsoitin = s.luoSivu(naytto1);
        
        String komento;
        System.out.println("Komennot: \n"
                + " 1 = poistetaan objekti1 \n"
                + " 2=  poistetaan objekti2 \n"
                + " 3 = poistetaan objekti3  \n"
                + " 4 = poistetaan objekti4 \n"
                + " 5 = vaihdetaan sivu \n"
                + " 6 = poistetaan valikko\n"
                + " 7 = exit");
        do {
            komento = lue.nextLine();
            if (komento.equals("1")) {
                s.poistaObjekti(objektinOsoitin1);
                System.out.println("objekti pois");
            }
            if (komento.equals("2")) {
                s.poistaObjekti(objektinOsoitin2);
                System.out.println("objekti pois");
            }
            if (komento.equals("3")) {
                s.poistaObjekti(objektinOsoitin3);
                System.out.println("objekti pois");
            }
            if (komento.equals("4")) {
                s.poistaObjekti(objektinOsoitin4);
                System.out.println("objekti pois");
            }
            if (komento.equals("5")) {
                s.poistaSivu(sivuOsoitin);
                System.out.println("sivu pois");
            }
            if (komento.equals("6")) {
                s.poistaValikko(valikkoOsoitin);
                System.out.println("valikko pois");
            }
            if (komento.equals("7")) {
                System.out.println("exit");
            }
        }
        while (!(komento.equals("7")));
        System.out.println("\n Tultiin ulos valikosta");       
        
        // /* viimeisimmät piirtyvät edellisten alle */
        
        
    }    
    
    public static void tarkistaPaikka(Point paikka, String t)  {
        Point raahaus = paikka;
        System.out.println("Objektin: " + t + " paikka, x= " + raahaus.x +" y= " + raahaus.y);
    }
    
   /* public Point luePaikka() {
        return raahaus;
    }*/
        
    private void onkoSivunvaihto(Point paikka) {
        //System.out.println("Sivun vaihto ??: paikka, x= " + paikka.x +" y= " + paikka.y);
    }
}
