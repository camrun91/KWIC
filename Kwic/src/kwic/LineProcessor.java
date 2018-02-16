package kwic;

import java.util.ArrayList;
import java.util.Arrays;

public class LineProcessor {
    
    InputReader inputReader;
    ArrayList<String> titles;
   // ArrayList<String> ignoreWords;
    ArrayList<String> circularShifts;
    
    public LineProcessor(InputReader inputReader) {
        this.inputReader = inputReader;
        titles = new ArrayList<>();
    }
    
    protected void setup() {
        for (int i = 0; i < inputReader.getLineCount(); i++) {
            titles.add(inputReader.getLine(i));
        }
     //   ignoreWords = splitToArrayList(inputReader.getLine(0));
    }
    
    //protected ArrayList<String> getAllIgnoreWords() {
   //     return ignoreWords;
   // }
    
    protected ArrayList<String> getTitle(int index) {
        return splitToArrayList(titles.get(index));
    }
    
    /**
     * Splits a line into words and returns it as ArrayList
     * 
     * @param line String containing a line
     * @return     ArrayList containing all words in given line
     */
    private ArrayList<String> splitToArrayList(String line) {
        return new ArrayList<>(Arrays.asList(line.split(" ")));
    }
    
    protected int getTitleCount() {
        return titles.size();
    }

}
