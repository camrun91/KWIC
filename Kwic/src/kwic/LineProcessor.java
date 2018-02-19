package kwic;

import java.util.ArrayList;
import java.util.Arrays;
/*
This class takes the lines from input reader and processes them for shifting.
*/
public class LineProcessor {
    
    InputReader inputReader;
    ArrayList<String> Lines;
    ArrayList<String> circularShifts;
    
    public LineProcessor(InputReader inputReader) {
        this.inputReader = inputReader;
        Lines = new ArrayList<>();
    }
    //sets up the arraylist to contain the lines
    protected void setup() {
        for (int i = 0; i < inputReader.getLineCount(); i++) {
            Lines.add(inputReader.getLine(i));
        }
    }
    
    
    protected ArrayList<String> getWord(int index) {
        return splitToArrayList(Lines.get(index));
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
        return Lines.size();
    }

}
