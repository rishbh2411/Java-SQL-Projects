package Atm_Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.TextField;
import javax.swing.JButton;



public class Atm extends JPanel implements ActionListener {
    JButton Deposit = new JButton("Deposit");
    JButton Withdraw = new JButton("Withdraw");
    JButton exit = new JButton("Exit");
    TextField t1, t2, output;
    Label DepositAccount, WithdrawAccount, balanceAmount;
    double AcctBalance=0.0;
    public Atm(JFrame frame) {

        DepositAccount = new Label(" Deposit :");  // Deposit label LOCATION
        DepositAccount.setBounds(100, 100, 100, 25);
        frame.add(DepositAccount);

        WithdrawAccount = new Label(" Withdraw :");  // Withdraw label LOCATION
        WithdrawAccount.setBounds(100, 200, 100, 25);
        frame.add(WithdrawAccount);

        balanceAmount = new Label(" Balance :"); //Balance label LOCATION
        balanceAmount.setBounds(100, 300, 100, 25);
        frame.add(balanceAmount);

        t1 = new TextField("");  // Deposit text box (INPUT) LOCATION
        t1.setBounds(250, 100, 100, 25);
        frame.add(t1);

        t2 = new TextField("");  // Withdraw text box (INPUT) LOCATION
        t2.setBounds(250, 200, 100, 25);
        frame.add(t2);

        output = new TextField("");  //Balance text box (OUTPUT) LOCATION
        output.setBounds(250, 300, 100, 25);
        frame.add(output);

        Deposit.addActionListener(this);  // Deposit button LOCATION
        Deposit.setBounds(400,100, 100,25);
        frame. add(Deposit);

        Withdraw.addActionListener(this);  // Withdraw button LOCATION
        Withdraw.setBounds(400,200, 100,30);
        frame.add(Withdraw);

        exit.addActionListener(this); //Exit button LOCATION
        exit.setBounds(400,300, 100,30); ;
        frame.add(exit);
    }



    public void actionPerformed(ActionEvent v) { //gives action to buttons

        if (v.getActionCommand().equals("Deposit")) {
            System.out.println("Funds Deposited");
            String balanceAmount = t1.getText();
            double DepositAmount = Double.parseDouble(balanceAmount);
            AcctBalance=AcctBalance+DepositAmount;
            output.setText(String.valueOf(AcctBalance));



        } else if (v.getActionCommand().equals("Withdraw")) {
            System.out.println("Funds Withdrawn");
            String balanceAmount = t2.getText();
            double WithdrawAmount = Double.parseDouble(balanceAmount);
            AcctBalance=AcctBalance-WithdrawAmount;
            output.setText(String.valueOf(AcctBalance));



        }else if(v.getActionCommand().equals("Exit")){
            System.out.println("Have a Good Day");
            System.exit(0);
//Creates output when Exit is chosen and terminates program
        }
    }
}



