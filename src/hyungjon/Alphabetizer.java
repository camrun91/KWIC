package hyungjon;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CircularShifter circularShifter;
    
    public Alphabetizer(CircularShifter shifter) {
        this.circularShifter = shifter;
        circularShifts = new ArrayList<String>(circularShifter.getCircularShifts());
    }
    
    protected void sortCircularShifts() {
        Collections.sort(circularShifts);
    }
    
    protected ArrayList<String> getSortedShifts() {
        return circularShifts;
    }
    
}
