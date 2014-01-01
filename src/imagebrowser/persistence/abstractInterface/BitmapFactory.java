package imagebrowser.persistence.abstractInterface;

import imagebrowser.model.Bitmap;

public interface BitmapFactory<Parameter> {

    public Bitmap createBitmap(Parameter input);
}
