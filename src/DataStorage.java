
import java.util.ArrayList;
import java.util.Arrays;

public class DataStorage {
    
    InputReader inputReader;
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> ignoreWords = new ArrayList<>();
    
    public DataStorage(InputReader ir) {
        inputReader = ir;
        titles = ir.getTitles();
        ignoreWords = ir.getIgnoreWords();
    }
    
    public void setup() {
        
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
