package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class InputReader {
    
    List<String> lines;
    String input;
    
    public InputReader(String input) {
        this.input = input;
        this.lines = new ArrayList<>(Arrays.asList(input.split("\\r?\\n")));
    }
    
    protected String getLine(int index) {
        return lines.get(index);
    }
    
    protected int getLineCount() {
        return lines.size();
    }

}
