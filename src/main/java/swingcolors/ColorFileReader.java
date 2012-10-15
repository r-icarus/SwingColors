package swingcolors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ColorFileReader {
    public ColorComboBoxModel makeColorListModelFromFile(String filename) throws IOException {
        ColorComboBoxModel comboBoxModel = new ColorComboBoxModel();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new FileReader(filename));
            String str;
            while((str = in.readLine()) != null){
                comboBoxModel.addElement(str.split(" ")[1]);
            }
        } finally {
            in.close();
        }

        return comboBoxModel;
    }
}
