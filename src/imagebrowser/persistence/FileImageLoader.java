package imagebrowser.persistence;

import imagebrowser.persistence.abstractInterface.BitmapCreator;
import imagebrowser.persistence.abstractInterface.ImageLoader;
import imagebrowser.model.Image;
import imagebrowser.model.RealImage;

public class FileImageLoader implements ImageLoader {

    private String filename;
    private BitmapCreator creator;

    public FileImageLoader(String filename, BitmapCreator creator) {
        this.filename = filename;
        this.creator = creator;
    }

    @Override
    public Image load() {
        return new RealImage(creator.create(filename));
    }
}
