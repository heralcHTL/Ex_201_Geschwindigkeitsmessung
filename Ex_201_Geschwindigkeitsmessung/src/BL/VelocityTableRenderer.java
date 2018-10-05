/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Richard Hofmeister
 */
public class VelocityTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Measurement m = (Measurement) value;
        JLabel label = new JLabel();
        label.setOpaque(true);    
        label.setBackground(m.getBackground());
        label.setForeground(Color.white);
        
        switch(column)
        {
            case 0: label.setText(m.getDatum().toString()); break;
            case 1: label.setText(m.getUhrzeit().toString()); break;
            case 2: label.setText(m.getKennzeichen()); break;
            case 3: label.setText(m.getGemessen()+""); break;
            case 4: label.setText(m.getErlaubt()+""); break;
            case 5: label.setText((m.getGemessen()-m.getErlaubt())+""); break;
        }
        
        return label;
    }
    
}
