package swingcolors;

import org.picocontainer.injectors.ProviderAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NamedAndHexColorsFromFileProvider extends ProviderAdapter {

    private final String colorsTextFileName;

    public NamedAndHexColorsFromFileProvider(String colorsTextFileName) {
        this.colorsTextFileName = colorsTextFileName;
    }

    // TODO pass colorsTextFileName in here, rather than constructor
    public String provide() throws IOException {
        BufferedReader in = null;
        StringBuilder namedAndHexColors = new StringBuilder();
        try{
            in = new BufferedReader(new FileReader(colorsTextFileName));
            String str;
            while((str = in.readLine()) != null){
                namedAndHexColors.append(str).append("\n");
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return namedAndHexColors.toString();
    }
}
