package oasis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Number_guessing implements ActionListener {
    JFrame jFrameLogin;
    JButton jButtonLogin;
    JTextField jTextFieldUser,jTextField1;
    JLabel jLabelUser;
    ResultSet rs;
    public Number_guessing()
    {
        int r = (int) (Math.random() * 100 + 1);
        String s=String.valueOf(r);
        jFrameLogin = new JFrame("GUESS THE NUMBER");
        jFrameLogin.setResizable(false);
        jFrameLogin.setBounds(440,100,400,400);

        jLabelUser = new JLabel("ENTER :");
        jLabelUser.setBounds(100,100,100,25);

        jTextFieldUser = new JTextField("");
        jTextFieldUser.setBounds(200,100,100,25);

        jTextField1 = new JTextField("");
        jTextField1.setBounds(200,300,100,25);
        jTextField1.setText(s);
        jButtonLogin = new JButton("ENTER");
        jButtonLogin.setBounds(150,200,100,25);

        jButtonLogin.addActionListener(this);
        jFrameLogin.add(jButtonLogin);
        jFrameLogin.add(jTextFieldUser);
        //jFrameLogin.add(jTextField1);
        jFrameLogin.add(jLabelUser);
        jFrameLogin.setLayout(null);
        jFrameLogin.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {

        try
        {
            if(e.getSource()==jButtonLogin)
            {
                String num = jTextFieldUser.getText();
                String random = jTextField1.getText();
                int n = Integer.parseInt(num);
                int r = Integer.parseInt(random);
                if (n==r )
                {
                    JOptionPane.showMessageDialog(jFrameLogin,"Correct","YOU Won",JOptionPane.INFORMATION_MESSAGE);

                    jFrameLogin.setVisible(false);
                }
                else if (n<r)
                {
                    JOptionPane.showMessageDialog(jFrameLogin,"Number is Greater","Try Again",JOptionPane.INFORMATION_MESSAGE);
                }
                else if (n>r)
                {
                    JOptionPane.showMessageDialog(jFrameLogin,"Number is Smaller","Try Again",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(jFrameLogin,"Error","Try Again",JOptionPane.INFORMATION_MESSAGE);

                }

            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
