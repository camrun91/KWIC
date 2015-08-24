
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.IOException;

public class OutputPrinter {
    
    ArrayList<String> circularShifts;
    
    public OutputPrinter(String filename, ArrayList<String> circularShifts) {
        this.circularShifts = circularShifts;
    }
    
    public void writeFile(String filename) {
        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (String shift : circularShifts) {
                bw.write(shift);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
