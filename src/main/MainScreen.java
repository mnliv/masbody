package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import auth.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.HomePage;
import main.IBM;
import main.AdviseScreen;

public class MainScreen extends JPanel {
    private JPanel panelLeft, panelRight, panelTopLeft, panelMiddleLeft, panelBottomLeft, panelListHome, panelListAdvise, panelListData;
    private JLabel lblAppName, lblLogo, lblLogoHome, lblLogoAdvise, lblLogoData, lblHome, lblAdvise, lblData, lblLogoLogout, lblLogout;

    private CardLayout layoutContent;
    private JPanel panelContent;

    private HomePage homePage;
    private IBM IBM;
    private AdviseScreen adviseScreen;
    private Data data;

    public MainScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Display the screen width and height
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setLayout(new GridBagLayout());

        panelLeft = new JPanel();
        panelLeft.setBackground(new Color(0, 51, 102));
        panelLeft.setLayout(new GridBagLayout());

        panelTopLeft = new JPanel();
        panelTopLeft.setBackground(panelLeft.getBackground());
        panelTopLeft.setLayout(new GridBagLayout());
        // panelTopLeft.setBorder( new MatteBorder(0, 0, 5, 0, Color.WHITE));
        panelTopLeft.setEnabled(true);
        panelTopLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        lblAppName = new JLabel("MASBODY");
        lblAppName.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        lblAppName.setBorder(new EmptyBorder(0, 10, 0, 0));

        lblLogo = createLogoLabel("/icon/logo.png", screenWidth / 20, screenHeight / 20);

        GridBagConstraints gbcTopLeft = new GridBagConstraints();
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 0;
        gbcTopLeft.weightx = 1;
        gbcTopLeft.weighty = 0.5;
        gbcTopLeft.fill = GridBagConstraints.BOTH;
        gbcTopLeft.anchor = GridBagConstraints.WEST;
        panelTopLeft.add(lblAppName, gbcTopLeft);


        gbcTopLeft.gridx = 1;
        gbcTopLeft.anchor = GridBagConstraints.EAST;
        panelTopLeft.add(lblLogo, gbcTopLeft);

        panelMiddleLeft = new JPanel();
        panelMiddleLeft.setBackground(panelLeft.getBackground());
        panelMiddleLeft.setLayout(new BoxLayout(panelMiddleLeft, BoxLayout.Y_AXIS));
        panelMiddleLeft.setBorder(new EmptyBorder(screenHeight/10, 0, 0, 0));


        panelListHome = new JPanel();
        // panelListHome.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        panelListHome.setBackground(panelMiddleLeft.getBackground());
        panelListHome.setMaximumSize(new Dimension(Integer.MAX_VALUE, screenHeight / 10));
        panelListHome.setLayout(new BorderLayout());
        panelListHome.setEnabled(true);
        panelListHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblHome = new JLabel("Trang chủ");
        lblHome.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblHome.setForeground(Color.WHITE);
        lblHome.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));


        lblLogoHome = createLogoLabel("/icon/homelgo.png", screenWidth / 30 , screenHeight / 30);
        lblLogoHome.setBorder(new EmptyBorder(0, screenHeight/30, 0, 0));


        panelListHome.add(lblLogoHome, BorderLayout.WEST);
        panelListHome.add(lblHome, BorderLayout.CENTER);

        panelListAdvise = new JPanel();
        panelListAdvise.setBackground(panelMiddleLeft.getBackground());
        panelListAdvise.setMaximumSize(new Dimension(Integer.MAX_VALUE, screenHeight / 10));
        panelListAdvise.setLayout(new BorderLayout());
        panelListAdvise.setEnabled(true);
        panelListAdvise.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        lblAdvise = new JLabel("Tư vấn");
        lblAdvise.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblAdvise.setForeground(Color.WHITE);
        lblAdvise.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));

        lblLogoAdvise = createLogoLabel("/icon/chatlogo.png", screenWidth / 30 , screenHeight / 30);
        lblLogoAdvise.setBorder(new EmptyBorder(0, screenHeight/30, 0, 0));

        panelListAdvise.add(lblLogoAdvise, BorderLayout.WEST);
        panelListAdvise.add(lblAdvise, BorderLayout.CENTER);

        panelMiddleLeft.add(panelListHome);
        panelMiddleLeft.add(panelListAdvise);

        panelListData = new JPanel();
        panelListData.setBackground(panelMiddleLeft.getBackground());
        panelListData.setMaximumSize(new Dimension(Integer.MAX_VALUE, screenHeight / 10));
        panelListData.setLayout(new BorderLayout());
        panelListData.setEnabled(true);
        panelListData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        lblData = new JLabel("Dữ liệu");
        lblData.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblData.setForeground(Color.WHITE);
        lblData.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));

        lblLogoData = createLogoLabel("/icon/dulieulogo.png", screenWidth / 30 , screenHeight / 30);
        lblLogoData.setBorder(new EmptyBorder(0, screenHeight/30, 0, 0));

        panelListData.add(lblLogoData, BorderLayout.WEST);
        panelListData.add(lblData, BorderLayout.CENTER);

        panelMiddleLeft.add(panelListHome);
        panelMiddleLeft.add(panelListAdvise);
        panelMiddleLeft.add(panelListData);


        panelBottomLeft = new JPanel();
        panelBottomLeft.setBackground(panelLeft.getBackground());
        panelBottomLeft.setLayout(new BorderLayout());
        panelBottomLeft.setBorder( new MatteBorder(5, 0, 0, 0, Color.WHITE));
        panelBottomLeft.setEnabled(true);
        panelBottomLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        lblLogout = new JLabel("Đăng xuất");
        lblLogout.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblLogout.setForeground(Color.WHITE);
        lblLogout.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));

        lblLogoLogout = createLogoLabel("/icon/dangxuat.png", screenWidth / 30 , screenHeight / 30);
        lblLogoLogout.setBorder(new EmptyBorder(0, screenHeight/30, 0, 0));

        panelBottomLeft.add(lblLogoLogout, BorderLayout.WEST);
        panelBottomLeft.add(lblLogout, BorderLayout.CENTER);

        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.weightx = 1;
        gbcLeft.weighty = 0.1;
        gbcLeft.fill = GridBagConstraints.BOTH;
        panelLeft.add(panelTopLeft, gbcLeft);


        gbcLeft.gridy = 1;
        gbcLeft.weighty = 0.8;
        panelLeft.add(panelMiddleLeft, gbcLeft);

        gbcLeft.gridy = 2;
        gbcLeft.weighty = 0.1;
        panelLeft.add(panelBottomLeft, gbcLeft);

        layoutContent = new CardLayout();
        panelRight = new JPanel(layoutContent);
        panelRight.setBackground(new Color(255, 255, 255));

        homePage = new HomePage();
        IBM = new IBM();
        adviseScreen = new AdviseScreen();
        data = new Data();

        panelRight.add(homePage, "homePage");
        panelRight.add(IBM, "IBM");
        panelRight.add(adviseScreen, "adviseScreen");
        panelRight.add(data, "data");

        layoutContent.show(panelRight, "homePage");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelLeft, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.85;
        add(panelRight, gbc);

        panelListHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelListHome.setBackground( new Color (0,0,153));  // Change to the desired hover color
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelListHome.setBackground(panelLeft.getBackground());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                layoutContent.show(panelRight, "homePage");
            }
        });

        panelListAdvise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelListAdvise.setBackground( new Color (0,0,153));  // Change to the desired hover color
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelListAdvise.setBackground(panelLeft.getBackground());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                layoutContent.show(panelRight, "adviseScreen");
            }
        });

        panelListData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelListData.setBackground( new Color (0,0,153));  // Change to the desired hover color
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelListData.setBackground(panelLeft.getBackground());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                data.updateTable();
                layoutContent.show(panelRight, "data");
            }
        });
    }

    private JLabel createLogoLabel(String path, int sizeX, int sizeY) {
        ImageIcon originalIcon = new ImageIcon(Login.class.getResource(path));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lbl = new JLabel(scaledIcon);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        return lbl;
    }
}