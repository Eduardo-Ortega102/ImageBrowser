package imagebrowser.control;

import imagebrowser.ui.abstractInterface.ImageViewer;

public abstract class ImageControl implements Command{
    protected final ImageViewer viewer;
    
    public ImageControl(ImageViewer viewer){
        this.viewer = viewer;
    }

    @Override
    public abstract void execute();

}
