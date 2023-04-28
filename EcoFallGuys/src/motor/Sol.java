/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author youamran
 */
public class Sol {
    protected BufferedImage sprite;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Sol(){
         try {
            this.sprite = ImageIO.read(getClass().getResource("../motor/sol.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    this.x=0;
    this.y=256;
    }
    
    public void rendu(Graphics2D contexte){
        contexte.drawImage(this.sprite, x , y, null);  
    }
    
    public boolean collision(Joueur Joueur){
        if((abs(Joueur.getX()-this.x)<this.sprite.getWidth()+Joueur.getLargeur()) && 
            (abs(Joueur.getY()-this.y)<this.sprite.getHeight()+Joueur.getHauteur())){
            return true;
        }else{return false;}}
        
        
        
//       if((Joueur.getX()+Joueur.getLargeur()<=this.x-this.sprite.getWidth()) ||
//                (Joueur.getX()-Joueur.getLargeur()>=this.x+this.sprite.getWidth()) ||
//                (Joueur.getY()-Joueur.getHauteur()>=this.y+this.sprite.getHeight()) ||
//                (Joueur.getY()+Joueur.getHauteur()<=this.y-this.sprite.getHeight())){
//           return false;
//       }        
//       else{
//           return true;
//       }
//    }
    
     public double getHauteur(){
        return sprite.getHeight();
    }
    
    public double getLargeur(){
        return sprite.getWidth();
    }
    
}
