package swingcolors;

import java.awt.*;

public class NamedColor{

    private final String name;
    private final Color col;

    public NamedColor(String name, Color col) {
        this.name = name;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public Color getCol() {
        return col;
    }
}
