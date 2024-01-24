package app;

import javax.swing.*;

import auth.Login;
import auth.SignUp;

import main.MainScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class app extends JFrame{
    private JPanel panelMain;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private Login login;
    private SignUp signUp;
    private MainScreen mainScreen;


        public app() {
            setTitle("App");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);

            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);
            cardPanel.setPreferredSize(getSize());

            login = new Login();
            signUp = new SignUp();
            mainScreen = new MainScreen();

            signUp.setCardLayout(cardLayout, cardPanel);
            login.setCardLayout(cardLayout, cardPanel);
            mainScreen.setCardLayout(cardLayout, cardPanel);


            cardPanel.add(login, "login");
            cardPanel.add(signUp, "signUp");
            cardPanel.add(mainScreen, "mainScreen");
            cardLayout.show(cardPanel, "login");

            add(cardPanel);
            // add(cardLayout);

            login.setSignUpButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "signUp");
                }
            });

            signUp.setHaveAccountListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardLayout.show(cardPanel, "login");
                    System.out.println("Clicked");
                }
            });

            pack();
        }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                app app = new app();
                app.setVisible(true);
            }
        });
    }
}
