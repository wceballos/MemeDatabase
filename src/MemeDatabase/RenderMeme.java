package MemeDatabase;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RenderMeme {

    /**
     * This class will be responsible for rendering the meme
     * All memes in the system will be present in the meme folder
     * Memes are given a file name of <meme_id>.<type>
     */

    /**
     * @param location file path to the meme
     */
    public static void render (String location) {
        ImageIcon img = fetchImage(location);
        JLabel label = new JLabel(img);
        
        JFrame imageFrame = new JFrame();
        imageFrame.add(label);
        imageFrame.setVisible(true);
    }

    /**
     * Helper method that fetched the image and stores into an ImageIcon
     * @param location file parth to the meme
     */
    private static ImageIcon fetchImage (String location) {
        ImageIcon img = new ImageIcon(location);
        return img;
    }
}
