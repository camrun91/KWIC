package hyungjon;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author HyungJon
 *
 * Reads and stores all lines, without knowing what the contents are
 */
public class InputReader {
    
    ArrayList<String> lines;
    String filename;
    
    public InputReader(String filename) {
        this.filename = filename;
        lines = new ArrayList<>();
    }
    
    /**
     * Reads file and stores all lines into ArrayList
     * 
     * @param filename name of input file
     * @return         ArrayList containing all lines
     */
    protected void readFile() {
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected String getLine(int index) {
        return lines.get(index);
    }
    
    protected int getLineCount() {
        return lines.size();
    }

}
