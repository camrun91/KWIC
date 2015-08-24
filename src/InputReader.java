
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    
    ArrayList<String> lines = new ArrayList<>();
    // Stores all lines without knowing the contents. Knowledge of contents is for DataStorage.
    
    public InputReader(String filename) {
        readFile(filename);
    }
    
    /**
     * Reads file
     * 
     * @param filename name of input file
     * @return         arraylist containing all lines
     */
    public void readFile(String filename) {
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
    
    public ArrayList<String> getLines() {
        return lines;
    }
    
    public String getLine(int index) {
        return lines.get(index);
    }
    
    public int getLineCount() {
        return lines.size();
    }

}
