package imagebrowser.persistence.abstractInterface;

import imagebrowser.model.Bitmap;

public interface BitmapCreator<Parameter> {

    public Bitmap create(Parameter input);
}
