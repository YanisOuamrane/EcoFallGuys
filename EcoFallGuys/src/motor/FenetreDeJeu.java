
package motor;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author youamran
 */
public class FenetreDeJeu extends JFrame implements ActionListener, KeyListener {

    private BufferedImage framebuffer;
    private Graphics2D contexte;
    private JLabel jLabel1;
    private Jeu jeu;
    private Timer timer;

    public FenetreDeJeu() {
        // initialisation de la fenetre
        this.setSize(474, 266);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(474, 266));
        this.setContentPane(this.jLabel1);
        this.pack();

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.framebuffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();
        
        this.jeu=new Jeu();
        
        this.timer= new Timer(40,this);
        this.timer.start();
        this.addKeyListener(this);
        
    }
    
     public void actionPerformed(ActionEvent e){
        this.jeu.miseAJour();
        this.jeu.rendu(contexte);
        this.jLabel1.repaint();
        if(this.jeu.estTermine()){
            this.timer.stop();
        }
    }
    
    
      public void keyTyped(KeyEvent evt) {
    }
     
     
      public void keyPressed(KeyEvent evt) {
          
           if (evt.getKeyCode() == evt.VK_SPACE) {
            this.jeu.getJoueur().setEspace(true);
        }
           
           
        if (evt.getKeyCode() == evt.VK_UP) {
            this.jeu.getJoueur().setHaut(true);
        }
        if (evt.getKeyCode() == evt.VK_DOWN) {
             this.jeu.getJoueur().setBas(true);
        }
        if (evt.getKeyCode() == evt.VK_RIGHT) {
             this.jeu.getJoueur().setDroit(true);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.jeu.getJoueur().setGauche(true);
        }
    }
      
       public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_SPACE) {
            this.jeu.getJoueur().setEspace(false);
        }
         if (evt.getKeyCode() == evt.VK_UP) {
            this.jeu.getJoueur().setHaut(false);
        }
        if (evt.getKeyCode() == evt.VK_DOWN) {
             this.jeu.getJoueur().setBas(false);
        }
        if (evt.getKeyCode() == evt.VK_RIGHT) {
             this.jeu.getJoueur().setDroit(false);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.jeu.getJoueur().setGauche(false);
        }
    }
     
     
    
    public static void main(String[] args) {
        FenetreDeJeu fenetre = new FenetreDeJeu();
        fenetre.setVisible(true);
    }
    
    
    
    

}
