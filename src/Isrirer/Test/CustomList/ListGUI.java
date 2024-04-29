package Isrirer.Test.CustomList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListGUI extends JFrame {
    private List list = new List();

    public ListGUI() {
        setTitle("List Event Handling Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton addButton = new JButton("Add Element");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.addElement("New Element");
            }
        });

        list.addListChangeListener(new ListChangeListener() {
            @Override
            public void listChanged(ListChangeEvent event) {
                JOptionPane.showMessageDialog(ListGUI.this, "List size changed!");
            }
        });

        mainPanel.add(addButton, BorderLayout.NORTH);

        JTextArea listTextArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(listTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh List");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.elements.length; i++) {
                    sb.append(list.getElement(i)).append("\n");
                }
                listTextArea.setText(sb.toString());
            }
        });
        mainPanel.add(refreshButton, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListGUI().setVisible(true);
            }
        });
    }
}

