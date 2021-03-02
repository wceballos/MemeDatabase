package MemeDatabase;

import javax.swing.JFileChooser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileImporter {

    public static String importMeme () {

        JFileChooser chooser = new JFileChooser();
        try {
            int returnVal = chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            FileInputStream fileIn = new FileInputStream(file);
            String fileName = file.getName();
            String fileNameParts[] = fileName.split(".");
            FileOutputStream fileOut = new FileOutputStream("memes/"+file.getName());
            int n;
            while ((n = fileIn.read()) != -1) {
                fileOut.write(n);
            }
            fileIn.close();
            fileOut.close();
            return "memes/"+file.getName();
        } catch (IOException e) {
            System.err.println("An error occured importing file!");
            return null;
        }

    }

}
