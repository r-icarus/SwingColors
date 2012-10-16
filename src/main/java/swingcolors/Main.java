package swingcolors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ColorComboBoxModel lm = new ColorFileReader().makeColorListModelFromFile("colors.txt");
        final ColorComboBox ccb = new ColorComboBox(lm);
        JPanel panel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                try{
                    new ColorFileWriter().writeColorToFile((NamedColor)ccb.getSelectedItem(),"chosen_color.txt");
                }catch (IOException e){
                    JOptionPane.showConfirmDialog(null,"Could not save file.","Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        ccb.setRenderer(new ColorComboBoxRenderer());
        panel.add(ccb, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);
        JFrame frame = new JFrame("hello");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}
