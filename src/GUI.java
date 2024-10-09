//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class GUI {

    // Table for CDs
    private JTable cdTable;

    // Data model for CD details
    private JTextField cdTitleField;
    private JTextField cdAuthorField;
    private JTextField cdBarcodeField;

    // Log area
    private JTextArea logArea;

    // Data structures for binary tree, hashmap/hashset
    private HashMap<String, String> binaryTreeMap;  // Simplified
    private HashSet<String> binaryTreeSet;  // Simplified

    public GUI() {
        // Frame setup
        JFrame frame = new JFrame("Archive Control");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // LEFT SECTION: CD List
        JPanel leftPanel = new JPanel(new BorderLayout());
        String[] columnHeaders = {"Title", "Author", "Barcode"};
        Object[][] data = {{"CD1", "Author1", "123456"}, {"CD2", "Author2", "234567"}}; // Example data
        DefaultTableModel cdTableModel = new DefaultTableModel(data, columnHeaders);
        cdTable = new JTable(cdTableModel);

        // Add sorting functionality by title, author, barcode
        cdTable.setAutoCreateRowSorter(true);  // This allows sorting
        JScrollPane scrollPane = new JScrollPane(cdTable);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        // TOP RIGHT SECTION: CD Details and buttons
        JPanel topRightPanel = new JPanel(new GridLayout(4, 2));
        topRightPanel.add(new JLabel("Title:"));
        cdTitleField = new JTextField();
        topRightPanel.add(cdTitleField);

        topRightPanel.add(new JLabel("Author:"));
        cdAuthorField = new JTextField();
        topRightPanel.add(cdAuthorField);

        topRightPanel.add(new JLabel("Barcode:"));
        cdBarcodeField = new JTextField();
        topRightPanel.add(cdBarcodeField);

        JButton newItemButton = new JButton("New Item");
        JButton saveUpdateButton = new JButton("Save/Update");
        topRightPanel.add(newItemButton);
        topRightPanel.add(saveUpdateButton);

        // BOTTOM LEFT SECTION: Log and Binary Tree buttons
        JPanel bottomLeftPanel = new JPanel(new BorderLayout());
        logArea = new JTextArea(5, 30);
        logArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logArea);
        bottomLeftPanel.add(logScrollPane, BorderLayout.CENTER);

        JPanel binaryTreeButtonsPanel = new JPanel();
        JButton preOrderButton = new JButton("Pre-Order");
        JButton inOrderButton = new JButton("In-Order");
        JButton postOrderButton = new JButton("Post-Order");
        JButton graphicalButton = new JButton("Graphical");
        binaryTreeButtonsPanel.add(preOrderButton);
        binaryTreeButtonsPanel.add(inOrderButton);
        binaryTreeButtonsPanel.add(postOrderButton);
        binaryTreeButtonsPanel.add(graphicalButton);
        bottomLeftPanel.add(binaryTreeButtonsPanel, BorderLayout.SOUTH);

        // BOTTOM RIGHT SECTION: Automation buttons
        JPanel bottomRightPanel = new JPanel();
        JButton automationOption1 = new JButton("Automation 1");
        JButton automationOption2 = new JButton("Automation 2");
        JButton automationOption3 = new JButton("Automation 3");
        bottomRightPanel.add(automationOption1);
        bottomRightPanel.add(automationOption2);
        bottomRightPanel.add(automationOption3);

        // Adding panels to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(topRightPanel, BorderLayout.NORTH);
        frame.add(bottomLeftPanel, BorderLayout.SOUTH);
        frame.add(bottomRightPanel, BorderLayout.EAST);

        // Show frame
        frame.setVisible(true);

        // Event Listeners
        newItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cdTitleField.setText("");
                cdAuthorField.setText("");
                cdBarcodeField.setText("");
                logArea.append("New CD entry created.\n");
            }
        });

        saveUpdateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = cdTitleField.getText();
                String author = cdAuthorField.getText();
                String barcode = cdBarcodeField.getText();
                logArea.append("CD saved: " + title + " by " + author + " (Barcode: " + barcode + ").\n");
                // Add to binary tree or hash map as needed
            }
        });

        preOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logArea.append("Binary Tree traversal: Pre-Order.\n");
                // Binary tree traversal logic here
            }
        });

        // Add similar listeners for inOrderButton, postOrderButton, graphicalButton

        // Automation option buttons listeners (to be implemented)
    }

    public static void main(String[] args) {
        new GUI();
    }
}
