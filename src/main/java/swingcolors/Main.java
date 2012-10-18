package swingcolors;

import org.picocontainer.Characteristics;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.injectors.CompositeInjection;
import org.picocontainer.injectors.ConstructorInjection;
import org.picocontainer.injectors.MethodInjection;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final DefaultPicoContainer pico = new DefaultPicoContainer(
                new Caching().wrap(
                        new CompositeInjection(new ConstructorInjection(),
                        new MethodInjection("setRenderer"))
                )
        );
        pico.change(Characteristics.USE_NAMES);
        pico.addConfig("defaultSelectedColor", new ColorComboBoxModel(new NamedAndHexColorsFromFileProvider("chosen_color.txt").provide()).getElementAt(0));
        pico.addConfig("selectedColorFileName", "chosen_color.txt");
        pico.addAdapter(new NamedAndHexColorsFromFileProvider("colors.txt"));
        pico.addComponent(SelectedColorFileWriter.class);
        pico.addComponent(ColorComboBox.class);
        pico.addComponent(ColorComboBoxModel.class);
        pico.addComponent(ColorFrameModel.class);
        pico.addComponent(ColorComboBoxRenderer.class);
        pico.addComponent(ColorChoicePanel.class);
        pico.addComponent(ColorChoiceDialog.class);
        pico.addComponent(ColorFrame.class);

        final ColorFrame frame = pico.getComponent(ColorFrame.class);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                final ColorChoiceDialog dialog = pico.getComponent(ColorChoiceDialog.class);
                dialog.setVisible(true);

                dialog.getPanel().getOkButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent){
                        pico.getComponent(ColorComboBoxModel.class).save();
                        dialog.setVisible(false);
                        frame.refresh();
                    }

                });
                dialog.getPanel().setCancelButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        dialog.setVisible(false);
                    }
                });
            }
        });


    }

}
