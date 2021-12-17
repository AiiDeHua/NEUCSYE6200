package edu.neu.csye6200.view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyButtonRender implements TableCellRenderer {
    private JPanel jPanel;
    private JButton jButton;

    public MyButtonRender() {
        initJPanel();
        initButton();
        jPanel.add(jButton);
    }

    private void initButton() {
        jButton = new JButton();
        jButton.setBounds(100, 4, 80, 30);
        jButton.addActionListener(e->{
            new StudentTable();
        });
    }

    private void initJPanel() {
        jPanel = new JPanel();
        jPanel.setLayout(null);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        jButton.setText("+");
        return jPanel;
    }
}