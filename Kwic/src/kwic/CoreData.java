
package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.TextArea;

public class CoreData {
    private String inputString;
	private TextArea outputString;
	private ArrayList<String> lines;
    private ArrayList<String> words;
    private ArrayList<String> ignoreWords;
    ArrayList<String> shifts;
    ArrayList<String> circularShifts;
	
         public ArrayList<String> getCircularShifts() {
            return circularShifts;
         }

         public void setCircularShifts(ArrayList<String> circularShifts) {
		this.circularShifts = circularShifts;
        }

         public ArrayList<String> getShifts() {
		return shifts;
         }

        public void setShifts(ArrayList<String> shifts) {
		this.shifts = shifts;
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getIgnoreWords() {
		return ignoreWords;
	}

	public void setIgnoreWords(ArrayList<String> ignoreWords) {
		this.ignoreWords = ignoreWords;
	}

	protected void setInput(String input){
		inputString = input;
	}

	protected String getInput(){
		return inputString;
	}

	protected void setOutput(TextArea output){
		outputString = output;
	}

	protected TextArea getOutput(){
		return outputString;
	}

	protected void setLines(ArrayList<String> lines){
    	this.lines = lines;    	
    }

	protected ArrayList<String> getLines(){
    	return lines;
    }

        protected void updateLineProcessor(ArrayList<String> lines){
   	this.lines = lines;
    }

    protected String getLine(int index) {
        return lines.get(index);
    }

    protected int getLineCount() {
        return lines.size();
    }

    protected int getWordCount() {
        return words.size();
    }

    protected ArrayList<String> getWord(int index) {
        return splitToArrayList(lines.get(index));
    }

    /**
     * Splits a line into words and returns it as ArrayList
     * @param line String containing a line
     * @return     ArrayList containing all words in given line
     */

    protected ArrayList<String> splitToArrayList(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }

    

    public void printList(ArrayList<String> listToPrint){
    	for (int i = 0; i < listToPrint.size(); i++){
    		System.out.println(listToPrint.get(i));
    	}
    }
}