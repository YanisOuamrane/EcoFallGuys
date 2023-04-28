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
public class Plateforme {
 protected BufferedImage sprite;
 private int x;
 private int y;
    
  public Plateforme(int x, int y){
         try {
            this.sprite = ImageIO.read(getClass().getResource("../motor/plateforme.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    this.x=x;
    this.y=y;
    }
    
    public void rendu(Graphics2D contexte){
        contexte.drawImage(this.sprite, x , y, null);  
    }
    
//    public boolean collision(Joueur Joueur){
////        if(Joueur.getX()+Joueur.getLargeur()>this.getX() && )
////                ){return false;}
////        else{
//            return false;
//        
//    }
    
     public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
     public double getHauteur(){
        return sprite.getHeight();
    }
    
    public double getLargeur(){
        return sprite.getWidth();
    }
    
}
