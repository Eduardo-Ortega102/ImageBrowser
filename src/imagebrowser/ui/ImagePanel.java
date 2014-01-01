package imagebrowser.ui;

import imagebrowser.ui.abstractInterface.ImageViewer;
import imagebrowser.model.Image;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public final class ImagePanel extends JPanel implements ImageViewer {

    private Image image;
    private int imageWidth;
    private int imageHeight;
    private int offset;
    private int initialX;

    public ImagePanel(Image image) {
        super();
        offset = 0;
        this.setImage(image);
        this.createTouchScreenVersion();
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        clearPanel(g);
        checkBounds((java.awt.Image) image.getBitmap().getImage());

        g.drawImage((java.awt.Image) image.getBitmap().getImage(), offset, 0,
                imageWidth, imageHeight, null);
    }

    private void clearPanel(Graphics g) {
        super.paint(g);
    }

    private void checkBounds(java.awt.Image img) {
        this.imageWidth = (img.getWidth(null) > this.getWidth()) ? this.getWidth() : img.getWidth(null);
        this.imageHeight = (img.getHeight(null) > this.getHeight()) ? this.getHeight() : img.getHeight(null);
    }

    @Override
    public Image getImage() {
        return image;
    }

    private void createTouchScreenVersion() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                offset = e.getX() - initialX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                initialX = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boolean run = true;
                if(offset > ((java.awt.Image) image.getBitmap().getImage()).getWidth(null) / 2){
                    setImage(image.getPrevImage());
                    run = false;
                }
                if(offset < -((java.awt.Image) image.getBitmap().getImage()).getWidth(null) / 2){
                    setImage(image.getNextImage());
                    run = false;
                }
                offset = 0;
                if (run) repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
