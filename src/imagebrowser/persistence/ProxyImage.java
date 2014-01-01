package imagebrowser.persistence;

import imagebrowser.persistence.abstractInterface.ImageLoader;
import imagebrowser.model.Bitmap;
import imagebrowser.model.Image;

public class ProxyImage implements Image {

    private Image prevImage;
    private Image actualImage;
    private Image nextImage;
    private ImageLoader loader;

    public ProxyImage(ImageLoader loader) {
        this.actualImage = null;
        this.loader = loader;
    }

    @Override
    public Image getNextImage() {
        return nextImage;
    }

    @Override
    public void setNextImage(Image image) {
        this.nextImage = image;
    }

    @Override
    public Image getPrevImage() {
        return prevImage;
    }

    @Override
    public void setPrevImage(Image image) {
        this.prevImage = image;
    }

    @Override
    public Bitmap getBitmap() {
        if (this.actualImage == null) this.actualImage = loader.load();
        return this.actualImage.getBitmap();
    }
}
