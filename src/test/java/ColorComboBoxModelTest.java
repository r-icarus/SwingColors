import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.ColorFrameModel;
import swingcolors.NamedColor;
import swingcolors.SelectedColorFileWriter;

import java.awt.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ColorComboBoxModelTest {
    @Test
    public void save_should_change_the_color_frame_model(){
        ColorFrameModel cfm = new ColorFrameModel(new NamedColor("Black",Color.black),mock(SelectedColorFileWriter.class));
        ColorComboBoxModel comboBoxModel = new ColorComboBoxModel(new NamedColor[]
                {new NamedColor("Blue", Color.blue), new NamedColor("Red",Color.red)},cfm);
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        comboBoxModel.save();
        assertEquals(comboBoxModel.getSelectedItem(),cfm.getSelectedColor());
    }
}
