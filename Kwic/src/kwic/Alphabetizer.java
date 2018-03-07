package kwic;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

public class Alphabetizer {
    
    ArrayList<String> circularShifts;
    CoreData core;
    
    public Alphabetizer(CoreData core) {
        this.core = core;
        circularShifts = new ArrayList<>(core.getCircularShifts());
    }
    
    
    protected void sortCircularShifts() {
        /*Was testing with this
ba a Ca
ad an Ce
Bd the cb
af and dc
ab or cd
Bb of Db
bc to Cc
Ae be Dd
Ac is da
        */
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
            
        core.setCircularShifts(hold);
        
    }
    


}
