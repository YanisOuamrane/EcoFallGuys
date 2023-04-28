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
    private Sol Sol;
    private Plateforme Plateforme;
    
    public Jeu(){
         try {
        this.decor = ImageIO . read ( getClass () . getResource ("../motor/terrain.jpg"));
                } catch (IOException ex ) {
            Logger . getLogger ( Jeu . class . getName () ). log ( Level . SEVERE , null , ex );
            }  
         this.Joueur=new Joueur("Yanis");
         this.Joueur.setLimiteGauche(0);
         this.Joueur.setLimiteDroit(this.decor.getWidth()-(int) this.Joueur.getHauteur());
         this.Joueur.setLimiteHaut(0);
         this.Joueur.setLimiteBas(this.decor.getHeight()- (int) this.Joueur.getLargeur());
         this.Sol=new Sol();
         this.Plateforme= new Plateforme(250,216);
         
         
    }
    
    public void rendu (Graphics2D contexte){
            contexte.drawImage ( this . decor , 0, 0, null );
            this.Joueur.rendu(contexte);
            this.Sol.rendu(contexte);
            this.Plateforme.rendu(contexte);
    }
    
    public void miseAJour(){
        this.Joueur.miseAJour();
        if(this.Sol.collision(Joueur)){
            this.Joueur.setLimiteBas(this.Sol.getY()-(int)this.Sol.getHauteur()-(int)this.Joueur.getHauteur());
            this.Joueur.setEstauSol(true);
        }
        else{
            this.Joueur.setLimiteBas(this.decor.getHeight()- (int) this.Joueur.getHauteur());
            this.Joueur.setEstauSol(false);
        }
        
//        if(this.Plateforme.collision(Joueur)){
//            this.Joueur.setLimiteBas(this.Plateforme.getY()-(int)this.Plateforme.getHauteur()-(int)this.Joueur.getHauteur());
//            this.Joueur.setEstauSol(true);
//        }
//        else{
//            this.Joueur.setLimiteBas(this.decor.getHeight()- (int) this.Joueur.getHauteur());
//            this.Joueur.setEstauSol(false);
//        }
        Joueur.gravite();
    }
    
    public boolean estTermine(){
        return false;
    }

    public Joueur getJoueur() {
        return Joueur;
    }
    
}
