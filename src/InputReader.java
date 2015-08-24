
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    
    ArrayList<String> input;
    
    public InputReader(String filename) {
        input = readFile(filename);
    }
    
    /**
     * Reads file
     * 
     * @param filename name of input file
     * @return         arraylist containing all lines
     */
    public ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
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
        
        return lines;
    }
    
    public ArrayList<String> getIgnoreWords() {
        String ignore = input.get(0);
        return new ArrayList<String>(Arrays.asList(ignore.split(" ")));
    }
    
    public ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            titles.add(input.get(i));
        }
        return titles;
    }

}
