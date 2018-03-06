package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CoreData core;
    
    public Alphabetizer(CoreData core) {
        this.core = core;
        circularShifts = new ArrayList<>(core.getCircularShifts());
    }
    //the collections.sort sorst the array list alphebeticly the collections.reverse reverses this to fit the criteria
    //for the asignment.
    protected void sortCircularShifts() {
        Collections.sort(circularShifts);
        Collections.reverse(circularShifts);
    }
}
