package kwic;

import java.util.ArrayList;
import java.util.Arrays;
/*
This class takes the lines from input reader and processes them for shifting.
*/
public class LineProcessor {
    
    ArrayList<String> Lines;
    CoreData core;
    
    public LineProcessor(CoreData core) {
        this.core = core;
        Lines = new ArrayList<>();
    }
    //sets up the arraylist to contain the lines
    protected void setup() {
        for (int i = 0; i < core.getLineCount(); i++) {
            Lines.add(core.getLine(i));
        }
    }
}
