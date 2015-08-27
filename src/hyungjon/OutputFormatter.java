package hyungjon;

import java.util.ArrayList;

public class OutputFormatter {
    
    String output;
    
    public OutputFormatter(ArrayList<String> sortedShifts) {
        output = formatOutput(sortedShifts);
    }
    
    public String formatOutput(ArrayList<String> sortedShifts) {
        String output = "";
        for (String shift : sortedShifts) {
            output = output + shift + "\n";
        }
        return output;
    }
    
    public String getOutput() {
        return output;
    }

}
