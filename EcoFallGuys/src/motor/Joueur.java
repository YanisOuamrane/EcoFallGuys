/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor;

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
public class Joueur {
    protected BufferedImage sprite;
    private String pseudo;
    private boolean EstauSol;
    private int x;
    private int y;
    private int x_vitesse;
    private int y_vitesse;
    private boolean haut;
    private boolean bas;
    private boolean gauche;
    private boolean droit;
    private boolean espace;
    private int limiteHaut;
    private int limiteBas;
    private int LimiteDroit;
    private int LimiteGauche;
    
    
    public Joueur(String pseudo){
        this.pseudo=pseudo;
        this.x=0;
        this.y=150;
        try {
            this.sprite = ImageIO.read(getClass().getResource("../motor/fallguysrose.png"));
        } catch (IOException ex) {
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x_vitesse=2;
        this.y_vitesse=15;
        this.bas=false;
        this.droit=false;
        this.haut=false;
        this.gauche=false;
        this.LimiteDroit=0;
        this.LimiteGauche=0;
        this.limiteBas=0;
        this.limiteHaut=0;
        this.EstauSol=false;
    }

    public int getX_vitesse() {
        return x_vitesse;
    }

    public int getY_vitesse() {
        return y_vitesse;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLimiteHaut(int limiteHaut) {
        this.limiteHaut = limiteHaut;
    }

    public void setLimiteBas(int limiteBas) {
        this.limiteBas = limiteBas;
    }

    public void setLimiteDroit(int LimiteDroit) {
        this.LimiteDroit = LimiteDroit;
    }

    public void setLimiteGauche(int LimiteGauche) {
        this.LimiteGauche = LimiteGauche;
    }
    
    
    public void Avance(){
        if(this.x + this.x_vitesse<this.LimiteDroit){
        this.x=this.x + this.x_vitesse;
        }
        else{
            this.x=this.x;
        }
    }
    
 
    
     public void Recule(){
         if(this.x - this.x_vitesse>this.LimiteGauche){
            this.x= this.x - this.x_vitesse ;
            }
        else{
        this.x=this.x;
            }
        }
     
     public void Monte(){
         if(this.EstauSol){
         if(this.y-this.y_vitesse>this.limiteHaut){
        this.y= this.y - 
              5*this.y_vitesse;
         }
         else{
             this.y=this.y;
         }
         }
     }

    public void setEstauSol(boolean EstauSol) {
        this.EstauSol = EstauSol;
    }
     
     
//     public void Descend(){
//         if(this.y+this.y_vitesse<this.limiteBas){
//         this.y= this.y + this.y_vitesse;
//     }
//         else{
//             this.y=this.y;
//         }
//     }
     
     public void gravite(){
          if(this.y+this.y_vitesse<this.limiteBas){
         this.y=this.y+2;
     }
     }
     
     public void miseAJour() {
       if(this.haut){
           this.Monte();
       }
//       if(this.bas){
//           this.Descend();
//       }
       if(this.gauche){
           this.Recule();
       }
       if(this.droit){
           this.Avance();
       }
//       if(this.espace){
//           this.Saute();
//       }
           
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.sprite, (int) x, (int) y, null);
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroit(boolean droit) {
        this.droit = droit;
    }
    
    public void setEspace(boolean espace) {
        this.espace = espace;
    }
    
    public double getHauteur(){
        return sprite.getHeight()-10;
    }
    
    public double getLargeur(){
        return sprite.getWidth();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
     
     
}
