import org.junit.Test;
import swingcolors.*;

import java.awt.*;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ColorFrameTest {

    @Test
    public void should_change_color_label_after_color_change() throws IOException {
        ColorFrameModel cfm = new ColorFrameModel(new NamedColor("Red",Color.red),mock(SelectedColorFileWriter.class));
        ColorFrame frame = new ColorFrame(cfm);
        assertEquals("Red",frame.getColorLabel().getText());
        cfm.setSelectedColor(new NamedColor("Blue",Color.blue));
        frame.refresh();
        assertEquals("Blue",frame.getColorLabel().getText());
    }
}
