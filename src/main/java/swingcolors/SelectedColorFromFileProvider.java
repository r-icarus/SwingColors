package swingcolors;

import java.awt.*;
import java.io.IOException;

public class SelectedColorFromFileProvider extends AbstractFromFileProvider {

    public NamedColor provide(String selectedColorFileName) throws IOException {
        String[] colorString = super.getStringFromFile(selectedColorFileName).trim().split(" ");
        return new NamedColor(colorString[0], Color.decode(colorString[1]));
    }
}
