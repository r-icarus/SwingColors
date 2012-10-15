import org.junit.Test;
import swingcolors.ColorComboBoxModel;

import javax.swing.*;
import java.awt.Color;

import static junit.framework.Assert.assertEquals;

public class ColorListModelTest {

    @Test
    public void testListOfColors(){

        DefaultComboBoxModel lm = new ColorComboBoxModel();
        lm.addElement("0xFF0000");
        lm.addElement("0x0000FF");
        assertEquals(2, lm.getSize());
        assertEquals(Color.red, lm.getElementAt(0));
        assertEquals(Color.blue, lm.getElementAt(1));
    }

    @Test
    public void testBadColors(){
        DefaultComboBoxModel lm = new ColorComboBoxModel();
        try {
            lm.addElement("dsfdffsd");
            throw new AssertionError("should have barfed");
        } catch (UnsupportedOperationException e) {
            assertEquals("dsfdffsd not a color", e.getMessage());
        }
    }
}
