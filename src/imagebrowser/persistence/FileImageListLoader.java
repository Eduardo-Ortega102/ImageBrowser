package imagebrowser.persistence;

import imagebrowser.model.Image;
import imagebrowser.persistence.abstractInterface.BitmapCreator;
import imagebrowser.persistence.abstractInterface.ImageListLoader;
import java.io.File;
import java.util.*;

public class FileImageListLoader implements ImageListLoader {

    private final String path;
    private final BitmapCreator creator;
    private final ArrayList<String> formatList;

    public FileImageListLoader(String path, BitmapCreator creator) {
        this.path = path;
        this.creator = creator;
        this.formatList = new ArrayList<>(Arrays.asList(new String[]{
            ".bmp", ".dib", ".jpg", ".jpeg", ".jpe", ".jfif", ".png"}));
    }

    @Override
    public Image[] load() {
        File folder = new File(path);
        String[] fileNameList = createFileNameList(folder.listFiles(), new ArrayList<String>());
        return linkImages(createProxies(fileNameList));
    }

    private String[] createFileNameList(File[] fileList, ArrayList<String> arrayList) {
        for (File file : fileList) {
            int index = file.getName().lastIndexOf(".");
            if (index > -1)
                if (formatList.contains(file.getName().substring(index)))
                    arrayList.add(file.getName());
        }
        return arrayList.toArray(new String[0]);
    }

    private ProxyImage[] createProxies(String[] fileNameList) {
        ProxyImage[] proxyList = new ProxyImage[fileNameList.length];
        for (int index = 0; index < proxyList.length; index++)
            proxyList[index] = new ProxyImage(new FileImageLoader(path + "\\" + fileNameList[index], creator));
        return proxyList;
    }

    private Image[] linkImages(ProxyImage[] images) {
        for (int i = 0; i < images.length; i++) {
            images[i].setNextImage(images[(i + 1) % images.length]);
            images[i].setPrevImage(images[(i - 1 + images.length) % images.length]);
        }
        return images;
    }
}
