package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
This class is used to read the input that is placed in the input box on the main page. 
It puts the lines into an arraylist for manipulation later. 
*/


public class InputReader {
    
    ArrayList<String> lines;
    String input;
    CoreData core;
    //reads in the content of the text area. And splits it on new lines.
    public InputReader(CoreData core) {
        this.core =core;
        this.input = core.getInput();
    }
    protected void readInput(){
        lines = new ArrayList<>(Arrays.asList(input.split("\\r?\\n")));
        core.setLines(lines);
    }
}
