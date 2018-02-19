package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
This class is used to read the input that is placed in the input box on the main page. 
It puts the lines into an arraylist for manipulation later. 
*/


public class InputReader {
    
    List<String> lines;
    String input;
    //reads in the content of the text area. And splits it on new lines.
    public InputReader(String input) {
        this.input = input;
        this.lines = new ArrayList<>(Arrays.asList(input.split("\\r?\\n")));
    }
    //gets index of the line 
    protected String getLine(int index) {
        return lines.get(index);
    }
    //length of the line
    protected int getLineCount() {
        return lines.size();
    }

}
