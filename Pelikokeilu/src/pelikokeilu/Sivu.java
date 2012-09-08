package pelikokeilu;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

/**
 * Sivu-luokka luo graafisen käyttöliittymän ja näyttää näytöllä sivut, objektit ja valikot. 
 * Täällä jäädään myös odottamaan käyttäjän tekemiä hiiren klikkauksia ja raahaamisia. 
 * Niiden tapahduttua kutsutaan Ohjaus-luokan metodeja määrittelemään mitä silloin on tehtävä.
 * @author Pena
 */
public class Sivu extends JFrame {
    private static Point klikkaus = new Point();
    private static Point raahaus  = new Point();
    private static JFrame raami = new JFrame("Käyttöliittymädemo");
    private static JPanel nayttoPaneli = new JPanel();
    
    /**
     * Asetetaan näyttöpanelin layout
     */
    public Sivu() {
        raami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  raami.setUndecorated(true);    
        nayttoPaneli.setLayout(null);
    } 
    
    /**
     * luo sivujen perustana olevan kirjan. Asettaa contentPanen
     * @param nimi
     * @return 
     */
    public JLabel kirjaNakyviin(Objekti nimi) {       
        JLabel sivu = new JLabel("", nimi.kuva, JLabel.CENTER);
        nayttoPaneli.add(sivu);
                     
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = sivu.getPreferredSize();
        sivu.setBounds(10 + sisennys.left, 10 + sisennys.top, koko.width, koko.height);
        
        raami.setContentPane(nayttoPaneli);
        raami.setSize(295, 488); 
        raami.setLocation(700, 200);
        raami.setVisible(true);
        
        return sivu;
    }
    
    /**
     * Poistaa kirjan näkyvistä (remove ko. JPanel)
     * @param kirja 
     */
    public void poistaKirjaNakyvista(JLabel kirja) {
        nayttoPaneli.remove(kirja);
        nayttoPaneli.validate();
        nayttoPaneli.repaint();
       // sivu.setVisible(false);
    }   
    
    /**
     * Näyttää valikon
     * @param nimi
     * @return 
     */
    public JLabel valikkoNakyviin(final Objekti nimi) {
        final JLabel valikko = new JLabel("", nimi.kuva, JLabel.CENTER); 
        nayttoPaneli.add(valikko);
             
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = valikko.getPreferredSize();
        valikko.setBounds(nimi.paikka_x + sisennys.left, nimi.paikka_y + sisennys.top, koko.width, koko.height);
        //System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "+MouseInfo.getPointerInfo().getLocation().y+")");
        
        valikko.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                klikkaus.x = e.getX();
                klikkaus.y = e.getY();
                Ohjaus.valikkoaOnKlikattu(klikkaus, nimi);
              // System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "
                //       +MouseInfo.getPointerInfo().getLocation().y+")");
            }
        });             
        return valikko;
    }
    
    /**
     * Poistaa valikon
     * @param valikko 
     */
    public void poistaValikkoNakyvista(JLabel valikko) {
        nayttoPaneli.remove(valikko);
        nayttoPaneli.validate();
        nayttoPaneli.repaint();
        //valikko.setVisible(false);
    }
    
    /**
     * Näyttää objektin
     * @param nimi
     * @return 
     */
    public JLabel objektiNakyviin(final Objekti nimi) {
        final JLabel objektiLabel = new JLabel("", nimi.kuva, JLabel.CENTER);      
        nayttoPaneli.add(objektiLabel);
       
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = objektiLabel.getPreferredSize();
        objektiLabel.setBounds(nimi.paikka_x + sisennys.left, nimi.paikka_y + sisennys.top, koko.width, koko.height);
        
        objektiLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                klikkaus.x = e.getX();
                klikkaus.y = e.getY();
                Ohjaus.objektiaOnKlikattu(klikkaus, nimi, objektiLabel);
            }
        });     
        objektiLabel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = objektiLabel.getLocation();
                objektiLabel.setLocation(p.x + e.getX() - klikkaus.x, p.y + e.getY() - klikkaus.y);
                Point r = objektiLabel.getLocation();
                Ohjaus.objektiaRaahataan(r, nimi, objektiLabel);                 
            }   
        });
        return objektiLabel;
    } 
    
    /**
     * Poistaa objektin näkyvistä
     * @param objektiLabel 
     */
    public void poistaObjektiNakyvista(JLabel objektiLabel) {
        nayttoPaneli.remove(objektiLabel);
        nayttoPaneli.validate();
        nayttoPaneli.repaint();
        // ???objektiLabel.setVisible(true);
    }
}
