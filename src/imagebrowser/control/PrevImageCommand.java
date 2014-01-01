package imagebrowser.control;

import imagebrowser.ui.abstractInterface.ImageViewer;

public class PrevImageCommand extends ImageControl{
    
    public PrevImageCommand(ImageViewer viewer){
        super(viewer);
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getPrevImage());
    }

}
