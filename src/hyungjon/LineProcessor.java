package hyungjon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author HyungJon
 *
 * Takes lines from InputReader, with knowledge of what each line is,
 * and turns them into a form usable by CircularShifter
 */
public class LineProcessor {
    
    InputReader inputReader;
    ArrayList<String> titles;
    ArrayList<String> ignoreWords;
    ArrayList<String> circularShifts;
    
    public LineProcessor(InputReader inputReader) {
        this.inputReader = inputReader;
        titles = new ArrayList<>();
    }
    
    protected void setup() {
        System.out.println("Setting up titles");
        for (int i = 1; i < inputReader.getLineCount(); i++) {
            titles.add(inputReader.getLine(i));
        }
        ignoreWords = splitToArrayList(inputReader.getLine(0));
    }
    
    protected ArrayList<String> getAllIgnoreWords() {
        return ignoreWords;
    }
    
    protected ArrayList<String> getTitle(int index) {
        return splitToArrayList(titles.get(index));
    }
    
    /**
     * Splits a line into words and stores it in ArrayList
     * 
     * @param line String containing a line
     * @return     ArrayList containing all words in given line
     */
    private ArrayList<String> splitToArrayList(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }
    
    protected int getTitleCount() {
        return titles.size();
    }

}
