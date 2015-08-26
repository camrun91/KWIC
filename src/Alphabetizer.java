
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    ArrayList<String> arr = new ArrayList<>();
    
    public Alphabetizer(ArrayList<String> circularShifts) {
        arr = circularShifts;
        sort();
    }
    
    public void sort() {
        System.out.println("Sorting shifts");
        Collections.sort(arr);
    }
    
    public ArrayList<String> getSortedShifts() {
        System.out.println("Returning sorted shifts");
        return arr;
    }

}
