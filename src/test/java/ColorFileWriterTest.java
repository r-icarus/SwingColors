import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.SelectedColorFileWriter;
import swingcolors.NamedColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ColorFileWriterTest {

    @Test
    public void writing_one_color_to_file() throws IOException {
        String filename = "chosen_color.txt";
        ColorComboBoxModel comboBoxModel = new ColorComboBoxModel("Red 0xFF0000\nBlue 0x0000FF\nGreen 0x00FF00");
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        new SelectedColorFileWriter(filename).writeColorToFile((NamedColor) comboBoxModel.getSelectedItem());
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str = in.readLine();
        assertEquals(str,"Red 0xFF0000");
    }
}
