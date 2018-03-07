package kwic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CoreData core;
    
    public Alphabetizer(CoreData core) {
        this.core = core;
        circularShifts = new ArrayList<>(core.getCircularShifts());
    }
    
    
    protected void sortCircularShifts() {
        //Added the CASE_INSENSITIVE part
        //This pretty much needs us to write our own sort for it
        //It might be able to be done lazily using another ArrayList
        //Just put all the lines begining with A or a into
        //the new ArrayList and then sort that with the below
        //Collections.sort(circularShifts)
        //Add that list of sorted a's to another List
        //Then do the same for every other letter
        Collections.sort(this.circularShifts, String.CASE_INSENSITIVE_ORDER);
        //Collections.sort(circularShifts);
        core.setCircularShifts(this.circularShifts);
        
    }
    


}
