/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 *
 * @author xlai
 */
public class User {
    private String name;
    private int id;
    private String password;
    private String color;
    private boolean iswin;
    private boolean issignin;
    private int win_time;
    private double x;
    private double y;
    private double speed_x;
    private double speed_y;
    private int COUNT;
    private String accessoire;
    
    private String url="jdbc:mysql://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_EcoFallGuy?serverTimezone=UTC";
    private String user="etudiant";
    private String pass="YTDTvj9TR3CDYCmP";
    
    public double[] aux= new double [3];
    public double[] auy= new double [3];
    public String[] aun= new String [3];
    public String[] aucolor=new String [3];
    public double[] auspeed_x= new double [3];
    public double[] auspeed_y= new double [3];
    
    public void setPassword(String password){
        this.password=password;
    }
    public int getWin_time(){
        return this.win_time;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public boolean isRed(String name){
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete = connexion.prepareStatement("SELECT id, name, password, win_time FROM EFB;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.name = resultat.getString("name");
                this.id = resultat.getInt("id");
                this.password = resultat.getString("password");
                this.win_time=resultat.getInt("win_time");
                
                if(this.name.equals(name)){
                    return true;
                }     
            }
            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean SignIn(String name, String password, String color){//interface de connextion requis
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete01 = connexion.prepareStatement("SELECT id, name, password, iswin, win_time FROM EFB;");
            ResultSet resultat = requete01.executeQuery();
            while (resultat.next()) {
                this.name = resultat.getString("name");
                this.id = resultat.getInt("id");
                this.password = resultat.getString("password");
                this.iswin=false;
                this.win_time=resultat.getInt("win_time");
                if((this.name.equals(name))&&(this.password.equals(password))){
                    PreparedStatement requete02 = connexion.prepareStatement("UPDATE EFB SET color = ?, issignin = 1 WHERE name = ?");
                    requete02.setString(1, color);
                    
                    requete02.setString(2, name);
                    requete02.executeUpdate();
                    requete02.close();
                    return true;
                }
                    
            }

            requete01.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    public boolean Register(String name,String password){//interface d'inscription requis
        if(name.length()>=10){
            return false;
        }
        if(name.contains(" ")){
            return false;
        }
        if(password.contains(" ")){
            return false;
        }
        if(password.length()<=6||password.length()>11){
            return false;
        }
        if(isRed(name)){
            return false;
        }
        
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO EFB(name,password,iswin,win_time,x,y,accessoire,color,speed_x,speed_y,issignin) VALUES (?,?,0,0,0,0,?,?,0,0,0)",Statement.RETURN_GENERATED_KEYS);
            
           // requete.setInt(1,getCOUNT()+1 );
            requete.setString(1, name);
            requete.setString(2, password);
            requete.setString(3, " ");
            requete.setString(4, " ");
            requete.executeUpdate();
            requete.close();
            connexion.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    public void setWin(){//d茅finissez le gagnant seul
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            String sql="UPDATE EFB SET iswin = ?, win_time = ? WHERE name = ?";
            PreparedStatement requete = connexion.prepareStatement(sql);
            requete.setBoolean(1,true);
            requete.setInt(2,getWin_time()+1);
            requete.setString(3, this.name);
            requete.executeUpdate();

            requete.close();
            connexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setx_y(double x, double y){//emplacement synchrone en temps r茅el
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            String sql="UPDATE EFB SET x = ?, y = ? WHERE name = ?";
            PreparedStatement requete = connexion.prepareStatement(sql);
            requete.setDouble(1,x);
            requete.setDouble(2,y);
            requete.setString(3, this.name);
            requete.executeUpdate();

            requete.close();
            connexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getx_y() {
    	int a=0;
    	 try {

             Connection connexion = DriverManager.getConnection(url, user, pass);
             String sql="SELECT  name, x, y  FROM EFB WHERE issignin=1 AND name!= ?";
             PreparedStatement requete = connexion.prepareStatement(sql);
             requete.setString(1, this.name);
             ResultSet resultat = requete.executeQuery();
             
             while (resultat.next()) {
                aun[a]=resultat.getString("name");
                aux[a]=resultat.getDouble("x");
                auy[a]=resultat.getDouble("y");
                a++;     
             }
             requete.close();
             connexion.close();

         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        
     }
    
    public void setSpeedx_y(double speed_x, double speed_y){
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            String sql="UPDATE EFB SET speed_x = ?, speed_y = ? WHERE name = ?";
            PreparedStatement requete = connexion.prepareStatement(sql);
            requete.setDouble(1,speed_x);
            requete.setDouble(2,speed_y);
            requete.setString(3, this.name);
            requete.executeUpdate();

            requete.close();
            connexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getSpeedx_y() {
    	int a=0;
    	 try {

             Connection connexion = DriverManager.getConnection(url, user, pass);
             String sql="SELECT  name, speed_x, speed_y  FROM EFB WHERE issignin=1 AND name!= ?";
             PreparedStatement requete = connexion.prepareStatement(sql);
             requete.setString(1, this.name);
             ResultSet resultat = requete.executeQuery();
             
             while (resultat.next()) {
                aun[a]=resultat.getString("name");
                auspeed_x[a]=resultat.getDouble("speed_x");
                auspeed_y[a]=resultat.getDouble("speed_y");
                a++;     
             }
             requete.close();
             connexion.close();

         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        
     }
    
    
    public void getcolor() {
    	int a=0;
    	 try {

             Connection connexion = DriverManager.getConnection(url, user, pass);
             String sql="SELECT  name, color  FROM EFB WHERE issignin=1 AND name!= ?";
             PreparedStatement requete = connexion.prepareStatement(sql);
             requete.setString(1, this.name);
             ResultSet resultat = requete.executeQuery();
             
             while (resultat.next()) {
                aun[a]=resultat.getString("name");
                aucolor[a]=resultat.getString("color");
                a++;     
             }
             requete.close();
             connexion.close();

         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        
     }
    public void setAccessoire(String Accessoire){//un seul accessoire peut etre utilis茅 脿 la fois
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            String sql="UPDATE EFB SET accessoire = ? WHERE name = ?";
            PreparedStatement requete = connexion.prepareStatement(sql);
            requete.setString(1,Accessoire);
            requete.setString(2, this.name);
            requete.executeUpdate();
            requete.close();
            connexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void setAccessoireExable(){//perdre de accessoire apr猫s une heure d茅termin茅e
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            String sql="UPDATE EFB SET accessoire = ? WHERE name = ?";
            PreparedStatement requete = connexion.prepareStatement(sql);
            requete.setString(1," ");
            requete.setString(2, this.name);
            requete.executeUpdate();
            requete.close();
            connexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getNamefromID(int id){
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete = connexion.prepareStatement("SELECT id, name, password,iswin, win_time FROM EFB;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int temp_id = resultat.getInt("id");
                String temp_name = resultat.getString("name");
                if (id == temp_id)
                    return temp_name;
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public int getWintimefromID(int id){//enregistrez le nombre de victoires
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete = connexion.prepareStatement("SELECT  id,  win_time FROM EFB;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int temp_id= resultat.getInt("id");
                int temp_win_time = resultat.getInt("win_time");
                if (id == temp_id){
                    this.win_time=temp_win_time;
                    return temp_win_time;
                }
                   
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
   
}