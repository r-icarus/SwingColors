package swingcolors;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ColorFileWriter {

    public void writeColorToFile(Color color, String filename) throws IOException {
        FileWriter fstream = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(fstream);
        String hexString = Integer.toHexString(color.getRGB());
        out.write("0x"+hexString.substring(2).toUpperCase());
        out.close();
    }
}
