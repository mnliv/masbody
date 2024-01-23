package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class IBM extends javax.swing.JPanel {
    private JPanel panelButton;

    private JLabel lblBMILeft;
    private JLabel lblHeight;
    private JLabel lblWeight;
    private JLabel lblReponse;
    private JLabel lblAppName;
    private JLabel lblBMIRight;
    private JLabel lblHealth;
    private JLabel lblHistory;
    private JLabel lblLogout;
    private JLabel lblHome;
    private JLabel lblSex;
    private JLabel lblMenu;

    private JTextField fieldHeight;
    private JTextField fieldWeight;

    private JButton btnReponse;

    private JRadioButton rbtnMen;
    private JRadioButton rbtnWomen;


    public IBM(){
         //Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setLayout(new GridBagLayout());
        setBackground(new java.awt.Color(255, 255, 255));

        // Left Panel
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(255, 255, 255));
        panelLeft.setLayout(new GridBagLayout());

        lblBMILeft = new JLabel("TƯ VẤN BMI");
        lblBMILeft.setFont(new java.awt.Font("Segoe UI", 1, 36));
        lblBMILeft.setForeground(new java.awt.Color(0, 51, 102));

        lblHeight = new JLabel("Chiều cao(cm): ");
        lblHeight.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldHeight = new JTextField();
        fieldHeight.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldHeight.setForeground(new java.awt.Color(120, 120, 120));
        fieldHeight.setColumns(20);

        lblWeight = new JLabel("Cân nặng(kg): ");
        lblWeight.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldWeight = new JTextField();
        fieldWeight.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldWeight.setForeground(new java.awt.Color(120, 120, 120));
        fieldWeight.setColumns(20);

        lblSex = new JLabel("Giới tính: ");
        lblSex.setFont(new java.awt.Font("Segoe UI", 0, 14));

        rbtnMen = new JRadioButton ("Nam");
        rbtnMen.setFont(new java.awt.Font("Segoe UI", 0, 14));
        rbtnMen.setBounds(100, 50, 100, 20);

        rbtnWomen = new JRadioButton ("Nữ");
        rbtnWomen.setFont(new java.awt.Font("Segoe UI", 0, 14));
        rbtnMen.setBounds(200, 50, 100, 20);

        ButtonGroup Sex = new ButtonGroup ();
        Sex.add(rbtnMen);
        Sex.add(rbtnWomen);

        btnReponse = new JButton("Tư vấn");
        btnReponse.setBackground(new Color(0, 51, 102));
        btnReponse.setForeground(Color.WHITE);

        lblReponse = new JLabel (" Lời khuyên dành cho bạn:  ");

        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));
        panelButton.setBackground(getBackground());

        panelButton.add(btnReponse);
        panelButton.add(Box.createHorizontalStrut(5));

        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(lblBMILeft, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        gbcLeft.anchor = GridBagConstraints.WEST;
        panelLeft.add(lblSex, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        panelLeft.add(rbtnMen, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        panelLeft.add(rbtnWomen, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 4;
        panelLeft.add(lblHeight, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 5;
        panelLeft.add(fieldHeight, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 6;
        panelLeft.add(lblWeight, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 7;
        panelLeft.add(fieldWeight, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 8;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(panelButton, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 9;
        panelLeft.add(lblReponse, gbcLeft);

        //Right Panel
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(new Color(0, 51, 102));

        ImageIcon menuIcon = new ImageIcon(IBM.class.getResource("/icon/menu.png"));
        Image menuImage = menuIcon.getImage();
        Image scaledmenuImage = menuImage.getScaledInstance(screenWidth / 5, screenWidth /5, Image.SCALE_SMOOTH);

        ImageIcon scaledmenuIcon = new ImageIcon(scaledmenuImage);
        lblMenu = new JLabel(scaledmenuIcon);

        lblAppName = new JLabel("MASBODY");
        lblAppName.setFont(new Font("Showcard Gothic", Font.BOLD, 50));

        lblBMIRight = new JLabel("<html><u>TƯ VẤN BMI</html></u>");
        lblBMIRight.setEnabled(true);
        lblBMIRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblHealth = new JLabel("<html><u>TƯ VẤN SỨC KHOẺ</html></u>");
        lblHealth.setEnabled(true);
        lblHealth.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblHistory = new JLabel("<html><u>LỊCH SỬ</html></u>");
        lblHistory.setEnabled(true);
        lblHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblLogout = new JLabel("<html><u>ĐĂNG XUẤT</html></u>");
        lblLogout.setEnabled(true);
        lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 0;
        gbcRight.gridy = 0;
        gbcRight.anchor = GridBagConstraints.NORTHEAST;
        panelRight.add(lblAppName, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 1;
        gbcRight.anchor = GridBagConstraints.NORTHWEST;
        panelRight.add(lblMenu, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 2;
        gbcRight.anchor = GridBagConstraints.EAST;
        panelRight.add(lblBMIRight, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 3;
        panelRight.add(lblHealth, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 4;
        panelRight.add(lblHistory, gbcRight);

        gbcRight.gridx = 0;
        gbcRight.gridy = 5;
        panelRight.add(lblLogout, gbcRight);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelRight, gbc);

        gbc.gridx = 1;
        add(panelLeft, gbc);

    }
}
