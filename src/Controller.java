
public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String filename) {
        InputReader inputReader = new InputReader(filename);
        inputReader.readFile();
        
        LineProcessor lineProcessor = new LineProcessor(inputReader);
        lineProcessor.setup();
        
        CircularShifter circularShifter = new CircularShifter(lineProcessor);
        circularShifter.constructCircularShifts();
        
        Alphabetizer alphabetizer = new Alphabetizer(circularShifter);
        alphabetizer.sortCircularShifts();
        
        OutputFormatter outputFormatter = new OutputFormatter(alphabetizer.getSortedShifts());
        
        displayCircularShift(outputFormatter.getOutput());
    }
    
    public void displayCircularShift(String output) {
        ui.displayResult(output);
    }

}
