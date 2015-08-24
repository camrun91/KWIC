
import java.util.ArrayList;
import java.util.Arrays;

public class DataStorage {
    
    InputReader inputReader;
    ArrayList<String> titles;
    ArrayList<String> ignoreWords;
    
    public DataStorage(InputReader ir) {
        inputReader = ir;
        titles = new ArrayList<>();
        setup();
    }
    
    public void setup() {
        for (int i = 1; i < inputReader.getLineCount(); i++) {
            titles.add(inputReader.getLine(i));
        }
        ignoreWords = new ArrayList<String>(Arrays.asList(inputReader.getLine(0).split(" ")));
    }
    
    public ArrayList<String> getAllTitles() {
        return titles;
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
