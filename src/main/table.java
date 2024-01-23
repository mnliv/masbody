package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class table extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private int currentPage = 1;
    private int rowsPerPage = 5;

    public table() {
        setTitle("Paginated Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Sample data
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "John Doe", 25},
                {2, "Jane Smith", 30},
                {3, "Bob Johnson", 22},
                {4, "Alice Williams", 28},
                {5, "Charlie Brown", 35},
                {6, "Eva Davis", 26},
                {7, "Frank Wilson", 32},
                // Add more data as needed
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Create pagination controls
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updateTable();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalPages = (int) Math.ceil((double) tableModel.getRowCount() / rowsPerPage);
                if (currentPage < totalPages) {
                    currentPage++;
                    updateTable();
                }
            }
        });

        // Set layout and add components
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel paginationPanel = new JPanel();
        paginationPanel.add(prevButton);
        paginationPanel.add(new JLabel("Page " + currentPage));
        paginationPanel.add(nextButton);

        add(paginationPanel, BorderLayout.SOUTH);
    }

private void updateTable() {
    int startIndex = (currentPage - 1) * rowsPerPage;
    int endIndex = Math.min(startIndex + rowsPerPage, tableModel.getRowCount());

    tableModel.setRowCount(0); // Clear existing rows

    for (int i = startIndex; i < endIndex; i++) {
        Vector<Object> rowData = (Vector<Object>) tableModel.getDataVector().elementAt(i);
        tableModel.addRow(rowData);
    }

    // Update page label
    ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(1)).setText("Page " + currentPage);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new table().setVisible(true);
        });
    }
}