/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motor;

/**
 *
 * @author youamran
 */
public class Joueur {
    private String pseudo;
    private int x_position;
    private int y_position=0;
    private double x_vitesse=1;
    private double y_vitesse=1;
    
    
    
    public Joueur(String pseudo){
        this.pseudo=pseudo;
    }
    
    public void Avance(){
        this.x_position++;
    }
    
     public void Recule(){
        this.x_position--;
    }
     
     public void Monte(){
        this.y_position++;
    }
     
     public void Descend(){
         this.y_position--;
         
     }
    
}
