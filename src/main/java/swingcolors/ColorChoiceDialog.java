package swingcolors;

import javax.swing.*;
import java.awt.*;

public class ColorChoiceDialog extends JDialog {
    public ColorChoiceDialog(ColorChoicePanel panel){
        super();
        this.setTitle("Hello Color");
        this.setSize(300, 200);
        this.add(panel);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation(screenWidth / 3, screenHeight / 3);
    }
}
