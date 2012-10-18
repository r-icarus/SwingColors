package swingcolors;

import java.io.IOException;

public class ColorFrameModel {
    private NamedColor selectedColor;
    private SelectedColorFileWriter colorFileWriter;

    public ColorFrameModel(NamedColor defaultSelectedColor, SelectedColorFileWriter colorFileWriter){
        this.selectedColor = defaultSelectedColor;
        this.colorFileWriter = colorFileWriter;
    }

    public NamedColor getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(NamedColor selectedColor) {
        this.selectedColor = selectedColor;
        try{
            colorFileWriter.writeColorToFile(getSelectedColor());
        }catch (IOException e){
            e.printStackTrace();
            //Log file exception
        }
    }
}
