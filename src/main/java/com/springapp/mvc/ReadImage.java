package com.springapp.mvc;

/**
 * Created by suruchi on 20/4/16.
 */
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReadImage
{
    public static Image imageRead() {
        Image image = null;
        try {
            URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);

        return image;
    }
}

