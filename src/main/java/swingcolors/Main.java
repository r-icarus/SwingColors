package swingcolors;

import org.picocontainer.Characteristics;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.injectors.CompositeInjection;
import org.picocontainer.injectors.ConstructorInjection;
import org.picocontainer.injectors.MethodInjection;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DefaultPicoContainer pico = new DefaultPicoContainer(new CompositeInjection(new ConstructorInjection(),
                new MethodInjection("setRenderer")));
        pico.change(Characteristics.USE_NAMES);
        pico.addConfig("selectedColorFileName", "chosen_color.txt");
        pico.addAdapter(new NamedAndHexColorsFromFileProvider("colors.txt"));
        pico.addComponent(SelectedColorFileWriter.class);
        pico.addComponent(ColorComboBox.class);
        pico.addComponent(ColorComboBoxModel.class);
        pico.addComponent(ColorComboBoxRenderer.class);
        pico.addComponent(ColorChoicePanel.class);
        pico.addComponent(ColorChoiceDialog.class);

        JDialog dialog   = pico.getComponent(ColorChoiceDialog.class);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

}
