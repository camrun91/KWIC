package kwic;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class InputReader {
    
    List<String> lines;
    String input;
    
    public InputReader(String input) {
        this.input = input;
        this.lines = new ArrayList<>(Arrays.asList(input.split("\\r?\\n")));
    }
    
   // protected void readFile() {
        //try {
            
            //BufferedReader br = new BufferedReader(fr);
            //String line;
           // while ((line = br.readLine()) != null) {
//                lines.add(line);
  //          }
    //        br.close();
      //  } catch (IOException e) {
        //    e.printStackTrace();
        //}
   // }
    
    protected String getLine(int index) {
        return lines.get(index);
    }
    
    protected int getLineCount() {
        return lines.size();
    }

}
