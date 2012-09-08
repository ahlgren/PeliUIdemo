package pelikokeilu;

import java.awt.Point;
import java.util.Scanner;
import java.util.*;
import javax.swing.*;

/**
 * Ohjaus-luokka luo objektioliot, sivut ja valikot. Sivuille asetetaan halutut objektit. Kirja ja etusivu  
 * Sivu-oliolta pyydetään näyttämään kirja, etusivu ja päävalikko.
 * Kun Sivu-oliolta tulee tieto käyttäjän klikkauksista ja objektien raahauksesta Ohjaus-luokka tekee halutut 
 * muutokset näytöllä ja ylläpitää tietoa siitä, mitä kulloinkin näytöllä näkyy ja mitä objekteja sivältyy sivuihin.
 * @author Pena
 */
public class Ohjaus {
    
        static Sivu sivu = new Sivu();
        static JLabel sivuOsoitin = null;
        static JLabel valikkoOsoitin = null;
        static JLabel aliValikkoOsoitin = null;
        static JLabel aliAliValikkoOsoitin = null;
        static int nytEsillaOlevaSivuNro = 0;
        static int nytEsillaOlevienKuvienLkm = 0;
        
          /** luodaan eri sivujen valikko-oliot **/
        static Objekti etuSivuValikko = new Objekti("etusivuVa1.png", 207, 44, "etusivu");
        static Objekti peopleSivuValikko = new Objekti("peopleVa1.png", 207, 44, "people");
        static Objekti placiesSivuValikko = new Objekti("placiesVa1.png", 207, 44, "placies");
        static Objekti communicateSivuValikko = new Objekti("communicateVa1.png", 207, 44, "communicate");
        static Objekti timeSivuValikko = new Objekti("timeVa1.png", 207, 44, "time");
        static Objekti createSivuValikko = new Objekti("createVa1.png", 207, 44, "text");
        static Objekti internetSivuValikko = new Objekti("internetVa1.png", 207, 44, "internet");
        static Objekti filesSivuValikko = new Objekti("filesVa1.png", 207, 44, "files");
        static Objekti settingSivuValikko = new Objekti("settingVa1.png", 207, 44, "setting");
        static Objekti appsSivuValikko = new Objekti("appsVa1.png", 207, 43, "apps");
        static Objekti homeValikko = new Objekti("home.png", 94, 408, "home");
        static Objekti peopleAliValikko = new Objekti("peopleAli2.png", 172, 44, "peopleAliValikko");
        static Objekti placiesAliValikko = new Objekti("placiesAli.png", 172, 72, "placiesAliValikko");
        static Objekti communicateAliValikko = new Objekti("communicateAli.png", 172, 84, "communicateAliValikko");
        static Objekti timeAliValikko = new Objekti("timeAli.png", 172, 154, "timeAliValikko");
        static Objekti createAliValikko = new Objekti("createAli.png", 172, 180, "createAliValikko");
        static Objekti internetAliValikko = new Objekti("internetAli.png", 172, 220, "internetAliValikko");
        static Objekti filesAliValikko = new Objekti("filesAli1.png", 172, 245, "filesAliValikko");
        static Objekti callAliAliValikko = new Objekti("callAli.png", 136, 100, "callAliValikko");
        static Objekti roskis = new Objekti("roskis.png", 36, 412, "roskis");
        static Objekti leikepoyta = new Objekti("leikepoyta.png", 190, 412, "leikepoyta");
        
          /** luodaan kirjaolio, mikä näkyy näytöllä kirjana, jonka sivuja selaillaan **/    
        static Objekti kirja = new Objekti("kirja3.png", 177, 48, "kirja");
       
           /** luodaan taulukko objektiolioille **/      
        static ArrayList<Objekti> objektit = new ArrayList<Objekti>();
        
          /** luodaan oliotaulukko, joka sisältää viitteet kunkin sivun objektiviitteitä 
            sisältävään oliotaulukkoon, sivujen määrä on kiinteä, esim max 40  **/
        //static HashMap<ArrayList, Objekti> sivut = new HashMap<ArrayList, Objekti>();
        static ArrayList[] sivut = new ArrayList[40];
        static Objekti valikot[] = new Objekti[40];
        /*  luodaan taulukko, missä on viittaukset objektien kuviin (ikoneihin) */
        static ArrayList<JLabel> objKuvanOsoittimet = new ArrayList<JLabel>();
        
      /**
       * * Luodaan ikonin kokoiset objektioliot, luodaan ruudun kokoiset objektioliot.
         * Alustetaan sivut-taulukko = kiinteäpituinen taulukko ArrayListoista.
         * Alustetaan valikot-taulukko valikko-objekteilla.
         * Alustetaan sivujen objektitaulukot.
         * Näytetään näytöllä kirja ja etusivu + home-, roskis ja leikepöytänappula kutsumalla Sivu-oliopn metodeja.
       */
    public Ohjaus() { 
        
         /** Luodaan ikonin kokoiset objektioliot */
        objektit.add(new Objekti("tytto.png", 35, 60, "tyttö"));  //0
        objektit.add(new Objekti("mies.png", 35, 100, "mies"));     //1
        objektit.add(new Objekti("nainen.png", 35, 140, "nainen")); //2
        objektit.add(new Objekti("ukko.png", 35, 180, "ukko"));     //3
        objektit.add(new Objekti("luuri.png", 90, 150, "luuri"));   //4 = luuri
        objektit.add(new Objekti("kello.png",100, 180, "kello"));   //5
        objektit.add(new Objekti("kirje2.png", 35, 140, "kirje"));   //6
        objektit.add(new Objekti("tekstilappu2.png", 35, 240, "tekstiä"));   //7
        objektit.add(new Objekti("keltlappu2.png", 35, 170, "keltainen lappu"));  //8
        objektit.add(new Objekti("luuri_off.png", 100, 140, "luuri_off"));  //9
        
        /** Luodaan ruudun kokoiset objektioliot */ 
        objektit.add(new Objekti("googleMS.png", 50, 50, "googleMS"));  //10
        objektit.add(new Objekti("kirjanKansi.png", 37, 100, "Kansilehti")); //11
        objektit.add(new Objekti("kartta.png", 35, 147, "kartta")); //12
        objektit.add(new Objekti("isokello.png", 35, 147, "isokello")); //13
        objektit.add(new Objekti("numkeys.png", 55, 160, "numkeys")); //14
        objektit.add(new Objekti("qwerty.png", 28, 298, "qwerty")); //15
        objektit.add(new Objekti("appsIcons.png", 23, 45, "appsIcons")); //16
        objektit.add(new Objekti("calendar.png", 40, 230, "calendar")); //17
        
        /** Alustetaan sivut-taulukko = kiinteäpituinen taulukko ArrayListoista **/
        sivut[0] = new ArrayList<Objekti>(); //etusivu
        sivut[1] = new ArrayList<Objekti>(); // People-sivu
        sivut[2] = new ArrayList<Objekti>(); // Placies-sivu
        sivut[3] = new ArrayList<Objekti>(); // Communicate-sivu
        sivut[4] = new ArrayList<Objekti>(); // Time-sivu
        sivut[5] = new ArrayList<Objekti>(); // Create-sivu
        sivut[6] = new ArrayList<Objekti>(); // Internet-sivu
        sivut[7] = new ArrayList<Objekti>(); // Files-sivu
        sivut[8] = new ArrayList<Objekti>(); // Setting-sivu
        sivut[9] = new ArrayList<Objekti>(); // Apps-sivu
        sivut[10] = new ArrayList<Objekti>(); // ABC
        sivut[11] = new ArrayList<Objekti>(); // MostUsed
        sivut[12] = new ArrayList<Objekti>(); // New
        sivut[13] = new ArrayList<Objekti>(); // Map
        sivut[14] = new ArrayList<Objekti>(); // Navigate
        sivut[15] = new ArrayList<Objekti>(); // email
        sivut[16] = new ArrayList<Objekti>(); // Call
        sivut[17] = new ArrayList<Objekti>(); // Message
        sivut[18] = new ArrayList<Objekti>(); // Voicemail
        sivut[19] = new ArrayList<Objekti>(); // Clock
        sivut[20] = new ArrayList<Objekti>(); // Calendar
        sivut[21] = new ArrayList<Objekti>(); // Camera
        sivut[22] = new ArrayList<Objekti>(); // Write
        sivut[23] = new ArrayList<Objekti>(); // Record
        sivut[24] = new ArrayList<Objekti>(); // Search
        sivut[25] = new ArrayList<Objekti>(); // Favorities
        sivut[26] = new ArrayList<Objekti>(); // Media
        sivut[27] = new ArrayList<Objekti>(); // Notes
        sivut[28] = new ArrayList<Objekti>(); // Music
        sivut[29] = new ArrayList<Objekti>(); // Photo
        sivut[31] = new ArrayList<Objekti>(); // Video
        sivut[32] = new ArrayList<Objekti>(); // Document
        sivut[33] = new ArrayList<Objekti>(); // Log
        sivut[34] = new ArrayList<Objekti>(); // Numkeys
        
          /** Alustetaan valikot-taulukko valikko-objekteilla  **/
        valikot[0] = etuSivuValikko;
        valikot[1] = peopleSivuValikko;
        valikot[2] = placiesSivuValikko;
        valikot[3] = communicateSivuValikko;
        valikot[4] = timeSivuValikko;
        valikot[5] = createSivuValikko;
        valikot[6] = internetSivuValikko;
        valikot[7] = filesSivuValikko;
        valikot[8] = settingSivuValikko;
        valikot[9] = appsSivuValikko;
        valikot[10] = homeValikko;
        valikot[11] = peopleAliValikko;
        valikot[12] = placiesAliValikko;
        valikot[13] = communicateAliValikko;
        valikot[14] = timeAliValikko;
        valikot[15] = createAliValikko;
        valikot[16] = internetAliValikko;
        valikot[17] = filesAliValikko;
        valikot[18] = callAliAliValikko;
        valikot[19] = roskis;
        valikot[20] = leikepoyta;
        
        alustaSivujenObjektiTaulukot();
    }    
    
    /**
     * Asetetaan vakiona sivulla olevat objektit
     */
    private void alustaSivujenObjektiTaulukot() {
        /** alustetaan sivujen oliotaulukot **/
        /** etuSivu-sivu**/
        sivut[0].add(objektit.get(11));
        
        /** peopleSivu-sivun oliotaulukot **/
     /*   sivut[1].add(objektit.get(0));
        sivut[1].add(objektit.get(1));
        sivut[1].add(objektit.get(2));
        sivut[1].add(objektit.get(3)); */

        /** Placies-sivun oliotaulukko **/
        //sivut[2].add(objektit.get(12));
        
        /** communicateSivu-sivun oliotaulukko **/
        //sivut[3].add(objektit.get(4));
        
        /** TimeSivu-sivun oliotaulukko **/
        //sivut[4].add(objektit.get(5));
        
        /** Create-sivun oliotaulukko **/
        //sivut[5].add(objektit.get(7));
        
        /** InternetSivu-sivun oliotaulukko **/
        //sivut[6].add(objektit.get(10));
        
         /** Apps-sivun oliotaulukko **/
        sivut[9].add(objektit.get(16));
        
        /* ABC-sivun oliotaulukko **/
        //sivut[10].add(objektit.get(0));
        //sivut[10].add(objektit.get(1));
        //sivut[10].add(objektit.get(2));
        //sivut[10].add(objektit.get(3)); 
        //asetaAlkupObjektit_ABC();
        
        /** MostUsed-sivun oliotaulukko **/
        //sivut[11].add(objektit.get(3));
        //sivut[11].add(objektit.get(2));
        //sivut[11].add(objektit.get(0));
        //sivut[11].add(objektit.get(1)); 
             
         /** New-sivun oliotaulukko **/
        //sivut[12].add(objektit.get(4));
        
         /** Map-sivun oliotaulukko **/
        sivut[13].add(objektit.get(12));
        /** Navigate-sivun oliotaulukko **/
        sivut[14].add(objektit.get(12));
        
          /** Message-sivun oliotaulukko **/
        sivut[17].add(objektit.get(6));
        
        /** Clock-sivun oliotaulukko **/
        sivut[19].add(objektit.get(13));
        
         /** Calendar-sivun oliotaulukko **/
        sivut[20].add(objektit.get(17));
        
        /** Write-sivun oliotaulukko **/
        sivut[22].add(objektit.get(15));
        sivut[22].add(objektit.get(7));
        sivut[22].add(objektit.get(8));
          
        /** Search-sivun oliotaulukko **/
        sivut[24].add(objektit.get(10));
        
          /** Notes-sivun oliotaulukko **/
        sivut[27].add(objektit.get(8));
        
        /** Log-sivun oliotaulukko **/
        sivut[33].add(objektit.get(3));
        sivut[33].add(objektit.get(2));
        sivut[33].add(objektit.get(0));
        sivut[33].add(objektit.get(1)); 
        
         /** Numkeys-sivun oliotaulukko **/
        sivut[34].add(objektit.get(14));
        
        //int maxOlioitaSivulla = 15;
        objKuvanOsoittimet.add(new JLabel (""));
        
        /* Näytetään näytöllä kirja ja etusivu + home-, roskis ja leikepöytänappula  */
        valikkoOsoitin = sivu.valikkoNakyviin(etuSivuValikko);
        sivu.valikkoNakyviin(homeValikko);
        sivu.valikkoNakyviin(roskis);
        sivu.valikkoNakyviin(leikepoyta);
        naytaSivu(0);
        sivuOsoitin = sivu.kirjaNakyviin(kirja);     
    }
    
    /**
     * palauttaa alkuperäiset objektit sivun oliotaulukkoon
     */
    private static void asetaAlkupObjektit_ABC() {
        /** alustetaan ABC-sivun oliotaulukko **/
        objektit.get(0).muutaPaikkaa(55, 60);
        objektit.get(1).muutaPaikkaa(55, 100);
        objektit.get(2).muutaPaikkaa(55, 140);
        objektit.get(3).muutaPaikkaa(55, 180);
        int i = sivut[8].size();
        System.out.println(" i = "+i);
        if (i>0) {
            for (int j=0; j<i; j++) {
                sivut[8].remove(0);
            }
        }
        sivut[10].add(objektit.get(0));
        sivut[10].add(objektit.get(1));
        sivut[10].add(objektit.get(2));
        sivut[10].add(objektit.get(3)); 
    }
    
    /**
     * palauttaa alkuperäiset objektit sivun oliotaulukkoon 
     */
     private static void asetaAlkupObjektit_MostUsed() {
        /** alustetaan MostUsed-sivun oliotaulukko **/
        objektit.get(0).muutaPaikkaa(55, 180);
        objektit.get(1).muutaPaikkaa(55, 140);
        objektit.get(2).muutaPaikkaa(55, 100);
        objektit.get(3).muutaPaikkaa(55, 60);
        sivut[11].add(objektit.get(0));
        sivut[11].add(objektit.get(1));
        sivut[11].add(objektit.get(2));
        sivut[11].add(objektit.get(3)); 
    }
     
    /**
     * 
     * @param sivunNro - sen sivun nro, joka halutaan näytölle
     * metodi näyttää sivulle kuuluvat objektit
     */  
    public static void naytaSivu(int sivunNro){
        poistaSivunObjektitNakyvista();
        int i;
        ArrayList t = sivut[sivunNro];
        for(i=0; i<t.size(); i++) {
           JLabel temp = sivu.objektiNakyviin((Objekti)t.get(i));
           objKuvanOsoittimet.add(i,temp);
        }
        nytEsillaOlevienKuvienLkm = i;
        nytEsillaOlevaSivuNro = sivunNro;
    }   
    
    /**
     * 
     * @param sivunNro - sen sivun nro, joka halutaan näytölle 
     */
    public static void naytaAliSivu(int sivunNro){
        poistaSivunObjektitNakyvista();
        int i=0;
        ArrayList t = sivut[sivunNro];
        for(i=0; i<t.size(); i++) {
           JLabel temp = sivu.objektiNakyviin((Objekti)t.get(i));
           objKuvanOsoittimet.add(i,temp);
        }
        nytEsillaOlevienKuvienLkm = i;
        nytEsillaOlevaSivuNro = sivunNro;
    }   
    
    /**
     * 
     * @param valikonNro - näkyviin halutun valikon numero
     */
    public static void naytaValikko(int valikonNro) {
        if (valikkoOsoitin != null) sivu.poistaValikkoNakyvista(valikkoOsoitin);
        if (aliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliValikkoOsoitin);
        if (aliAliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliAliValikkoOsoitin);
        valikkoOsoitin = sivu.valikkoNakyviin(valikot[valikonNro]);
    } 
    
    /**
     * 
     * @param valikonNro  - näkyviin halutun valikon numero
     */
    public static void naytaAliValikko(int valikonNro){
        if (aliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliValikkoOsoitin);
        if (aliAliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliAliValikkoOsoitin);
        aliValikkoOsoitin = sivu.valikkoNakyviin(valikot[valikonNro]);
    }
    
    /**
     * 
     * @param valikonNro  - näkyviin halutun valikon numero
     */
    public static void naytaAliAliValikko(int valikonNro){
        if (aliAliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliAliValikkoOsoitin);
        aliAliValikkoOsoitin = sivu.valikkoNakyviin(valikot[valikonNro]);
    }
    
   /**
    * Kaikki valikot pois näkyvistä, , remoovataan objektin labeli
    */
     public static void poistaValikot() {
        if (valikkoOsoitin != null) sivu.poistaValikkoNakyvista(valikkoOsoitin);
        if (aliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliValikkoOsoitin);
        if (aliAliValikkoOsoitin != null) sivu.poistaValikkoNakyvista(aliAliValikkoOsoitin);
     }
     
    /**
     * Poistetaan näkyvillä olevat objektit, remoovataan objektin labeli
     */
    public static void poistaSivunObjektitNakyvista() { /** poistaa esillä olevan sivun kaikkien objektien kuvat **/
        if (objKuvanOsoittimet != null) {
            for(int i=0; i<nytEsillaOlevienKuvienLkm; i++) {
                sivu.poistaObjektiNakyvista(objKuvanOsoittimet.get(i));
            }
        }   
    }
    
    /**
     * Poistetaan objektit ko sivun oliotaulukosta
     */
    public static void poistaObjektitSivultaKokonaan()  {
        int i = sivut[nytEsillaOlevaSivuNro].size();
        System.out.println(" i = "+i);
        System.out.println("nytEsillaOlevaSivuNro = " + nytEsillaOlevaSivuNro);
        if (i>0) {
            for (int j=0; j<i; j++) {
                sivut[nytEsillaOlevaSivuNro].remove(0);
            }
        }    
    } 
    
    /**
     * Valitaan toiminta riippuen raahatun objektin koordinaateista
     * @param paikka - koordinaatit mihin objekti on parhaillaan raahattu
     * @param nimi - raahattavan objektin nimi
     * @param kuvanOsoitin - raahattavan objektin osoite
     */
    public static void objektiaRaahataan(Point paikka, Objekti nimi, JLabel kuvanOsoitin)  {
        System.out.println("Objektia " + nimi.tiedot + " raahataan ja sen paikka on: x= " + paikka.x +" y= " + paikka.y);
        nimi.muutaPaikkaa(paikka.x, paikka.y);
        
        // objekti raahattiin lähelle alivalikkoja 
        if (paikka.x > 128 && paikka.x < 179) {  
             System.out.println("Objekti lähellä alivalikkoja");
             if (paikka.y > 70 && paikka.y < 101) {  // placies
                 naytaAliValikko(12);  //PlaciesAliValikko    
                 if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 60 && paikka.y < 80)) { //Map
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[13].add(nimi); // siirretään objekti ko sivulle
                    naytaAliSivu(13);  //Map
                }   
             }
            if (paikka.y > 100 && paikka.y < 130) { //Communicate
                naytaAliValikko(13);  //CommunicateAliValikko    
                if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 105 && paikka.y < 130)) { //Call
                    sivut[16].add(objektit.get(4));  //4 = luuri
                    sivut[16].add(objektit.get(9));   //9 = luuri_off
                    objektit.get(4).muutaPaikkaa(70, paikka.y);  //4 = luuri
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[16].add(nimi);
                    naytaAliSivu(16);  //Call
                }
            }
            if (paikka.y > 129 && paikka.y < 191) {  // Time
                 naytaAliValikko(14);  //TimeAliValikko    
                 if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 170 && paikka.y < 191)) { //Calendar
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[20].add(nimi); // siirretään objekti ko sivulle
                    naytaSivu(4); //Time
                    naytaAliSivu(20);  //calendar
                }   
             }
             if (paikka.y > 190 && paikka.y < 236) {  // Create
                naytaAliValikko(15);  //CreateAliValikko    
                if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 190 && paikka.y < 236)) { //Write
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[22].add(nimi); // siirretään objekti ko sivulle
                    poistaValikot();
                    naytaAliSivu(22);  //write
                }   
             }
             if (paikka.y > 235 && paikka.y < 280) {  // Internet
                naytaAliValikko(16);  //InternetAliValikko    
                if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 235 && paikka.y < 260)) { //Search
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[24].add(nimi); // siirretään objekti ko sivulle
                    poistaValikot();
                    naytaAliSivu(24);  //Search
                }   
             }
             if (paikka.y > 279 && paikka.y < 321) {  // files
                naytaAliValikko(17);  //FilesAliValikko    
                if ((paikka.x > 164 && paikka.x < 181) && (paikka.y > 260 && paikka.y < 320)) { //Notes
                    nimi.muutaPaikkaa(100, paikka.y);
                    sivut[27].add(nimi); // siirretään objekti ko sivulle
                    //poistaValikot();
                    naytaAliSivu(27);  //Notes
                }   
             }
        }
        // objekti raahattiin päävalikolle
        if (paikka.x > 200 && paikka.x < 230) {  
            System.out.println("Objekti lähellä päävalikkoja");
            if (paikka.y > 25 && paikka.y < 71) {
                naytaSivu(1); //People
                return;  }
          /*  if (paikka.y > 59 && paikka.y < 102) naytaSivu(2); //Placies
            if (paikka.y > 101 && paikka.y < 142) naytaSivu(3); //Communicate  
            if (paikka.y > 141 && paikka.y < 194) naytaSivu(4);  //Time
            if (paikka.y > 190 && paikka.y < 236) {
                naytaSivu(5);
                naytaValikko(5);  }//Create 
            if (paikka.y > 235 && paikka.y < 280) {
                naytaSivu(6);
                naytaValikko(6);  } //Internet
            if (paikka.y > 279 && paikka.y < 321) {
                naytaSivu(7);
                naytaValikko(7);  }//Files */
            if (paikka.y > 320 && paikka.y < 361) {
                naytaSivu(8);
                naytaValikko(8);  }//Setting
            if (paikka.y > 360 && paikka.y < 388) {
                poistaValikot();
                naytaSivu(9); } //Apps
        }
        
        // objekti raahattiin näytön alareunalle
        if (paikka.y > 387 && paikka.y < 460) { 
            if (paikka.x > 15 && paikka.x < 47) { // =roskis
                sivu.poistaObjektiNakyvista(kuvanOsoitin);  // ko objekti poistetaan näkyvistä
                sivut[nytEsillaOlevaSivuNro].remove(nimi);  // ko objekti poistetaan ko sivulta
            }
            if (paikka.x > 170 && paikka.x < 196) { // =leikepöytä
                sivu.poistaObjektiNakyvista(kuvanOsoitin);  // ko objekti poistetaan näkyvistä
                sivut[nytEsillaOlevaSivuNro].remove(nimi);  // ko objekti poistetaan ko sivulta
            }
        }
    }
    
    /**
     * Tunnistetaan mitä objektia klikattiin ja toiimitaan sen mukaan
     * @param paikka - klikkauskohdan koordinaatit
     * @param nimi - klikatun objektin nimi
     * @param kuvanOsoitin - näytöllä olevan objektin kuvakkeen osoite
     */
    public static void objektiaOnKlikattu(Point paikka, Objekti nimi, JLabel kuvanOsoitin) {
        if (nimi == (objektit.get(9))) {  // 9=luuri_off
            poistaObjektitSivultaKokonaan();
            //poistaSivunObjektitNakyvista();
            poistaValikot();
            naytaSivu(0);
            naytaValikko(0);
            return;
        }
    }
    
    /**
     * Valitaan haluttu toiminta riippuen mitä valikkoa klikattiin 
     * @param paikka - koordinaatit missä valikkoa on klikatttu
     * @param nimi - klikatun valikon nimi
     */
    public static void valikkoaOnKlikattu (Point paikka, Objekti nimi) {
        System.out.println("Valikkoa " + nimi.tiedot + " klikattu paikassa: x= " + paikka.x +", y= " + paikka.y);
        
        /* Ruudun alareunan valikkojen klikkausten tunnistaminen: */
        if (nimi == homeValikko) {
            naytaSivu(0);
            naytaValikko(0);
            return;
        }
        if (nimi == roskis) {
            naytaSivu(0);
            naytaValikko(0);
            return;
        }
        if (nimi == leikepoyta) {
            naytaSivu(0);
            naytaValikko(0);
            return;
        }
        
        /* Alivalikkojen klikkausten tunnistaminen: */
        if (nimi == peopleAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                asetaAlkupObjektit_ABC();
                naytaAliSivu(10);  //ABC
                System.out.println("ABC");
                return;
            }
            if (paikka.y > 32 && paikka.y < 64) {
                asetaAlkupObjektit_MostUsed();
                naytaAliSivu(11);  //MostUsed
                System.out.println("MostUsed"); 
                return;
            }
            if (paikka.y > 63 && paikka.y < 97) {
                //naytaAliSivu(12);  //New
                System.out.println("New");
                poistaSivunObjektitNakyvista();
            return;    
            }
        }
        if (nimi == placiesAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                naytaAliSivu(13);  //Map
                System.out.println("Map");
                return;
            }
            if (paikka.y > 32 && paikka.y < 63) {
                naytaAliSivu(14);  //Navigate
                System.out.println("Navigate"); 
                return;
            }
        }
        if (nimi == communicateAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                System.out.println("eMail");
                return; }
            if (paikka.y > 32 && paikka.y < 65) {
                naytaAliAliValikko(18);  //Call
                System.out.println("Call"); 
                return;}
            if (paikka.y > 64 && paikka.y < 98) {
                naytaAliSivu(17);  // Message
                System.out.println("Message");
                return;}
              if (paikka.y > 97 && paikka.y < 133) {
                //naytaAliSivu(18);  //Voicemail
                System.out.println("VoiceMail");
                return;}
        }
        if (nimi == timeAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                naytaAliSivu(19);  //Clock
                System.out.println("Clock");
                return;
            }
            if (paikka.y > 32 && paikka.y < 66) {
                naytaAliSivu(20);  //Calendar
                System.out.println("Calendar"); 
                return;
            }
        }
        if (nimi == createAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                //naytaAliSivu(21);  //Camera
                System.out.println("Camera");
                return;
            }
            if (paikka.y > 32 && paikka.y < 66) {
                poistaValikot();
                naytaAliSivu(22);  //Write
                System.out.println("Write"); 
                return;
            }
            if (paikka.y > 65 && paikka.y < 100) {
                //naytaAliSivu(23);  //Record
                System.out.println("Record"); 
                return;
            }
        }
        if (nimi == internetAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                naytaAliSivu(24);  //Search
                System.out.println("Search");
                return;
            }
            if (paikka.y > 32 && paikka.y < 66) {
                //naytaAliSivu(25);  //Favorities
                System.out.println("Favorities"); 
                return;
            }
            if (paikka.y > 65 && paikka.y < 97) {
                //naytaAliSivu(26);  //Media
                System.out.println("Media"); 
                return;
            }
        }
        if (nimi == filesAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                naytaAliSivu(27);  //Notes
                System.out.println("Notes");
                return; }
            if (paikka.y > 32 && paikka.y < 65) {
                //naytaAliSivu(28);  //Music
                System.out.println("Music"); 
                return;}
            if (paikka.y > 64 && paikka.y < 98) {
                //naytaAliSivu(29);  //Photo
                System.out.println("Photo");
                return;}
            if (paikka.y > 97 && paikka.y < 131) {
                //naytaAliSivu(30);  //Video
                System.out.println("Video");
                return;}
            if (paikka.y > 130 && paikka.y < 165) {
                //naytaAliSivu(31);  // Document
                System.out.println("Document");
                return;}
        }
        if (nimi == callAliAliValikko) {
            if (paikka.y > 1 && paikka.y < 33) {
                naytaAliSivu(33);  //Log
                System.out.println("log");
                return; }
            if (paikka.y > 32 && paikka.y < 67) {
                poistaValikot();
                naytaAliSivu(34);  //Numkeys
                System.out.println("Numkeys"); 
                return;}
        }  
        
        /* Päävalikon klikkausten tunnistaminen: */
        if (paikka.x > 1 && paikka.x < 49) {
            if (paikka.y > 1 && paikka.y < 41) {  // people
                naytaSivu(1); 
                naytaValikko(1);
                naytaAliValikko(11);
            } 
            if (paikka.y > 40 && paikka.y < 84) { //placies
                naytaSivu(2);
                naytaValikko(2);
                naytaAliValikko(12);
            } 
            if (paikka.y > 83 && paikka.y < 123) {  // communicate 
                naytaSivu(3); 
                naytaValikko(3);
                naytaAliValikko(13);
            }
            if (paikka.y > 122 && paikka.y < 166) { // Time
                naytaSivu(4);
                naytaValikko(4);
                naytaAliValikko(14);          
            } 
            if (paikka.y > 165 && paikka.y < 207) { //Create
                naytaSivu(5);
                naytaValikko(5);
                naytaAliValikko(15);
            } 
            if (paikka.y > 206 && paikka.y < 248) {  //Internet
                naytaSivu(6);
                naytaValikko(6);
                naytaAliValikko(16);
            } 
            if (paikka.y > 247 && paikka.y < 287) {  //Files
                naytaSivu(7);
                naytaValikko(7);
                naytaAliValikko(17);
            }    
            if (paikka.y > 286 && paikka.y < 329) {  //Setting
                naytaSivu(8);
                naytaValikko(8);
                //naytaAliValikko(15);
            }    
            if (paikka.y > 328 && paikka.y < 368) {  //Apps
                poistaValikot();
                //naytaValikko(9);
                naytaSivu(9);
                //naytaAliValikko(15);
            }  
        }
    }
        
        
    
    public static void main(String[] args) {
        Ohjaus ohjaus = new Ohjaus();
        Scanner lue = new Scanner(System.in);
        String komento;
        System.out.println("Komennot: \n"
                + " 1 = siirrä objekti0 peoplesivulta textSivulle \n"
                + " 2 =  poistetaan objekti2 \n"
                + " 3 = näytä se sivu, minkä numeron käyttäjä antaa \n"
                + " 4 = poistetaan kaikki sivun objektit \n"
                + " 5 = poista sivu \n"
                + " 6 = poistetaan valikko\n"
                + " 7 = aseta tyttö uudestaan\n"
                + " 8 = näytä peoplesivu\n"
                + " 9 = näytä textsivu\n"
                + " 0 = exit");
        do {
            komento = lue.nextLine();
            if (komento.equals("1")) {
                sivu.poistaObjektiNakyvista(objKuvanOsoittimet.get(0));
                Objekti obj = (Objekti) sivut[1].get(0);
                sivut[1].remove(sivut[1].get(0));
                ohjaus.sivut[8].add(obj);
                System.out.println("tytto pois peoplesivulta ja siirrätextisivulle");
            }
            if (komento.equals("2")) {
                sivu.poistaObjektiNakyvista(objKuvanOsoittimet.get(1));
                System.out.println("objekti pois");
            }
            if (komento.equals("3")) {
                System.out.println("Anna sivun numero");
                int temp = lue.nextInt();
                ohjaus.naytaSivu(temp);   
            }
            if (komento.equals("4")) {
                ohjaus.poistaSivunObjektitNakyvista();
            }
            if (komento.equals("5")) {
                sivu.poistaKirjaNakyvista(sivuOsoitin);
                System.out.println("sivu pois");
                //sivuOsoitin = s.luoSivu(naytto2);
            }
            if (komento.equals("6")) {
                sivu.poistaValikkoNakyvista(valikkoOsoitin);
                System.out.println("valikko pois");
            }
            if (komento.equals("7")) {
                ohjaus.poistaSivunObjektitNakyvista();
                
            }
            if (komento.equals("8")) {
                ohjaus.poistaSivunObjektitNakyvista();
            }
            if (komento.equals("9")) {
                ohjaus.poistaSivunObjektitNakyvista();
            }
            if (komento.equals("0")) {
                System.out.println("exit");
            }
        }
        while (!(komento.equals("0")));
        System.out.println("\n Tultiin ulos valikosta");              
        // /* viimeisimmät piirtyvät edellisten alle */        
    }           
}
