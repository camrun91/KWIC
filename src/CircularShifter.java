
import java.util.ArrayList;

public class CircularShifter {
    
    LineStorage lineStorage;
    InputReader inputReader;
    ArrayList<String> shifts= new ArrayList<>();
    ArrayList<String> ignoreWords = new ArrayList<>();
    
    public CircularShifter(LineStorage ls, InputReader ir) {
        lineStorage = ls;
        inputReader = ir;
        ignoreWords = ir.getIgnoreWords();
        for (String ignore : ignoreWords) {
            System.out.println("Ignore: " + ignore);
        }
    }
    
    public void setup() {
        for (int i = 0; i < lineStorage.getLineCount(); i++) { // for each line
            ArrayList<String> titleWords = lineStorage.getLine(i).getWords();
            
            for (int j = 0; j < titleWords.size(); j++) { // for each word in line
                String firstWord = titleWords.get(j).toLowerCase();
                if (!ignoreWords.contains(firstWord)) {
                    shifts.add(constructCircularShift(titleWords, j));
                }
            }
        }
    }
    
    public String constructCircularShift(ArrayList<String> title, int startIndex) {
        int wordCount = title.size();
        String circularShift = "";
        for (int i = startIndex; i < (wordCount + startIndex); i++) {
            String word;
            
            if (i < wordCount) {
                word = title.get(i);
            } else {
                word = title.get(i - wordCount);
            }
            System.out.print(word + " ");
            
            if (i == startIndex) {
                circularShift = circularShift + word;
            } else {
                circularShift = circularShift + " " + word;
            }
        }
        System.out.println("");
        return circularShift; // Remove first whitespace
    }
    
    public ArrayList<String> getCircularShifts() {
        for (String shift : shifts) {
            System.out.println("Shift: " + shift);
        }
        return shifts;
    }

}
