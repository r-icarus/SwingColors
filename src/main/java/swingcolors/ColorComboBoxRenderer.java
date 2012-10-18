package swingcolors;

import javax.swing.*;
import java.awt.*;

public class ColorComboBoxRenderer extends JLabel implements ListCellRenderer {

    public ColorComboBoxRenderer(){
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }

    public ColorComboBoxRenderer(final NamedColor color){
        super(color.getName(), new Icon() {
            @Override
            public void paintIcon(Component component, Graphics graphics, int x, int y) {
                graphics.setColor(color.getCol());
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
        if (value == null) {
            setText("No selection");
            return this;
        }

        JLabel label = new ColorComboBoxRenderer(selectedColor);
        label.setPreferredSize(new Dimension(100,20));
        return label;
    }
}
