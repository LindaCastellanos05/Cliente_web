/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rendertabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Linda
 */
public class renderColorCeldas extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        
       /* if(celdaspares(row)){
            this.setBackground(Color.CYAN);
        }else{
            this.setBackground(Color.yellow);
        }*/
        double valorfila = Double.parseDouble(value.toString());
        if(valorfila>=70){
            this.setBackground(Color.GREEN);
        }else{
             this.setBackground(Color.YELLOW);
        }
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        return this;
    }
    
    public boolean celdaspares(int numero){
        if(numero%2==0){
            return true;
        }else{
            return false;
        }
    }
}
