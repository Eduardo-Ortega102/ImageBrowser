package imagebrowser.model;

public interface Image {

    public Image getNextImage();

    public void setNextImage(Image image);

    public Image getPrevImage();

    public void setPrevImage(Image image);

    public Bitmap getBitmap();
}
