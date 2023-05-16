/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motor;

/**
 *
 * @author xlai
 */
public class UserTest3 {

     private static String name="dfvd";
    private static String password="123540ABC";
    private static String color="p";
   
    public static void main(String[] args) {
        // TODO code application logic here
        sql.User user= new sql.User();
        user.Register(name,password);
        user.SignIn(name, password,color);
        user.getWintimefromID(1);
        //user.setWin();
        user.setx_y(1.5587874, 54.654);
        user.setSpeedx_y(0.5265, 0.55447);
        user.setAccessoire("fly");
        
    }
}
