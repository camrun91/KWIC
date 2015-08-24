
import java.util.ArrayList;

public class CircularShifter {
    
    DataStorage dataStorage;
    InputReader inputReader;
    ArrayList<String> shifts= new ArrayList<>();
    
    public CircularShifter(DataStorage ds) {
        dataStorage = ds;
    }
    
    public void setup() {
        for (int i = 0; i < dataStorage.getTitleCount(); i++) { // for each title
            ArrayList<String> titleWords = dataStorage.getTitle(i);
            
            for (int j = 0; j < titleWords.size(); j++) { // for each word in line
                String firstWord = titleWords.get(j).toLowerCase();
                if (!dataStorage.getAllIgnoreWords().contains(firstWord)) {
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
