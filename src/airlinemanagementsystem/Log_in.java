package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Log_in extends JFrame implements ActionListener {
    JButton reset, submit, close;
    JTextField tUsername;
    JPasswordField tPassword;

    public Log_in() {
        setTitle("Login Form");
        getContentPane().setBackground(Color.white);
        setLayout(null);


        tUsername = new JTextField();
        tUsername.setBounds(100, 20, 200, 20);
        add(tUsername);

        JLabel username = new JLabel("Username");
        username.setBounds(20, 20, 100, 20);
        add(username);

        tPassword = new JPasswordField();
        tPassword.setBounds(100, 72, 200, 20);
        add(tPassword);

        JLabel password = new JLabel("Password");
        password.setBounds(20, 60, 100, 50);
        add(password);

        reset = new JButton("Reset");
        reset.setBounds(40, 160, 100, 30);
        reset.addActionListener(this);
        add(reset);


        submit = new JButton("Submit");
        submit.setBounds(200, 160, 100, 30);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(120, 220, 100, 30);
        close.addActionListener(this);
        add(close);

        setLocation(720, 350);
        setSize(380, 320);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reset) {
            tUsername.setText("");
            tPassword.setText("");
        } else if (ae.getSource() == submit) {
            String userName = tUsername.getText();
            String password = tPassword.getText();

            DatabaseConnection dc = new DatabaseConnection();
            try {
                String query = "select * from login where username = '" + userName + "' and password = '" + password + "'";
                ResultSet rs = dc.s.executeQuery(query);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Valid");
                    setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                    setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (ae.getSource() == close) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Log_in();
    }
}
