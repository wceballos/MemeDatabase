import javax.swing.JFileChooser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileImporter {

    public static boolean import () {

        JFileChooser chooser = new JFileChooser(int meme_id);
        try {
            int returnVal = chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile():
            FileInputStream fileIn = new FileInputStream(file);
            String fileName = file.getName();
            String fileNameParts[] = fileName.split(".");
            FileOutputStream fileOut = new FileOutputStream(Integer.toString(meme_id) + "." + fileNameParts[1]);
            int n;
            while ((n = fileIn.read()) != -1) {
                fileOut.write(n);
            }
            fileIn.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            System.err.println("An error occured importing file!");
            return false;
        }

    }

}
