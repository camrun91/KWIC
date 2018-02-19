package kwic;

import java.util.ArrayList;
/*
This class takes the input from lineprocessor and shifts it word by word. 
*/
public class CircularShifter {
    
    LineProcessor lineProcessor;
    ArrayList<String> shifts= new ArrayList<>();
    
    public CircularShifter(LineProcessor lineProcessor) {
        this.lineProcessor = lineProcessor;
    }
    
    public void constructCircularShifts() {
        //this loop gets each line
        for (int i = 0; i < lineProcessor.getTitleCount(); i++) {
            ArrayList<String> lines = lineProcessor.getWord(i);
            //this next loop gets each word in the line
            for (int j = 0; j < lines.size(); j++) { 
                    shifts.add(getCircularShift(lines, j));
                
            }
        }
    }
    
    /**
     * Constructs one circular shift of one line, starting from given word
     * 
     * @param line      line to construct circular shift out of
     * @param startIndex index of word to start the shift from
     * @return           circular shift constructed
     */
    protected String getCircularShift(ArrayList<String> line, int startIndex) {
        int wordCount = line.size();
        String circularShift = "";
        
        for (int i = startIndex; i < (wordCount + startIndex); i++) {
            String word;
            
            if (i < wordCount) 
                word = line.get(i);
             else {
                // Wrap back to first word
                word = line.get(i - wordCount); 
            }
            
            if (i == startIndex) {
                circularShift = circularShift + word;
            } else {
               circularShift = circularShift + " " + word;
            }
        }
        return circularShift;
    }
    
    protected ArrayList<String> getCircularShifts() {
        return shifts;
    }

}
