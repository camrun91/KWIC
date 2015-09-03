package jerrold;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CoreData core;
    
    public Alphabetizer(CoreData core) {
        this.core = core;
        circularShifts = new ArrayList<String>(core.getShifts());
        Collections.sort(circularShifts);
        core.setCircularShifts(circularShifts);
    }
    
}
