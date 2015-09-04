package jerrold;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Jerrold
 *
 * Reads and stores all lines in CoreData, without knowing what the contents are
 */
public class InputReader {
    
    ArrayList<String> lines;
    String filename;
    CoreData core;
    
    public InputReader(CoreData core) {
    	this.core = core;
        this.filename = core.getInput();
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
            core.setLines(lines);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
