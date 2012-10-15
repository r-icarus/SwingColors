package swingcolors;

import java.awt.Color;
import javax.swing.*;

public class ColorComboBoxModel extends DefaultComboBoxModel implements MutableComboBoxModel {

    private Object selectedItem;

    @Override
    public void addElement(Object o) {
        Color col;
        try{
            col = Color.decode(o.toString());
        }
            catch(NumberFormatException e){
            throw new UnsupportedOperationException(o + " not a color");
        }
        super.addElement(col);
    }

    public Object getSelectedItem(){
        return selectedItem;
    }

    public void setSelectedItem(Object anItem) {
        this.selectedItem = anItem;
    }



}