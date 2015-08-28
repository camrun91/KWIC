package hyungjon;

import ui.UI;

public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String inputFilename, String outputFilename) {
        InputReader inputReader = new InputReader(inputFilename);
        inputReader.readFile();
        
        LineProcessor lineProcessor = new LineProcessor(inputReader);
        lineProcessor.setup();
        
        CircularShifter circularShifter = new CircularShifter(lineProcessor);
        circularShifter.constructCircularShifts();
        
        Alphabetizer alphabetizer = new Alphabetizer(circularShifter);
        alphabetizer.sortCircularShifts();
        
        OutputWriter outputWriter = new OutputWriter(outputFilename, alphabetizer.getSortedShifts());
        outputWriter.writeToFile();
    }

}
