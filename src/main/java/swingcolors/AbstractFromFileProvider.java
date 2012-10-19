package swingcolors;

import org.picocontainer.injectors.ProviderAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AbstractFromFileProvider extends ProviderAdapter {

    protected String getStringFromFile(String fileName) throws IOException {
        BufferedReader in = null;
        StringBuilder namedAndHexColors = new StringBuilder();
        try{
            in = new BufferedReader(new FileReader(fileName));
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

    @Override
    protected boolean useNames() {
        return true;
    }
}
