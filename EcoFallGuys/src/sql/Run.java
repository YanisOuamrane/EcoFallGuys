/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

/**
 *
 * @author xlai
 */

import sql.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Run extends JPanel {
    public static final int WIDTH = 600; // 宽
    public static final int HEIGHT = 800; // 高
   
    //public static final int SIGN = 0;//登录
  


    public static User user = new User();//一个游戏对应一个User

   

   

    JFrame jf_main = new JFrame("Game");
    //JButton jb_sign = new JButton();//登录按钮
    JButton jb_register = new JButton();//注册按钮

    JButton jb_cancel = new JButton();//取消按钮
    JLabel jl_name = new JLabel("Name：");//用户名标签
    JLabel jl_password = new JLabel("Password：");//密码标签
    String name_tip = "please do not enter spaces.";
    String password_tip = "please enter a 6-11 digit password";
    JTextField jt_name = new JTextField(name_tip, 10);//用户名文本框
    JPasswordField jp_password = new JPasswordField();//密码文本框
    //JSpinner js_color=new JSpinner();
    class JTextFieldHintListener implements FocusListener {
        private String hintText;
        private JTextField textField;

        public JTextFieldHintListener(JTextField jTextField, String hintText) {
            this.textField = jTextField;
            this.hintText = hintText;
            jTextField.setText(hintText);  //默认直接显示
            jTextField.setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {
            //获取焦点时，清空提示内容
            String temp = textField.getText();
            if (temp.equals(hintText)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            //失去焦点时，没有输入内容，显示提示内容
            String temp = textField.getText();
            if (temp.equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }
        }
    }

    public void signIn() {

        this.setLayout(null);//默认流布局，null设置为空布局可以进行自定义操作
        //jb_sign.setBounds(180, 450, 100, 40);//自定义位置和大小
        //jb_sign.setText("Signin");
        jb_register.setBounds(320, 450, 100, 40);//自定义位置和大小
        jb_register.setText("Register");
       
        jb_cancel.setBounds(320, 500, 100, 40);
        jb_cancel.setText("Cancel");
        //this.add(jb_sign);
        this.add(jb_register);
      
        this.add(jb_cancel);

        jl_name.setBounds(100, 250, 150, 30);
        jl_name.setFont(new Font("Calibri", Font.BOLD, 25));
        jl_name.requestFocus();//使name标签获取焦点
        this.add(jl_name);
        jt_name.setBounds(250, 250, 150, 30);
        jt_name.addFocusListener(new JTextFieldHintListener(jt_name, name_tip));
        this.add(jt_name);
        jl_password.setBounds(100, 350, 150, 30);
        jl_password.setFont(new Font("Calibri", Font.BOLD, 25));
        this.add(jl_password);
        jp_password.setBounds(250, 350, 150, 30);
        //jp_password.addFocusListener(new JTextFieldHintListener(jp_password, password_tip));

        this.add(jp_password);

        MyActionListener myActionListener = new MyActionListener();
        //jb_sign.addActionListener(myActionListener);
        jb_register.addActionListener(myActionListener);
       
        jb_cancel.addActionListener(myActionListener);

        //jf_main.add(this);
    }

    public void action() {
        // 创建鼠标适配器对象，监听鼠标事件，并且重写鼠标点击、移动的方法
        MouseAdapter mAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

        };
    }

    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = jt_name.getText();
            String password = String.valueOf(jp_password.getPassword());
//            String color=(String)js_color.getValue();
            
            
            /*if (e.getActionCommand() == "Signin") {
                Run game = new Run();//创建该用户的子游戏
                if (user.SignIn(name, password, color)) {
                    JFrame jf_house = new JFrame(name + "house");
                    jf_house.setSize(WIDTH, HEIGHT);//设置窗体的宽高
                    jf_house.setLocationRelativeTo(null);//默认显示在屏幕的中间
                   
                    game.setLayout(null);//默认流布局，null设置为空布局可以进行自定义操作
                    
                    JButton jb_Game = new JButton();//shootGame按钮
                  
                    
                    jb_Game.setBounds(245, 300, 100, 40);//自定义位置和大小
                    jb_Game.setText("Game");
                    game.add(jb_Game);
                   
                    MyActionListener myActionListener = new MyActionListener();
                 
                    jb_Game.addActionListener(myActionListener);
                   
                    jf_house.add(game);
                    jf_house.setVisible(true); //将窗体显示出来
                } else {
                    JFrame jframe = new JFrame("Login failed"); //创建窗体并未窗体设置标题
                    jframe.add(game);
                    jframe.setSize(WIDTH + 100, HEIGHT - 500);//设置窗体的宽高
                    jframe.setLocationRelativeTo(null);//默认显示在屏幕的中间
                    JPanel jp = new JPanel();
                    jp.setLayout(null);
                    JLabel jl = new JLabel();
                    jl.setText("Usersname does not exist or password is wrong!");
                    jl.setBounds(100, 50, 600, 100);
                    jl.setFont(new Font("Calibri", Font.BOLD, 30));
                    jp.add(jl);
                    jframe.add(jp);
                    jframe.setVisible(true); //将窗体显示出来
                }
            } else */
            if (e.getActionCommand() == "Register") {
                if (user.Register(name, password)) {
                    JFrame jframe = new JFrame("Registration success");
                    jframe.setSize(WIDTH + 100, HEIGHT - 500);
                    jframe.setLocationRelativeTo(null);
                    JPanel jp = new JPanel();
                    jp.setLayout(null);
                    JLabel jl = new JLabel();
                    jl.setText("Congratulation");
                    jl.setBounds(220, 50, 400, 100);
                    jl.setFont(new Font("Calibri", Font.BOLD, 30));
                    jp.add(jl);
                    jframe.add(jp);
                    jframe.setVisible(true);
                } else {
                    JFrame jframe = new JFrame("Registration failed"); //创建窗体并未窗体设置标题
                    jframe.setSize(WIDTH + 100, HEIGHT - 500);//设置窗体的宽高
                    jframe.setLocationRelativeTo(null);//默认显示在屏幕的中间
                    JPanel jp = new JPanel();
                    jp.setLayout(null);
                    JLabel jl = new JLabel();
                    jl.setText("The password requires 6~11 characters, the user name is entered incorrectly, or the account already exists! ");
                    jl.setBounds(50, 50, 550, 100);
                    jl.setFont(new Font("Calibri", Font.BOLD, 20));
                    jp.add(jl);
                    jframe.add(jp);
                    jframe.setVisible(true); //将窗体显示出来
                }

            } 

        }
    }
    
    public void main() {
        Run game = new Run();
        jf_main.add(game);
        jf_main.setSize(WIDTH, HEIGHT);
        jf_main.setLocationRelativeTo(null);//默认显示在屏幕中间
        jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口进程结束
        game.signIn();
        jf_main.setVisible(true); //将窗体显示出来
    }

}

