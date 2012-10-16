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

    @Override
    public boolean equals(Object o){
        NamedColor other = (NamedColor)o;
        if(this.getCol() != null && this.getName() != null && other != null)
            return (this.getCol().equals(other.getCol()) && this.getName().equals(other.getName()));
        else
            return false;
    }
}
