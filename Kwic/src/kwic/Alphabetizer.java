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
        Collections.sort(this.circularShifts, String.CASE_INSENSITIVE_ORDER);
        ArrayList<String> tempup, templwr, hold;
        tempup = new ArrayList<>();
        templwr = new ArrayList<>();
        hold = new ArrayList<>();
        for(int x = 0; x < 26; x++){
            for(String s : circularShifts){
                char c = s.charAt(0); // This gives the first char of a line
                int ascii = (int) c; // ascii is now ascii value for first char
                if(ascii == (97+x)){templwr.add(s);}
                if(ascii == (65+x)){tempup.add(s);}
            }         
            Collections.sort(templwr);//sort the set of lowercase letters
            Collections.sort(tempup);//sort the set of uppercase letters
            
            templwr.forEach((s) -> {hold.add(s);});//add lowercase to hold
            tempup.forEach((s) -> {hold.add(s);});//add uppercase  to hold
            
            templwr.clear();//clear templwr
            tempup.clear();//clear tempup
    }
    }
    
    protected ArrayList<String> getSortedShifts() {
        return circularShifts;
    }
    
}
