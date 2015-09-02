package jerrold;

import ui.UI;

public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String inputFilename, String outputFilename) {
    	CoreData core = new CoreData();
    	core.setInput(inputFilename);
    	core.setOutput(outputFilename);
    	
        InputReader inputReader = new InputReader(core);
        inputReader.readFile();
        
        LineProcessor lineProcessor = new LineProcessor(core);
        lineProcessor.setup();
        
        CircularShifter circularShifter = new CircularShifter(core);
        circularShifter.constructCircularShifts();
        
        Alphabetizer alphabetizer = new Alphabetizer(core);
        
        OutputWriter outputWriter = new OutputWriter(core);
        outputWriter.writeToFile();
    }

}
