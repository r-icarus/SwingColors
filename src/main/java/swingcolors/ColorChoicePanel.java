package swingcolors;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class ColorChoicePanel extends JPanel {
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");

    public ColorChoicePanel(ColorComboBox ccb){
        this.add(ccb, BorderLayout.CENTER);
        this.add(okButton, BorderLayout.SOUTH);
        this.add(cancelButton, BorderLayout.SOUTH);
    }

    public JButton getOkButton(){
        return okButton;
    }

    public JButton setCancelButton(){
        return cancelButton;
    }
}
