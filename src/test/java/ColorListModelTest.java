import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.ColorFrameModel;
import swingcolors.NamedColor;

import java.awt.Color;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ColorListModelTest {

    @Test
    public void testListOfColors(){

        ColorFrameModel mockCFM = mock(ColorFrameModel.class);

        ColorComboBoxModel lm = new ColorComboBoxModel(new NamedColor[] { new NamedColor("Red", Color.red),
                new NamedColor("Blue", Color.blue) }, mockCFM);
        assertEquals(2, lm.getSize());
        assertEquals(new NamedColor("Red",Color.red), lm.getElementAt(0));
        assertEquals(new NamedColor("Blue",Color.blue), lm.getElementAt(1));
    }

}
