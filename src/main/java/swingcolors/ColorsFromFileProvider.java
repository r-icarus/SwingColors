package swingcolors;

import java.awt.*;
import java.io.IOException;

public class ColorsFromFileProvider extends AbstractFromFileProvider {

    public NamedColor[] provide(String colorsFileName) throws IOException {
        String[] colorLinesString = super.getStringFromFile(colorsFileName).split("\n");
        NamedColor[] colors = new NamedColor[colorLinesString.length];
        for (int i = 0; i < colorLinesString.length; i++) {
            String[] colorString = colorLinesString[i].split(" ");
            colors[i] = new NamedColor(colorString[0], Color.decode(colorString[1]));
        }
        return colors;
    }
}
