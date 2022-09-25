
package rendertabla;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class renderFoto extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            return lbl;
        }
        return this;
        
    }
    
}
