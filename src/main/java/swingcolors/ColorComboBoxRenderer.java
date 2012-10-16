package swingcolors;

import javax.swing.*;
import java.awt.*;

public class ColorComboBoxRenderer extends JLabel implements ListCellRenderer {

    public ColorComboBoxRenderer(){
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }


    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        final NamedColor selectedColor = ((NamedColor)value);
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        JLabel label = new JLabel(selectedColor.getName(), new Icon() {
            @Override
            public void paintIcon(Component component, Graphics graphics, int x, int y) {
                graphics.setColor(selectedColor.getCol());
                graphics.fillRect(x,y,getIconWidth(),getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 15;
            }

            @Override
            public int getIconHeight() {
                return 15;
            }
        }, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(100,20));

        return label;
    }
}
