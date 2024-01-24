package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class HomePage extends JPanel {
    private JPanel panelBottom;
    private JLabel titleLabel, lblImage;
    private JTextArea descriptionArea;

    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        setBackground(new Color(255, 255, 255));

        titleLabel = new JLabel("Masbody");
        titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        descriptionArea.setText("Chào mừng bạn đến với Masbody - Ứng dụng chăm sóc và theo dõi tình trạng sức khoẻ của bạn.\n\nMasbody giúp bạn tư vấn và quản lý thông tin về sức khoẻ, ngoại hình và đưa ra lời khuyên hợp lí.\n\nHãy bắt đầu hành trình chăm sóc sức khoẻ của bạn ngay hôm nay!");
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setBackground(new Color(0, 51, 102));
        descriptionArea.setForeground(new Color(255, 255, 255));


        lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(getClass().getResource("/icon/health.jpg")));

        panelBottom = new JPanel();
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.X_AXIS)); // Use BoxLayout for horizontal alignment
        panelBottom.setBackground(new Color(255, 255, 255));
        panelBottom.add(lblImage);
        panelBottom.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between image and text
        panelBottom.add(descriptionArea);
        panelBottom.setBorder(new EmptyBorder(10, 20, 10, 20));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.9;
        add(panelBottom, gbc);
    }
}