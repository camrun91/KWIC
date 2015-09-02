package jerrold;

import java.util.ArrayList;
import java.util.Arrays;

public class CoreData {
	
	private String inputFilename;
	private String outputFilename;
	private ArrayList<String> lines;
    private ArrayList<String> titles;
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

	public ArrayList<String> getTitles() {
		return titles;
	}

	public void setTitles(ArrayList<String> titles) {
		this.titles = titles;
	}

	public ArrayList<String> getIgnoreWords() {
		return ignoreWords;
	}

	public void setIgnoreWords(ArrayList<String> ignoreWords) {
		this.ignoreWords = ignoreWords;
	}

	protected void setInput(String input){
		inputFilename = input;
	}
	
	protected String getInput(){
		return inputFilename;
	}
	
	protected void setOutput(String output){
		outputFilename = output;
	}
	
	protected String getOutput(){
		return outputFilename;
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
    
    protected int getTitleCount() {
        return titles.size();
    }
    
    protected ArrayList<String> getTitle(int index) {
        return splitToArrayList(titles.get(index));
    }
    
    /**
     * Splits a line into words and stores it in ArrayList
     * 
     * 
     * @param line String containing a line
     * @return     ArrayList containing all words in given line
     */
    protected ArrayList<String> splitToArrayList(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }

}
