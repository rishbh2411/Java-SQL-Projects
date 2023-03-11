package Atm_Interface;

import com.mysql.cj.protocol.ReadAheadInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Login implements ActionListener {

    JFrame jFrameLogin, jFrameSignUp;
    JButton jButtonLogin, jButtonSignUp, jButtonCreate;
    JTextField jTextFieldUser, jTextFieldPass, jTextFieldUser1, jTextFieldPass1;
    JLabel jLabelUser, jLabelPass, jLabelUser1, jLabelPass1;
    ResultSet rs;

    public Login() {
        jFrameLogin = new JFrame("Login");
        jFrameLogin.setResizable(false);
        jFrameLogin.setBounds(440, 100, 400, 400);

        jFrameSignUp = new JFrame("SignUp");
        jFrameSignUp.setResizable(false);
        jFrameSignUp.setBounds(440, 100, 400, 400);

        jLabelUser = new JLabel("Username :");
        jLabelUser.setBounds(100, 100, 100, 25);

        jLabelPass = new JLabel("Password :");
        jLabelPass.setBounds(100, 150, 100, 25);

        jLabelUser1 = new JLabel("Username :");
        jLabelUser1.setBounds(100, 100, 100, 25);

        jLabelPass1 = new JLabel("Password :");
        jLabelPass1.setBounds(100, 150, 100, 25);

        jTextFieldUser = new JTextField();
        jTextFieldUser.setBounds(200, 100, 100, 25);
        jTextFieldPass = new JTextField();
        jTextFieldPass.setBounds(200, 150, 100, 25);


        jTextFieldUser1 = new JTextField();
        jTextFieldUser1.setBounds(200, 100, 100, 25);
        jTextFieldPass1 = new JTextField();
        jTextFieldPass1.setBounds(200, 150, 100, 25);

        jButtonCreate = new JButton("Create");
        jButtonCreate.setBounds(100, 200, 100, 25);

        jButtonSignUp = new JButton("SignUp");
        jButtonSignUp.setBounds(100, 300, 100, 25);
        jButtonLogin = new JButton("Login");
        jButtonLogin.setBounds(220, 300, 100, 25);

        jButtonLogin.addActionListener(this);
        jButtonSignUp.addActionListener(this);
        jButtonCreate.addActionListener(this);
        jFrameLogin.add(jButtonLogin);
        jFrameLogin.add(jButtonSignUp);
        jFrameLogin.add(jTextFieldPass);
        jFrameLogin.add(jTextFieldUser);
        jFrameLogin.add(jLabelPass);
        jFrameLogin.add(jLabelUser);


        jFrameSignUp.add(jTextFieldUser1);
        jFrameSignUp.add(jTextFieldPass1);
        jFrameSignUp.add(jLabelUser1);
        jFrameSignUp.add(jLabelPass1);
        jFrameSignUp.add(jButtonCreate);

        jFrameLogin.setLayout(null);
        jFrameLogin.setVisible(true);
        jFrameSignUp.setVisible(false);
        jFrameSignUp.setLayout(null);

    }

    public static void main(String[] args) {
        Atm_Interface.Login login = new Atm_Interface.Login();
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == jButtonLogin) {
                String user = jTextFieldUser.getText();
                String pass = jTextFieldPass.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");

                //establish the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb?useTimezone=true&serverTimezone=UTC",
                        "root",
                        "");
                //create stmt object
                Statement stmt = con.createStatement();
                //execute the query
                ResultSet rs = stmt.executeQuery("select * from Login");
                boolean b = false;

                if (Objects.equals(user, "") || Objects.equals(pass, "")) {

                }

                while (rs.next() == true) {
                    String u = rs.getString(1);
                    String p = rs.getString(2);
                    //System.out.println(u + " == "+user);
                    //System.out.println(p + " == "+pass);


                    if (Objects.equals(user, u) && Objects.equals(pass, p)) {
                        b = true;
                    }
                }
                if (b) {
                    JOptionPane.showMessageDialog(jFrameLogin, "Login Successfull", "Done", JOptionPane.INFORMATION_MESSAGE);

                    JFrame frame = new JFrame(); //PANEL PARAMETERS
                    frame.getContentPane().add(new Atm_Interface.Atm(frame));
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(300, 100, 700, 500);

                    frame.setVisible(true);
                } else if (Objects.equals(user, "") || Objects.equals(pass, "")) {
                    JOptionPane.showMessageDialog(jFrameSignUp, "Any Field Can't be Empty ");
                } else {
                    JOptionPane.showMessageDialog(jFrameLogin, "ERROR !", "Done", JOptionPane.ERROR_MESSAGE);
                }

                con.close();
            }

            //SignUp
            else if (e.getSource() == jButtonSignUp) {
                jFrameLogin.setVisible(false);
                jFrameSignUp.setVisible(true);

            }
            //button create
            else if (e.getSource() == jButtonCreate) {
                String user = jTextFieldUser1.getText();
                String pass = jTextFieldPass1.getText();
                System.out.println(user + " " + pass);
                Class.forName("com.mysql.cj.jdbc.Driver");
                //establish the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb?useTimezone=true&serverTimezone=UTC", "root", "");
                //create stmt object
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery("select * from Login");
                boolean b = false;
                while (rs.next()) {
                    String u = rs.getString(1);
                    String p = rs.getString(2);
                    // System.out.println(u + " == "+user);
                    // System.out.println(p + " == "+pass);


                    if (Objects.equals(user, u)) {
                        b = true;
                    }

                }
                if (b) {
                    JOptionPane.showMessageDialog(jFrameSignUp, "UserName Already Exists");
                } else if (Objects.equals(user, "") || Objects.equals(pass, "")) {
                    JOptionPane.showMessageDialog(jFrameSignUp, "Any Field Can't be Empty ");
                } else {
                    //execute the query
                    stmt.executeUpdate("insert into Login values('" + user + "','" + pass + "')");
                    System.out.println("insert into Login values('" + user + "','" + pass + "')");
                    con.close();
                    JOptionPane.showMessageDialog(jFrameLogin, "Done SignUp ");
                    jFrameSignUp.setVisible(false);
                    jFrameLogin.setVisible(true);
                }


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



