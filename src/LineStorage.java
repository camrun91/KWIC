
import java.util.ArrayList;
import java.util.Arrays;

// Later distinguish between line and title
public class LineStorage {
    
    InputReader inputReader;
    ArrayList<Line> titles;
    ArrayList<String> linesString;
    
    public LineStorage(InputReader reader) {
        inputReader = reader;
        setupLines(inputReader.getTitles());
    }
    
    public void setupLines(ArrayList<String> linesString) {
        titles = new ArrayList<>();
        this.linesString = linesString;
        for (String lineString : this.linesString) {
            Line line = new Line(lineString);
            titles.add(line);
            System.out.println("Line: " + line.line);
        }
        
    }
    
    public int getLineCount() {
        return titles.size();
    }
    
    public Line getLine(int index) {
        return titles.get(index);
    }
    
    public String getLineString(int index) {
        return linesString.get(index);
    }

}

class Line {
    
    ArrayList<String> words;
    String line;
    
    public Line(String line) {
        this.line = line;
        words = separateWords(line);
    }
    
    public ArrayList<String> separateWords(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }
    
    public ArrayList<String> getWords() {
        return words;
    }
    
    public String getWord(int index) {
        return words.get(index);
    }
    
    public int getWordCount() {
        return words.size();
    }
}
