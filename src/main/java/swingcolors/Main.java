package swingcolors;

import org.picocontainer.Characteristics;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
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

        final DefaultPicoContainer colorFrameContainer = new DefaultPicoContainer(
                new Caching().wrap(
                        new CompositeInjection(new ConstructorInjection(),
                        new MethodInjection("setRenderer"))
                )
        );
        colorFrameContainer.change(Characteristics.USE_NAMES);

        colorFrameContainer.addConfig("selectedColorFileName", "chosen_color.txt");
        colorFrameContainer.addConfig("colorsFileName", "colors.txt");
        colorFrameContainer.addAdapter(new ColorsFromFileProvider());
        colorFrameContainer.addAdapter(new SelectedColorFromFileProvider());
        colorFrameContainer.addComponent(SelectedColorFileWriter.class);
        colorFrameContainer.addComponent(ColorFrameModel.class);
        colorFrameContainer.addComponent(ColorComboBoxRenderer.class);
        colorFrameContainer.addComponent(ColorFrame.class);

        final ColorFrame frame = colorFrameContainer.getComponent(ColorFrame.class);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                final MutablePicoContainer colorChoiceContainer = colorFrameContainer.makeChildContainer();
                colorChoiceContainer.addComponent(ColorChoicePanel.class);
                colorChoiceContainer.addComponent(ColorChoiceDialog.class);
                colorChoiceContainer.addComponent(ColorComboBox.class);
                colorChoiceContainer.addComponent(ColorComboBoxModel.class);

                final ColorChoiceDialog dialog = colorChoiceContainer.getComponent(ColorChoiceDialog.class);
                dialog.setVisible(true);

                dialog.getPanel().getOkButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent){
                        colorChoiceContainer.getComponent(ColorComboBoxModel.class).save();
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
