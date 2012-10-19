import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.ColorFrameModel;
import swingcolors.SelectedColorFileWriter;
import swingcolors.NamedColor;
import static org.mockito.Mockito.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ColorFileWriterTest {

    @Test
    public void writing_one_color_to_file() throws IOException {
        String filename = "chosen_color_test.txt";
        ColorFrameModel mockCFM = mock(ColorFrameModel.class);
        ColorComboBoxModel comboBoxModel = new ColorComboBoxModel(new NamedColor[] { new NamedColor("Red", Color.red),
                new NamedColor("Blue", Color.blue) }, mockCFM);
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        new SelectedColorFileWriter(filename).writeColorToFile((NamedColor) comboBoxModel.getSelectedItem());
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str = in.readLine();
        assertEquals(str,"Red 0xFF0000");
    }
}
