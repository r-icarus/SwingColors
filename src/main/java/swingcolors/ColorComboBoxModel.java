package swingcolors;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class ColorComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private ArrayList<NamedColor> namedColors = new ArrayList<NamedColor>();

    public void addElement(Object o) {
        NamedColor col;
        try{
            String values[] = o.toString().split(" ");
            col =new NamedColor(values[0],Color.decode(values[1]));
        }
            catch(NumberFormatException e){
            throw new UnsupportedOperationException(o + " not a color");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new UnsupportedOperationException(o + " not a color");
        }
        namedColors.add(col);
    }

    public Object getSelectedItem(){
        return selectedItem;
    }

    public void setSelectedItem(Object anItem) {
        this.selectedItem = anItem;
    }


    @Override
    public int getSize() {
        return namedColors.size();
    }

    @Override
    public Object getElementAt(int i) {
        return namedColors.get(i);
    }
}