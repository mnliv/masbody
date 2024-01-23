
package main;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        // Thiết lập layout cho JPanel
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Màu nền

        // Tiêu đề của ứng dụng
        JLabel titleLabel = new JLabel("Masbody");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 60));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(70, 130, 180)); // Màu chữ
        add(titleLabel, BorderLayout.NORTH);

        // Mô tả ứng dụng với nhiều chữ và phóng to chữ
        JTextArea descriptionArea = new JTextArea(
                "Chào mừng bạn đến với Masbody - Ứng dụng chăm sóc và theo dõi tình trạng sức khỏe của bạn.\n" +
                        "Masbody giúp bạn theo dõi và quản lý thông tin về hoạt động vận động, dinh dưỡng, và nhiều hơn nữa.\n" +
                        "Hãy bắt đầu hành trình chăm sóc sức khỏe của bạn ngay hôm nay!\n" +
                        "\n" +
                        "Masbody cung cấp:\n" +
                        "- Theo dõi lịch sử hoạt động và tiêu thụ năng lượng.\n" +
                        "- Gợi ý chế độ ăn uống và lịch trình tập luyện.\n" +
                        "- Thông báo nhắc nhở để duy trì thói quen lành mạnh.\n" +
                        "và nhiều tính năng khác đang chờ bạn khám phá!"
        );
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionArea.setForeground(new Color(50, 50, 50)); // Màu chữ
        descriptionArea.setBackground(new Color(240, 240, 240)); // Màu nền
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Khoảng cách từ lề

        // Đặt khả năng cuộn cho vùng mô tả
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        add(scrollPane, BorderLayout.CENTER);

        // Tạo một nút "Bắt đầu" để bổ sung tính năng tương lai
        JButton startButton = new JButton("Bắt đầu");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setForeground(Color.WHITE); // Màu chữ
        startButton.setBackground(new Color(70, 130, 180)); // Màu nền
        startButton.setBorderPainted(false); // Ẩn đường viền
        startButton.setFocusPainted(false); // Ẩn đường viền khi được chọn
        startButton.addActionListener(e -> {
            // Xử lý sự kiện khi nút được nhấp
            JOptionPane.showMessageDialog(this, "Chức năng này sẽ được triển khai trong tương lai!");
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(240, 240, 240)); // Màu nền của panel chứa nút
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}