package swingcolors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SelectedColorFileWriter {

    private final String filename;

    public SelectedColorFileWriter(String selectedColorFileName) {
        this.filename = selectedColorFileName;
    }

    public void writeColorToFile(NamedColor color) throws IOException {
        FileWriter fstream = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(fstream);
        String hexString = Integer.toHexString(color.getCol().getRGB());
        out.write(color.getName() + " ");
        out.write("0x" + hexString.substring(2).toUpperCase());
        out.close();
    }
}
