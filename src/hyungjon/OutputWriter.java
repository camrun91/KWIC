package hyungjon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder;
import java.util.ArrayList;

/**
 * 
 * @author HyungJon
 *
 * Prints all constructed and sorted circular shifts to output file and opens it
 */
public class OutputWriter {
    
    String filename;
    ArrayList<String> output;
    
    public OutputWriter(String filename, ArrayList<String> output) {
        this.filename = filename;
        this.output = output;
    }
    
    public void writeToFile() {
       try {
           File file = new File(filename);
           FileOutputStream fos = new FileOutputStream(file);
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
           
           for (String circularShift : output) {
               bw.write(circularShift);
               bw.newLine();
           }
           
           bw.close();
           openOutputFile();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    
    public void openOutputFile() {
        try {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", filename);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
