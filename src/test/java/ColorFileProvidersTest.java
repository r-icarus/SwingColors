import org.junit.Test;
import swingcolors.ColorsFromFileProvider;
import swingcolors.NamedColor;
import swingcolors.SelectedColorFromFileProvider;

import java.awt.*;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ColorFileProvidersTest {
    @Test
    public void should_read_a_test_file_and_return_colors() throws IOException{
        ColorsFromFileProvider provider = new ColorsFromFileProvider();
        NamedColor[] colors = provider.provide("colors_test.txt");
        assertEquals(8, colors.length);
    }

    @Test
    public void should_read_a_color_from_a_file() throws IOException {
        SelectedColorFromFileProvider provider = new SelectedColorFromFileProvider();
        NamedColor color = provider.provide("chosen_color_test.txt");
        assertEquals(Color.red,color.getCol());
    }
}
