import org.junit.Test;
import swingcolors.ColorComboBoxModel;
import swingcolors.NamedColor;

import javax.swing.*;
import java.awt.Color;

import static junit.framework.Assert.assertEquals;

public class ColorListModelTest {

    @Test
    public void testListOfColors(){
        ColorComboBoxModel lm = new ColorComboBoxModel();
        lm.addElement("Red 0xFF0000");
        lm.addElement("Blue 0x0000FF");
        assertEquals(2, lm.getSize());
        assertEquals(new NamedColor("Red",Color.red), lm.getElementAt(0));
        assertEquals(new NamedColor("Blue",Color.blue), lm.getElementAt(1));
    }

    @Test
    public void testBadColors(){
        ColorComboBoxModel lm = new ColorComboBoxModel();
        try {
            lm.addElement("dsfdffsd");
            throw new AssertionError("should have barfed");
        } catch (UnsupportedOperationException e) {
            assertEquals("dsfdffsd not a color", e.getMessage());
        }
    }
}
