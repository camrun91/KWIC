package kwic;

import java.util.ArrayList;
import javafx.scene.control.TextArea;


public class OutputWriter {
    
    CoreData core;
    ArrayList<String> outputList;
    TextArea output;
    
    public OutputWriter( CoreData core, TextArea output ) {
        this.core =core;
        this.outputList = core.getCircularShifts();
        this.output = output;
    }
    
    public void outputToText() {
        outputList.forEach((line) -> {
            String fw;
            String[] noise = new String[]{"a","an","the","and","or","of","to","be","is","in","out","by","as","at","off"};
            boolean check = true;
            if(line.contains(" ")){
                fw = line.substring(0, line.indexOf(" "));
                fw = fw.toLowerCase();
            }else{
                fw = line;
            }
            for(String s : noise){
                if(fw.equals(s)) check = false;
            }
            if(check){
                this.output.appendText(line);
                this.output.appendText("\n");
            }
            //this.output.appendText(line);
            //this.output.appendText("\n");
        });

    }
   

}
