package jerrold;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author HyungJon
 *
 * Takes lines from InputReader, with knowledge of what each line is,
 * and turns them into a form usable by CircularShifter
 */
public class LineProcessor {
    
	CoreData core;
    ArrayList<String> titles;
    ArrayList<String> ignoreWords;
    ArrayList<String> circularShifts;
    
    public LineProcessor(CoreData core) {
        this.core = core;
        titles = new ArrayList<>();
    }
    
    protected void setup() {
        for (int i = 1; i < core.getLineCount(); i++) {
            titles.add(core.getLine(i));
        }
        ignoreWords = core.splitToArrayList(core.getLine(0));
        
        core.setIgnoreWords(ignoreWords);
        core.setTitles(titles);
    }
    

}
