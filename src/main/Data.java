package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import auth.User;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data extends JPanel{
    private JPanel panelTop, panelBottom;
    private JLabel lblData;
    private JTable table;
    private DefaultTableModel tableModel;
    private int currentPage = 1;
    private int rowsPerPage = 5;

    public Data() {
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

        lblData = new JLabel("Dữ liệu");
        lblData.setFont(new java.awt.Font("Segoe UI Black", 1, 50));
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setBorder(new EmptyBorder(0, screenHeight/20, 0, 0));

        panelTop.add(lblData, BorderLayout.WEST);

        panelBottom = new JPanel();
        panelBottom.setBackground(new Color(255, 255, 255));
        panelBottom.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Ngày tạo", "Mô tả", "Lời khuyên"};

        Object[][] dbData = this.getData();

        tableModel = new DefaultTableModel(dbData, columnNames);
        table = new JTable(tableModel);
        panelBottom.add(new JScrollPane(table), BorderLayout.CENTER);



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
    }

    private Object[][] getData() {
        List<Object[]> dataList = new ArrayList<Object[]>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/masbody","admin","admin");
            PreparedStatement  stmt = con.prepareStatement(
                "SELECT * from history where user_id = ?"
                );
            System.out.println(Integer.toString(User.getId()));
            stmt.setString(1, Integer.toString(User.getId()));
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                // Replace DataObject with your actual class or use a Map to store column values
                String id = resultSet.getString("id");
                String date = resultSet.getString("created_date");
                String description = resultSet.getString("description");
                String advise = resultSet.getString("advise");
                Object[] data = {id, date, description, advise};
                System.out.println(Arrays.toString(data));
                dataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
        return convertListToObjectArray(dataList);
    }

    private static Object[][] convertListToObjectArray(List<Object[]> objectList) {
        if (objectList.size() == 0) {
            return new Object[0][0];
        }
        int listSize = objectList.size();
        int arrayLength = objectList.get(0).length;

        // Create a two-dimensional array
        Object[][] objectArray = new Object[listSize][arrayLength];

        // Copy elements from List<Object[]> to Object[][]
        for (int i = 0; i < listSize; i++) {
            objectArray[i] = objectList.get(i);
        }

        return objectArray;
    }

    public void updateTable() {
        tableModel.setRowCount(0);

        Object[][] updatedData = getData();

        for (Object[] row : updatedData) {
            tableModel.addRow(row);
        }
    }
}
