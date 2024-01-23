
package auth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.*;

import javax.swing.*;

public class SignUp extends JPanel {
    private JPanel panelButton;

    private JButton btnSignUp;
    private JButton btnLogin;

    private JLabel lblSignUp;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JLabel lblReenterPassword;
    private JLabel lblName;
    private JLabel lblBirth;
    private JLabel lblAppName;
    private JLabel lblLogo;
    private JLabel lblHaveAccount;

    private JPasswordField fieldPassword;
    private JPasswordField fieldReenterPassword;
    private JTextField fieldEmail;
    private JTextField fieldName;
    private JFormattedTextField fieldBirth;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public SignUp() {
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

        lblSignUp = new JLabel("ĐĂNG KÝ");
        lblSignUp.setFont(new java.awt.Font("Segoe UI", 1, 36));
        lblSignUp.setForeground(new java.awt.Color(0, 51, 102));

        lblName = new JLabel("Họ và tên: ");
        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldName = new JTextField();
        fieldName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldName.setForeground(new java.awt.Color(120, 120, 120));
        fieldName.setColumns(20);

        lblBirth = new JLabel("Ngày sinh: ");
        lblBirth.setFont(new java.awt.Font("Segoe UI", 0, 14));

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fieldBirth = new JFormattedTextField(df);
        fieldBirth.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldBirth.setForeground(new java.awt.Color(120, 120, 120));
        fieldBirth.setColumns(20);

        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldEmail = new JTextField();
        fieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldEmail.setForeground(new java.awt.Color(120, 120, 120));
        fieldEmail.setColumns(20);

        lblPassword = new JLabel("Mật khẩu: ");
        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldPassword = new JPasswordField();
        fieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldPassword.setColumns(20);

        lblReenterPassword = new JLabel("Nhập lại mật khẩu: ");
        lblReenterPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fieldReenterPassword = new JPasswordField();
        fieldReenterPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fieldReenterPassword.setColumns(20);

        btnSignUp = new JButton("Đăng ký");
        btnSignUp.setBackground(new Color(0, 51, 102));
        btnSignUp.setForeground(Color.WHITE);

        lblHaveAccount = new JLabel("<html><u>Tôi đã có tài khoản?</html></u>");
        lblHaveAccount.setEnabled(true);
        lblHaveAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));
        panelButton.setBackground(getBackground());

        panelButton.add(btnSignUp);
        panelButton.add(Box.createHorizontalStrut(5));

        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(lblSignUp, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 1;
        gbcLeft.anchor = GridBagConstraints.WEST;
        panelLeft.add(lblName, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        panelLeft.add(fieldName, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        panelLeft.add(lblBirth, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 4;
        panelLeft.add(fieldBirth, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 5;
        panelLeft.add(lblEmail, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 6;
        panelLeft.add(fieldEmail, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 7;
        panelLeft.add(lblPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 8;
        panelLeft.add(fieldPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 9;
        panelLeft.add(lblReenterPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 10;
        panelLeft.add(fieldReenterPassword, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 11;
        panelLeft.add(lblHaveAccount, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 12;
        gbcLeft.anchor = GridBagConstraints.CENTER;
        panelLeft.add(panelButton, gbcLeft);

        setBackground(Color.GREEN);
        add(new JLabel("SignUp Screen Content"));

        //Right Panel
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

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSignUpActionPerformed(e);
            }
        });
    }

    public void setCardLayout(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
    }

    private void btnSignUpActionPerformed(ActionEvent e) {
        String username = fieldName.getText();
        char[] password = fieldPassword.getPassword();
        char[] rePassword = fieldReenterPassword.getPassword();
        String birthday = fieldBirth.getText();
        String email = fieldEmail.getText();

        if (!validateEmail(email)) {
            showErrorMessage("Invalid email address");
            return;
        }
        if (!validateEmptyString(birthday)) {
            showErrorMessage("Invalid birthdate");
            return;
        }
        if (!validateEmptyString(username)) {
            showErrorMessage("Invalid name");
            return;
        }
        if (!validatePassword(password)) {
            showErrorMessage("Invalid password. Length must be more than 6 characters");
            return;
        }
        if (!validateRePassword(password, rePassword)) {
            showErrorMessage("Password do not match");
            return;
        }
        if (validateExistsEmail(email)) {
            showErrorMessage("Email is exists");
            return;
        }

        java.util.Date date;
        SimpleDateFormat outputFormat;
        String formatedBirthday;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            date = inputFormat.parse(birthday);
            outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            formatedBirthday = outputFormat.format(date);
        } catch (ParseException parseError) {
            parseError.printStackTrace();
            return;
        }

        int id = createUser(username, email, password, formatedBirthday);
        if (id > 0) {
            System.out.println("Created Success!");
        } else {
            showErrorMessage("Create user fail");
            return;
        }
        User user = User.getInstance();
        user.setInformation(id, username, email, formatedBirthday);
        cardLayout.show(cardPanel, "mainScreen");
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validateEmail(String email) {
        String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateEmptyString(String date) {
        return !date.isEmpty();
    }

    private boolean validatePassword(char[] password) {
        if (password.length > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateRePassword(char[] password, char[] rePassword) {
        boolean res = Arrays.equals(password, rePassword);
        return res;
    }

    private boolean validateExistsEmail(String email) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/masbody","admin","admin");
            PreparedStatement  stmt = con.prepareStatement("SELECT * FROM user WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private int createUser(String username, String email, char[] password, String birthday) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/masbody","admin","admin");
            PreparedStatement  stmt = con.prepareStatement(
                "INSERT INTO user (username, email, birthday, hashpass) VALUES (?, ?, ? ,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
                );
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, birthday);
            stmt.setString(4, new String(password));
            int rowsAffected = stmt.executeUpdate();
            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        con.close();
                        return generatedId;
                    }
                }
                con.close();
                return -1;
            } else {
                System.out.println("Failed to insert data.");
                con.close();
                return -1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public void setHaveAccountListener(MouseAdapter listener) {
        lblHaveAccount.addMouseListener(listener);
    }
}