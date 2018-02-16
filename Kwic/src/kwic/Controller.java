package kwic;

import javafx.scene.control.TextArea;


public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String input, TextArea output) {
        
        InputReader inputReader = new InputReader(input);
        
        LineProcessor lineProcessor = new LineProcessor(inputReader);
        lineProcessor.setup();
        
        CircularShifter circularShifter = new CircularShifter(lineProcessor);
        circularShifter.constructCircularShifts();
        
        Alphabetizer alphabetizer = new Alphabetizer(circularShifter);
        alphabetizer.sortCircularShifts();
        
        OutputWriter outputWriter = new OutputWriter( alphabetizer.getSortedShifts(), output);
        outputWriter.outputToText();
    }

}
