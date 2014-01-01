package imagebrowser.control;

import imagebrowser.ui.abstractInterface.ImageViewer;

public class NextImageCommand extends ImageControl{
    
    public NextImageCommand(ImageViewer viewer){
        super(viewer);
    }
    
    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getNextImage());
    }

}
