package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AI.Gemini;
import auth.User;

public class AdviseScreen extends JPanel{
    private JPanel panelTop, panelBottom;
    private JLabel lblAdvise, lblDescribeDisease, lblBotAdvise;
    private JTextArea  txtDescribeDisease, txtBotAdvise;
    AdviseScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Display the screen width and height
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setLayout(new GridBagLayout());
        setBorder( new MatteBorder(0, 5, 0, 0, Color.WHITE));

        panelTop = new JPanel();
        panelTop.setBackground(new Color(0, 51, 102));
        panelTop.setLayout(new BorderLayout());
        panelTop.setBorder( new MatteBorder(0, 0, 5, 0, Color.WHITE));

        lblAdvise = new JLabel("Tư vấn sức khỏe");
        lblAdvise.setFont(new java.awt.Font("Segoe UI Black", 1, 50));
        lblAdvise.setForeground(new java.awt.Color(255, 255, 255));
        lblAdvise.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));

        panelTop.add(lblAdvise, BorderLayout.WEST);

        panelBottom = new JPanel();
        panelBottom.setBackground(new Color(255, 255, 255));
        panelBottom.setLayout(new GridBagLayout());

        lblDescribeDisease = new JLabel("Tình trạng bệnh:");
        lblDescribeDisease.setFont(new java.awt.Font("Segoe UI", 1, 30));
        lblDescribeDisease.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));


        lblBotAdvise = new JLabel("Lời khuyên cho bạn:");
        lblBotAdvise.setFont(new java.awt.Font("Segoe UI Black", 1, 30));
        lblBotAdvise.setForeground(new java.awt.Color(0, 51, 153));
        lblBotAdvise.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));


        txtBotAdvise = new JTextArea ();
        txtBotAdvise.setLineWrap(true); // Enable line wrapping
        txtBotAdvise.setWrapStyleWord(true);
        txtBotAdvise.setEditable(false);

        txtDescribeDisease = new JTextArea ();
        txtDescribeDisease.setLineWrap(true); // Enable line wrapping
        txtDescribeDisease.setWrapStyleWord(true);

        // txtBotAdvise.setPreferredSize(new Dimension(300, 100));
        // txtDescribeDisease.setPreferredSize(new Dimension(300, 100));

        JScrollPane scrollPaneBotAdvise = new JScrollPane(txtBotAdvise);
        scrollPaneBotAdvise.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane scrollPaneDescribeDisease = new JScrollPane(txtDescribeDisease);
        scrollPaneDescribeDisease.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.gridx = 0;
        gbcBottom.gridy = 0;
        gbcBottom.weightx = 0.1;
        gbcBottom.weighty = 1;
        gbcBottom.fill = GridBagConstraints.BOTH;
        gbcBottom.anchor = GridBagConstraints.EAST;
        panelBottom.add(lblDescribeDisease, gbcBottom);

        gbcBottom.gridx = 1;
        gbcBottom.weightx = 0.9;
        gbcBottom.anchor = GridBagConstraints.WEST; // Set anchor to the left
        panelBottom.add(scrollPaneDescribeDisease, gbcBottom);

        gbcBottom.gridx = 0;
        gbcBottom.gridy = 1;
        gbcBottom.weightx = 0.1;
        gbcBottom.fill = GridBagConstraints.BOTH;
        panelBottom.add(lblBotAdvise, gbcBottom);

        gbcBottom.gridx = 1;
        gbcBottom.gridy = 1;
        gbcBottom.weightx = 0.9;
        gbcBottom.fill = GridBagConstraints.BOTH;
        panelBottom.add(scrollPaneBotAdvise, gbcBottom);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelTop, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.9;
        add(panelBottom, gbc);

        txtDescribeDisease.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Handle the Enter key press event here
                    // You can perform any action you want when Enter is pressed in txtDescribeDisease
                    // For example, you can get the text and display it in another component
                    String enteredText = txtDescribeDisease.getText();
                    txtDescribeDisease.setText("");
                    txtDescribeDisease.requestFocus(); //
                    txtDescribeDisease.setCaretPosition(0);
                    // Do something with the enteredText
                    System.out.println(enteredText);
                    String response = Gemini.getResponse(enteredText);
                    txtBotAdvise.setText(response);
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/masbody","admin","admin");
                        PreparedStatement  stmt = con.prepareStatement(
                            "INSERT INTO history (description, advise, user_id) VALUES (?, ?, ?);"
                            );
                        stmt.setString(1, enteredText);
                        stmt.setString(2, response);
                        stmt.setString(3, Integer.toString(User.getId()));

                        int rowsAffected = stmt.executeUpdate();
                        // Check the result
                        if (rowsAffected > 0) {
                            System.out.println("Data inserted successfully!");
                        } else {
                            System.out.println("Failed to insert data.");

                        }
                        con.close();
                    } catch (Exception error) {
                        System.out.println(error);
                    }
                }
            }
        });
    }
}
