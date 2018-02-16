package kwic;

import java.util.ArrayList;
import javafx.scene.control.TextArea;


public class OutputWriter {
    
    
    ArrayList<String> outputList;
    TextArea output;
    
    public OutputWriter( ArrayList<String> outputList, TextArea output ) {
        this.outputList = outputList;
        this.output = output;
    }
    
    public void outputToText() {
        outputList.forEach((line) -> {
            this.output.appendText(line);
            this.output.appendText("\n");
        });
    }
   

}
