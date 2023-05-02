/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motor;

/**
 *
 * @author xlai
 */
public class EcoFallGuys {
    private static String name="apple";
    private static String password="123456ABC";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sql.User user= new sql.User();
        user.Register(name,password);
        user.SignIn(name, password);
        user.getWintimefromID(1);
        //user.setWin();
        user.setx_y(1.5587874, 54.654);
        user.setAccessoire("fly");
    }
    
}
