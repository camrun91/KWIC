package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CircularShifter circularShifter;
    
    public Alphabetizer(CircularShifter shifter) {
        this.circularShifter = shifter;
        circularShifts = new ArrayList<>(circularShifter.getCircularShifts());
    }
    //the collections.sort sorst the array list alphebeticly the collections.reverse reverses this to fit the criteria
    //for the asignment.
    protected void sortCircularShifts() {
        Collections.sort(circularShifts);
        Collections.reverse(circularShifts);
    }
    
    protected ArrayList<String> getSortedShifts() {
        return circularShifts;
    }
    
}
