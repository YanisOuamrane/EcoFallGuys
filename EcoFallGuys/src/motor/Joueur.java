/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
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
    private int x;
    private int y;
    private double x_vitesse=1;
    private double y_vitesse=1;
    
    
    
    public Joueur(String pseudo){
        this.pseudo=pseudo;
        this.x=100;
        this.y=100;
        try {
            this.sprite = ImageIO.read(getClass().getResource("../motor/fallguysrose.png"));
        } catch (IOException ex) {
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Avance(){
        this.x++;
    }
    
     public void Recule(){
        this.x--;
    }
     
     public void Monte(){
        this.y++;
    }
     
     public void Descend(){
         this.y--;
     }
    
     public void miseAJour() {
        Random random=new Random();
       if(((int)(Math.random() * 2)==1)){
           this.Avance();
           this.Monte();
       }else{
           this.Descend();
           this.Recule();
       }
           
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.sprite, (int) x, (int) y, null);
    }

     
     
}
