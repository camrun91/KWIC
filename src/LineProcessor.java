
import java.util.ArrayList;
import java.util.Arrays;

public class LineProcessor {
    
    InputReader inputReader;
    ArrayList<String> titles;
    ArrayList<String> ignoreWords;
    ArrayList<String> circularShifts;
    
    public LineProcessor(InputReader ir) {
        inputReader = ir;
        titles = new ArrayList<>();
    }
    
    public void setup() {
        System.out.println("Setting up titles");
        for (int i = 1; i < inputReader.getLineCount(); i++) {
            titles.add(inputReader.getLine(i));
        }
        ignoreWords = new ArrayList<String>(Arrays.asList(inputReader.getLine(0).split(" ")));
    }
    
    public ArrayList<String> getTitle(int index) {
        return new ArrayList<String>(Arrays.asList(titles.get(index).split(" ")));
    }
    
    public int getTitleCount() {
        return titles.size();
    }
    
    public ArrayList<String> getAllIgnoreWords() {
        return ignoreWords;
    }

}
