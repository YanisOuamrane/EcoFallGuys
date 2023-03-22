/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author youamran
 */
public class Jeu {
    private BufferedImage decor;
    private Joueur Joueur;
    
    public Jeu(){
         try {
        this.decor = ImageIO . read ( getClass () . getResource ("../motor/terrain.jpg"));
                } catch (IOException ex ) {
            Logger . getLogger ( Jeu . class . getName () ). log ( Level . SEVERE , null , ex );
            }  
         this.Joueur=new Joueur("Yanis");
    }
    
    public void rendu (Graphics2D contexte){
            contexte.drawImage ( this . decor , 0, 0, null );
            this.Joueur.rendu(contexte);
    }
    
    public void miseAJour(){
        this.Joueur.miseAJour();
    }
    
    public boolean estTermine(){
        return false;
    }
    
}
