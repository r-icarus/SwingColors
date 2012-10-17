package swingcolors;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;
import org.picocontainer.injectors.CompositeInjection;
import org.picocontainer.injectors.ConstructorInjection;
import org.picocontainer.injectors.MethodInjection;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MutablePicoContainer pico = new DefaultPicoContainer(new CompositeInjection(new ConstructorInjection(),
                new MethodInjection("setRenderer")));
        pico.addComponent(ColorComboBoxModel.class, new ColorFileReader().makeColorListModelFromFile("colors.txt"));
        pico.addComponent(ColorFileWriter.class);
        pico.addComponent(ColorComboBox.class);
        pico.addComponent(ColorComboBoxRenderer.class);
        pico.addComponent(ColorChoicePanel.class);

        JFrame frame = new JFrame("hello");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(pico.getComponent(ColorChoicePanel.class));
        frame.setVisible(true);

    }

}
