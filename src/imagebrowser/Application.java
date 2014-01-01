package imagebrowser;

import imagebrowser.control.Command;
import imagebrowser.control.NextImageCommand;
import imagebrowser.control.PrevImageCommand;
import imagebrowser.model.Bitmap;
import imagebrowser.model.Image;
import imagebrowser.persistence.abstractInterface.BitmapFactory;
import imagebrowser.persistence.FileImageListLoader;
import imagebrowser.persistence.abstractInterface.ImageListLoader;
import imagebrowser.ui.ApplicationFrame;
import imagebrowser.ui.SwingBitmap;
import imagebrowser.ui.abstractInterface.ActionListenerFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Application {

    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private static HashMap<String, Command> commandMap;

    public static void main(String[] args) {
        ImageListLoader loader = createImageListLoader();
        ApplicationFrame frame = createApplicationFrame(loader.load()[0]);
        createCommands(frame);
    }

    private static ImageListLoader createImageListLoader() {
        return new FileImageListLoader(PATH, new BitmapFactory<String>() {
            @Override
            public Bitmap createBitmap(String input) {
                System.out.println("creando: " + input);
                return new SwingBitmap(input);
            }
        });
    }

    private static ApplicationFrame createApplicationFrame(Image image) {
        return new ApplicationFrame(image, new ActionListenerFactory() {
            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action);
                        if (command != null) command.execute();
                    }
                };
            }
        });
    }

    private static void createCommands(ApplicationFrame frame) {
        commandMap = new HashMap<>();
        commandMap.put("NextImage", new NextImageCommand(frame.getViewer()));
        commandMap.put("PrevImage", new PrevImageCommand(frame.getViewer()));
    }
}
