package imagebrowser.persistence;

import imagebrowser.persistence.abstractInterface.BitmapFactory;
import imagebrowser.persistence.abstractInterface.ImageLoader;
import imagebrowser.model.Image;
import imagebrowser.model.RealImage;

public class FileImageLoader implements ImageLoader {

    private String filename;
    private BitmapFactory factory;

    public FileImageLoader(String filename, BitmapFactory factory) {
        this.filename = filename;
        this.factory = factory;
    }

    @Override
    public Image load() {
        return new RealImage(factory.createBitmap(filename));
    }
}
