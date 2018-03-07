package kwic;

import javafx.scene.control.TextArea;

/*
This class is the main guts of the program it uses the UI Class to be able to 
display the output. It sends the input to the input reader which then sends its data to the lineProcessor 
The line processor then sends the data to the circular shifter which then sends its data to the alphabetizer 
The data is then sent to the output writer. 
*/
public class Controller {
    
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
    }
    
    public void processCircularShift(String input, TextArea output) {
        CoreData core = new CoreData();
        core.setInput(input);
        core.setOutput(output);
        //process input
        InputReader inputReader = new InputReader(core);
        inputReader.readInput();
        //use inputreaders data to process the lines
        LineProcessor lineProcessor = new LineProcessor(core);
        lineProcessor.setup();
        //shift the words in the lines
        CircularShifter circularShifter = new CircularShifter(core);
        circularShifter.constructCircularShifts();
        //aphabetize the ines 
        //core.switchFirstLetterCases();
        Alphabetizer alphabetizer = new Alphabetizer(core);
        alphabetizer.sortCircularShifts();
        //core.switchFirstLetterCases();
        //output the alphabetized lines 
        OutputWriter outputWriter = new OutputWriter(core, output);
        outputWriter.outputToText();
    }

}
