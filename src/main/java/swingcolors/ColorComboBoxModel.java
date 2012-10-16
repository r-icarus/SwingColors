package swingcolors;

import java.awt.Color;
import javax.swing.*;

public class ColorComboBoxModel extends DefaultComboBoxModel implements MutableComboBoxModel {

    private Object selectedItem;

    @Override
    public void addElement(Object o) {
        NamedColor col;
        try{
            String values[] = o.toString().split(" ");
            col =new NamedColor(values[0],Color.decode(values[1]));
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