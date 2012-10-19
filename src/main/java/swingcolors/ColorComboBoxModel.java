package swingcolors;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class ColorComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private final ArrayList<NamedColor> namedColors = new ArrayList<NamedColor>();
    ColorFrameModel crom;

    public ColorComboBoxModel(NamedColor[] colors, ColorFrameModel cfm) {
        Collections.addAll(namedColors, colors);
        this.crom = cfm;
        setSelectedItem(cfm.getSelectedColor());
    }

    public void save() {
        crom.setSelectedColor((NamedColor)getSelectedItem());
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