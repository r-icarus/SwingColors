import org.junit.Test;
import swingcolors.ColorComboBoxRenderer;
import swingcolors.NamedColor;

import javax.swing.*;
import java.awt.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ColorComboBoxRendererTest {

    @Test
    public void create_should_return_a_label_with_name_and_color(){
        NamedColor color = new NamedColor("Black", Color.black);
        JLabel renderer = new ColorComboBoxRenderer(color);
        assertEquals("Black", renderer.getText());
    }

    @Test
    public void get_list_cell_rendered_should_return_a_label_with_name_and_color(){
        JList list = mock(JList.class);
        NamedColor color = new NamedColor("Black", Color.black);
        ColorComboBoxRenderer renderer = new ColorComboBoxRenderer();
        JLabel label = (JLabel) renderer.getListCellRendererComponent(list,color,0,false,false);
        assertEquals("Black", label.getText());
    }
}
