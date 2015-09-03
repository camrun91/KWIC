package jerrold;

import java.util.ArrayList;

/**
 * 
 * @author HyungJon
 *
 * Takes all titles and words to ignore, to create all possible circular shifts and store them in an array
 */
public class CircularShifter {
    
    CoreData core;
    ArrayList<String> shifts = new ArrayList<String>();
    
    public CircularShifter(CoreData core) {
        this.core = core;
    }
    
    public void constructCircularShifts() {
        for (int i = 0; i < core.getTitleCount(); i++) { // for each title
            ArrayList<String> titleWords = core.getTitle(i);
            
            for (int j = 0; j < titleWords.size(); j++) { // for each word in line
                String firstWord = titleWords.get(j).toLowerCase();
                if (!core.getIgnoreWords().contains(firstWord)) {
                    shifts.add(getCircularShift(titleWords, j));
                }
            }
        }
        core.setShifts(shifts);
    }
    
    /**
     * Constructs one circular shift of one line, starting from given word
     * 
     * @param title      line to construct circular shift out of
     * @param startIndex index of word to start the shift from
     * @return           circular shift constructed
     */
    protected String getCircularShift(ArrayList<String> title, int startIndex) {
        int wordCount = title.size();
        String circularShift = "";
        
        for (int i = startIndex; i < (wordCount + startIndex); i++) {
            String word;
            
            if (i < wordCount) {
                word = title.get(i);
            } else {
                word = title.get(i - wordCount); // Wrap back to first word
            }
            
            // Capitalize if non-ignore, small letters if ignore
            if (core.getIgnoreWords().contains(word.toLowerCase())) {
                word = word.toLowerCase();
            } else {
                word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
            
            // This is to avoid having to take substring later
            if (i == startIndex) {
                circularShift = circularShift + word;
            } else {
                circularShift = circularShift + " " + word;
            }
        }
        return circularShift;
    }

}
