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
    private boolean iswin;
    private int win_time;
    private double x;
    private double y;
    private int COUNT;
    private String accessoire;
    
    private String url="jdbc:mysql://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_EcoFallGuy?serverTimezone=UTC";
    private String user="etudiant";
    private String pass="YTDTvj9TR3CDYCmP";
    public void setPassword(String password){
        this.password=password;
    }
    public int getWin_time(){
        return this.win_time;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getCOUNT(){
        return this.COUNT;
    }
    public boolean isSignIn(String name){
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete = connexion.prepareStatement("SELECT id, name, password, iswin FROM EFB;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.name = resultat.getString("name");
                this.id = resultat.getInt("id");
                this.password = resultat.getString("password");
                this.iswin=resultat.getBoolean("iswin");
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
    public boolean SignIn(String name, String password){
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement requete = connexion.prepareStatement("SELECT id, name, password, win_time FROM EFB;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.name = resultat.getString("name");
                this.id = resultat.getInt("id");
                this.password = resultat.getString("password");
                this.iswin=false;
                this.win_time=resultat.getInt("win_time");
                if((this.name.equals(name))&&(this.password.equals(password))){
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
    public boolean Register(String name,String password){
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
        if(isSignIn(name)){
            return false;
        }
        
        try {

            Connection connexion = DriverManager.getConnection(url, user, pass);
            
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO EFB(id,name,password,iswin,win_time,x,y,accessoire) VALUES (?,?,?,0,0,0,0,?)",Statement.RETURN_GENERATED_KEYS);
            getCOUNT();
            requete.setInt(1,COUNT+1 );
            requete.setString(2, name);
            requete.setString(3, password);
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
    public void setWin(){
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
    
    public void setx_y(double x, double y){
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
    
    public void setAccessoire(String Accessoire){
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
    public int getWintimefromID(int id){
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
