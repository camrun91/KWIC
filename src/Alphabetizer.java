
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CircularShifter circularShifter;
    
    public Alphabetizer(CircularShifter shifter) {
        this.circularShifter = shifter;
        // Array copied to avoid the sort affecting the DataStorage
        circularShifts = new ArrayList<String>(circularShifter.getCircularShifts());
    }
    
    public void sortCircularShifts() {
        Collections.sort(circularShifts);
    }
    
    public ArrayList<String> getSortedShifts() {
        return circularShifts;
    }
    
}
