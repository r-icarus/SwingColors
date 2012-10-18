package swingcolors;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ColorFrame extends JFrame {

    private JButton editButton = new JButton("Edit");
    private JLabel colorLabel;
    private ColorFrameModel cfm;
    private JPanel panel;

    public ColorFrame(ColorFrameModel cfm) {
        this.cfm = cfm;

        panel = new JPanel();
        colorLabel = new ColorComboBoxRenderer(cfm.getSelectedColor());
        panel.add(colorLabel, BorderLayout.CENTER);
        panel.add(editButton, BorderLayout.SOUTH);
        this.setSize(400, 400);
        this.add(panel);
    }

    public JLabel getColorLabel(){
        return colorLabel;
    }

    public JButton getEditButton(){
        return editButton;
    }

    public void refresh(){
        panel.remove(colorLabel);
        panel.remove(editButton);
        colorLabel = new ColorComboBoxRenderer(cfm.getSelectedColor());
        panel.add(colorLabel,BorderLayout.CENTER);
        panel.add(editButton, BorderLayout.SOUTH);
        this.pack();
        this.setSize(400, 400);
    }

}
