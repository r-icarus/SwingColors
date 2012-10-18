import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.NamedColor;

import java.awt.*;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ColorFileReaderTest {

    @Test
    public void reading_of_list_of_colors_from_file() throws IOException {
       ColorComboBoxModel comboBoxModel = new ColorComboBoxModel("Red 0xFF0000\nBlue 0x0000FF\nGreen 0x00FF00");
       assertEquals(3, comboBoxModel.getSize());
       assertEquals(new NamedColor("Red",Color.red), comboBoxModel.getElementAt(0));
       assertEquals(new NamedColor("Blue",Color.blue), comboBoxModel.getElementAt(1));
    }
}
