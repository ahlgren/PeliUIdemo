package pelikokeilu;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class Sivu extends JFrame {
    private static Point klikkaus = new Point();
    private static Point raahaus  = new Point();
    private static JFrame raami = new JFrame("Käyttöliittymädemo");
    private static JPanel nayttoPaneli = new JPanel();
    //private static JLabel sivu = new JLabel();
    //private static JLabel valikko = new JLabel();
    //private static JLabel objektiLabel = new JLabel();
    
    public Sivu() {
        raami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  raami.setUndecorated(true);    
        nayttoPaneli.setLayout(null);
    } 
    
    public JLabel luoSivu(Objekti nimi) {       
        JLabel sivu = new JLabel("", nimi.kuva, JLabel.LEFT);
        nayttoPaneli.add(sivu);
                     
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = sivu.getPreferredSize();
        sivu.setBounds(200 + sisennys.left, 60 + sisennys.top, koko.width, koko.height);
        
        raami.setContentPane(nayttoPaneli);
        raami.setSize(500, 500); 
        raami.setLocation(700, 200);
        raami.setVisible(true);
        
        return sivu;
    }
    
    public void poistaSivu(JLabel sivu) {
        nayttoPaneli.remove(sivu);
       // sivu.setVisible(false);
    }   
    
    public JLabel luoValikko() {
        final JLabel valikko = new JLabel("", new ImageIcon("valilehdet.png"), JLabel.LEFT);
        nayttoPaneli.add(valikko);
             
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = valikko.getPreferredSize();
        valikko.setBounds(367 + sisennys.left, 98 + sisennys.top, koko.width, koko.height);
       //System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "+MouseInfo.getPointerInfo().getLocation().y+")");
        
        valikko.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                klikkaus.x = e.getX();
                klikkaus.y = e.getY();
                System.out.println("tässä klikattu valikkoa: X on " + klikkaus.x + ",  Y on " + klikkaus.y); 
              // System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "
                //       +MouseInfo.getPointerInfo().getLocation().y+")");
            }
        });             
        valikko.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = valikko.getLocation();
                valikko.setLocation(p.x + e.getX() - klikkaus.x, p.y + e.getY() - klikkaus.y);
                Point r = valikko.getLocation(); 
                System.out.println("Valikon paikka, x= " + r.x +" y= " + r.y);
            }   
        });
        return valikko;
    }
    
    public void poistaValikko(JLabel valikko) {
        nayttoPaneli.remove(valikko);
        //valikko.setVisible(false);
    }
    
    
    public JLabel luoObjekti(final Objekti nimi, int paikka_x, int paikka_y) {
        final JLabel objektiLabel = new JLabel("", nimi.kuva, JLabel.CENTER);      
        nayttoPaneli.add(objektiLabel);
        
        
        Insets sisennys = nayttoPaneli.getInsets();
        Dimension koko = objektiLabel.getPreferredSize();
        objektiLabel.setBounds(paikka_x + sisennys.left, paikka_y + sisennys.top, koko.width, koko.height);
        
        objektiLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                klikkaus.x = e.getX();
                klikkaus.y = e.getY();
            }
        });     
        objektiLabel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = objektiLabel.getLocation();
                objektiLabel.setLocation(p.x + e.getX() - klikkaus.x, p.y + e.getY() - klikkaus.y);
                Point r = objektiLabel.getLocation();
                Ohjaus.tarkistaPaikka(r, nimi.tiedot);                 
            }   
        });
        return objektiLabel;
    } 
    
    public void poistaObjekti(JLabel objektiLabel) {
        nayttoPaneli.remove(objektiLabel);
        // ???objektiLabel.setVisible(true);
    }
}
