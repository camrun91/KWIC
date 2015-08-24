
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> arr = new ArrayList<>();
    
    public Alphabetizer(ArrayList<String> circularShifts) {
        arr = circularShifts;
        sort();
    }
    
    public void sort() {
        Collections.sort(arr);
    }
    
    public ArrayList<String> getSortedShifts() {
        return arr;
    }

}
