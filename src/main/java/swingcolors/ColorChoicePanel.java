package swingcolors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ColorChoicePanel extends JPanel {
    public ColorChoicePanel(ColorComboBox ccb, final ColorComboBoxModel ccbm, final ColorFileWriter colorFileWriter) {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                try{
                    NamedColor currentColor = (NamedColor) ccbm.getSelectedItem();
                    if(currentColor != null){
                        colorFileWriter.writeColorToFile(currentColor, "chosen_color.txt");
                    }
                }catch (IOException e){
                    JOptionPane.showConfirmDialog(null,"Could not save file.","Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        this.add(ccb, BorderLayout.CENTER);
        this.add(saveButton, BorderLayout.SOUTH);
    }
}
