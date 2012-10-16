package swingcolors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final ColorFileWriter colorFileWriter = new ColorFileWriter();
        final ColorComboBoxModel ccbm = new ColorFileReader().makeColorListModelFromFile("colors.txt");
        ColorComboBox ccb = new ColorComboBox(ccbm);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                try{
                    NamedColor currentColor = (NamedColor)ccbm.getSelectedItem();
                    if(currentColor != null){
                        colorFileWriter.writeColorToFile(currentColor, "chosen_color.txt");
                    }
                }catch (IOException e){
                    JOptionPane.showConfirmDialog(null,"Could not save file.","Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        ColorComboBoxRenderer colorComboBoxRenderer = new ColorComboBoxRenderer();
        ccb.setRenderer(colorComboBoxRenderer);
        JPanel panel = new JPanel();
        panel.add(ccb, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);
        JFrame frame = new JFrame("hello");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

    }
}
