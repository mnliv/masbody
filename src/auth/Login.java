package auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JPanel panelButton;

    private JButton btnLogin;
    private JButton btnSignUp;

    private JLabel lblLogin;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JLabel lblDontHaveAccount;
    private JLabel lblLogo;
    private JLabel lblAppName;

    private JPasswordField fieldPassword;
    private JTextField fieldEmail;

    public Login() {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Display the screen width and height
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setLayout(new GridBagLayout());
        setBackground(new java.awt.Color(255, 255, 255));


        // Left Panel
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(255, 255, 255));
        panelLeft.setLayout(new GridBagLayout());

        lblLogin = new JLabel("ĐĂNG NHẬP");
        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(0, 51, 102));

        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fieldEmail = new JTextField();
        fieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        fieldEmail.setColumns(20);

        lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fieldPassword = new JPasswordField();
        fieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldPassword.setColumns(20);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBackground(new Color(0, 51, 102));
        btnLogin.setForeground(Color.WHITE);

        lblDontHaveAccount = new JLabel("Tôi không có tài khoản");
        btnSignUp = new JButton("Đăng ký");
        btnSignUp.setForeground(new Color(255, 51, 51));

        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));
        panelButton.setBackground(getBackground());

        panelButton.add(btnLogin);
        panelButton.add(Box.createHorizontalStrut(5));
        panelButton.add(btnSignUp);


        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(lblLogin, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        gbcLeft.anchor = GridBagConstraints.WEST;
        panelLeft.add(lblEmail, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        panelLeft.add(fieldEmail, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        panelLeft.add(lblPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 4;
        panelLeft.add(fieldPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 5;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(panelButton, gbcLeft);

        // Right Panel
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(new Color(0, 51, 102));

        ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/icon/logo.png"));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(screenWidth / 5, screenWidth /5, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lblLogo = new JLabel(scaledIcon);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblAppName = new JLabel("MASBODY");
        lblAppName.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
        lblAppName.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelRight.add(Box.createVerticalGlue());
        panelRight.add(lblLogo);
        panelRight.add(Box.createVerticalStrut(20)); // Add spacing
        panelRight.add(lblAppName);
        panelRight.add(Box.createVerticalGlue());

        // Add both panels to the main container
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

    public void setSignUpButtonListener(ActionListener listener) {
        btnSignUp.addActionListener(listener);
    }
}