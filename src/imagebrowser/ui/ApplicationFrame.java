package imagebrowser.ui;

import imagebrowser.ui.abstractInterface.ActionListenerFactory;
import imagebrowser.ui.abstractInterface.ImageViewer;
import imagebrowser.model.Image;
import java.awt.*;
import javax.swing.*;

public class ApplicationFrame extends JFrame {

    private ImageViewer viewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(Image image, ActionListenerFactory factory) throws HeadlessException {
        super("Image Browser");
        this.factory = factory;
//        this.setPreferredSize(getDimension());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents(image);
        this.setVisible(true);
        this.pack();
    }

    private Dimension getDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension((int) (screenSize.width / 1.1), (int) (screenSize.height / 1.1));
    }

    private void createComponents(Image image) {
        this.addBorderPanels(new JPanel(), new JPanel(), new JPanel());
        this.add(createImageViewer(image), BorderLayout.CENTER);
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    private void addBorderPanels(JPanel panel1, JPanel panel2, JPanel panel3) {
//        panel1.setBackground(Color.red);
//        panel2.setBackground(Color.black);
//        panel3.setBackground(Color.yellow);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.EAST);
        this.add(panel3, BorderLayout.WEST);
    }

    private ImagePanel createImageViewer(Image image) {
        ImagePanel panel = new ImagePanel(image);
        this.viewer = panel;
        return panel;
    }

    private JPanel createToolBar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(createButton("PrevImage", "Prev"));
        panel.add(createButton("NextImage", "Next"));
        return panel;
    }

    private JButton createButton(String action, String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.createActionListener(action));
        return button;
    }

    public ImageViewer getViewer() {
        return viewer;
    }
}
