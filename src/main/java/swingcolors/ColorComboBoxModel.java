package swingcolors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ColorComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private final ArrayList<NamedColor> namedColors = new ArrayList<NamedColor>();
    ColorFrameModel crom;

    public ColorComboBoxModel(String namedAndHexColors){
        addColorsAsElements(namedAndHexColors);
    }

    public ColorComboBoxModel(String namedAndHexColors, ColorFrameModel cfm) {
        addColorsAsElements(namedAndHexColors);
        this.crom = cfm;
        setSelectedItem(cfm.getSelectedColor());
    }

    public ColorComboBoxModel() {
    }

    public void save() {
        crom.setSelectedColor((NamedColor)getSelectedItem());
    }

    public void addElement(Object namedAndHexColor) {
        NamedColor col;
        try{
            String values[] = namedAndHexColor.toString().split(" ");
            col =new NamedColor(values[0],Color.decode(values[1]));
        } catch(NumberFormatException e){
            throw new UnsupportedOperationException(namedAndHexColor + " not a color");
        } catch(ArrayIndexOutOfBoundsException e){
            throw new UnsupportedOperationException(namedAndHexColor + " not a color");
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


    private void addColorsAsElements(String namedAndHexColors){
        for (String namedAndHexColor : namedAndHexColors.split("\n")) {
            addElement(namedAndHexColor);
        }
    }
}