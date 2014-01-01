package imagebrowser.model;

public class RealImage implements Image {

    private Bitmap bitMap;

    public RealImage(Bitmap bitmap) {
        bitMap = bitmap;
    }

    @Override
    public RealImage getNextImage() {
        return null;
    }

    @Override
    public void setNextImage(Image nextImage) {
    }

    @Override
    public RealImage getPrevImage() {
        return null;
    }

    @Override
    public void setPrevImage(Image prevImage) {
    }

    @Override
    public Bitmap getBitmap() {
        return bitMap;
    }
}
