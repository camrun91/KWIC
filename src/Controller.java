
import java.util.ArrayList;

public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String filename) {
        InputReader ir = new InputReader(filename);
        
        DataStorage ds = new DataStorage(ir);
        ds.setup();
        
        CircularShifter cs = new CircularShifter(ds);
        cs.setup();
        
        Alphabetizer a = new Alphabetizer(cs.getCircularShifts());
        for (int i = 0; i < a.getSortedShifts().size(); i++) {
            System.out.println(a.getSortedShifts().get(i));
        }
        
        displayCircularShift(a.getSortedShifts());
    }
    
    public void displayCircularShift(ArrayList<String> sortedShifts) {
        String result = "";
        for (String shift : sortedShifts) {
            result = result + shift + "\n";
        }
        ui.displayResult(result);
    }

    public static void main(String[] args) {
        
        String inputFile = args[0];
        String outputFile = args[1];
        
        InputReader ir = new InputReader(inputFile);
        
        DataStorage ds = new DataStorage(ir);
        
        CircularShifter cs = new CircularShifter(ds);
        cs.setup();
        
        Alphabetizer a = new Alphabetizer(cs.getCircularShifts());
        for (int i = 0; i < a.getSortedShifts().size(); i++) {
            System.out.println(a.getSortedShifts().get(i));
        }
        
        OutputPrinter op = new OutputPrinter(outputFile, a.getSortedShifts());
        op.writeFile(outputFile);

    }

}
