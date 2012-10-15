import org.junit.*;
import swingcolors.ColorComboBoxModel;
import swingcolors.ColorFileReader;
import swingcolors.ColorFileWriter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ColorFileWriterTest {

    @Test
    public void writing_one_color_to_file() throws IOException {
        String filename = "chosen_color.txt";
        ColorComboBoxModel comboBoxModel = new ColorFileReader().makeColorListModelFromFile("colors.txt");
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        new ColorFileWriter().writeColorToFile((Color) comboBoxModel.getSelectedItem(),filename);
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str = in.readLine();
        assertEquals(str,"0xFF0000");
    }
}
